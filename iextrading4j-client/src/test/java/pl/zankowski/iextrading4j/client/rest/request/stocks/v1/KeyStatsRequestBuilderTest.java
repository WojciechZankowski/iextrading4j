package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.KeyStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class KeyStatsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateKeyStatsRequest() {
        final String symbol = "AAPL";

        final RestRequest<KeyStats> request = new KeyStatsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/stats");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<KeyStats>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
