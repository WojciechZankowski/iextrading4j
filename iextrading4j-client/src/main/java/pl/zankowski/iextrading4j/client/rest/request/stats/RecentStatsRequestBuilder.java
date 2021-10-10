package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class RecentStatsRequestBuilder extends AbstractRequestFilterBuilder<List<RecentStats>, RecentStatsRequestBuilder>
        implements IEXApiRestRequest<List<RecentStats>>, IEXCloudV1RestRequest<List<RecentStats>> {

    @Override
    public RestRequest<List<RecentStats>> build() {
        return RestRequestBuilder.<List<RecentStats>>builder()
                .withPath("/stats/recent").get()
                .withResponse(new GenericType<List<RecentStats>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

}
