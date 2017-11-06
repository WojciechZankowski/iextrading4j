package pl.zankowski.iextrading4j.client.socket.request;

import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

public interface IAsyncRequest<R> {

    SocketRequest<R> build();

}
