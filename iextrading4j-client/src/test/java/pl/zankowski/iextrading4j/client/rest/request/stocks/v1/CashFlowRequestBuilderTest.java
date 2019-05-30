package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CashFlowRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateCashFlowRequest() {
        final String symbol = "AAPL";

        final RestRequest<CashFlows> request = new CashFlowRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/cash-flow");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<CashFlows>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateCashFlowWithPeriodRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;

        final RestRequest<CashFlows> request = new CashFlowRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/cash-flow");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<CashFlows>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

    @Test
    public void shouldSuccessfullyCreateCashFlowWithPeriodAndLastRequest() {
        final String symbol = "AAPL";
        final Period period = Period.ANNUAL;
        final int last = 3;

        final RestRequest<CashFlows> request = new CashFlowRequestBuilder()
                .withSymbol(symbol)
                .withPeriod(period)
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/cash-flow/{last}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<CashFlows>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("last", String.valueOf(last)));
        assertThat(request.getQueryParams()).containsExactly(entry("period", period.name().toLowerCase()));
    }

}
