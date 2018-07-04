package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TradingStatusRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class TradingStatusServiceTest extends BaseRestServiceTest {

    @Test
    public void tradingStatusServiceTest() {
        stubFor(get(urlEqualTo("/deep/trading-status?symbols=AAPL"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/TradingStatusResponse.json")));

        final Map<String, TradingStatus> tradingStatusMap = iexTradingClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final TradingStatus tradingStatus = tradingStatusMap.get("AAPL");
        assertThat(tradingStatus.getStatus()).isEqualTo(TradingStatusType.TRADING_ON_IEX);
        assertThat(tradingStatus.getReason()).isEqualTo(TradingStatusReasonType.UNKNOWN);
    }

}
