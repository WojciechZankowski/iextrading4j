package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class OhlcMarketRequestBuilder implements IEXApiRestRequest<Map<String, Ohlc>>,
        IEXCloudV1RestRequest<Map<String, Ohlc>> {

    @Override
    public RestRequest<Map<String, Ohlc>> build() {
        return RestRequestBuilder.<Map<String, Ohlc>>builder()
                .withPath("/stock/{symbol}/ohlc")
                .addPathParam("symbol", "market").get()
                .withResponse(new GenericType<Map<String, Ohlc>>(){})
                .build();
    }
}
