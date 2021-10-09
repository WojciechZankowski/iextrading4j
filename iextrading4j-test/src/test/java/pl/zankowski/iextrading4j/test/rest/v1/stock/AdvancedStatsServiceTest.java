package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.AdvancedStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class AdvancedStatsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void advancedStatsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/advanced-stats")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/AdvancedStatsResponse.json")));

        final AdvancedStats advancedStats = cloudClient.executeRequest(new AdvancedStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(advancedStats.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(advancedStats.getMarketcap()).isEqualTo(BigDecimal.valueOf(760334287200L));
        assertThat(advancedStats.getWeek52high()).isEqualTo(BigDecimal.valueOf(156.65));
        assertThat(advancedStats.getWeek52low()).isEqualTo(BigDecimal.valueOf(93.63));
        assertThat(advancedStats.getWeek52highSplitAdjustOnly()).isEqualTo(BigDecimal.valueOf(69.96));
        assertThat(advancedStats.getWeek52highDateSplitAdjustOnly()).isEqualTo(LocalDate.of(2021, 2, 9));
        assertThat(advancedStats.getWeek52lowSplitAdjustOnly()).isEqualTo(BigDecimal.valueOf(20));
        assertThat(advancedStats.getWeek52lowDateSplitAdjustOnly()).isEqualTo(LocalDate.of(2020, 3, 8));
        assertThat(advancedStats.getWeek52change()).isEqualTo(BigDecimal.valueOf(58.801903));
        assertThat(advancedStats.getSharesOutstanding()).isEqualTo(BigDecimal.valueOf(5213840000L));
        assertThat(advancedStats.getFloat()).isEqualTo(BigDecimal.valueOf(5203997571L));
        assertThat(advancedStats.getSymbol()).isEqualTo("AAPL");
        assertThat(advancedStats.getAvg10Volume()).isEqualTo(BigDecimal.valueOf(2774000));
        assertThat(advancedStats.getAvg30Volume()).isEqualTo(BigDecimal.valueOf(12774000));
        assertThat(advancedStats.getDay200MovingAvg()).isEqualTo(BigDecimal.valueOf(140.60541));
        assertThat(advancedStats.getDay50MovingAvg()).isEqualTo(BigDecimal.valueOf(156.49678));
        assertThat(advancedStats.getEmployees()).isEqualTo(BigDecimal.valueOf(120000));
        assertThat(advancedStats.getTtmEPS()).isEqualTo(BigDecimal.valueOf(16.5));
        assertThat(advancedStats.getTtmDividendRate()).isEqualTo(BigDecimal.valueOf(2.25));
        assertThat(advancedStats.getDividendYield()).isEqualTo(BigDecimal.valueOf(0.021));
        assertThat(advancedStats.getNextDividendDate()).isEqualTo(LocalDate.of(2019, 3, 1));
        assertThat(advancedStats.getExDividendDate()).isEqualTo(LocalDate.of(2019, 2, 8));
        assertThat(advancedStats.getNextEarningsDate()).isEqualTo(LocalDate.of(2019, 1, 1));
        assertThat(advancedStats.getPeRatio()).isEqualTo(BigDecimal.valueOf(14));
        assertThat(advancedStats.getMaxChangePercent()).isEqualTo(BigDecimal.valueOf(153.021));
        assertThat(advancedStats.getYear5ChangePercent()).isEqualTo(BigDecimal.valueOf(0.5902546932200027));
        assertThat(advancedStats.getYear2ChangePercent()).isEqualTo(BigDecimal.valueOf(0.3777449874142869));
        assertThat(advancedStats.getYear1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.39751716851558366));
        assertThat(advancedStats.getYtdChangePercent()).isEqualTo(BigDecimal.valueOf(0.36659492036160124));
        assertThat(advancedStats.getMonth6ChangePercent()).isEqualTo(BigDecimal.valueOf(0.12208398133748043));
        assertThat(advancedStats.getMonth3ChangePercent()).isEqualTo(BigDecimal.valueOf(0.08466584665846649));
        assertThat(advancedStats.getMonth1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.009668596145283263));
        assertThat(advancedStats.getDay5ChangePercent()).isEqualTo(BigDecimal.valueOf(-0.005762605699968781));
        assertThat(advancedStats.getDay30ChangePercent()).isEqualTo(BigDecimal.valueOf(-0.002762605699968781));
        assertThat(advancedStats.getTotalCash()).isEqualTo(BigDecimal.valueOf(66301000000L));
        assertThat(advancedStats.getCurrentDebt()).isEqualTo(BigDecimal.valueOf(20748000000L));
        assertThat(advancedStats.getRevenue()).isEqualTo(BigDecimal.valueOf(265809000000L));
        assertThat(advancedStats.getGrossProfit()).isEqualTo(BigDecimal.valueOf(101983000000L));
        assertThat(advancedStats.getTotalRevenue()).isEqualTo(BigDecimal.valueOf(265809000000L));
        assertThat(advancedStats.getEbitda()).isEqualTo(BigDecimal.valueOf(80342000000L));
        assertThat(advancedStats.getRevenuePerShare()).isEqualTo(BigDecimal.valueOf(0.02));
        assertThat(advancedStats.getRevenuePerEmployee()).isEqualTo(BigDecimal.valueOf(2013704.55));
        assertThat(advancedStats.getDebtToEquity()).isEqualTo(BigDecimal.valueOf(1.07));
        assertThat(advancedStats.getProfitMargin()).isEqualTo(BigDecimal.valueOf(22.396157));
        assertThat(advancedStats.getEnterpriseValue()).isEqualTo(BigDecimal.valueOf(1022460690000L));
        assertThat(advancedStats.getEnterpriseValueToRevenue()).isEqualTo(BigDecimal.valueOf(3.85));
        assertThat(advancedStats.getPriceToSales()).isEqualTo(BigDecimal.valueOf(3.49));
        assertThat(advancedStats.getPriceToBook()).isEqualTo(BigDecimal.valueOf(8.805916432564608));
        assertThat(advancedStats.getForwardPERatio()).isEqualTo(BigDecimal.valueOf(18.14));
        assertThat(advancedStats.getPegRatio()).isEqualTo(BigDecimal.valueOf(2.19));
        assertThat(advancedStats.getBeta()).isEqualTo(BigDecimal.valueOf(1.4661365583766115));
        assertThat(advancedStats.getPeHigh()).isEqualTo(BigDecimal.valueOf(20.32690672651231));
        assertThat(advancedStats.getPeLow()).isEqualTo(BigDecimal.valueOf(12.591979637697179));
        assertThat(advancedStats.getWeek52lowDate()).isEqualTo(LocalDate.of(2019, 1, 14));
        assertThat(advancedStats.getWeek52highDate()).isEqualTo(LocalDate.of(2019, 11, 7));
        assertThat(advancedStats.getPutCallRatio()).isEqualTo(BigDecimal.valueOf(0.7611902044412406));
    }

}
