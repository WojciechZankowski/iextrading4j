package pl.zankowski.iextrading4j.client.rest;

import pl.zankowski.iextrading4j.client.IEndpoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

public interface IRestEndpoint extends IEndpoint {

    <R> R execute(RestRequest<R> restRequest);

}
