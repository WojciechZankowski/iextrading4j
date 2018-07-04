package pl.zankowski.iextrading4j.test.rest.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.Record;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class RecordsServiceTest extends BaseRestServiceTest {

    @Test
    public void recordsServiceTest() {
        stubFor(get(urlEqualTo("/stats/records"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stats/RecordsResponse.json")));

        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder().build());

        final Record volume = recordsStats.getVolume();
        assertThat(volume.getRecordValue()).isEqualTo(BigDecimal.valueOf(233000477L));
        assertThat(volume.getRecordDate()).isEqualTo(LocalDate.of(2016,1,20));
        assertThat(volume.getPreviousDayValue()).isEqualTo(BigDecimal.valueOf(60916575L));
        assertThat(volume.getAvg30Value()).isEqualTo(BigDecimal.valueOf(169446718L));

        final Record symbolsTraded = recordsStats.getSymbolsTraded();
        assertThat(symbolsTraded.getRecordValue()).isEqualTo(BigDecimal.valueOf(6086L));
        assertThat(symbolsTraded.getRecordDate()).isEqualTo(LocalDate.of(2017,7, 5));
        assertThat(symbolsTraded.getPreviousDayValue()).isEqualTo(BigDecimal.valueOf(5172));
        assertThat(symbolsTraded.getAvg30Value()).isEqualTo(BigDecimal.valueOf(5695));

        final Record routedVolume = recordsStats.getRoutedVolume();
        assertThat(routedVolume.getRecordValue()).isEqualTo(BigDecimal.valueOf(74855222L));
        assertThat(routedVolume.getRecordDate()).isEqualTo(LocalDate.of(2016, 11, 10));
        assertThat(routedVolume.getPreviousDayValue()).isEqualTo(BigDecimal.valueOf(14825505L));
        assertThat(routedVolume.getAvg30Value()).isEqualTo(BigDecimal.valueOf(45024147L));

        final Record notional = recordsStats.getNotional();
        assertThat(notional.getRecordValue()).isEqualTo(BigDecimal.valueOf(10772885363.2202));
        assertThat(notional.getRecordDate()).isEqualTo(LocalDate.of(2017, 10, 27));
        assertThat(notional.getPreviousDayValue()).isEqualTo(BigDecimal.valueOf(2698087404.9412));
        assertThat(notional.getAvg30Value()).isEqualTo(BigDecimal.valueOf(7731908805.708));
    }

}
