package pl.zankowski.iextrading4j.test.rest.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalDailyStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoricalDailyServiceTest extends BaseRestServiceTest {

    @Test
    public void historicalDailyServiceTest() {
        stubFor(get(urlEqualTo("/stats/historical/daily?date=201605"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stats/HistoricalDailyResponse.json")));

        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(
                new HistoricalDailyStatsRequestBuilder()
                        .withDate(YearMonth.of(2016, 5))
                        .build());

        final HistoricalDailyStats historicalDailyStats = historicalDailyStatsList.get(0);
        assertThat(historicalDailyStats.getDate()).isEqualTo(LocalDate.of(2016, 5, 31));
        assertThat(historicalDailyStats.getVolume()).isEqualTo(BigDecimal.valueOf(116043638L));
        assertThat(historicalDailyStats.getRoutedVolume()).isEqualTo(BigDecimal.valueOf(40746597L));
        assertThat(historicalDailyStats.getMarketShare()).isEqualTo(BigDecimal.valueOf(0.01401));
        assertThat(historicalDailyStats.isHalfday()).isFalse();
        assertThat(historicalDailyStats.getLitVolume()).isEqualTo(BigDecimal.valueOf(12835219));
    }

}
