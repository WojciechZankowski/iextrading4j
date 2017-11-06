package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class RecentStatsRequestBuilder extends AbstractRequestFilterBuilder<List<RecentStats>, RecentStatsRequestBuilder> {

    @Override
    public RestRequest<List<RecentStats>> build() {
        return RestRequestBuilder.<List<RecentStats>>builder()
                .withPath("/stats/recent").get()
                .withResponse(new GenericType<List<RecentStats>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
