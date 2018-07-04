package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TradeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class TradesServiceTest extends BaseRestServiceTest {

    @Test
    public void tradesServiceTest() {
        stubFor(get(urlEqualTo("/deep/trades?symbols=SNAP"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/TradesResponse.json")));

        final Map<String, List<Trade>> tradeMap = iexTradingClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("SNAP")
                .build());

        final List<Trade> tradeList = tradeMap.get("SNAP");
        final Trade trade = tradeList.get(0);
        assertThat(trade.getPrice()).isEqualTo(BigDecimal.valueOf(12.835));
        assertThat(trade.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(trade.getTradeId()).isEqualTo(364415895L);
        assertThat(trade.isISO()).isFalse();
        assertThat(trade.isOddLot()).isFalse();
        assertThat(trade.isOutsideRegularHours()).isFalse();
        assertThat(trade.isSinglePriceCross()).isFalse();
        assertThat(trade.isTradeThroughExempt()).isFalse();
        assertThat(trade.getTimestamp()).isEqualTo(1510961576182L);
    }

}
