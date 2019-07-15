package pl.zankowski.iextrading4j.client.sse.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class QuoteSseRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<Quote>> request = new QuoteSseRequestBuilder()
                .withQuoteInterval(QuoteInterval.REALTIME)
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/stocksUS{interval}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Quote>>() {
        });
        assertThat(request.getPathParams()).contains(entry("interval", ""));
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
