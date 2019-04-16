package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class TradingStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, TradingStatus>, TradingStatusRequestBuilder>
        implements IEXApiRestRequest<Map<String, TradingStatus>>, IEXCloudV1RestRequest<Map<String, TradingStatus>> {

    @Override
    public RestRequest<Map<String, TradingStatus>> build() {
        return RestRequestBuilder.<Map<String, TradingStatus>>builder()
                .withPath("/deep/trading-status").get()
                .withResponse(new GenericType<Map<String, TradingStatus>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
