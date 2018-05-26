package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class PreviousMarketRequestBuilder implements IRestRequestBuilder<Map<String, BarData>> {

    @Override
    public RestRequest<Map<String, BarData>> build() {
        return RestRequestBuilder.<Map<String, BarData>>builder()
                .withPath("/stock/{symbol}/previous")
                .addPathParam("symbol", "market").get()
                .withResponse(new GenericType<Map<String, BarData>>(){})
                .build();
    }
}
