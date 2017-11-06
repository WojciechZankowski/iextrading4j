package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class RecentStatsRequestBuilder implements IRestRequestBuilder<RecentStats> {

    @Override
    public RestRequest<RecentStats> build() {
        return RestRequestBuilder.builder()
                .withPath("/stats/recent").get()
                .withResponse(new GenericType<RecentStats>() {})
                .build();
    }

}
