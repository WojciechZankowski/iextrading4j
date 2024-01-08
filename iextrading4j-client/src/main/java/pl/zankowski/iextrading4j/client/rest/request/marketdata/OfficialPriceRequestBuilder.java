package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.OfficialPrice;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class OfficialPriceRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, OfficialPrice>, OfficialPriceRequestBuilder>
        implements IEXApiRestRequest<Map<String, OfficialPrice>>, IEXCloudV1RestRequest<Map<String, OfficialPrice>> {

    @Override
    public RestRequest<Map<String, OfficialPrice>> build() {
        return RestRequestBuilder.<Map<String, OfficialPrice>>builder()
                .withPath("/deep/official-price").get()
                .withResponse(new GenericType<Map<String, OfficialPrice>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
