package pl.zankowski.iextrading4j.client.rest;

import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

public abstract class AbstractRestEndpoint implements IRestEndpoint {

    private final RestManager restManager;

    public AbstractRestEndpoint(final RestManager restManager) {
        this.restManager = restManager;
    }

    @Override
    public <R> R execute(final RestRequest<R> restRequest) {
        return restManager.executeRequest(restRequest).getResponse();
    }



}
