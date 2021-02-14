package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static pl.zankowski.iextrading4j.client.rest.request.marketdata.AbstractMarketDataRequestBuilder.ALL_SYMBOLS;

public class TopsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<TOPS>> request = new TopsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/tops");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<TOPS>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("symbols", symbol));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithMultipleSymbols() {
        final String firstSymbol = "IBM";
        final String secondSymbol = "MSFT";

        final RestRequest<List<TOPS>> request = new TopsRequestBuilder()
                .withSymbols(firstSymbol, secondSymbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/tops");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<TOPS>>() {});
        assertThat(request.getPathParams()).isEmpty();

        final Map<String, String> queryParams = request.getQueryParams();
        final String symbols = queryParams.get("symbols");
        assertThat(symbols).contains(firstSymbol, secondSymbol);
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithAllSymbols() {
        final RestRequest<List<TOPS>> request = new TopsRequestBuilder()
                .withAllSymbols()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/tops");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<TOPS>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("symbols", ALL_SYMBOLS));
    }

}
