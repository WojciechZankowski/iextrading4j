package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import static org.assertj.core.api.Assertions.assertThat;

class LastAsyncRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateAsyncRequest() {
        final String symbol = "IBM";

        final SocketRequest<LastTrade> request = new LastAsyncRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/last");
        assertThat(String.valueOf(request.getParam())).contains(symbol);
    }

}
