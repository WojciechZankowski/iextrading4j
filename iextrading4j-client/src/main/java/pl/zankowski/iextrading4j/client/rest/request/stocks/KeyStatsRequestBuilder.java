package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class KeyStatsRequestBuilder extends AbstractStocksRequestBuilder<KeyStats, KeyStatsRequestBuilder> {

    @Override
    public RestRequest<KeyStats> build() {
        return RestRequestBuilder.<KeyStats>builder()
                .withPath("/stock/{symbol}/stats")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(KeyStats.class)
                .build();
    }

}
