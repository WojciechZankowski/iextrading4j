package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class BookServiceTest extends BaseRestServiceTest {

    @Test
    public void bookServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/book"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/BookResponse.json")));

        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("aapl")
                .build());

        final Quote quote = book.getQuote();
        assertThat(quote.getSymbol()).isEqualTo("AAPL");
        assertThat(quote.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(quote.getPrimaryExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(quote.getSector()).isEqualTo("Technology");
        assertThat(quote.getCalculationPrice()).isEqualTo("tops");
        assertThat(quote.getOpen()).isEqualTo(BigDecimal.valueOf(170.89));
        assertThat(quote.getOpenTime()).isEqualTo(1510929000472L);
        assertThat(quote.getClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(quote.getCloseTime()).isEqualTo(1510866000375L);
        assertThat(quote.getLatestPrice()).isEqualTo(BigDecimal.valueOf(170.42));
        assertThat(quote.getLatestSource()).isEqualTo("IEX real time price");
        assertThat(quote.getLatestTime()).isEqualTo("1:21:56 PM");
        assertThat(quote.getLatestUpdate()).isEqualTo(1510942916161L);
        assertThat(quote.getLatestVolume()).isEqualTo(BigDecimal.valueOf(13574815));
        assertThat(quote.getIexRealtimePrice()).isEqualTo(BigDecimal.valueOf(170.42));
        assertThat(quote.getIexRealtimeSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(quote.getIexLastUpdated()).isEqualTo(1510942916161L);
        assertThat(quote.getDelayedPrice()).isEqualTo(BigDecimal.valueOf(170.45));
        assertThat(quote.getDelayedPriceTime()).isEqualTo(1510942025430L);
        assertThat(quote.getExtendedPrice()).isEqualTo(BigDecimal.valueOf(187.64));
        assertThat(quote.getExtendedChange()).isEqualTo(BigDecimal.valueOf(-0.08));
        assertThat(quote.getExtendedChangePercent()).isEqualTo(BigDecimal.valueOf(-0.00042));
        assertThat(quote.getExtendedPriceTime()).isEqualTo(1526936340405L);
        assertThat(quote.getPreviousClose()).isEqualTo(BigDecimal.valueOf(171.1));
        assertThat(quote.getChange()).isEqualTo(BigDecimal.valueOf(-0.68));
        assertThat(quote.getChangePercent()).isEqualTo(BigDecimal.valueOf(-0.00397));
        assertThat(quote.getIexMarketPercent()).isEqualTo(BigDecimal.valueOf(0.0135));
        assertThat(quote.getIexVolume()).isEqualTo(BigDecimal.valueOf(183260));
        assertThat(quote.getAvgTotalVolume()).isEqualTo(BigDecimal.valueOf(26499527));
        assertThat(quote.getIexBidPrice()).isEqualTo(BigDecimal.valueOf(166.18));
        assertThat(quote.getIexBidSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(quote.getIexAskPrice()).isEqualTo(BigDecimal.valueOf(172));
        assertThat(quote.getIexAskSize()).isEqualTo(BigDecimal.valueOf(315));
        assertThat(quote.getMarketCap()).isEqualTo(BigDecimal.valueOf(874989451040L));
        assertThat(quote.getPeRatio()).isEqualTo(BigDecimal.valueOf(19.37));
        assertThat(quote.getWeek52High()).isEqualTo(BigDecimal.valueOf(176.24));
        assertThat(quote.getWeek52Low()).isEqualTo(BigDecimal.valueOf(108.25));
        assertThat(quote.getYtdChange()).isEqualTo(BigDecimal.valueOf(0.47309513560051647));

        final BookEntry bid = book.getBids().get(0);
        assertThat(bid.getPrice()).isEqualTo(BigDecimal.valueOf(166.18));
        assertThat(bid.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(bid.getTimestamp()).isEqualTo(1510960265246L);

        final BookEntry ask = book.getAsks().get(0);
        assertThat(ask.getPrice()).isEqualTo(BigDecimal.valueOf(170.42));
        assertThat(ask.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(ask.getTimestamp()).isEqualTo(1510960908460L);

        final Trade trade = book.getTrades().get(0);
        assertThat(trade.getPrice()).isEqualTo(BigDecimal.valueOf(170.42));
        assertThat(trade.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(trade.getTradeId()).isEqualTo(353430061L);
        assertThat(trade.isISO()).isFalse();
        assertThat(trade.isOddLot()).isFalse();
        assertThat(trade.isOutsideRegularHours()).isFalse();
        assertThat(trade.isSinglePriceCross()).isFalse();
        assertThat(trade.isTradeThroughExempt()).isFalse();
        assertThat(trade.getTimestamp()).isEqualTo(1510960916161L);

        final SystemEvent systemEvent = book.getSystemEvent();
        assertThat(systemEvent.getSystemEvent()).isEqualTo(SystemEventType.REGULAR_MARKET_HOURS_START);
        assertThat(systemEvent.getTimestamp()).isEqualTo(1510947000001L);
    }

}
