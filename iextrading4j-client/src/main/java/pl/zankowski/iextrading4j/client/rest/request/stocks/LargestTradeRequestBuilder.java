package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.LargestTrade;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class LargestTradeRequestBuilder extends AbstractStocksRequestBuilder<List<LargestTrade>, LargestTradeRequestBuilder> {

    @Override
    public RestRequest<List<LargestTrade>> build() {
        return RestRequestBuilder.<List<LargestTrade>>builder()
                .withPath("/stock/{symbol}/largest-trades")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<LargestTrade>>() {})
                .build();
    }

}
