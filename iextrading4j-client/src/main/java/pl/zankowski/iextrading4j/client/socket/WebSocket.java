package pl.zankowski.iextrading4j.client.socket;

import pl.zankowski.iextrading4j.client.socket.model.AsyncRequestType;
import pl.zankowski.iextrading4j.client.socket.model.LastAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.MarketAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.TOPSAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.exception.SocketConnectException;
import pl.zankowski.iextrading4j.client.socket.model.exception.SubscribeException;
import pl.zankowski.iextrading4j.client.socket.model.exception.UnsubscribeException;

/**
 * @author Wojciech Zankowski
 */
public interface WebSocket {

    void connect() throws SocketConnectException;

    void connect(AsyncRequestType asyncRequestType) throws SocketConnectException;

    void subscribe(TOPSAsyncRequest topsAsyncRequest) throws SubscribeException;

    void subscribe(LastAsyncRequest lastAsyncRequest) throws SubscribeException;

    void subscribe(MarketAsyncRequest marketAsyncRequest) throws SubscribeException;

    void unsubscribe(TOPSAsyncRequest topsAsyncRequest) throws UnsubscribeException;

    void unsubscribe(LastAsyncRequest lastAsyncRequest) throws UnsubscribeException;

    void unsubscribe(MarketAsyncRequest marketAsyncRequest) throws UnsubscribeException;

    boolean isConnected(AsyncRequestType asyncRequestType);

    boolean isConnected();

    void disconnect();

}
