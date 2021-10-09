package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class IncomeStatementRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateIncomeStatementRequest() {
        final String symbol = "AAPL";

        final RestRequest<IncomeStatements> request = new IncomeStatementRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/income");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<IncomeStatements>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateIncomeStatementWithPeriodRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;

        final RestRequest<IncomeStatements> request = new IncomeStatementRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/income");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<IncomeStatements>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

    @Test
    void shouldSuccessfullyCreateIncomeStatementWithPeriodAndLastRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;
        final int last = 3;

        final RestRequest<IncomeStatements> request = new IncomeStatementRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/income/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<IncomeStatements>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

}
