package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.Period;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class EarningsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<Earnings> request = new EarningsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/earnings");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Earnings>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateRequestWithLastAndPeriod() {
        final String symbol = "IBM";
        final Period period = Period.ANNUAL;
        final int last = 3;

        final RestRequest<Earnings> request = new EarningsRequestBuilder()
                .withSymbol(symbol)
                .withLast(last)
                .withPeriod(period)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/earnings/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Earnings>() {});
        assertThat(request.getPathParams()).contains(entry("symbol", symbol), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).contains(entry("period", period.name().toLowerCase()));
    }

}
