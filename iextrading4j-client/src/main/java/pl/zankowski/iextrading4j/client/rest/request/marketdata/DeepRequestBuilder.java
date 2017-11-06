package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.DEEP;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;

public class DeepRequestBuilder extends AbstractMarketDataRequestBuilder<DEEP, DeepRequestBuilder> {

    @Override
    public RestRequest<DEEP> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep").get()
                .withResponse(new GenericType<DEEP>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
