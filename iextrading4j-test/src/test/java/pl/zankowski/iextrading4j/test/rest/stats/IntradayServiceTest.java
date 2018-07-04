package pl.zankowski.iextrading4j.test.rest.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.IntradayStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IntradayServiceTest extends BaseRestServiceTest {

    @Test
    public void intradayServiceTest() {
        stubFor(get(urlEqualTo("/stats/intraday"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stats/IntradayResponse.json")));

        final IntradayStats intradayStats = iexTradingClient.executeRequest(new IntradayStatsRequestBuilder().build());

        assertThat(intradayStats.getVolume().getValue()).isEqualTo(BigDecimal.valueOf(60916575));
        assertThat(intradayStats.getVolume().getLastUpdated()).isEqualTo(1511550902744L);
        assertThat(intradayStats.getSymbolsTraded().getValue()).isEqualTo(BigDecimal.valueOf(5172));
        assertThat(intradayStats.getSymbolsTraded().getLastUpdated()).isEqualTo(1511547648662L);
        assertThat(intradayStats.getRoutedVolume().getValue()).isEqualTo(BigDecimal.valueOf(14825505));
        assertThat(intradayStats.getRoutedVolume().getLastUpdated()).isEqualTo(1511550902744L);
        assertThat(intradayStats.getNotional().getValue()).isEqualTo(BigDecimal.valueOf(2698087405L));
        assertThat(intradayStats.getNotional().getLastUpdated()).isEqualTo(1511550902744L);
        assertThat(intradayStats.getMarketShare().getValue()).isEqualTo(BigDecimal.valueOf(0.02196));
        assertThat(intradayStats.getMarketShare().getLastUpdated()).isEqualTo(1511550902390L);
    }

}
