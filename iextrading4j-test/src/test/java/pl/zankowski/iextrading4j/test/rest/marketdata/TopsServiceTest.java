package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TopsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class TopsServiceTest extends BaseRestServiceTest {

    @Test
    public void topsServiceTest() {
        stubFor(get(urlEqualTo("/tops?symbols=AAPL"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/TopsResponse.json")));

        final List<TOPS> topsList = iexTradingClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final TOPS tops = topsList.get(0);
        assertThat(tops.getSymbol()).isEqualTo("AAPL");
        assertThat(tops.getMarketPercent()).isEqualTo(BigDecimal.valueOf(0.01341));
        assertThat(tops.getBidSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(tops.getBidPrice()).isEqualTo(BigDecimal.valueOf(166.18));
        assertThat(tops.getAskSize()).isEqualTo(BigDecimal.valueOf(315));
        assertThat(tops.getAskPrice()).isEqualTo(BigDecimal.valueOf(172));
        assertThat(tops.getVolume()).isEqualTo(BigDecimal.valueOf(184260));
        assertThat(tops.getLastSalePrice()).isEqualTo(BigDecimal.valueOf(170.435));
        assertThat(tops.getLastSaleSize()).isEqualTo(BigDecimal.valueOf(60));
        assertThat(tops.getLastSaleTime()).isEqualTo(1510943467901L);
        assertThat(tops.getLastUpdated()).isEqualTo(1510943543270L);
        assertThat(tops.getSector()).isEqualTo("technologyhardwareequipmen");
        assertThat(tops.getSecurityType()).isEqualTo("commonstock");
    }

}
