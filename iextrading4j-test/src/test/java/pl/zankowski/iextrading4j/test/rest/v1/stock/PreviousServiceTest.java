package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.BarData;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.PreviousMarketRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.PreviousRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PreviousServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void previousServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/previous")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/PreviousResponse.json")));

        final BarData barData = cloudClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(barData.getSymbol()).isEqualTo("AAPL");
        assertThat(barData.getDate()).isEqualTo(LocalDate.of(2017, 11, 16));
        assertThat(barData.getOpen()).isEqualTo(BigDecimal.valueOf(171.18));
        assertThat(barData.getHigh()).isEqualTo(BigDecimal.valueOf(171.87));
        assertThat(barData.getLow()).isEqualTo(BigDecimal.valueOf(170.3));
        assertThat(barData.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(barData.getVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getuOpen()).isEqualTo(BigDecimal.valueOf(191.51));
        assertThat(barData.getuClose()).isEqualTo(BigDecimal.valueOf(188.74));
        assertThat(barData.getuHigh()).isEqualTo(BigDecimal.valueOf(191.98));
        assertThat(barData.getuLow()).isEqualTo(BigDecimal.valueOf(186.6));
        assertThat(barData.getuVolume()).isEqualTo(BigDecimal.valueOf(43845293));
        assertThat(barData.getChange()).isEqualTo(BigDecimal.valueOf(2.02));
        assertThat(barData.getChangePercent()).isEqualTo(BigDecimal.valueOf(1.195));
    }

    @Test
    void previousMarketServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/market/previous")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/PreviousMarketResponse.json")));

        final Map<String, BarData> barDataMap = cloudClient.executeRequest(new PreviousMarketRequestBuilder()
                .build());

        final BarData barData = barDataMap.get("AAPL");
        assertThat(barData.getSymbol()).isEqualTo("AAPL");
        assertThat(barData.getDate()).isEqualTo(LocalDate.of(2017, 11, 16));
        assertThat(barData.getOpen()).isEqualTo(BigDecimal.valueOf(171.18));
        assertThat(barData.getHigh()).isEqualTo(BigDecimal.valueOf(171.87));
        assertThat(barData.getLow()).isEqualTo(BigDecimal.valueOf(170.3));
        assertThat(barData.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(barData.getVolume()).isEqualTo(BigDecimal.valueOf(23637484L));
        assertThat(barData.getuOpen()).isEqualTo(BigDecimal.valueOf(191.51));
        assertThat(barData.getuClose()).isEqualTo(BigDecimal.valueOf(188.74));
        assertThat(barData.getuHigh()).isEqualTo(BigDecimal.valueOf(191.98));
        assertThat(barData.getuLow()).isEqualTo(BigDecimal.valueOf(186.6));
        assertThat(barData.getuVolume()).isEqualTo(BigDecimal.valueOf(43845293));
        assertThat(barData.getChange()).isEqualTo(BigDecimal.valueOf(2.02));
        assertThat(barData.getChangePercent()).isEqualTo(BigDecimal.valueOf(1.195));
    }

}
