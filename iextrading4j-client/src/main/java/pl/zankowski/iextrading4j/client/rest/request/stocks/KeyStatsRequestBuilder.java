package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class KeyStatsRequestBuilder extends AbstractStocksRequestBuilder<KeyStats, KeyStatsRequestBuilder> {

    @Override
    public RestRequest<KeyStats> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/stats")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<KeyStats>() {})
                .build();
    }

}
