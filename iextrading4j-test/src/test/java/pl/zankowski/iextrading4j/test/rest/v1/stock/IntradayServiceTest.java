package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Intraday;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IntradayRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IntradayServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void intradayServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/intraday-prices")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/IntradayPricesResponse.json")));

        final List<Intraday> result = cloudClient.executeRequest(new IntradayRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final Intraday intraday = result.get(0);
        assertThat(intraday.getDate()).isEqualTo("2019-05-30");
        assertThat(intraday.getMinute()).isEqualTo("09:30");
        assertThat(intraday.getLabel()).isEqualTo("09:30 AM");
        assertThat(intraday.getHigh()).isEqualTo(BigDecimal.valueOf(178.42));
        assertThat(intraday.getLow()).isEqualTo(BigDecimal.valueOf(177.75));
        assertThat(intraday.getAverage()).isEqualTo(BigDecimal.valueOf(178.169));
        assertThat(intraday.getVolume()).isEqualTo(BigDecimal.valueOf(16428));
        assertThat(intraday.getNotional()).isEqualTo(BigDecimal.valueOf(2926969.635));
        assertThat(intraday.getNumberOfTrades()).isEqualTo(BigDecimal.valueOf(108));
        assertThat(intraday.getMarketHigh()).isEqualTo(BigDecimal.valueOf(178.446));
        assertThat(intraday.getMarketLow()).isEqualTo(BigDecimal.valueOf(177.64));
        assertThat(intraday.getMarketAverage()).isEqualTo(BigDecimal.valueOf(178.018));
        assertThat(intraday.getMarketVolume()).isEqualTo(BigDecimal.valueOf(524149));
        assertThat(intraday.getMarketNotional()).isEqualTo(BigDecimal.valueOf(93307962.1503));
        assertThat(intraday.getMarketNumberOfTrades()).isEqualTo(BigDecimal.valueOf(1384));
        assertThat(intraday.getOpen()).isEqualTo(BigDecimal.valueOf(177.9));
        assertThat(intraday.getClose()).isEqualTo(BigDecimal.valueOf(178.36));
        assertThat(intraday.getMarketOpen()).isEqualTo(BigDecimal.valueOf(177.95));
        assertThat(intraday.getMarketClose()).isEqualTo(BigDecimal.valueOf(178.446));
        assertThat(intraday.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
        assertThat(intraday.getMarketChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

}
