package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class ChartServiceTest extends BaseServiceTest {

    @Test
    public void oneDayChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/1d"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("/rest/stock/OneDayChartResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_DAY)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("20171117");
        assertThat(point.getMinute()).isEqualTo("09:30");
        assertThat(point.getLabel()).isEqualTo("09:30 AM");
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(170.87));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(170.575));
        assertThat(point.getAverage()).isEqualTo(BigDecimal.valueOf(170.791));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(4313));
        assertThat(point.getNotional()).isEqualTo(BigDecimal.valueOf(736621.13));
        assertThat(point.getNumberOfTrades()).isEqualTo(BigDecimal.valueOf(23));
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void oneMonthChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/1m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("/rest/stock/OneMonthChartResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("2017-10-16");
        assertThat(point.getOpen()).isEqualTo(BigDecimal.valueOf(157.9));
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(160));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(157.65));
        assertThat(point.getClose()).isEqualTo(BigDecimal.valueOf(159.88));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(24121452));
        assertThat(point.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(24121452));
        assertThat(point.getChange()).isEqualTo(BigDecimal.valueOf(2.89));
        assertThat(point.getChangePercent()).isEqualTo(BigDecimal.valueOf(1.841));
        assertThat(point.getVwap()).isEqualTo(BigDecimal.valueOf(159.277));
        assertThat(point.getLabel()).isEqualTo("Oct 16");
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

}
