package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

public class AuctionRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, Auction>, AuctionRequestBuilder>
        implements IEXApiRestRequest<Map<String, Auction>>, IEXCloudV1RestRequest<Map<String, Auction>> {

    @Override
    public RestRequest<Map<String, Auction>> build() {
        return RestRequestBuilder.<Map<String, Auction>>builder()
                .withPath("/deep/auction").get()
                .withResponse(new GenericType<Map<String, Auction>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }
}
