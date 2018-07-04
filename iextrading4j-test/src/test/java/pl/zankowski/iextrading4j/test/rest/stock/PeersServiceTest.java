package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PeersRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PeersServiceTest extends BaseRestServiceTest {

    @Test
    public void peersServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/peers"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/PeersResponse.json")));

        final List<String> peers = iexTradingClient.executeRequest(new PeersRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(peers.get(0)).isEqualTo("MSFT");
        assertThat(peers.get(1)).isEqualTo("NOK");
        assertThat(peers.get(2)).isEqualTo("IBM");
        assertThat(peers.get(3)).isEqualTo("HPQ");
        assertThat(peers.get(4)).isEqualTo("GOOGL");
        assertThat(peers.get(5)).isEqualTo("XLK");
    }

}
