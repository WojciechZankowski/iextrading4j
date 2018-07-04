package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEventType;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.SecurityEventRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SecurityEventServiceTest extends BaseRestServiceTest {

    @Test
    public void securityEventServiceTest() {
        stubFor(get(urlEqualTo("/deep/security-event?symbols=AAPL"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/SecurityEventResponse.json")));

        final Map<String, SecurityEvent> securityEventMap = iexTradingClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final SecurityEvent securityEvent = securityEventMap.get("AAPL");
        assertThat(securityEvent.getSecurityEvent()).isEqualTo(SecurityEventType.MarketOpen);
        assertThat(securityEvent.getTimestamp()).isEqualTo(1510947000001L);
    }

}
