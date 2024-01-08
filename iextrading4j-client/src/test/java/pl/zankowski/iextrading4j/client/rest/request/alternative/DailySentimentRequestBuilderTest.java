package pl.zankowski.iextrading4j.client.rest.request.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class DailySentimentRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateTypeRequest() {
        final String symbol = "IBM";

        final RestRequest<Sentiment> request = new DailySentimentRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/sentiment/{type}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Sentiment>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", symbol), entry("type", "daily"));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateTypeAndDateRequest() {
        final String symbol = "IBM";

        final RestRequest<Sentiment> request = new DailySentimentRequestBuilder()
                .withDate(LocalDate.of(2019, 5, 11))
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/sentiment/{type}/{date}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Sentiment>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", symbol), entry("type", "daily"),
                entry("date", "20190511"));
        assertThat(request.getQueryParams()).isEmpty();
    }
    
}
