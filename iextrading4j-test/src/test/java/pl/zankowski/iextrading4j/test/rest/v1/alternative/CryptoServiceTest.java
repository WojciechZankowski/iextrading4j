package pl.zankowski.iextrading4j.test.rest.v1.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CryptoServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void cryptoServiceTest() {
        stubFor(get(urlEqualTo(path("/crypto/BTCUSDT/quote")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/CryptoResponse.json")));

        final Quote quote = cloudClient.executeRequest(new CryptoRequestBuilder()
                .withSymbol("BTCUSDT")
                .build());

        assertThat(quote.getSymbol()).isEqualTo("BTCUSDT");
        assertThat(quote.getCompanyName()).isEqualTo("Bitcoin USD");
        assertThat(quote.getPrimaryExchange()).isEqualTo("crypto");
        assertThat(quote.getSector()).isEqualTo("cryptocurrency");
        assertThat(quote.getCalculationPrice()).isEqualTo("realtime");
        assertThat(quote.getOpen()).isEqualTo(BigDecimal.valueOf(6491.05));
        assertThat(quote.getOpenTime()).isEqualTo(1541532475327L);
        assertThat(quote.getClose()).isEqualTo(BigDecimal.valueOf(6561.21349934));
        assertThat(quote.getCloseTime()).isEqualTo(1541618875327L);
        assertThat(quote.getHigh()).isEqualTo(BigDecimal.valueOf(6615.15));
        assertThat(quote.getLow()).isEqualTo(BigDecimal.valueOf(6475.6));
        assertThat(quote.getLatestPrice()).isEqualTo(BigDecimal.valueOf(6576.4));
        assertThat(quote.getLatestSource()).isEqualTo("Real time price");
        assertThat(quote.getLatestTime()).isEqualTo("2:27:55 PM");
        assertThat(quote.getLatestUpdate()).isEqualTo(1541618875327L);
        assertThat(quote.getLatestVolume()).isEqualTo(BigDecimal.valueOf(15436.65675));
        assertThat(quote.getIexRealtimePrice()).isNull();
        assertThat(quote.getIexRealtimeSize()).isNull();
        assertThat(quote.getIexLastUpdated()).isNull();
        assertThat(quote.getDelayedPrice()).isNull();
        assertThat(quote.getDelayedPriceTime()).isNull();
        assertThat(quote.getExtendedPrice()).isNull();
        assertThat(quote.getExtendedChange()).isNull();
        assertThat(quote.getExtendedChangePercent()).isNull();
        assertThat(quote.getExtendedPriceTime()).isNull();
        assertThat(quote.getPreviousClose()).isEqualTo(BigDecimal.valueOf(6492.73));
        assertThat(quote.getChange()).isEqualTo(BigDecimal.valueOf(85.35));
        assertThat(quote.getChangePercent()).isEqualTo(BigDecimal.valueOf(0.01315));
        assertThat(quote.getIexMarketPercent()).isNull();
        assertThat(quote.getIexVolume()).isNull();
        assertThat(quote.getAvgTotalVolume()).isNull();
        assertThat(quote.getIexBidPrice()).isNull();
        assertThat(quote.getIexBidSize()).isNull();
        assertThat(quote.getIexAskPrice()).isNull();
        assertThat(quote.getIexAskSize()).isNull();
        assertThat(quote.getMarketCap()).isNull();
        assertThat(quote.getPeRatio()).isNull();
        assertThat(quote.getWeek52High()).isNull();
        assertThat(quote.getWeek52Low()).isNull();
        assertThat(quote.getYtdChange()).isNull();
        assertThat(quote.getBidPrice()).isEqualTo(BigDecimal.valueOf(6576.4));
        assertThat(quote.getBidSize()).isEqualTo(BigDecimal.valueOf(0.60331));
        assertThat(quote.getAskPrice()).isEqualTo(BigDecimal.valueOf(6578.77));
        assertThat(quote.getAskSize()).isEqualTo(BigDecimal.valueOf(0.490818));
    }

}
