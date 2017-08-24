package pl.zankowski.iextrading4j.client.socket;

import io.socket.client.Socket;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequestType;
import pl.zankowski.iextrading4j.client.socket.model.LastAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.MarketAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.TOPSAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.exception.SocketConnectException;
import pl.zankowski.iextrading4j.client.socket.model.exception.SubscribeException;
import pl.zankowski.iextrading4j.client.socket.model.exception.UnsubscribeException;

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

    private final IOSocketFactory ioSocketFactory;

    public IOSocketImpl(IOSocketWrapper ioSocketWrapper, DataReceiver dataReceiver) {
        this.ioSocketFactory = new IOSocketFactory(ioSocketWrapper, dataReceiver);
    }

    @Override
    public void connect() throws SocketConnectException {
        connect(AsyncRequestType.TOPS);
        connect(AsyncRequestType.LAST);
        connect(AsyncRequestType.MARKET);
    }

    @Override
    public void connect(AsyncRequestType asyncRequestType) throws SocketConnectException {
        try {
            Socket socket = requestSockets.get(asyncRequestType);
            if (socket == null) {
                socket = ioSocketFactory.initSocket(asyncRequestType);
            }
            socket.connect();
            requestSockets.put(asyncRequestType, socket);
        } catch (URISyntaxException e) {
            throw new SocketConnectException();
        }
    }

    @Override
    public void subscribe(TOPSAsyncRequest topsAsyncRequest) throws SubscribeException {
        subscribe(topsAsyncRequest, topsAsyncRequest.getSymbolList());
    }

    @Override
    public void subscribe(LastAsyncRequest lastAsyncRequest) throws SubscribeException {
        subscribe(lastAsyncRequest, lastAsyncRequest.getSymbolList());
    }

    @Override
    public void subscribe(MarketAsyncRequest marketAsyncRequest) throws SubscribeException {
        subscribe(marketAsyncRequest, new Object[0]);
    }

    private void subscribe(AsyncRequest asyncRequest, Object... args) throws SubscribeException {
        Socket socket = requestSockets.get(asyncRequest.getAsyncRequestType());
        if (socket == null || !socket.connected()) {
            throw new SubscribeException("Socket not connected");
        }
        socket.emit(SUBSCRIBE_EVENT, args);
    }

    @Override
    public void unsubscribe(TOPSAsyncRequest topsAsyncRequest) throws UnsubscribeException {
        unsubscribe(topsAsyncRequest, topsAsyncRequest.getSymbolList());
    }

    @Override
    public void unsubscribe(LastAsyncRequest lastAsyncRequest) throws UnsubscribeException {
        unsubscribe(lastAsyncRequest, lastAsyncRequest.getSymbolList());
    }

    @Override
    public void unsubscribe(MarketAsyncRequest marketAsyncRequest) throws UnsubscribeException {
        unsubscribe(marketAsyncRequest);
    }

    private void unsubscribe(AsyncRequest asyncRequest, Object... args) throws UnsubscribeException {
        Socket socket = requestSockets.get(asyncRequest.getAsyncRequestType());
        if (socket == null || !socket.connected()) {
            throw new UnsubscribeException("Socket not connected");
        }
        socket.emit(UNSUBSCRIBE_EVENT, args);
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
        requestSockets.entrySet().forEach(entry -> entry.getValue().disconnect());
    }

}
