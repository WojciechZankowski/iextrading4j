package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

public class IntradayStatsRequestBuilder extends AbstractRequestFilterBuilder<IntradayStats, HistoricalStatsRequestBuilder> {

    @Override
    public RestRequest<IntradayStats> build() {
        return RestRequestBuilder.<IntradayStats>builder()
                .withPath("/stats/intraday").get()
                .withResponse(IntradayStats.class)
                .addQueryParam(getFilterParams())
                .build();
    }

}
