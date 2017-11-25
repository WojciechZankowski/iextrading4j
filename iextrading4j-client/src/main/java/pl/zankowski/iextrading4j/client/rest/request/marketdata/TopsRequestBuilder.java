package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class TopsRequestBuilder extends AbstractMarketDataRequestBuilder<List<TOPS>, TopsRequestBuilder> {

    @Override
    public RestRequest<List<TOPS>> build() {
        return RestRequestBuilder.<List<TOPS>>builder()
                .withPath("/tops").get()
                .withResponse(new GenericType<List<TOPS>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
