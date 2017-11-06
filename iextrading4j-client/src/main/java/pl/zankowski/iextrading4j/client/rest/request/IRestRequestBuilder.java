package pl.zankowski.iextrading4j.client.rest.request;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import java.io.Serializable;

public interface IRestRequestBuilder<R extends Serializable> {

    RestRequest<R> build();

}
