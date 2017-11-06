package pl.zankowski.iextrading4j.client.rest;

import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import java.io.Serializable;

public abstract class AbstractRestEndpoint implements IRestEndpoint {

    private final RestManager restManager;

    public AbstractRestEndpoint(final RestManager restManager) {
        this.restManager = restManager;
    }

    @Override
    public <R extends Serializable> R execute(final RestRequest<R> restRequest) {
        return restManager.executeRequest(restRequest).getResponse();
    }



}
