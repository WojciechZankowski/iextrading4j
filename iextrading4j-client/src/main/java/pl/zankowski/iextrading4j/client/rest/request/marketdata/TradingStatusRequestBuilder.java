package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;

public class TradingStatusRequestBuilder extends AbstractMarketDataRequestBuilder<HashMap<String, TradingStatus>, BookRequestBuilder> {

    @Override
    public RestRequest<HashMap<String, TradingStatus>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/trading-status").get()
                .withResponse(new GenericType<HashMap<String, TradingStatus>>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }
}
