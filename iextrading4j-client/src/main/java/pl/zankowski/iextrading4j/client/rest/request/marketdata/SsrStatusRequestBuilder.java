package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;

public class SsrStatusRequestBuilder extends AbstractMarketDataRequestBuilder<HashMap<String, SsrStatus>, BookRequestBuilder> {

    @Override
    public RestRequest<HashMap<String, SsrStatus>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/ssr-status").get()
                .withResponse(new GenericType<HashMap<String, SsrStatus>>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }
}
