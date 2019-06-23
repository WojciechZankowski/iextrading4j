package pl.zankowski.iextrading4j.client.socket;

import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import java.util.function.Consumer;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public interface ISocketEndpoint {

    <R> void subscribe(SocketRequest<R> socketRequest, Consumer<R> consumer);

    <R> void unsubscribe(SocketRequest<R> socketRequest);

}
