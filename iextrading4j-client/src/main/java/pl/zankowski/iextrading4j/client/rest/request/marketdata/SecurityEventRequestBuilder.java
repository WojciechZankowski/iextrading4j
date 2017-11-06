package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.HashMap;

public class SecurityEventRequestBuilder extends AbstractMarketDataRequestBuilder<HashMap<String, SecurityEvent>, BookRequestBuilder> {

    @Override
    public RestRequest<HashMap<String, SecurityEvent>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/deep/security-event").get()
                .withResponse(new GenericType<HashMap<String, SecurityEvent>>() {});

        applySymbols(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
