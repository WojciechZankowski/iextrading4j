package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;

public class OpHaltStatusRequestBuilder extends AbstractMarketDataRequestBuilder<HashMap<String, OpHaltStatus>, BookRequestBuilder> {

    @Override
    public RestRequest<HashMap<String, OpHaltStatus>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/op-halt-status").get()
                .withResponse(new GenericType<HashMap<String, OpHaltStatus>>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
