package pl.zankowski.iextrading4j.client.sse.manager;

import javax.ws.rs.core.GenericType;
import java.io.Serializable;

public interface ISseResponseTypeRequestBuilder<R extends Serializable> {

    ISseResponseTypeRequestBuilder<R> addPathParam(String key, String value);

    ISseParamRequestBuilder<R> withResponse(Class<R> responseType);

    ISseParamRequestBuilder<R> withResponse(GenericType<R> genericType);

}
