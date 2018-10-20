package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksType;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class BatchChartRangeStocksResponseTest extends BaseRestServiceTest {

    @Test
    public void batchStocksServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/batch?types=chart&range=1m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/BatchChartRangeStocksResponse.json")));

        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .addType(BatchStocksType.CHART)
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("aapl")
                .build());

        final List<Chart> charts = batchStocks.getChart();
        final Chart point = charts.get(0);
        assertThat(point.getDate()).isEqualTo("2018-09-20");
        assertThat(point.getOpen()).isEqualTo(BigDecimal.valueOf(220.24));
        assertThat(point.getHigh()).isEqualTo(BigDecimal.valueOf(222.28));
        assertThat(point.getLow()).isEqualTo(BigDecimal.valueOf(219.15));
        assertThat(point.getClose()).isEqualTo(BigDecimal.valueOf(220.03));
        assertThat(point.getVolume()).isEqualTo(BigDecimal.valueOf(26608794));
        assertThat(point.getUnadjustedVolume()).isEqualTo(BigDecimal.valueOf(26608794));
        assertThat(point.getChange()).isEqualTo(BigDecimal.valueOf(1.66));
        assertThat(point.getChangePercent()).isEqualTo(BigDecimal.valueOf(0.76));
        assertThat(point.getVwap()).isEqualTo(BigDecimal.valueOf(220.7675));
        assertThat(point.getLabel()).isEqualTo("Sep 20");
        assertThat(point.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }
}
