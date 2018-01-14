package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

public class RecordStatsRequestBuilder extends AbstractRequestFilterBuilder<RecordsStats, RecordStatsRequestBuilder> {

    @Override
    public RestRequest<RecordsStats> build() {
        return RestRequestBuilder.<RecordsStats>builder()
                .withPath("/stats/records").get()
                .withResponse(RecordsStats.class)
                .addQueryParam(getFilterParams())
                .build();
    }

}
