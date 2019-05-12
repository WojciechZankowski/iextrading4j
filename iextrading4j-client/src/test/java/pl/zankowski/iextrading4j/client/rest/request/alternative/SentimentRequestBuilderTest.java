package pl.zankowski.iextrading4j.client.rest.request.alternative;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class SentimentRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Sentiment>> request = new SentimentRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/sentiment");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Sentiment>>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateTypeRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Sentiment>> request = new SentimentRequestBuilder()
                .withSentimentType(SentimentType.DAILY)
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/sentiment/{type}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Sentiment>>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", symbol), entry("type", "daily"));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateTypeAndDateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Sentiment>> request = new SentimentRequestBuilder()
                .withSentimentType(SentimentType.DAILY)
                .withDate(LocalDate.of(2019, 5, 11))
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/sentiment/{type}/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Sentiment>>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", symbol), entry("type", "daily"),
                entry("date", "20190511"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
