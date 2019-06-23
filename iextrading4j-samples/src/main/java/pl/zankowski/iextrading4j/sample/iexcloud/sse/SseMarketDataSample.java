package pl.zankowski.iextrading4j.sample.iexcloud.sse;

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
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepConsumerAdapter;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.AuctionSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.BookSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.DeepSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.LastSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.OpHaltStatusSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.SecurityEventSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.SsrStatusSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.SystemEventSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TopsSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TradeBreaksSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TradesSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TradingStatusSseRequestBuilder;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class SseMarketDataSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) throws InterruptedException {
        final SseMarketDataSample marketDataSample = new SseMarketDataSample();

        // The requested data is not available to free tier accounts
        // marketDataSample.topsSseRequestSample();
        // marketDataSample.lastSseRequestSample();

        // marketDataSample.tradingStatusSseRequestSample();
        // marketDataSample.auctionSseRequestSample();
        // marketDataSample.opHaltStatusSseRequestSample();
        // marketDataSample.ssrStatusSseRequestBuilder();
        // marketDataSample.securityEventSseRequestBuilder();
        // marketDataSample.tradeBreakSseRequestSample();
        // marketDataSample.tradesSseRequestSample();
        // marketDataSample.bookSseRequestSample();
        // marketDataSample.systemEventSseRequestSample();
        // marketDataSample.deepSseRequestSample();
        // marketDataSample.deepSseRequestWithAdapterSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<TOPS> TOPS_CONSUMER = System.out::println;

    private void topsSseRequestSample() {
        final SseRequest<TOPS> request = new TopsSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, TOPS_CONSUMER);
    }

    private static final Consumer<LastTrade> LAST_CONSUMER = System.out::println;

    private void lastSseRequestSample() {
        final SseRequest<LastTrade> request = new LastSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, LAST_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<TradingStatus>> TRADING_STATUS_CONSUMER = System.out::println;

    private void tradingStatusSseRequestSample() {
        final SseRequest<DeepAsyncResponse<TradingStatus>> request = new TradingStatusSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, TRADING_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Auction>> AUCTION_CONSUMER = System.out::println;

    private void auctionSseRequestSample() {
        final SseRequest<DeepAsyncResponse<Auction>> request = new AuctionSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, AUCTION_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<OpHaltStatus>> OP_HALT_STATUS_CONSUMER = System.out::println;

    private void opHaltStatusSseRequestSample() {
        final SseRequest<DeepAsyncResponse<OpHaltStatus>> request = new OpHaltStatusSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, OP_HALT_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SsrStatus>> SSR_STATUS_CONSUMER = System.out::println;

    private void ssrStatusSseRequestBuilder() {
        final SseRequest<DeepAsyncResponse<SsrStatus>> request = new SsrStatusSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SSR_STATUS_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SecurityEvent>> SECURITY_EVENT_CONSUMER = System.out::println;

    private void securityEventSseRequestBuilder() {
        final SseRequest<DeepAsyncResponse<SecurityEvent>> request = new SecurityEventSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SECURITY_EVENT_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Trade>> TRADE_BREAK_CONSUMER = System.out::println;

    private void tradeBreakSseRequestSample() {
        final SseRequest<DeepAsyncResponse<Trade>> request = new TradeBreaksSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, TRADE_BREAK_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Trade>> TRADES_CONSUMER = System.out::println;

    private void tradesSseRequestSample() {
        final SseRequest<DeepAsyncResponse<Trade>> request = new TradesSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, TRADES_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<Book>> BOOK_CONSUMER = System.out::println;

    private void bookSseRequestSample() {
        final SseRequest<DeepAsyncResponse<Book>> request = new BookSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, BOOK_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<SystemEvent>> SYSTEM_EVENT_CONSUMER = System.out::println;

    private void systemEventSseRequestSample() {
        final SseRequest<DeepAsyncResponse<SystemEvent>> request = new SystemEventSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SYSTEM_EVENT_CONSUMER);
    }

    private static final Consumer<DeepAsyncResponse<DeepResult>> DEEP_ASYNC_RESPONSE_CONSUMER = System.out::println;

    private void deepSseRequestSample() {
        final SseRequest<DeepAsyncResponse<DeepResult>> request = new DeepSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, DEEP_ASYNC_RESPONSE_CONSUMER);
    }

    private void deepSseRequestWithAdapterSample() {
        final SseRequest<DeepAsyncResponse<DeepResult>> request = new DeepSseRequestBuilder()
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, new SseMarketDataSample.SampleDeepConsumerAdapter());
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
