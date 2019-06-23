package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import java.util.function.Consumer;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public interface IEXApiClient {

    <R> R executeRequest(final RestRequest<R> restRequest);

    <R> void subscribe(final SocketRequest<R> socketRequest, final Consumer<R> consumer);

    <R> void unsubscribe(final SocketRequest<R> socketRequest);

}
