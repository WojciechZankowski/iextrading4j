package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.LargestTrade;
import pl.zankowski.iextrading4j.client.rest.request.stocks.LargestTradeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class LargestTradeServiceTest extends BaseRestServiceTest {

    @Test
    public void largestTradeServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/largest-trades"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/LargestTradeResponse.json")));

        final List<LargestTrade> largestTradeList = iexTradingClient.executeRequest(new LargestTradeRequestBuilder()
                .withSymbol("aapl")
                .build());

        final LargestTrade largestTrade = largestTradeList.get(0);
        assertThat(largestTrade.getPrice()).isEqualTo(BigDecimal.valueOf(186.39));
        assertThat(largestTrade.getSize()).isEqualTo(BigDecimal.valueOf(10000));
        assertThat(largestTrade.getTime()).isEqualTo(1527090690175L);
        assertThat(largestTrade.getTimeLabel()).isEqualTo(LocalTime.of(11, 51, 30));
        assertThat(largestTrade.getVenue()).isEqualTo("EDGX");
        assertThat(largestTrade.getVenueName()).isEqualTo("Cboe EDGX");
    }

}
