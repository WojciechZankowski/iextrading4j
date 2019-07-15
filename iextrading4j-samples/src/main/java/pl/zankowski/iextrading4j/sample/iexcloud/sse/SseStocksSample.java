package pl.zankowski.iextrading4j.sample.iexcloud.sse;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.v1.News;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.stocks.NewsSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.stocks.QuoteInterval;
import pl.zankowski.iextrading4j.client.sse.request.stocks.QuoteSseRequestBuilder;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class SseStocksSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) throws InterruptedException {
        final SseStocksSample stocksSample = new SseStocksSample();

        // The requested data is not available to free tier accounts
        stocksSample.quoteRealtimeSample();
        stocksSample.quote1SecondSample();
        stocksSample.quote5SecondsSample();
        stocksSample.quoteOneMinuteSample();

        stocksSample.newsSample();

        new Semaphore(0).acquire();
    }

    private static final Consumer<List<Quote>> SENTIMENT_CONSUMER = System.out::println;

    private void quoteRealtimeSample() {
        final SseRequest<List<Quote>> request = new QuoteSseRequestBuilder()
                .withQuoteInterval(QuoteInterval.REALTIME)
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SENTIMENT_CONSUMER);
    }

    private void quote1SecondSample() {
        final SseRequest<List<Quote>> request = new QuoteSseRequestBuilder()
                .withQuoteInterval(QuoteInterval.ONE_SECOND)
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SENTIMENT_CONSUMER);
    }

    private void quote5SecondsSample() {
        final SseRequest<List<Quote>> request = new QuoteSseRequestBuilder()
                .withQuoteInterval(QuoteInterval.FIVE_SECONDS)
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SENTIMENT_CONSUMER);
    }

    private void quoteOneMinuteSample() {
        final SseRequest<List<Quote>> request = new QuoteSseRequestBuilder()
                .withQuoteInterval(QuoteInterval.ONE_MINUTE)
                .withSymbol("AAPL")
                .build();

        cloudClient.subscribe(request, SENTIMENT_CONSUMER);
    }

    private static final Consumer<News> NEWS_CONSUMER = System.out::println;

    private void newsSample() {
        final SseRequest<News> request = new NewsSseRequestBuilder()
                .withSymbol("spy")
                .build();

        cloudClient.subscribe(request, NEWS_CONSUMER);
    }

}
