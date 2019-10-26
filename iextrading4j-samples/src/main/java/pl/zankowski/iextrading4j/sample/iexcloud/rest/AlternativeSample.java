package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.alternative.CeoCompensation;
import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CeoCompensationRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoBookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoPriceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.DailySentimentRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentType;

import java.time.LocalDate;
import java.util.List;

public class AlternativeSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final AlternativeSample alternativeSample = new AlternativeSample();

        // This data is not available to free tier accounts
        alternativeSample.ceoCompensationRequestSample();

        alternativeSample.cryptoRequestSample();
        alternativeSample.cryptoPriceRequestSample();
        alternativeSample.cryptoBookRequestSample();
        alternativeSample.minuteSentimentRequestSample();
        alternativeSample.dailySentimentRequestSample();
    }

    private void cryptoRequestSample() {
        final Quote quote = cloudClient.executeRequest(new CryptoRequestBuilder()
                .withSymbol("BTCUSDT")
                .build());
        System.out.println(quote);
    }

    private void ceoCompensationRequestSample() {
        final CeoCompensation ceoCompensation = cloudClient.executeRequest(new CeoCompensationRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ceoCompensation);
    }

    private void cryptoPriceRequestSample() {
        final CryptoPrice price = cloudClient.executeRequest(new CryptoPriceRequestBuilder()
                .withSymbol("BTCUSD")
                .build());
        System.out.println(price);
    }

    private void cryptoBookRequestSample() {
        final Book book = cloudClient.executeRequest(new CryptoBookRequestBuilder()
                .withSymbol("BTCUSD")
                .build());
        System.out.println(book);
    }

    private void minuteSentimentRequestSample() {
        final List<Sentiment> sentiments = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .withSentimentType(SentimentType.MINUTE)
                .withDate(LocalDate.of(2019, 10, 12))
                .build());
        System.out.println(sentiments);
    }

    private void dailySentimentRequestSample() {
        final Sentiment sentiment = cloudClient.executeRequest(new DailySentimentRequestBuilder()
                .withSymbol("AAPL")
                .withDate(LocalDate.of(2019, 10, 12))
                .build());
        System.out.println(sentiment);
    }

}
