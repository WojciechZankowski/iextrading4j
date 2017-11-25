package pl.zankowski.iextrading4j.client.socket.manager;

public interface ISocketParamRequestBuilder<R> {

    ISocketParamRequestBuilder<R> addParam(String param);

    SocketRequest<R> build();

}
