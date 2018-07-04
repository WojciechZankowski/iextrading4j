package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.client.rest.request.stocks.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class KeyStatsServiceTest extends BaseRestServiceTest {

    @Test
    public void keyStatsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/stats"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/KeyStatsResponse.json")));

        final KeyStats keyStats = iexTradingClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(keyStats.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(keyStats.getMarketcap()).isEqualTo(BigDecimal.valueOf(878480783200L));
        assertThat(keyStats.getBeta()).isEqualTo(BigDecimal.valueOf(1.215991));
        assertThat(keyStats.getWeek52high()).isEqualTo(BigDecimal.valueOf(176.24));
        assertThat(keyStats.getWeek52low()).isEqualTo(BigDecimal.valueOf(108.25));
        assertThat(keyStats.getWeek52change()).isEqualTo(BigDecimal.valueOf(58.061302));
        assertThat(keyStats.getShortInterest()).isEqualTo(BigDecimal.valueOf(33490296));
        assertThat(keyStats.getShortDate()).isEqualTo(LocalDate.of(2017, 10, 31));
        assertThat(keyStats.getDividendRate()).isEqualTo(BigDecimal.valueOf(2.52));
        assertThat(keyStats.getDividendYield()).isEqualTo(BigDecimal.valueOf(1.4728229));
        assertThat(keyStats.getExDividendDate()).isEqualTo(LocalDateTime.of(2017, 11, 10, 0, 0, 0));
        assertThat(keyStats.getLatestEPS()).isEqualTo(BigDecimal.valueOf(9.2));
        assertThat(keyStats.getLatestEPSDate()).isEqualTo(LocalDate.of(2017, 9, 30));
        assertThat(keyStats.getSharesOutstanding()).isEqualTo(BigDecimal.valueOf(5134312000L));
        assertThat(keyStats.getFloat()).isEqualTo(BigDecimal.valueOf(5124446610L));
        assertThat(keyStats.getReturnOnEquity()).isEqualTo(BigDecimal.valueOf(36.08));
        assertThat(keyStats.getConsensusEPS()).isEqualTo(BigDecimal.valueOf(1.57));
        assertThat(keyStats.getNumberOfEstimates()).isEqualTo(BigDecimal.valueOf(13));
        assertThat(keyStats.getEPSSurpriseDollar()).isNull();
        assertThat(keyStats.getEPSSurprisePercent()).isEqualTo(BigDecimal.valueOf(6.3694));
        assertThat(keyStats.getSymbol()).isEqualTo("AAPL");
        assertThat(keyStats.getEBITDA()).isEqualTo(BigDecimal.valueOf(76569000000L));
        assertThat(keyStats.getRevenue()).isEqualTo(BigDecimal.valueOf(229234000000L));
        assertThat(keyStats.getGrossProfit()).isEqualTo(BigDecimal.valueOf(88186000000L));
        assertThat(keyStats.getCash()).isEqualTo(BigDecimal.valueOf(278493000000L));
        assertThat(keyStats.getDebt()).isEqualTo(BigDecimal.valueOf(410090000000L));
        assertThat(keyStats.getTtmEPS()).isEqualTo(BigDecimal.valueOf(8.8));
        assertThat(keyStats.getRevenuePerShare()).isEqualTo(BigDecimal.valueOf(45));
        assertThat(keyStats.getRevenuePerEmployee()).isNull();
        assertThat(keyStats.getPeRatioHigh()).isEqualTo(BigDecimal.valueOf(114.1));
        assertThat(keyStats.getPeRatioLow()).isEqualTo(BigDecimal.ZERO);
        assertThat(keyStats.getReturnOnAssets()).isEqualTo(BigDecimal.valueOf(13.6));
        assertThat(keyStats.getReturnOnCapital()).isNull();
        assertThat(keyStats.getProfitMargin()).isEqualTo(BigDecimal.valueOf(20.72));
        assertThat(keyStats.getPriceToSales()).isEqualTo(BigDecimal.valueOf(3.7870016));
        assertThat(keyStats.getPriceToBook()).isEqualTo(BigDecimal.valueOf(6.48));
        assertThat(keyStats.getDay200MovingAvg()).isEqualTo(BigDecimal.valueOf(149.61687));
        assertThat(keyStats.getDay50MovingAvg()).isEqualTo(BigDecimal.valueOf(160.35918));
        assertThat(keyStats.getInstitutionPercent()).isEqualTo(BigDecimal.valueOf(63.1));
        assertThat(keyStats.getInsiderPercent()).isNull();
        assertThat(keyStats.getShortRatio()).isEqualTo(BigDecimal.valueOf(1.4610342));
        assertThat(keyStats.getYear5ChangePercent()).isEqualTo(BigDecimal.valueOf(1.1170895277690132));
        assertThat(keyStats.getYear2ChangePercent()).isEqualTo(BigDecimal.valueOf(0.49857674622290343));
        assertThat(keyStats.getYear1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.5555959632693881));
        assertThat(keyStats.getYtdChangePercent()).isEqualTo(BigDecimal.valueOf(0.47309513560051647));
        assertThat(keyStats.getMonth6ChangePercent()).isEqualTo(BigDecimal.valueOf(0.10053386505435129));
        assertThat(keyStats.getMonth3ChangePercent()).isEqualTo(BigDecimal.valueOf(0.0630630630630631));
        assertThat(keyStats.getMonth1ChangePercent()).isEqualTo(BigDecimal.valueOf(0.07017763322491868));
        assertThat(keyStats.getDay5ChangePercent()).isEqualTo(BigDecimal.valueOf(-0.020438541249212763));
        assertThat(keyStats.getDay30ChangePercent()).isEqualTo(BigDecimal.valueOf(0.010616070924388703));
    }

}
