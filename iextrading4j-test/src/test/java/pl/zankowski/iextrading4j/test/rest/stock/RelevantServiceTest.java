package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Relevant;
import pl.zankowski.iextrading4j.client.rest.request.stocks.RelevantRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class RelevantServiceTest extends BaseRestServiceTest {

    @Test
    public void relevantServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/relevant"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/RelevantResponse.json")));

        final Relevant relevant = iexTradingClient.executeRequest(new RelevantRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(relevant.isPeers()).isTrue();

        final List<String> symbols = relevant.getSymbols();
        assertThat(symbols.get(0)).isEqualTo("MSFT");
        assertThat(symbols.get(1)).isEqualTo("NOK");
        assertThat(symbols.get(2)).isEqualTo("IBM");
        assertThat(symbols.get(3)).isEqualTo("HPQ");
        assertThat(symbols.get(4)).isEqualTo("GOOGL");
        assertThat(symbols.get(5)).isEqualTo("XLK");
    }

}
