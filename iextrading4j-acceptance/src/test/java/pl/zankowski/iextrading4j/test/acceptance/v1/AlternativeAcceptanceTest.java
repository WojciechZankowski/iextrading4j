package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.CeoCompensation;
import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CeoCompensationRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoBookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoPriceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.DailySentimentRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Sandbox environment is disabled for this subscription tier.")
class AlternativeAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    void ceoCompensationTest() {
        final CeoCompensation result = cloudClient.executeRequest(new CeoCompensationRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void cryptoTest() {
        final Quote result = cloudClient.executeRequest(new CryptoRequestBuilder()
                .withSymbol("BTCUSDT")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void cryptoPriceTest() {
        final CryptoPrice price = cloudClient.executeRequest(new CryptoPriceRequestBuilder()
                .withSymbol("BTCUSD")
                .build());
        assertThat(price).isNotNull();
    }

    @Test
    void cryptoBookTest() {
        final Book book = cloudClient.executeRequest(new CryptoBookRequestBuilder()
                .withSymbol("BTCUSD")
                .build());
        assertThat(book).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void dailySentimentTest() {
        final Sentiment result = cloudClient.executeRequest(new DailySentimentRequestBuilder()
                .withSymbol("AAPL")
                .withDate(LocalDate.of(2019, 10, 12))
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void manualDailySentimentTest() {
        final List<Sentiment> result = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .withSentimentType(SentimentType.DAILY)
                .withDate(LocalDate.of(2019, 10, 12))
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void minuteSentimentTest() {
        final List<Sentiment> result = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .withSentimentType(SentimentType.MINUTE)
                .withDate(LocalDate.of(2019, 10, 12))
                .build());
        assertThat(result).isNotNull();
    }

}
