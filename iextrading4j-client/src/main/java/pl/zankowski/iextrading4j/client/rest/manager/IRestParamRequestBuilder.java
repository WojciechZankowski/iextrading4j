package pl.zankowski.iextrading4j.client.rest.manager;

import java.io.Serializable;

public interface IRestParamRequestBuilder<R extends Serializable> {

    IRestParamRequestBuilder<R> addHeaderParam(String key, String value);

    IRestParamRequestBuilder<R> addQueryParam(String key, String value);

    RestRequest<R> build();

}
