package pl.zankowski.iextrading4j.test.rest.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecentStatsRequestBuilder;
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

public class RecentServiceTest extends BaseRestServiceTest {

    @Test
    public void recentServiceTest() {
        stubFor(get(urlEqualTo("/stats/recent"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stats/RecentResponse.json")));

        final List<RecentStats> recentStatsList = iexTradingClient.executeRequest(new RecentStatsRequestBuilder().build());

        final RecentStats recentStats = recentStatsList.get(0);
        assertThat(recentStats.getDate()).isEqualTo(LocalDate.of(2017, 11, 24));
        assertThat(recentStats.getVolume()).isEqualTo(BigDecimal.valueOf(60916575L));
        assertThat(recentStats.getRoutedVolume()).isEqualTo(BigDecimal.valueOf(14825505L));
        assertThat(recentStats.getMarketShare()).isEqualTo(BigDecimal.valueOf(0.0219));
        assertThat(recentStats.isHalfday()).isFalse();
        assertThat(recentStats.getLitVolume()).isEqualTo(BigDecimal.valueOf(15721600L));
    }

}
