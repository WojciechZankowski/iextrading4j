package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.SystemEventRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SystemEventServiceTest extends BaseRestServiceTest {

    @Test
    public void systemEventServiceTest() {
        stubFor(get(urlEqualTo("/deep/system-event?symbols=SNAP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/SystemEventResponse.json")));

        final SystemEvent systemEvent = iexTradingClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("SNAP")
                .build());

        assertThat(systemEvent.getSystemEvent()).isEqualTo(SystemEventType.REGULAR_MARKET_HOURS_START);
        assertThat(systemEvent.getTimestamp()).isEqualTo(1510947000001L);
    }

}
