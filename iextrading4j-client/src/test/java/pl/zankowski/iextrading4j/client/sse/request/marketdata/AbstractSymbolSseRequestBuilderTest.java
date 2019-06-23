package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class AbstractSymbolSseRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateSseRequestWithMultipleSymbols() {
        final String ibmSymbol = "ibm";
        final String aaplSymbol = "aapl";

        final SseRequest<LastTrade> request = new LastSseRequestBuilder()
                .withSymbols(ibmSymbol, aaplSymbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/last");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<LastTrade>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"));

        final String value = request.getQueryParams().get("symbols");
        assertThat(value).containsSequence(ibmSymbol).containsSequence(aaplSymbol);
    }

}
