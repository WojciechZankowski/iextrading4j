package pl.zankowski.iextrading4j.client.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.json.JSONObject;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequestType;
import pl.zankowski.iextrading4j.client.socket.model.exception.SocketConnectException;
import pl.zankowski.iextrading4j.client.socket.model.exception.SubscribeException;
import pl.zankowski.iextrading4j.client.socket.model.exception.UnsubscribeException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wojciech Zankowski
 */
public class IOSocketImpl implements WebSocket {

    public static final String WEB_SOCKET_URL = "https://ws-api.iextrading.com/1.0";
    public static final String PATH_DELIMITER = "/";
    public static final String TOPS_PATH = "tops";
    public static final String LAST_PATH = "last";
    public static final String MESSAGE_EVENT = "message";

    public static final String SUBSCRIBE_EVENT = "subscribe";
    public static final String UNSUBSCRIBE_EVENT = "unsubscribe";

    private final Map<AsyncRequestType, Socket> requestSockets = new ConcurrentHashMap<>();

    private final DataReceiver dataReceiver;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public IOSocketImpl(DataReceiver dataReceiver) {
        this.dataReceiver = dataReceiver;
    }

    @Override
    public void connect() throws SocketConnectException {
        try {
            initTOPSConnection();
            initLastTradeConnection();
        } catch (URISyntaxException e) {
            throw new SocketConnectException();
        }
    }

    @Override
    public void connect(AsyncRequestType asyncRequestType) throws URISyntaxException {
        if (asyncRequestType == AsyncRequestType.TOPS) {
            initTOPSConnection();
        } else if (asyncRequestType == AsyncRequestType.LAST) {
            initLastTradeConnection();
        }
    }

    private void initTOPSConnection() throws URISyntaxException {
        Socket socket = requestSockets.get(AsyncRequestType.TOPS);
        if (socket == null) {
            socket = IO.socket(String.join(PATH_DELIMITER, WEB_SOCKET_URL, TOPS_PATH));
            socket.on(MESSAGE_EVENT, (args) -> {
                for (Object arg : args) {
                    notifyListenerOnTOPS((JSONObject) arg);
                }
            });
            requestSockets.put(AsyncRequestType.TOPS, socket);
        }
        socket.connect();
    }

    private void notifyListenerOnTOPS(JSONObject jsonObject) {
        try {
            if (dataReceiver != null) {
                dataReceiver.onTOPS(objectMapper.readValue(jsonObject.toString(), TOPS.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initLastTradeConnection() throws URISyntaxException {
        Socket socket = requestSockets.get(AsyncRequestType.LAST);
        if (socket == null) {
            socket = IO.socket(String.join(PATH_DELIMITER, WEB_SOCKET_URL, LAST_PATH));
            socket.on(MESSAGE_EVENT, (args) -> {
                for (Object arg : args) {
                    notifyListenerOnLastTrade((JSONObject) arg);
                }
            });
            requestSockets.put(AsyncRequestType.LAST, socket);
        }
        socket.connect();
    }

    private void notifyListenerOnLastTrade(JSONObject jsonObject) {
        try {
            if (dataReceiver != null) {
                dataReceiver.onLastTrade(objectMapper.readValue(jsonObject.toString(), LastTrade.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void subscribe(AsyncRequest asyncRequest) throws SubscribeException {
        Socket socket = requestSockets.get(asyncRequest.getAsyncRequestType());
        if (socket == null || !socket.connected()) {
            throw new SubscribeException("Socket not connected");
        }
        socket.emit(SUBSCRIBE_EVENT, asyncRequest.getSymbolList());
    }

    @Override
    public void unsubscribe(AsyncRequest asyncRequest) throws UnsubscribeException {
        Socket socket = requestSockets.get(asyncRequest.getAsyncRequestType());
        if (socket == null || !socket.connected()) {
            throw new UnsubscribeException("Socket not connected");
        }
        socket.emit(UNSUBSCRIBE_EVENT, asyncRequest.getSymbolList());
    }

    @Override
    public boolean isConnected(AsyncRequestType asyncRequestType) {
        Socket socket = requestSockets.get(asyncRequestType);
        return socket.connected();
    }

    @Override
    public boolean isConnected() {
        for (Map.Entry<AsyncRequestType, Socket> entry : requestSockets.entrySet()) {
            if (!entry.getValue().connected()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void disconnect() {
        requestSockets.entrySet().forEach((entry) -> entry.getValue().disconnect());
    }

}
