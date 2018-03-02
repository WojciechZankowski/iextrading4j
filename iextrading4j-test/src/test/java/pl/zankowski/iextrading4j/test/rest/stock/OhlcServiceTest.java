package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OhlcServiceTest extends BaseServiceTest {

    @Test
    public void ohlcServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/ohlc"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("/rest/stock/OhlcResponse.json")));

        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(ohlc.getOpen().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(154));
        assertThat(ohlc.getOpen().getTime()).isEqualTo(1506605400394L);
        assertThat(ohlc.getClose().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(153.28));
        assertThat(ohlc.getClose().getTime()).isEqualTo(1506605400394L);
        assertThat(ohlc.getHigh()).isEqualByComparingTo(BigDecimal.valueOf(154.80));
        assertThat(ohlc.getLow()).isEqualByComparingTo(BigDecimal.valueOf(153.25));
    }
}
