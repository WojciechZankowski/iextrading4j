package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.SectorPerformance;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class SectorPerformanceRequestBuilder implements IRestRequestBuilder<List<SectorPerformance>> {

    @Override
    public RestRequest<List<SectorPerformance>> build() {
        return RestRequestBuilder.<List<SectorPerformance>>builder()
                .withPath("/stock/market/sector-performance").get()
                .withResponse(new GenericType<List<SectorPerformance>>(){})
                .build();
    }

}
