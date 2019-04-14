package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.BarData;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class PreviousMarketRequestBuilder implements IEXCloudV1RestRequest<Map<String, BarData>> {

    @Override
    public RestRequest<Map<String, BarData>> build() {
        return RestRequestBuilder.<Map<String, BarData>>builder()
                .withPath("/stock/{symbol}/previous")
                .addPathParam("symbol", "market").get()
                .withResponse(new GenericType<Map<String, BarData>>(){})
                .build();
    }
}
