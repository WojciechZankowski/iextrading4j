package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicator;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicatorType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.TechnicalIndicatorRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class TechnicalIndicatorServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void technicalIndicatorServiceTest() {
        stubFor(get(urlEqualTo(extendedPath("/stock/AAPL/indicator/bbands?range=6m")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/TechnicalIndicatorResponse.json")));

        final TechnicalIndicator technicalIndicator = cloudClient.executeRequest(new TechnicalIndicatorRequestBuilder()
                .withSymbol("AAPL")
                .withTechnicalIndicatorType(TechnicalIndicatorType.BBANDS)
                .withRange(ChartRange.SIX_MONTHS)
                .build());

        assertThat(technicalIndicator.getIndicator()).hasSize(1);
        assertThat(technicalIndicator.getIndicator().get(0)).hasSize(2);
        assertThat(technicalIndicator.getIndicator().get(0).get(0)).isEqualTo(BigDecimal.valueOf(32.89100833109358));
        assertThat(technicalIndicator.getIndicator().get(0).get(1)).isEqualTo(BigDecimal.valueOf(34.12321658001891));

        assertThat(technicalIndicator.getChart()).hasSize(1);

        final Chart chart = technicalIndicator.getChart().get(0);
        assertThat(chart.getDate()).isEqualTo("2019-04-11");
        assertThat(chart.getOpen()).isEqualTo(BigDecimal.valueOf(34.83));
        assertThat(chart.getClose()).isEqualTo(BigDecimal.valueOf(35.42));
        assertThat(chart.getHigh()).isEqualTo(BigDecimal.valueOf(36.41));
        assertThat(chart.getLow()).isEqualTo(BigDecimal.valueOf(34.61));
        assertThat(chart.getVolume()).isEqualTo(BigDecimal.valueOf(11104786));
        assertThat(chart.getuOpen()).isEqualTo(BigDecimal.valueOf(34.76));
        assertThat(chart.getuClose()).isEqualTo(BigDecimal.valueOf(36.16));
        assertThat(chart.getuHigh()).isEqualTo(BigDecimal.valueOf(36.36));
        assertThat(chart.getuLow()).isEqualTo(BigDecimal.valueOf(35.99));
        assertThat(chart.getuVolume()).isEqualTo(BigDecimal.valueOf(11477825L));
        assertThat(chart.getChange()).isEqualTo(BigDecimal.ZERO);
        assertThat(chart.getChangePercent()).isEqualTo(BigDecimal.ZERO);
        assertThat(chart.getLabel()).isEqualTo("Apr 11, 19");
        assertThat(chart.getChangeOverTime()).isEqualTo(BigDecimal.ZERO);
    }

}
