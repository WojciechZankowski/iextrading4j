package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

public class AdvancedStatsRequestBuilder extends AbstractStocksRequestBuilder<AdvancedStats, AdvancedStatsRequestBuilder>
        implements IEXCloudV1RestRequest<AdvancedStats> {

    @Override
    public RestRequest<AdvancedStats> build() {
        return RestRequestBuilder.<AdvancedStats>builder()
                .withPath("/stock/{symbol}/advanced-stats")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(AdvancedStats.class)
                .build();
    }

}
