package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

public class TradeBreakRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, List<Trade>>, TradeBreakRequestBuilder> {

    @Override
    public RestRequest<Map<String, List<Trade>>> build() {
        return RestRequestBuilder.<Map<String, List<Trade>>>builder()
                .withPath("/deep/trade-breaks").get()
                .withResponse(new GenericType<Map<String, List<Trade>>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
