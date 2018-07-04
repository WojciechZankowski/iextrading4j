package pl.zankowski.iextrading4j.test.rest.market;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class MarketServiceTest extends BaseRestServiceTest {

    @Test
    public void marketServiceTest() {
        stubFor(get(urlEqualTo("/market"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/market/MarketResponse.json")));

        final List<MarketVolume> result = iexTradingClient.executeRequest(new MarketRequestBuilder().build());

        final MarketVolume xphlMarket = result.get(0);
        assertThat(xphlMarket.getMic()).isEqualTo("XPHL");
        assertThat(xphlMarket.getTapeId()).isEqualTo("X");
        assertThat(xphlMarket.getVenueName()).isEqualTo("NASDAQ PSX");
        assertThat(xphlMarket.getVolume()).isEqualTo(BigDecimal.valueOf(151449455));
        assertThat(xphlMarket.getTapeA()).isEqualTo(BigDecimal.valueOf(151449455));
        assertThat(xphlMarket.getTapeB()).isEqualTo(BigDecimal.ZERO);
        assertThat(xphlMarket.getTapeC()).isEqualTo(BigDecimal.ZERO);
        assertThat(xphlMarket.getMarketPercent()).isEqualTo(BigDecimal.valueOf(0.98842));
        assertThat(xphlMarket.getLastUpdated()).isEqualTo(1510408410385L);

        final MarketVolume trfMarket = result.get(1);
        assertThat(trfMarket.getMic()).isEqualTo("TRF");
        assertThat(trfMarket.getTapeId()).isEqualTo("-");
        assertThat(trfMarket.getVenueName()).isEqualTo("TRF Volume");
        assertThat(trfMarket.getVolume()).isEqualTo(BigDecimal.valueOf(309400));
        assertThat(trfMarket.getTapeA()).isEqualTo(BigDecimal.valueOf(123400));
        assertThat(trfMarket.getTapeB()).isEqualTo(BigDecimal.valueOf(31300));
        assertThat(trfMarket.getTapeC()).isEqualTo(BigDecimal.valueOf(154700));
        assertThat(trfMarket.getMarketPercent()).isEqualTo(BigDecimal.valueOf(0.00202));
        assertThat(trfMarket.getLastUpdated()).isEqualTo(1510408411468L);
    }

}
