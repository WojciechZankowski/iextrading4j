package pl.zankowski.iextrading4j.sample.iexcloud.sse;

import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.forex.CurrencyRatesSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.stocks.QuoteInterval;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class SseForexSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) throws InterruptedException {
        final SseForexSample forexSample = new SseForexSample();

        forexSample.currencyRatesSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<List<CurrencyRate>> CURRENCY_RATE_CONSUMER = System.out::println;

    private void currencyRatesSample() {
        final SseRequest<List<CurrencyRate>> request = new CurrencyRatesSseRequestBuilder()
                .withSymbol("EURUSD")
                .withQuoteInterval(QuoteInterval.REALTIME)
                .build();

        cloudClient.subscribe(request, CURRENCY_RATE_CONSUMER);
    }

}
