package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Point;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OpenCloseRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenCloseServiceTest extends BaseRestServiceTest {

    @Test
    public void openCloseServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/open-close"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/OpenCloseResponse.json")));

        final Ohlc ohlc = iexTradingClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("aapl")
                .build());

        final Point open = ohlc.getOpen();
        assertThat(open.getPrice()).isEqualTo(BigDecimal.valueOf(170.89));
        assertThat(open.getTime()).isEqualTo(1510929000472L);

        final Point close = ohlc.getClose();
        assertThat(close.getPrice()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(close.getTime()).isEqualTo(1510866000375L);

        assertThat(ohlc.getHigh()).isEqualTo(BigDecimal.valueOf(172.2));
        assertThat(ohlc.getLow()).isEqualTo(BigDecimal.valueOf(170.44));
    }

}
