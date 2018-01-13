package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.News;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class NewsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithWorldNews() {
        final RestRequest<List<News>> request = new NewsRequestBuilder()
                .withWorldNews()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/news/last/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<News>>() {});
        assertThat(request.getPathParams()).contains(
                entry("range", "10"),
                entry("symbol", "market"));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithRange() {
        final String symbol = "IBM";
        final int range = 3;

        final RestRequest<List<News>> request = new NewsRequestBuilder()
                .withSymbol(symbol)
                .withLast(range)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/news/last/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<News>>() {});
        assertThat(request.getPathParams()).containsExactly(
                entry("symbol", symbol),
                entry("range", String.valueOf(range)));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
