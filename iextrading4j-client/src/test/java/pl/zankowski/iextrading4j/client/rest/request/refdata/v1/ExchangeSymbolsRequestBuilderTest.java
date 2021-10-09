package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class ExchangeSymbolsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateExchangeSymbolsRequest() {
        final String exchange = "NYSE";

        final RestRequest<List<ExchangeSymbol>> request = new ExchangeSymbolsRequestBuilder()
                .withExchange(exchange)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/exchange/{exchange}/symbols");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ExchangeSymbol>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("exchange", exchange));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
