package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.DynamicChart;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DynamicChartRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class DynamicChartServiceTest extends BaseRestServiceTest {

    @Test
    public void dynamicChartServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/chart/dynamic"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ChartDynamicResponse.json")));

        final DynamicChart dynamicChart = iexTradingClient.executeRequest(new DynamicChartRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(dynamicChart.getRange()).isEqualTo(ChartRange.ONE_MONTH);

        final Chart point = dynamicChart.getData().get(0);
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

}
