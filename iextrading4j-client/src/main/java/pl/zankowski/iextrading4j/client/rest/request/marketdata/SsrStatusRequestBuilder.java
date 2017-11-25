package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class SsrStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, SsrStatus>, SsrStatusRequestBuilder> {

    @Override
    public RestRequest<Map<String, SsrStatus>> build() {
        return RestRequestBuilder.<Map<String, SsrStatus>>builder()
                .withPath("/deep/ssr-status").get()
                .withResponse(new GenericType<Map<String, SsrStatus>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
