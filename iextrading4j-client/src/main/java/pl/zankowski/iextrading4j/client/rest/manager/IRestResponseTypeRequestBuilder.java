package pl.zankowski.iextrading4j.client.rest.manager;

import javax.ws.rs.core.GenericType;
import java.io.Serializable;

public interface IRestResponseTypeRequestBuilder<R extends Serializable> {

    IRestParamRequestBuilder<R> withResponse(Class<R> responseType);

    IRestParamRequestBuilder<R> withResponse(GenericType<R> genericType);

}
