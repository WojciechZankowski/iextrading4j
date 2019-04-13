package pl.zankowski.iextrading4j.client.rest.request.market;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class MarketRequestBuilder extends AbstractRequestFilterBuilder<List<MarketVolume>, MarketRequestBuilder> {

    @Override
    public RestRequest<List<MarketVolume>> build() {
        return RestRequestBuilder.<List<MarketVolume>>builder()
                .withPath("/market").get()
                .withResponse(new GenericType<List<MarketVolume>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
