package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Earning;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
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

public class EarningsServiceTest extends BaseRestServiceTest {

    @Test
    public void earningsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/earnings"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/EarningsResponse.json")));

        final Earnings earnings = iexTradingClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(earnings.getSymbol()).isEqualTo("AAPL");

        final List<Earning> earningList = earnings.getEarnings();
        final Earning earning = earningList.get(0);
        assertThat(earning.getActualEPS()).isEqualTo(BigDecimal.valueOf(1.67));
        assertThat(earning.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(1.57));
        assertThat(earning.getEstimatedEPS()).isEqualTo(BigDecimal.valueOf(1.57));
        assertThat(earning.getAnnounceTime()).isEqualTo("AMC");
        assertThat(earning.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(13));
        assertThat(earning.getEPSSurpriseDollar()).isEqualTo(BigDecimal.valueOf(0.1));
        assertThat(earning.getEPSReportDate()).isEqualTo(LocalDate.of(2017, 8, 1));
        assertThat(earning.getFiscalPeriod()).isEqualTo("Q3 2017");
        assertThat(earning.getFiscalEndDate()).isEqualTo(LocalDate.of(2017, 6, 30));
        assertThat(earning.getYearAgo()).isEqualByComparingTo(BigDecimal.valueOf(3.36));
        assertThat(earning.getYearAgoChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(16));
        assertThat(earning.getEstimatedChangePercent()).isEqualByComparingTo(BigDecimal.valueOf(14));
        assertThat(earning.getSymbolId()).isEqualByComparingTo(BigDecimal.valueOf(11));
    }

}
