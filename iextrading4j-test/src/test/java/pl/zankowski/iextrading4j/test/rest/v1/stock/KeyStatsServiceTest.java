package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.KeyStats;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class KeyStatsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void keyStatsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/stats")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/KeyStatsResponse.json")));

        final KeyStats keyStats = cloudClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(keyStats.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(keyStats.getMarketcap()).isEqualTo(BigDecimal.valueOf(760334287200L));
        assertThat(keyStats.getWeek52high()).isEqualTo(BigDecimal.valueOf(156.65));
        assertThat(keyStats.getWeek52low()).isEqualTo(BigDecimal.valueOf(93.63));
        assertThat(keyStats.getWeek52change()).isEqualTo(BigDecimal.valueOf(58.801903));
        assertThat(keyStats.getSharesOutstanding()).isEqualTo(BigDecimal.valueOf(5213840000L));
        assertThat(keyStats.getFloat()).isEqualTo(BigDecimal.valueOf(5203997571L));
        assertThat(keyStats.getSymbol()).isEqualTo("AAPL");
        assertThat(keyStats.getAvg10Volume()).isEqualTo(BigDecimal.valueOf(2774000));
        assertThat(keyStats.getAvg30Volume()).isEqualTo(BigDecimal.valueOf(12774000));
        assertThat(keyStats.getDay200MovingAvg()).isEqualTo(BigDecimal.valueOf(140.60541));
        assertThat(keyStats.getDay50MovingAvg()).isEqualTo(BigDecimal.valueOf(156.49678));
        assertThat(keyStats.getEmployees()).isEqualTo(BigDecimal.valueOf(120000));
        assertThat(keyStats.getTtmEPS()).isEqualTo(BigDecimal.valueOf(16.5));
        assertThat(keyStats.getTtmDividendRate()).isEqualTo(BigDecimal.valueOf(2.25));
        assertThat(keyStats.getDividendYield()).isEqualTo(BigDecimal.valueOf(0.021));
        assertThat(keyStats.getNextDividendDate()).isEqualTo(LocalDate.of(2019, 3, 1));
        assertThat(keyStats.getExDividendDate()).isEqualTo(LocalDate.of(2019, 2, 8));
        assertThat(keyStats.getNextEarningsDate()).isEqualTo(LocalDate.of(2019, 1, 1));
        assertThat(keyStats.getPeRatio()).isEqualTo(BigDecimal.valueOf(14));
        assertThat(keyStats.getMaxChangePercent()).isEqualTo(BigDecimal.valueOf(153.021));
        assertThat(keyStats.getYear5ChangePercent()).isEqualTo(BigDecimal.valueOf(0.5902546932200027));
        assertThat(keyStats.getYear2ChangePercent()).isEqualTo(BigDecimal.valueOf(0.3777449874142869));
        assertThat(keyStats.getYear1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.39751716851558366));
        assertThat(keyStats.getYtdChangePercent()).isEqualTo(BigDecimal.valueOf(0.36659492036160124));
        assertThat(keyStats.getMonth6ChangePercent()).isEqualTo(BigDecimal.valueOf(0.12208398133748043));
        assertThat(keyStats.getMonth3ChangePercent()).isEqualTo(BigDecimal.valueOf(0.08466584665846649));
        assertThat(keyStats.getMonth1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.009668596145283263));
        assertThat(keyStats.getDay5ChangePercent()).isEqualTo(BigDecimal.valueOf(-0.005762605699968781));
        assertThat(keyStats.getDay30ChangePercent()).isEqualTo(BigDecimal.valueOf(-0.002762605699968781));
        assertThat(keyStats.getBeta()).isEqualTo(BigDecimal.valueOf(1.4661365583766115));
    }

}
