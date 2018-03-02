package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.type.TypeReference;

public interface ISocketResponseTypeRequestBuilder<R> {

    ISocketParamRequestBuilder<R> withResponse(TypeReference<R> genericType);

}
