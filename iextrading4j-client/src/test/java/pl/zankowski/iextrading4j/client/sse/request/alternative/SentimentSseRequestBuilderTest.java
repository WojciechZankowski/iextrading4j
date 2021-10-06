package pl.zankowski.iextrading4j.client.sse.request.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.SentimentEvent;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import jakarta.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class SentimentSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<SentimentEvent>> request = new SentimentSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/sentiment");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<SentimentEvent>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
