package pl.zankowski.iextrading4j.client.rest.request;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

public interface IRestRequestBuilder<R> {

    RestRequest<R> build();

}
