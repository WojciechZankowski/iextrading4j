package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class SplitsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Split>> request = new SplitsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/splits/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Split>>() {});
        assertThat(request.getPathParams()).containsExactly(
                entry("symbol", symbol),
                entry("range", SplitsRange.ONE_MONTH.getCode()));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithCustomRange() {
        final String symbol = "IBM";
        final SplitsRange splitsRange = SplitsRange.ONE_YEAR;

        final RestRequest<List<Split>> request = new SplitsRequestBuilder()
                .withSymbol(symbol)
                .withSplitsRange(splitsRange)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/splits/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Split>>() {});
        assertThat(request.getPathParams()).containsExactly(
                entry("symbol", symbol),
                entry("range", splitsRange.getCode()));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
