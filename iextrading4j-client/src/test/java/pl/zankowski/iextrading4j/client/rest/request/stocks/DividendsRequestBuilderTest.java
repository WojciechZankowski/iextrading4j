package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Dividends;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class DividendsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<Dividends>> request = new DividendsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/dividends/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Dividends>>() {});
        assertThat(request.getPathParams()).containsExactly(
                entry("symbol", symbol),
                entry("range", DividendRange.ONE_MONTH.getCode()));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithCustomRange() {
        final String symbol = "IBM";
        final DividendRange dividendRange = DividendRange.ONE_YEAR;

        final RestRequest<List<Dividends>> request = new DividendsRequestBuilder()
                .withDividendRange(dividendRange)
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/dividends/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Dividends>>() {});
        assertThat(request.getPathParams()).containsExactly(
                entry("symbol", symbol),
                entry("range", dividendRange.getCode()));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
