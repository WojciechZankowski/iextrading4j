package pl.zankowski.iextrading4j.client.socket;

import pl.zankowski.iextrading4j.client.socket.model.AsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.AsyncRequestType;
import pl.zankowski.iextrading4j.client.socket.model.exception.SocketConnectException;
import pl.zankowski.iextrading4j.client.socket.model.exception.SubscribeException;
import pl.zankowski.iextrading4j.client.socket.model.exception.UnsubscribeException;

import java.net.URISyntaxException;

/**
 * @author Wojciech Zankowski
 */
public interface WebSocket {

    void connect() throws SocketConnectException;

    void connect(AsyncRequestType asyncRequestType) throws SocketConnectException;

    void subscribe(AsyncRequest asyncRequest) throws SubscribeException;

    void unsubscribe(AsyncRequest asyncRequest) throws UnsubscribeException;

    boolean isConnected(AsyncRequestType asyncRequestType);

    boolean isConnected();

    void disconnect();

}
