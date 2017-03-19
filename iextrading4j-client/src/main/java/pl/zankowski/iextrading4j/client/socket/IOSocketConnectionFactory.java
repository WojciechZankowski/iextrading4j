package pl.zankowski.iextrading4j.client.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.json.JSONObject;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequestType;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Wojciech Zankowski
 */
public class IOSocketConnectionFactory {

    public static final String WEB_SOCKET_URL = "https://ws-api.iextrading.com/1.0";
    public static final String PATH_DELIMITER = "/";
    public static final String TOPS_PATH = "tops";
    public static final String LAST_PATH = "last";
    public static final String MESSAGE_EVENT = "message";

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DataReceiver dataReceiver;
    private final IOSocketWrapper ioSocketWrapper;

    public IOSocketConnectionFactory(IOSocketWrapper ioSocketWrapper, DataReceiver dataReceiver) {
        this.ioSocketWrapper = ioSocketWrapper;
        this.dataReceiver = dataReceiver;
    }

    public Socket initConnection(AsyncRequestType asyncRequestType) throws URISyntaxException {
        switch (asyncRequestType) {
            case LAST:
                return initLastTradeConnection();
            case TOPS:
                return initTOPSConnection();
            default:
                throw new IllegalArgumentException("Unsupported async request type " + asyncRequestType);
        }
    }

    private Socket initLastTradeConnection() throws URISyntaxException {
        Socket socket = ioSocketWrapper.socket(String.join(PATH_DELIMITER, WEB_SOCKET_URL, LAST_PATH));
        socket.on(MESSAGE_EVENT, (args) -> {
            for (Object arg : args) {
                notifyListenerOnLastTrade((JSONObject) arg);
            }
        });
        return socket;
    }

    private Socket initTOPSConnection() throws URISyntaxException {
        Socket socket = ioSocketWrapper.socket(String.join(PATH_DELIMITER, WEB_SOCKET_URL, TOPS_PATH));
        socket.on(MESSAGE_EVENT, (args) -> {
            for (Object arg : args) {
                notifyListenerOnTOPS((JSONObject) arg);
            }
        });
        return socket;
    }

    private void notifyListenerOnTOPS(JSONObject jsonObject) {
        try {
            if (dataReceiver != null) {
                dataReceiver.onEvent(objectMapper.readValue(jsonObject.toString(), TOPS.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void notifyListenerOnLastTrade(JSONObject jsonObject) {
        try {
            if (dataReceiver != null) {
                dataReceiver.onEvent(objectMapper.readValue(jsonObject.toString(), LastTrade.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
