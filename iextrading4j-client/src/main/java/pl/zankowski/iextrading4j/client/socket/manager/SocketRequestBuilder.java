package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;

import java.util.List;

public class SocketRequestBuilder<R> implements ISocketParamRequestBuilder<R>, ISocketPathRequestBuilder<R>,
        ISocketResponseTypeRequestBuilder<R> {

    private TypeReference<R> responseType;
    private String path;
    private Object param;

    public static <R> ISocketPathRequestBuilder<R> builder() {
        return new SocketRequestBuilder<>();
    }

    @Override
    public ISocketResponseTypeRequestBuilder<R> withPath(final String path) {
        this.path = path;
        return this;
    }

    @Override
    public ISocketParamRequestBuilder<R> withResponse(final TypeReference<R> genericType) {
        this.responseType = genericType;
        return this;
    }

    @Override
    public ISocketParamRequestBuilder<R> withParam(final Object param) {
        this.param = param;
        return this;
    }


    @Override
    public SocketRequest<R> build() {
        return new SocketRequest<>(responseType, path, param);
    }

}
