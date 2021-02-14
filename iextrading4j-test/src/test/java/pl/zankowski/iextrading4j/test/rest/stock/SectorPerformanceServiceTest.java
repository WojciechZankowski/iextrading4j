package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.SectorPerformance;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SectorPerformanceRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SectorPerformanceServiceTest extends BaseRestServiceTest {

    @Test
    public void todayEarningsServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/sector-performance"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/SectorPerformanceResponse.json")));

        final List<SectorPerformance> sectorPerformances = iexTradingClient.executeRequest(
                new SectorPerformanceRequestBuilder().build());

        assertThat(sectorPerformances).hasSize(1);

        final SectorPerformance sectorPerformance = sectorPerformances.get(0);
        assertThat(sectorPerformance.getType()).isEqualTo("sector");
        assertThat(sectorPerformance.getName()).isEqualTo("Financials");
        assertThat(sectorPerformance.getPerformance()).isEqualTo(BigDecimal.valueOf(0.00293));
        assertThat(sectorPerformance.getLastUpdated()).isEqualTo(1541710800463L);
    }
}
