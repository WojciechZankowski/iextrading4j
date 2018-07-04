package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.OpHaltStatusRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OpHaltStatusServiceTest extends BaseRestServiceTest {

    @Test
    public void opHaltStatusServiceTest() {
        stubFor(get(urlEqualTo("/deep/op-halt-status?symbols=SNAP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/OpHaltStatusResponse.json")));

        final Map<String, OpHaltStatus> opHaltStatusMap = iexTradingClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("SNAP")
                .build());

        final OpHaltStatus opHaltStatus = opHaltStatusMap.get("SNAP");
        assertThat(opHaltStatus.isHalted()).isFalse();
        assertThat(opHaltStatus.getTimestamp()).isEqualTo(1510939321339L);
    }

}
