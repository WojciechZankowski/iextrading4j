package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class ChartServiceTest extends BaseRestServiceTest {

    @Test
    public void oneDayChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/1d"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartOneDayResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_DAY)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("20180301");
        assertThat(point.getMinute()).isEqualTo("09:30");
        assertThat(point.getLabel()).isEqualTo("09:30 AM");
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(178.72));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(178.39));
        assertThat(point.getAverage()).isEqualTo(BigDecimal.valueOf(178.568));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(6216));
        assertThat(point.getNotional()).isEqualTo(BigDecimal.valueOf(1109979.115));
        assertThat(point.getNumberOfTrades()).isEqualTo(BigDecimal.valueOf(48));
        assertThat(point.getMarketHigh()).isEqualByComparingTo(BigDecimal.valueOf(178.75));
        assertThat(point.getMarketLow()).isEqualByComparingTo(BigDecimal.valueOf(178.35));
        assertThat(point.getMarketAverage()).isEqualByComparingTo(BigDecimal.valueOf(178.611));
        assertThat(point.getMarketVolume()).isEqualByComparingTo(BigDecimal.valueOf(830360));
        assertThat(point.getMarketNotional()).isEqualByComparingTo(BigDecimal.valueOf(148311474.4978));
        assertThat(point.getMarketOpen()).isEqualByComparingTo(BigDecimal.valueOf(162.11));
        assertThat(point.getMarketClose()).isEqualByComparingTo(BigDecimal.valueOf(161.88));
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
        assertThat(point.getMarketChangeOverTime()).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    public void oneMonthChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/1m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartOneMonthResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("2018-02-01");
        assertThat(point.getOpen()).isEqualTo(BigDecimal.valueOf(167.165));
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(168.62));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(166.76));
        assertThat(point.getClose()).isEqualTo(BigDecimal.valueOf(167.78));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(47230787));
        assertThat(point.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(47230787));
        assertThat(point.getChange()).isEqualTo(BigDecimal.valueOf(0.35));
        assertThat(point.getChangePercent()).isEqualTo(BigDecimal.valueOf(0.209));
        assertThat(point.getVwap()).isEqualTo(BigDecimal.valueOf(167.6021));
        assertThat(point.getLabel()).isEqualTo("Feb 1");
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void threeMonthChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/3m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartThreeMonthResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.THREE_MONTHS)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("2017-12-01");
        assertThat(point.getOpen()).isEqualTo(BigDecimal.valueOf(169.95));
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(171.67));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(168.5));
        assertThat(point.getClose()).isEqualTo(BigDecimal.valueOf(171.05));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(39759288));
        assertThat(point.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(39759288));
        assertThat(point.getChange()).isEqualTo(BigDecimal.valueOf(-0.8));
        assertThat(point.getChangePercent()).isEqualTo(BigDecimal.valueOf(-0.466));
        assertThat(point.getVwap()).isEqualTo(BigDecimal.valueOf(170.4191));
        assertThat(point.getLabel()).isEqualTo("Dec 1, 17");
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void sixMonthChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/6m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartSixMonthResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.SIX_MONTHS)
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("2017-09-01");
        assertThat(point.getOpen()).isEqualTo(BigDecimal.valueOf(164.8));
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(164.94));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(163.63));
        assertThat(point.getClose()).isEqualTo(BigDecimal.valueOf(164.05));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(16591051));
        assertThat(point.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(16591051));
        assertThat(point.getChange()).isEqualTo(BigDecimal.valueOf(0.05));
        assertThat(point.getChangePercent()).isEqualTo(BigDecimal.valueOf(0.03));
        assertThat(point.getVwap()).isEqualTo(BigDecimal.valueOf(164.1212));
        assertThat(point.getLabel()).isEqualTo("Sep 1, 17");
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void dateChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/date/20180129"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartDateResponse.json")));

        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withDate(LocalDate.of(2018, 1, 29))
                .withSymbol("aapl")
                .build());

        final Chart point = chartList.get(0);
        assertThat(point.getDate()).isEqualTo("20180129");
        assertThat(point.getMinute()).isEqualTo("09:30");
        assertThat(point.getLabel()).isEqualTo("09:30 AM");
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(169.9));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(168.74));
        assertThat(point.getAverage()).isEqualByComparingTo(BigDecimal.valueOf(169.546));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(34492));
        assertThat(point.getNotional()).isEqualByComparingTo(BigDecimal.valueOf(5847991.62));
        assertThat(point.getNumberOfTrades()).isEqualByComparingTo(BigDecimal.valueOf(335));
        assertThat(point.getMarketHigh()).isEqualByComparingTo(BigDecimal.valueOf(170.16));
        assertThat(point.getMarketLow()).isEqualByComparingTo(BigDecimal.valueOf(168.74));
        assertThat(point.getMarketAverage()).isEqualByComparingTo(BigDecimal.valueOf(169.695));
        assertThat(point.getMarketVolume()).isEqualByComparingTo(BigDecimal.valueOf(2618304));
        assertThat(point.getMarketNotional()).isEqualByComparingTo(BigDecimal.valueOf(444312772.8062));
        assertThat(point.getMarketNumberOfTrades()).isEqualByComparingTo(BigDecimal.valueOf(10710));
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
        assertThat(point.getMarketChangeOverTime()).isEqualByComparingTo(BigDecimal.ZERO);
    }



}
