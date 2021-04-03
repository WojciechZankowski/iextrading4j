package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class AdvancedStatsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateAdvancedStatsRequest() {
        final String symbol = "AAPL";

        final RestRequest<AdvancedStats> request = new AdvancedStatsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/advanced-stats");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<AdvancedStats>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
