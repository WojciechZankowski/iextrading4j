package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Financials;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class FinancialsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateFinancialsRequest() {
        final String symbol = "AAPL";

        final RestRequest<Financials> request = new FinancialsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/financials");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Financials>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateFinancialsWithPeriodRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;

        final RestRequest<Financials> request = new FinancialsRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/financials");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Financials>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

    @Test
    void shouldSuccessfullyCreateFinancialsWithPeriodAndLastRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;
        final int last = 3;

        final RestRequest<Financials> request = new FinancialsRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/financials/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Financials>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

}
