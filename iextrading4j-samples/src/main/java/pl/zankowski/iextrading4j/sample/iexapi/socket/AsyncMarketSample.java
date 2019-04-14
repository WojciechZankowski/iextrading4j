package pl.zankowski.iextrading4j.sample.iexapi.socket;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.IEXApiClient;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.request.market.MarketAsyncRequestBuilder;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

@Deprecated
public class AsyncMarketSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) throws InterruptedException {
        final AsyncMarketSample sampleSuite = new AsyncMarketSample();

        sampleSuite.marketAsyncRequestSample();

        new Semaphore(0).acquire();
    }

    private final Consumer<List<MarketVolume>> MARKET_CONSUMER = marketVolumes -> marketVolumes.forEach(System.out::println);

    private void marketAsyncRequestSample() {
        iexTradingClient.subscribe(new MarketAsyncRequestBuilder().build(), MARKET_CONSUMER);
    }

}
