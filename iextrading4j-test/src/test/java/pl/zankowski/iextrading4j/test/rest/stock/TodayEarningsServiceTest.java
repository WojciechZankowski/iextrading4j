package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Earning;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.TodayEarning;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayEarningsRequestBuilder;
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

public class TodayEarningsServiceTest extends BaseRestServiceTest {

    @Test
    public void earningsServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/today-earnings"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/TodayEarningsResponse.json")));

        final TodayEarnings todayEarnings = iexTradingClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());

        final List<TodayEarning> bto = todayEarnings.getBto();
        final TodayEarning btoEarning = bto.get(0);
        assertThat(btoEarning.getActualEPS()).isNull();
        assertThat(btoEarning.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(0.53));
        assertThat(btoEarning.getEstimatedEPS()).isEqualTo(BigDecimal.valueOf(0.53));
        assertThat(btoEarning.getAnnounceTime()).isEqualTo("AMC");
        assertThat(btoEarning.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(13));
        assertThat(btoEarning.getEPSSurpriseDollar()).isEqualTo(BigDecimal.valueOf(0.1));
        assertThat(btoEarning.getEPSReportDate()).isEqualTo(LocalDate.of(2017, 8, 1));
        assertThat(btoEarning.getFiscalPeriod()).isEqualTo("Q3 2017");
        assertThat(btoEarning.getFiscalEndDate()).isEqualTo(LocalDate.of(2017, 6, 30));
        assertThat(btoEarning.getYearAgo()).isEqualByComparingTo(BigDecimal.valueOf(3.36));
        assertThat(btoEarning.getYearAgoChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(16));
        assertThat(btoEarning.getEstimatedChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(14));
        assertThat(btoEarning.getSymbolId()).isEqualByComparingTo(BigDecimal.valueOf(11));

        final List<TodayEarning> amc = todayEarnings.getAmc();
        final TodayEarning amcEarning = amc.get(0);
        assertThat(amcEarning.getActualEPS()).isEqualTo(BigDecimal.valueOf(1.67));
        assertThat(amcEarning.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(1.57));
        assertThat(amcEarning.getEstimatedEPS()).isEqualTo(BigDecimal.valueOf(1.57));
        assertThat(amcEarning.getAnnounceTime()).isEqualTo("AMC");
        assertThat(amcEarning.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(13));
        assertThat(amcEarning.getEPSSurpriseDollar()).isEqualTo(BigDecimal.valueOf(0.1));
        assertThat(amcEarning.getEPSReportDate()).isEqualTo(LocalDate.of(2017, 8, 1));
        assertThat(amcEarning.getFiscalPeriod()).isEqualTo("Q3 2017");
        assertThat(amcEarning.getFiscalEndDate()).isEqualTo(LocalDate.of(2017, 6, 30));
        assertThat(amcEarning.getYearAgo()).isEqualByComparingTo(BigDecimal.valueOf(3.36));
        assertThat(amcEarning.getYearAgoChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(16));
        assertThat(amcEarning.getEstimatedChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(14));
        assertThat(amcEarning.getSymbolId()).isEqualByComparingTo(BigDecimal.valueOf(11));
    }

}
