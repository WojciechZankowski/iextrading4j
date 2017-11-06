package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class IntradayStatsRequestBuilder implements IRestRequestBuilder<IntradayStats> {

    @Override
    public RestRequest<IntradayStats> build() {
        return RestRequestBuilder.builder()
                .withPath("/stats/intraday").get()
                .withResponse(new GenericType<IntradayStats>() {})
                .build();
    }

}
