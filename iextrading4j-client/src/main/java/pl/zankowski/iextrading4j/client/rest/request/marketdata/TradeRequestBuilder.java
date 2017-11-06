package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;
import java.util.List;

public class TradeRequestBuilder extends AbstractMarketDataRequestBuilder<HashMap<String, List<Trade>>, BookRequestBuilder> {

    @Override
    public RestRequest<HashMap<String, List<Trade>>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/trades").get()
                .withResponse(new GenericType<HashMap<String, List<Trade>>>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }
}
