package pl.zankowski.iextrading4j.client.sse.request.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.stocks.QuoteInterval;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CurrencyRatesSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "USDJPY";

        final SseRequest<List<CurrencyRate>> request = new CurrencyRatesSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/forex{interval}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CurrencyRate>>() {});
        assertThat(request.getPathParams()).contains(entry("interval", "1Minute"));
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

    @Test
    void shouldSuccessfullyCreateRequestWithInterval() {
        final String symbol = "USDJPY";
        final QuoteInterval interval = QuoteInterval.FIVE_SECONDS;

        final SseRequest<List<CurrencyRate>> request = new CurrencyRatesSseRequestBuilder()
                .withSymbol(symbol)
                .withQuoteInterval(interval)
                .build();

        assertThat(request.getPath()).isEqualTo("/forex{interval}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CurrencyRate>>() {});
        assertThat(request.getPathParams()).contains(entry("interval", interval.getName()));
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
