package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PreviousMarketRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PreviousRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PreviousServiceTest extends BaseRestServiceTest {

    @Test
    public void previousServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/previous"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/PreviousResponse.json")));

        final BarData barData = iexTradingClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(barData.getSymbol()).isEqualTo("AAPL");
        assertThat(barData.getDate()).isEqualTo(LocalDate.of(2017, 11, 16));
        assertThat(barData.getOpen()).isEqualTo(BigDecimal.valueOf(171.18));
        assertThat(barData.getHigh()).isEqualTo(BigDecimal.valueOf(171.87));
        assertThat(barData.getLow()).isEqualTo(BigDecimal.valueOf(170.3));
        assertThat(barData.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(barData.getVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getChange()).isEqualTo(BigDecimal.valueOf(2.02));
        assertThat(barData.getChangePercent()).isEqualTo(BigDecimal.valueOf(1.195));
        assertThat(barData.getVwap()).isEqualTo(BigDecimal.valueOf(171.1673));
    }

    @Test
    public void previousMarketServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/previous"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/PreviousMarketResponse.json")));

        final Map<String, BarData> barDataMap = iexTradingClient.executeRequest(new PreviousMarketRequestBuilder()
                .build());

        final BarData barData = barDataMap.get("AAPL");
        assertThat(barData.getSymbol()).isEqualTo("AAPL");
        assertThat(barData.getDate()).isEqualTo(LocalDate.of(2017, 11, 16));
        assertThat(barData.getOpen()).isEqualTo(BigDecimal.valueOf(171.18));
        assertThat(barData.getHigh()).isEqualTo(BigDecimal.valueOf(171.87));
        assertThat(barData.getLow()).isEqualTo(BigDecimal.valueOf(170.3));
        assertThat(barData.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(barData.getVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getChange()).isEqualTo(BigDecimal.valueOf(2.02));
        assertThat(barData.getChangePercent()).isEqualTo(BigDecimal.valueOf(1.195));
        assertThat(barData.getVwap()).isEqualTo(BigDecimal.valueOf(171.1673));
    }

}
