package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.HistRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class HistServiceTest extends BaseRestServiceTest {

    @Test
    public void histParameterizedServiceTest() {
        stubFor(get(urlEqualTo("/hist?date=20170515"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/HistParameterizedResponse.json")));

        final List<HIST> histList = iexTradingClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());

        final HIST deepHist = histList.get(0);
        assertThat(deepHist.getLink()).isEqualTo("https://www.googleapis.com/download/storage/v1/b/iex/o/data%2Ffeeds%2F20170515%2F20170515_IEXTP1_DEEP1.0.pcap.gz?generation=1495063270068421&alt=media");
        assertThat(deepHist.getDate()).isEqualTo(LocalDate.of(2017, 5, 15));
        assertThat(deepHist.getFeed()).isEqualTo("DEEP");
        assertThat(deepHist.getVersion()).isEqualTo("1.0");
        assertThat(deepHist.getProtocol()).isEqualTo("IEXTP1");
        assertThat(deepHist.getSize()).isEqualTo("640265166");

        final HIST topsHist = histList.get(1);
        assertThat(topsHist.getLink()).isEqualTo("https://www.googleapis.com/download/storage/v1/b/iex/o/data%2Ffeeds%2F20170515%2F20170515_IEXTP1_TOPS1.5.pcap.gz?generation=1494982589401271&alt=media");
        assertThat(topsHist.getDate()).isEqualTo(LocalDate.of(2017, 5, 15));
        assertThat(topsHist.getFeed()).isEqualTo("TOPS");
        assertThat(topsHist.getVersion()).isEqualTo("1.5");
        assertThat(topsHist.getProtocol()).isEqualTo("IEXTP1");
        assertThat(topsHist.getSize()).isEqualTo("503325585");
    }

    @Test
    public void histServiceTest() {
        stubFor(get(urlEqualTo("/hist"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/HistResponse.json")));

        final Map<String, List<HIST>> histMap = iexTradingClient.executeRequest(new HistRequestBuilder()
                .build());

        final List<HIST> histList = histMap.get("20161212");
        final HIST deepHist = histList.get(0);
        assertThat(deepHist.getLink()).isEqualTo("https://www.googleapis.com/download/storage/v1/b/iex/o/data%2Ffeeds%2F20161212%2F20161212_IEXTP1_TOPS1.5.pcap.gz?generation=1494973084263797&alt=media");
        assertThat(deepHist.getDate()).isEqualTo(LocalDate.of(2016, 12, 12));
        assertThat(deepHist.getFeed()).isEqualTo("TOPS");
        assertThat(deepHist.getVersion()).isEqualTo("1.5");
        assertThat(deepHist.getProtocol()).isEqualTo("IEXTP1");
        assertThat(deepHist.getSize()).isEqualTo("672322139");
    }

}
