package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DelayedQuoteRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class DelayedQuoteServiceTest extends BaseServiceTest {

    @Test
    public void delayedQuoteServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/delayed-quote"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("/rest/stock/DelayedQuoteResponse.json")));

        final DelayedQuote delayedQuote = iexTradingClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(delayedQuote.getSymbol()).isEqualTo("AAPL");
        assertThat(delayedQuote.getDelayedPrice()).isEqualTo(BigDecimal.valueOf(170.5));
        assertThat(delayedQuote.getDelayedSize()).isEqualTo(BigDecimal.valueOf(9));
        assertThat(delayedQuote.getDelayedPriceTime()).isEqualTo(1510942340633L);
        assertThat(delayedQuote.getProcessedTime()).isEqualTo(1510943241506L);
    }

}
