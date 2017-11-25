package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.DEEP;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class DeepRequestBuilder extends AbstractMarketDataRequestBuilder<DEEP, DeepRequestBuilder> {

    @Override
    public RestRequest<DEEP> build() {
        return RestRequestBuilder.<DEEP>builder()
                .withPath("/deep").get()
                .withResponse(DEEP.class)
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
