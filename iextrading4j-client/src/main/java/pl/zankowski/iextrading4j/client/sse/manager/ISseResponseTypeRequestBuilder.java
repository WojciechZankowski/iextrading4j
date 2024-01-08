package pl.zankowski.iextrading4j.client.sse.manager;

import javax.ws.rs.core.GenericType;

public interface ISseResponseTypeRequestBuilder<R> {

    ISseResponseTypeRequestBuilder<R> addPathParam(String key, String value);

    ISseParamRequestBuilder<R> withResponse(Class<R> responseType);

    ISseParamRequestBuilder<R> withResponse(GenericType<R> genericType);

}
