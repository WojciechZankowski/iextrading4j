package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

public interface IEXCloudClient {

    <R> R executeRequest(final RestRequest<R> restRequest);

}
