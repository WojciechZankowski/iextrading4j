package pl.zankowski.iextrading4j.client.rest.manager;

import jakarta.ws.rs.core.GenericType;

public interface IRestResponseTypeRequestBuilder<R> {

    IRestParamRequestBuilder<R> withResponse(Class<R> responseType);

    IRestParamRequestBuilder<R> withResponse(GenericType<R> genericType);

}
