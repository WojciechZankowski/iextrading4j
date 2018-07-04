package pl.zankowski.iextrading4j.test.rest.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoricalServiceTest extends BaseRestServiceTest {

    @Test
    public void historicalServiceTest() {
        stubFor(get(urlEqualTo("/stats/historical?date=201605"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stats/HistoricalResponse.json")));

        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2016, 5))
                .build());

        final HistoricalStats historicalStats = historicalStatsList.get(0);
        assertThat(historicalStats.getAverageDailyVolume()).isEqualTo(BigDecimal.valueOf(112247378.5));
        assertThat(historicalStats.getAverageDailyRoutedVolume()).isEqualTo(BigDecimal.valueOf(34282226.24));
        assertThat(historicalStats.getAverageMarketShare()).isEqualTo(BigDecimal.valueOf(0.015969999999999998));
        assertThat(historicalStats.getAverageOrderSize()).isEqualTo(BigDecimal.valueOf(493));
        assertThat(historicalStats.getAverageFillSize()).isEqualTo(BigDecimal.valueOf(287));
        assertThat(historicalStats.getBin100Percent()).isEqualTo(BigDecimal.valueOf(0.61559));
        assertThat(historicalStats.getBin101Percent()).isEqualTo(BigDecimal.valueOf(0.01819));
        assertThat(historicalStats.getBin200Percent()).isEqualTo(BigDecimal.valueOf(0.1587));
        assertThat(historicalStats.getBin300Percent()).isEqualTo(BigDecimal.valueOf(0.06125));
        assertThat(historicalStats.getBin400Percent()).isEqualTo(BigDecimal.valueOf(0.03561));
        assertThat(historicalStats.getBin500Percent()).isEqualTo(BigDecimal.valueOf(0.06507));
        assertThat(historicalStats.getBin1000Percent()).isEqualTo(BigDecimal.valueOf(0.04019));
        assertThat(historicalStats.getBin5000Percent()).isEqualTo(BigDecimal.valueOf(0.00342));
        assertThat(historicalStats.getBin10000Percent()).isEqualTo(BigDecimal.valueOf(0.00199));
        assertThat(historicalStats.getBin10000Trades()).isEqualTo(BigDecimal.valueOf(4666));
        assertThat(historicalStats.getBin20000Trades()).isEqualTo(BigDecimal.valueOf(1568));
        assertThat(historicalStats.getBin50000Trades()).isEqualTo(BigDecimal.valueOf(231));
        assertThat(historicalStats.getUniqueSymbolsTraded()).isEqualTo(BigDecimal.valueOf(7419));
        assertThat(historicalStats.getBlockPercent()).isEqualTo(BigDecimal.valueOf(0.08159));
        assertThat(historicalStats.getSelfCrossPercent()).isEqualTo(BigDecimal.valueOf(0.02993));
        assertThat(historicalStats.getEtfPercent()).isEqualTo(BigDecimal.valueOf(0.12646));
        assertThat(historicalStats.getLargeCapPercent()).isEqualTo(BigDecimal.valueOf(0.40685));
        assertThat(historicalStats.getMidCapPercent()).isEqualTo(BigDecimal.valueOf(0.2806));
        assertThat(historicalStats.getSmallCapPercent()).isEqualTo(BigDecimal.valueOf(0.18609));
        assertThat(historicalStats.getVenueARCXFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.22063));
        assertThat(historicalStats.getVenueBATSFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.06249));
        assertThat(historicalStats.getVenueBATYFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.07361));
        assertThat(historicalStats.getVenueEDGAFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.01083));
        assertThat(historicalStats.getVenueEDGXFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.0869));
        assertThat(historicalStats.getVenueOverallFirstWaveWeight()).isEqualTo(BigDecimal.ONE);
        assertThat(historicalStats.getVenueXASEFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.00321));
        assertThat(historicalStats.getVenueXBOSFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.02935));
        assertThat(historicalStats.getVenueXCHIFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.00108));
        assertThat(historicalStats.getVenueXCISFirstWaveWeight()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(0.00008));
        assertThat(historicalStats.getVenueXNGSFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.20358));
        assertThat(historicalStats.getVenueXNYSFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.29313));
        assertThat(historicalStats.getVenueXPHLFirstWaveWeight()).isEqualTo(BigDecimal.valueOf(0.01511));
        assertThat(historicalStats.getVenueARCXFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.97737));
        assertThat(historicalStats.getVenueBATSFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.99357));
        assertThat(historicalStats.getVenueBATYFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.99189));
        assertThat(historicalStats.getVenueEDGAFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.98314));
        assertThat(historicalStats.getVenueEDGXFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.99334));
        assertThat(historicalStats.getVenueOverallFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.98171));
        assertThat(historicalStats.getVenueXASEFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.94479));
        assertThat(historicalStats.getVenueXBOSFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.97829));
        assertThat(historicalStats.getVenueXCHIFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.65811));
        assertThat(historicalStats.getVenueXCISFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.9468));
        assertThat(historicalStats.getVenueXNGSFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.98174));
        assertThat(historicalStats.getVenueXNYSFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.98068));
        assertThat(historicalStats.getVenueXPHLFirstWaveRate()).isEqualTo(BigDecimal.valueOf(0.93629));
    }

}
