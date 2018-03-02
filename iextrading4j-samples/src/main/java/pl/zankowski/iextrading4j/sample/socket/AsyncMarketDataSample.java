package pl.zankowski.iextrading4j.sample.socket;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.LastAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TopsAsyncRequestBuilder;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class AsyncMarketDataSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) throws InterruptedException {
        final AsyncMarketDataSample sampleSuite = new AsyncMarketDataSample();

        sampleSuite.topsAsyncRequestSample();
        sampleSuite.lastAsyncRequestSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<TOPS> TOPS_CONSUMER = System.out::println;

    private void topsAsyncRequestSample() {
        final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder()
                .withSymbol("aapl")
                .build();

        iexTradingClient.subscribe(request, TOPS_CONSUMER);
    }

    private static final Consumer<LastTrade> LAST_CONSUMER = System.out::println;

    private void lastAsyncRequestSample() {
        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withSymbol("aapl")
                .build();

        iexTradingClient.subscribe(request, LAST_CONSUMER);
    }

}
