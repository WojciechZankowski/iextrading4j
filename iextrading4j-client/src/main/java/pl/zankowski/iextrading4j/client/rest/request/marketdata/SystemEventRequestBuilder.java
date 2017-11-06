package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class SystemEventRequestBuilder extends AbstractMarketDataRequestBuilder<SystemEvent, BookRequestBuilder> {

    @Override
    public RestRequest<SystemEvent> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/system-event").get()
                .withResponse(new GenericType<SystemEvent>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
