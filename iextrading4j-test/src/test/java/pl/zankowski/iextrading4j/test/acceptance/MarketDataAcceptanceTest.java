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

public class MarketDataAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void bookAcceptanceTest() {
        final Map<String, Book> books = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());
    }

    @Test
    public void deepAcceptanceTest() {
        final DEEP deep = iexTradingClient.executeRequest(new DeepRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void histAcceptanceTest() {
        final List<HIST> histList = iexTradingClient.executeRequest(new HistRequestBuilder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
    }

    @Test
    public void histParameterizedAcceptanceTest() {
        final Map<String, List<HIST>> histMap = iexTradingClient.executeRequest(new HistRequestBuilder()
                .build());
    }

    @Test
    public void lastTradeAcceptanceTest() {
        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void opHaltStatusAcceptanceTest() {
        final Map<String, OpHaltStatus> opHaltStatuses = iexTradingClient.executeRequest(new OpHaltStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void officialPriceAcceptanceTest() {
        final Map<String, OfficialPrice> officialPriceMap = iexTradingClient.executeRequest(new OfficialPriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void securityEventAcceptanceTest() {
        final Map<String, SecurityEvent> securityEvent = iexTradingClient.executeRequest(new SecurityEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void ssrStatusAcceptanceTest() {
        final Map<String, SsrStatus> ssrStatus = iexTradingClient.executeRequest(new SsrStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void systemEventAcceptanceTest() {
        final SystemEvent systemEvent = iexTradingClient.executeRequest(new SystemEventRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void topsAcceptanceTest() {
        final List<TOPS> tops = iexTradingClient.executeRequest(new TopsRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void tradeBreakAcceptanceTest() {
        final Map<String, List<Trade>> tradeBreak = iexTradingClient.executeRequest(new TradeBreakRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void tradeAcceptanceTest() {
        final Map<String, List<Trade>> trade = iexTradingClient.executeRequest(new TradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void tradingStatusAcceptanceTest() {
        final Map<String, TradingStatus> tradingStatus = iexTradingClient.executeRequest(new TradingStatusRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void auctionAcceptanceTest() {
        final Map<String, Auction> auction = iexTradingClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

}
