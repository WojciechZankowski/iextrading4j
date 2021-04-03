package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class SystemEventSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<DeepAsyncResponse<SystemEvent>>> request = new SystemEventSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/deep");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<DeepAsyncResponse<SystemEvent>>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol),
                entry("channels", "system-event"));
    }

}
