package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

public class SecurityEventRequestBuilder extends AbstractMarketDataRequestBuilder<Map<String, SecurityEvent>, SecurityEventRequestBuilder>
        implements IEXApiRestRequest<Map<String, SecurityEvent>>, IEXCloudV1RestRequest<Map<String, SecurityEvent>> {

    @Override
    public RestRequest<Map<String, SecurityEvent>> build() {
        return RestRequestBuilder.<Map<String, SecurityEvent>>builder()
                .withPath("/deep/security-event").get()
                .withResponse(new GenericType<Map<String, SecurityEvent>>() {})
                .addQueryParam(getSymbols())
                .addQueryParam(getFilterParams())
                .build();
    }

}
