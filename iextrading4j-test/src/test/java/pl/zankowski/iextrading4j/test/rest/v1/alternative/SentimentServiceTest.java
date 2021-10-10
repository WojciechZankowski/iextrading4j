package pl.zankowski.iextrading4j.test.rest.v1.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.SentimentType;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class SentimentServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void sentimentServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/sentiment")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/SentimentResponse.json")));

        final List<Sentiment> result = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final Sentiment sentiment = result.get(0);
        assertThat(sentiment.getSentiment()).isEqualByComparingTo(BigDecimal.valueOf(0.20365833333333336));
        assertThat(sentiment.getTotalScores()).isEqualByComparingTo(BigDecimal.valueOf(24));
        assertThat(sentiment.getPositive()).isEqualByComparingTo(BigDecimal.valueOf(0.88));
        assertThat(sentiment.getNegative()).isEqualByComparingTo(BigDecimal.valueOf(0.12));
        assertThat(sentiment.getMinute()).isNull();
    }

    @Test
    void minuteSentimentServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/sentiment/minute")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/MinuteSentimentResponse.json")));

        final List<Sentiment> result = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .withSentimentType(SentimentType.MINUTE)
                .build());

        assertThat(result).hasSize(1);

        final Sentiment sentiment = result.get(0);
        assertThat(sentiment.getSentiment()).isEqualByComparingTo(BigDecimal.valueOf(0.23336666666666664));
        assertThat(sentiment.getTotalScores()).isEqualByComparingTo(BigDecimal.valueOf(3));
        assertThat(sentiment.getPositive()).isEqualByComparingTo(BigDecimal.ONE);
        assertThat(sentiment.getNegative()).isEqualByComparingTo(BigDecimal.ZERO);
        assertThat(sentiment.getMinute()).isEqualTo(LocalTime.of(12, 58));
    }

    @Test
    void minuteAndDateSentimentServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/sentiment/minute/20190511")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/MinuteSentimentResponse.json")));

        final List<Sentiment> result = cloudClient.executeRequest(new SentimentRequestBuilder()
                .withSymbol("AAPL")
                .withSentimentType(SentimentType.MINUTE)
                .withDate(LocalDate.of(2019, 5, 11))
                .build());

        assertThat(result).hasSize(1);

        final Sentiment sentiment = result.get(0);
        assertThat(sentiment.getSentiment()).isEqualByComparingTo(BigDecimal.valueOf(0.23336666666666664));
        assertThat(sentiment.getTotalScores()).isEqualByComparingTo(BigDecimal.valueOf(3));
        assertThat(sentiment.getPositive()).isEqualByComparingTo(BigDecimal.ONE);
        assertThat(sentiment.getNegative()).isEqualByComparingTo(BigDecimal.ZERO);
        assertThat(sentiment.getMinute()).isEqualTo(LocalTime.of(12, 58));
    }

}
