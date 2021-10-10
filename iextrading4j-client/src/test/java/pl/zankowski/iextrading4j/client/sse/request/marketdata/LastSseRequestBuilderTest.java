package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import jakarta.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LastSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateSseRequest() {
        final String symbol = "IBM";

        final SseRequest<List<LastTrade>> request = new LastSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/last");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<LastTrade>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
