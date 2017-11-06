package pl.zankowski.iextrading4j.client.rest.request.stats;

import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class RecordStatsRequestBuilder implements IRestRequestBuilder<RecordsStats> {

    @Override
    public RestRequest<RecordsStats> build() {
        return RestRequestBuilder.builder()
                .withPath("/stats/records").get()
                .withResponse(new GenericType<RecordsStats>() {})
                .build();
    }

}
