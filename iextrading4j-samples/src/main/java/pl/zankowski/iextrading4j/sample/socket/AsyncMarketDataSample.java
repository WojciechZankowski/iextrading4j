package pl.zankowski.iextrading4j.sample.socket;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TopsAsyncRequestBuilder;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class AsyncMarketDataSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) throws InterruptedException {
        final AsyncMarketDataSample sampleSuite = new AsyncMarketDataSample();

        sampleSuite.topsAsyncRequestSample();

        new Semaphore(0).acquire();
    }

    private final Consumer<TOPS> TOPS_CONSUMER = System.out::println;

    private void topsAsyncRequestSample() {
        final SocketRequest<TOPS> socketRequest = new TopsAsyncRequestBuilder()
                .withAllSymbols()
                .build();

        iexTradingClient.subscribe(socketRequest, TOPS_CONSUMER);
    }

}
