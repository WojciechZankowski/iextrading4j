package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.client.rest.request.stocks.LogoRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class LogoServiceTest extends BaseRestServiceTest {

    @Test
    public void logoServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/logo"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/LogoResponse.json")));

        final Logo logo = iexTradingClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(logo.getUrl()).isEqualTo("https://storage.googleapis.com/iex/api/logos/AAPL.png");
    }

}
