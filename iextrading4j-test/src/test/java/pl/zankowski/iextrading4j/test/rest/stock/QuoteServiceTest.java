package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteServiceTest extends BaseRestServiceTest {

    @Test
    public void quoteServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/quote?displayPercent=false"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/QuoteResponse.json")));

        final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(quote.getSymbol()).isEqualTo("AAPL");
        assertThat(quote.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(quote.getPrimaryExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(quote.getSector()).isEqualTo("Technology");
        assertThat(quote.getCalculationPrice()).isEqualTo("tops");
        assertThat(quote.getOpen()).isEqualTo(BigDecimal.valueOf(170.89));
        assertThat(quote.getOpenTime()).isEqualTo(1510929000472L);
        assertThat(quote.getOpenSource()).isEqualTo("open source");
        assertThat(quote.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(quote.getCloseTime()).isEqualTo(1510866000375L);
        assertThat(quote.getCloseSource()).isEqualTo("close source");
        assertThat(quote.getHigh()).isEqualTo(BigDecimal.valueOf(170.78));
        assertThat(quote.getHighTime()).isEqualTo(1510929000472L);
        assertThat(quote.getHighSource()).isEqualTo("high source");
        assertThat(quote.getLow()).isEqualTo(BigDecimal.valueOf(169.71));
        assertThat(quote.getLowTime()).isEqualTo(1510929000472L);
        assertThat(quote.getLowSource()).isEqualTo("low source");
        assertThat(quote.getLatestPrice()).isEqualTo(BigDecimal.valueOf(170.39));
        assertThat(quote.getLatestSource()).isEqualTo("IEX real time price");
        assertThat(quote.getLatestTime()).isEqualTo("1:18:58 PM");
        assertThat(quote.getLatestUpdate()).isEqualTo(1510942738831L);
        assertThat(quote.getLatestVolume()).isEqualTo(BigDecimal.valueOf(13529933));
        assertThat(quote.getIexRealtimePrice()).isEqualTo(BigDecimal.valueOf(170.39));
        assertThat(quote.getIexRealtimeSize()).isEqualTo(BigDecimal.valueOf(200));
        assertThat(quote.getIexLastUpdated()).isEqualTo(1510942738831L);
        assertThat(quote.getDelayedPrice()).isEqualTo(BigDecimal.valueOf(170.59));
        assertThat(quote.getDelayedPriceTime()).isEqualTo(1510941879189L);
        assertThat(quote.getExtendedPrice()).isEqualTo(BigDecimal.valueOf(187.64));
        assertThat(quote.getExtendedChange()).isEqualTo(BigDecimal.valueOf(-0.08));
        assertThat(quote.getExtendedChangePercent()).isEqualTo(BigDecimal.valueOf(-0.00042));
        assertThat(quote.getExtendedPriceTime()).isEqualTo(1526936340405L);
        assertThat(quote.getPreviousClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(quote.getChange()).isEqualTo(BigDecimal.valueOf(-0.71));
        assertThat(quote.getChangePercent()).isEqualTo(BigDecimal.valueOf(-0.00415));
        assertThat(quote.getIexMarketPercent()).isEqualTo(BigDecimal.valueOf(0.01353));
        assertThat(quote.getIexVolume()).isEqualTo(BigDecimal.valueOf(183060));
        assertThat(quote.getAvgTotalVolume()).isEqualTo(BigDecimal.valueOf(26499527));
        assertThat(quote.getIexBidPrice()).isEqualTo(BigDecimal.valueOf(166.18));
        assertThat(quote.getIexBidSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(quote.getIexAskPrice()).isEqualTo(BigDecimal.valueOf(172));
        assertThat(quote.getIexAskSize()).isEqualTo(BigDecimal.valueOf(315));
        assertThat(quote.getIexOpen()).isEqualTo(BigDecimal.valueOf(155.05));
        assertThat(quote.getIexOpenTime()).isEqualTo(1510929000472L);
        assertThat(quote.getIexClose()).isEqualTo(BigDecimal.valueOf(156.55));
        assertThat(quote.getIexCloseTime()).isEqualTo(1510866000375L);
        assertThat(quote.getMarketCap()).isEqualTo(BigDecimal.valueOf(874835421680L));
        assertThat(quote.getPeRatio()).isEqualTo(BigDecimal.valueOf(19.36));
        assertThat(quote.getWeek52High()).isEqualTo(BigDecimal.valueOf(176.24));
        assertThat(quote.getWeek52Low()).isEqualTo(BigDecimal.valueOf(108.25));
        assertThat(quote.getYtdChange()).isEqualTo(BigDecimal.valueOf(0.47309513560051647));
        assertThat(quote.getLastTradeTime()).isEqualTo(1567857882944L);
        assertThat(quote.isUSMarketOpen()).isTrue();
        assertThat(quote.getOddLotDelayedPriceTime()).isEqualTo(1588865141461L);
        assertThat(quote.getOddLotDelayedPrice()).isEqualTo(BigDecimal.valueOf(326.37));
    }

}
