package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class OpHaltStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, OpHaltStatus>, OpHaltStatusRequestBuilder> {

    @Override
    public RestRequest<Map<String, OpHaltStatus>> build() {
        return RestRequestBuilder.<Map<String, OpHaltStatus>>builder()
                .withPath("/deep/op-halt-status").get()
                .withResponse(new GenericType<Map<String, OpHaltStatus>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
