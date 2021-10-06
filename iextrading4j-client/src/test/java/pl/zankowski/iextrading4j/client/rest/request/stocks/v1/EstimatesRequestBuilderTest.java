package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Estimates;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class EstimatesRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateEstimatesRequest() {
        final String symbol = "AAPL";

        final RestRequest<Estimates> request = new EstimatesRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/estimates");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Estimates>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateEstimatesWithPeriodRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;

        final RestRequest<Estimates> request = new EstimatesRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/estimates");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Estimates>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

    @Test
    void shouldSuccessfullyCreateEstimatesWithPeriodAndLastRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;
        final int last = 3;

        final RestRequest<Estimates> request = new EstimatesRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/estimates/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Estimates>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

}
