package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class SystemEventRequestBuilder extends AbstractMarketDataRequestBuilder<SystemEvent, SystemEventRequestBuilder> {

    @Override
    public RestRequest<SystemEvent> build() {
        return RestRequestBuilder.<SystemEvent>builder()
                .withPath("/deep/system-event").get()
                .withResponse(SystemEvent.class)
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
