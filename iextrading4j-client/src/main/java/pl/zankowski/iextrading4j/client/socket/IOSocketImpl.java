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

    public static final String SUBSCRIBE_EVENT = "subscribe";
    public static final String UNSUBSCRIBE_EVENT = "unsubscribe";

    private final Map<AsyncRequestType, Socket> requestSockets = new ConcurrentHashMap<>();

    private final IOSocketConnectionFactory ioSocketConnectionFactory;

    public IOSocketImpl(IOSocketWrapper ioSocketWrapper, DataReceiver dataReceiver) {
        this.ioSocketConnectionFactory = new IOSocketConnectionFactory(ioSocketWrapper, dataReceiver);
    }

    @Override
    public void connect() throws SocketConnectException {
        connect(AsyncRequestType.TOPS);
        connect(AsyncRequestType.LAST);
    }

    @Override
    public void connect(AsyncRequestType asyncRequestType) throws SocketConnectException {
        try {
            Socket socket = requestSockets.get(asyncRequestType);
            if (socket == null) {
                socket = ioSocketConnectionFactory.initConnection(asyncRequestType);
            }
            socket.connect();
            requestSockets.put(asyncRequestType, socket);
        } catch (URISyntaxException e) {
            throw new SocketConnectException();
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
