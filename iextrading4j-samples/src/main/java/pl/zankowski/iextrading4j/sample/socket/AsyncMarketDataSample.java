package pl.zankowski.iextrading4j.sample.socket;

import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.DeepResult;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.AuctionAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.BookAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.DeepAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.LastAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.OpHaltStatusAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.SecurityEventAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.SsrStatusAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.SystemEventAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TopsAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradeBreakAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradesAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradingStatusAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepConsumerAdapter;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class AsyncMarketDataSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) throws InterruptedException {
        final AsyncMarketDataSample sampleSuite = new AsyncMarketDataSample();

        sampleSuite.topsAsyncRequestSample();
        sampleSuite.lastAsyncRequestSample();

        sampleSuite.tradingStatusAsyncRequestSample();
        sampleSuite.auctionAsyncRequestSample();
        sampleSuite.opHaltStatusAsyncRequestSample();
        sampleSuite.ssrStatusAsyncRequestBuilder();
        sampleSuite.securityEventAsyncRequestBuilder();
        sampleSuite.tradeBreakAsyncRequestSample();
        sampleSuite.tradesAsyncRequestSample();
        sampleSuite.bookAsyncRequestSample();
        sampleSuite.systemEventAsyncRequestSample();
        sampleSuite.deepAsyncRequestSample();
        sampleSuite.deepAsyncRequestWithAdapterSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<TOPS> TOPS_CONSUMER = System.out::println;

    private void topsAsyncRequestSample() {
        final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, TOPS_CONSUMER);
    }

    private static final Consumer<LastTrade> LAST_CONSUMER = System.out::println;

    private void lastAsyncRequestSample() {
        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, LAST_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<TradingStatus>> TRADING_STATUS_CONSUMER = System.out::println;

    private void tradingStatusAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<TradingStatus>> request = new TradingStatusAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, TRADING_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Auction>> AUCTION_CONSUMER = System.out::println;

    private void auctionAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<Auction>> request = new AuctionAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, AUCTION_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<OpHaltStatus>> OP_HALT_STATUS_CONSUMER = System.out::println;

    private void opHaltStatusAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<OpHaltStatus>> request = new OpHaltStatusAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, OP_HALT_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SsrStatus>> SSR_STATUS_CONSUMER = System.out::println;

    private void ssrStatusAsyncRequestBuilder() {
        final SocketRequest<DeepAsyncResponse<SsrStatus>> request = new SsrStatusAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, SSR_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SecurityEvent>> SECURITY_EVENT_CONSUMER = System.out::println;

    private void securityEventAsyncRequestBuilder() {
        final SocketRequest<DeepAsyncResponse<SecurityEvent>> request = new SecurityEventAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, SECURITY_EVENT_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Trade>> TRADE_BREAK_CONSUMER = System.out::println;

    private void tradeBreakAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<Trade>> request = new TradeBreakAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, TRADE_BREAK_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Trade>> TRADES_CONSUMER = System.out::println;

    private void tradesAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<Trade>> request = new TradesAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, TRADES_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Book>> BOOK_CONSUMER = System.out::println;

    private void bookAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<Book>> request = new BookAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, BOOK_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SystemEvent>> SYSTEM_EVENT_CONSUMER = System.out::println;

    private void systemEventAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<SystemEvent>> request = new SystemEventAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, SYSTEM_EVENT_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<DeepResult>> DEEP_ASYNC_RESPONSE_CONSUMER = System.out::println;

    private void deepAsyncRequestSample() {
        final SocketRequest<DeepAsyncResponse<DeepResult>> request = new DeepAsyncRequestBuilder()
                .addChannel(DeepChannel.DEEP)
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, DEEP_ASYNC_RESPONSE_CONSUMER);
    }

    private void deepAsyncRequestWithAdapterSample() {
        final SocketRequest<DeepAsyncResponse<DeepResult>> request = new DeepAsyncRequestBuilder()
                .addChannel(DeepChannel.DEEP)
                .withSymbol("AAPL")
                .build();

        iexTradingClient.subscribe(request, new SampleDeepConsumerAdapter());
    }

    private static class SampleDeepConsumerAdapter extends DeepConsumerAdapter {

        @Override
        public void acceptTradingStatus(final DeepAsyncResponse<TradingStatus> tradingStatusResponse) {
            System.out.println("TradingStatus: " + tradingStatusResponse);
        }

        @Override
        public void acceptAuction(final DeepAsyncResponse<Auction> auctionResponse) {
            System.out.println("Auction: " + auctionResponse);
        }

        @Override
        public void acceptOpHaltStatus(final DeepAsyncResponse<OpHaltStatus> opHaltStatusResponse) {
            System.out.println("OpHaltStatus: " + opHaltStatusResponse);
        }

        @Override
        public void acceptSsrStatus(final DeepAsyncResponse<SsrStatus> ssrStatusResponse) {
            System.out.println("SsrStatus: " + ssrStatusResponse);
        }

        @Override
        public void acceptSecurityEvent(final DeepAsyncResponse<SecurityEvent> securityEventResponse) {
            System.out.println("SecurityEvent: " + securityEventResponse);
        }

        @Override
        public void acceptTradeBreak(final DeepAsyncResponse<Trade> tradeBreakResponse) {
            System.out.println("TradeBreak: " + tradeBreakResponse);
        }

        @Override
        public void acceptTrades(final DeepAsyncResponse<Trade> tradesResponse) {
            System.out.println("Trades: " + tradesResponse);
        }

        @Override
        public void acceptBook(final DeepAsyncResponse<Book> bookResponse) {
            System.out.println("Book: " + bookResponse);
        }

        @Override
        public void acceptSystemEvent(final DeepAsyncResponse<SystemEvent> systemEventResponse) {
            System.out.println("SystemEvent: " + systemEventResponse);
        }
    }
}
