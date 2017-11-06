package pl.zankowski.iextrading4j.client.rest.request.market;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class MarketRequestBuilder implements IRestRequestBuilder<ArrayList<MarketVolume>> {

    @Override
    public RestRequest<ArrayList<MarketVolume>> build() {
        return RestRequestBuilder.builder()
                .withPath("/market").get()
                .withResponse(new GenericType<ArrayList<ExchangeSymbol>>() {})
                .build();
    }

}
