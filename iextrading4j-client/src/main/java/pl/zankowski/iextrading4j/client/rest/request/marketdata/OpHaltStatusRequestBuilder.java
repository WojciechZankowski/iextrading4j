package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

public class OpHaltStatusRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, OpHaltStatus>, OpHaltStatusRequestBuilder>
        implements IEXApiRestRequest<Map<String, OpHaltStatus>>, IEXCloudV1RestRequest<Map<String, OpHaltStatus>> {

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
