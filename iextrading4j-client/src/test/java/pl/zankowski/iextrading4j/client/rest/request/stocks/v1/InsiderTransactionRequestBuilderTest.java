package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderTransaction;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class InsiderTransactionRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateInsiderTransactionRequest() {
        final String symbol = "AAPL";

        final RestRequest<List<InsiderTransaction>> request = new InsiderTransactionRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/insider-transactions");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<InsiderTransaction>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
