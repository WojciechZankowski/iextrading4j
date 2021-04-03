package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Dividends;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class DividendsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateDividendsRequest() {
        final String symbol = "AAPL";
        final DividendRange range = DividendRange.ONE_YEAR;

        final RestRequest<List<Dividends>> request = new DividendsRequestBuilder()
                .withSymbol(symbol)
                .withDividendRange(range)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/dividends/{range}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Dividends>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("range", range.getCode()));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
