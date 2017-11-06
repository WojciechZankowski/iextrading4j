package pl.zankowski.iextrading4j.client.rest.manager;

import java.io.Serializable;

public interface IRestRequestTypeBuilder<R extends Serializable> {

    IRestRequestTypeBuilder<R> addPathParam(String key, String value);

    IRestResponseTypeRequestBuilder<R> get();

}
