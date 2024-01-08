package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class TradingStatusSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<DeepAsyncResponse<TradingStatus>>> request = new TradingStatusSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/deep");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<DeepAsyncResponse<TradingStatus>>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol),
                entry("channels", "trading-status"));
    }

}
