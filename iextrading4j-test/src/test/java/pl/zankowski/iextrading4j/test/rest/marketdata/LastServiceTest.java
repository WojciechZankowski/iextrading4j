package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.LastTradeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class LastServiceTest extends BaseRestServiceTest {

    @Test
    public void lastServiceTest() {
        stubFor(get(urlEqualTo("/tops/last?symbols=AAPL"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/LastResponse.json")));

        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final LastTrade lastTrade = lastTradeList.get(0);
        assertThat(lastTrade.getSymbol()).isEqualTo("AAPL");
        assertThat(lastTrade.getPrice()).isEqualTo(BigDecimal.valueOf(170.435));
        assertThat(lastTrade.getSize()).isEqualTo(BigDecimal.valueOf(60));
        assertThat(lastTrade.getTime()).isEqualTo(1510943467901L);
    }

}
