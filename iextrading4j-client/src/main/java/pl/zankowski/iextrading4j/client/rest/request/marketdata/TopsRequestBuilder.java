package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import java.util.ArrayList;

public class TopsRequestBuilder extends AbstractMarketDataRequestBuilder<ArrayList<LastTrade>, TopsRequestBuilder> {

    @Override
    public RestRequest<ArrayList<LastTrade>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/tops").get()
                .withResponse(ArrayList.class);

        applyRequestFilter(restRequestBuilder);
        applySymbols(restRequestBuilder);

        return restRequestBuilder.build();
    }
}
