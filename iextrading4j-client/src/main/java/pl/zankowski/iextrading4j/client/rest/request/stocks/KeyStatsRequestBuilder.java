package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

@Deprecated
public class KeyStatsRequestBuilder extends AbstractStocksRequestBuilder<KeyStats, KeyStatsRequestBuilder>
        implements IEXApiRestRequest<KeyStats> {

    @Override
    public RestRequest<KeyStats> build() {
        return RestRequestBuilder.<KeyStats>builder()
                .withPath("/stock/{symbol}/stats")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(KeyStats.class)
                .build();
    }

}
