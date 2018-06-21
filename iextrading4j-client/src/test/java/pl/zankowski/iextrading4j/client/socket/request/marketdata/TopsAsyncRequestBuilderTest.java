package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class TopsAsyncRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateAsyncRequest() {
        final String symbol = "IBM";

        final SocketRequest<TOPS> request = new TopsAsyncRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/tops");
        assertThat(String.valueOf(request.getParam())).contains(symbol);
    }

}
