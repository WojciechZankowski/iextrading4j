package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.TodayEarning;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
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
    public void todayEarningsServiceTest() {
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
        assertThat(btoEarning.getAnnounceTime()).isEqualTo("BTO");
        assertThat(btoEarning.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(5));
        assertThat(btoEarning.getEPSSurpriseDollar()).isNull();
        assertThat(btoEarning.getEPSReportDate()).isEqualTo(LocalDate.of(2018, 11, 7));
        assertThat(btoEarning.getFiscalPeriod()).isEqualTo("Q1 2019");
        assertThat(btoEarning.getFiscalEndDate()).isEqualTo(LocalDate.of(2018, 9, 30));
        assertThat(btoEarning.getYearAgo()).isEqualByComparingTo(BigDecimal.valueOf(0.49));
        assertThat(btoEarning.getYearAgoChangePercent()).isNull();
        assertThat(btoEarning.getSymbol()).isEqualTo("FOXA");
        assertThat(btoEarning.getHeadline()).isEqualTo("Twenty-First Century Fox EPS in-line, misses on revenue");
        final Quote btoQuote = btoEarning.getQuote();
        assertThat(btoQuote.getSymbol()).isEqualTo("FOXA");

        final List<TodayEarning> amc = todayEarnings.getAmc();
        final TodayEarning amcEarning = amc.get(0);
        assertThat(amcEarning.getActualEPS()).isNull();
        assertThat(amcEarning.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(0.7));
        assertThat(amcEarning.getEstimatedEPS()).isEqualTo(BigDecimal.valueOf(0.7));
        assertThat(amcEarning.getAnnounceTime()).isEqualTo("AMC");
        assertThat(amcEarning.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(5));
        assertThat(amcEarning.getEPSSurpriseDollar()).isNull();
        assertThat(amcEarning.getEPSReportDate()).isEqualTo(LocalDate.of(2018, 11, 7));
        assertThat(amcEarning.getFiscalPeriod()).isEqualTo("Q4 2018");
        assertThat(amcEarning.getFiscalEndDate()).isEqualTo(LocalDate.of(2018, 9, 30));
        assertThat(amcEarning.getYearAgo()).isEqualByComparingTo(BigDecimal.valueOf(0.82));
        assertThat(amcEarning.getYearAgoChangePercent()).isNull();
        assertThat(amcEarning.getSymbol()).isEqualTo("QCOM");
        final Quote amcQuote = amcEarning.getQuote();
        assertThat(amcQuote.getSymbol()).isEqualTo("QCOM");
    }

}
