package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class LastTradeRequestBuilder extends AbstractMarketDataRequestBuilder<ArrayList<LastTrade>, LastTradeRequestBuilder> {

    @Override
    public RestRequest<ArrayList<LastTrade>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/tops/last").get()
                .withResponse(new GenericType<ArrayList<LastTrade>>() {});

        applyRequestFilter(restRequestBuilder);
        applySymbols(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
