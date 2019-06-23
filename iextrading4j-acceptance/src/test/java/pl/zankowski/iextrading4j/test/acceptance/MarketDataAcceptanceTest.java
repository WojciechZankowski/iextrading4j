package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.DEEP;
import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.OfficialPrice;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AuctionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.DeepRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.HistRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.LastTradeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.OfficialPriceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.OpHaltStatusRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.SecurityEventRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.SsrStatusRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.SystemEventRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TopsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TradeBreakRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TradeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.TradingStatusRequestBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class MarketDataAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void bookAcceptanceTest() {
        final Map<String, Book> books = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());
        assertThat(books).isNotNull();
    }

    @Test
    public void deepAcceptanceTest() {
        final DEEP deep = iexTradingClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(deep).isNotNull();
    }

    @Test
    public void histAcceptanceTest() {
        final List<HIST> histList = iexTradingClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
        assertThat(histList).isNotNull();
    }

    @Test
    public void histParameterizedAcceptanceTest() {
        final Map<String, List<HIST>> histMap = iexTradingClient.executeRequest(new HistRequestBuilder()
                .build());
        assertThat(histMap).isNotNull();
    }

    @Test
    public void lastTradeAcceptanceTest() {
        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(lastTradeList).isNotNull();
    }

    @Test
    public void opHaltStatusAcceptanceTest() {
        final Map<String, OpHaltStatus> opHaltStatuses = iexTradingClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(opHaltStatuses).isNotNull();
    }

    @Test
    public void officialPriceAcceptanceTest() {
        final Map<String, OfficialPrice> officialPriceMap = iexTradingClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(officialPriceMap).isNotNull();
    }

    @Test
    public void securityEventAcceptanceTest() {
        final Map<String, SecurityEvent> securityEvent = iexTradingClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(securityEvent).isNotNull();
    }

    @Test
    public void ssrStatusAcceptanceTest() {
        final Map<String, SsrStatus> ssrStatus = iexTradingClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(ssrStatus).isNotNull();
    }

    @Test
    public void systemEventAcceptanceTest() {
        final SystemEvent systemEvent = iexTradingClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(systemEvent).isNotNull();
    }

    @Test
    public void topsAcceptanceTest() {
        final List<TOPS> tops = iexTradingClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tops).isNotNull();
    }

    @Test
    public void tradeBreakAcceptanceTest() {
        final Map<String, List<Trade>> tradeBreak = iexTradingClient.executeRequest(new TradeBreakRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tradeBreak).isNotNull();
    }

    @Test
    public void tradeAcceptanceTest() {
        final Map<String, List<Trade>> trade = iexTradingClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(trade).isNotNull();
    }

    @Test
    public void tradingStatusAcceptanceTest() {
        final Map<String, TradingStatus> tradingStatus = iexTradingClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(tradingStatus).isNotNull();
    }

    @Test
    public void auctionAcceptanceTest() {
        final Map<String, Auction> auction = iexTradingClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(auction).isNotNull();
    }

}
