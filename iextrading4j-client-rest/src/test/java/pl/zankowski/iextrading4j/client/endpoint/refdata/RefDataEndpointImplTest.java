package pl.zankowski.iextrading4j.client.endpoint.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.endpoint.EndpointTestBase;

import javax.ws.rs.core.UriBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.zankowski.iextrading4j.api.refdata.builder.ExchangeSymbolDataBuilder.defaultExchangeSymbol;
import static pl.zankowski.iextrading4j.client.endpoint.refdata.RefDataEndpointImpl.REF_DATA_PATH;
import static pl.zankowski.iextrading4j.client.endpoint.refdata.RefDataEndpointImpl.SYMBOLS_PATH;

/**
 * @author Wojciech Zankowski
 */
public class RefDataEndpointImplTest extends EndpointTestBase {

    final UriBuilder API_PATH = UriBuilder.fromPath("http://localhost:8080");

    @Test
    public void shouldCallExchangeSymbolsPath() {
        final ExchangeSymbol[] expectedExchangeSymbols = new ExchangeSymbol[]{defaultExchangeSymbol()};
        when(builderMock.get(ExchangeSymbol[].class)).thenReturn(expectedExchangeSymbols);

        RefDataEndpoint refDataEndpoint = new RefDataEndpointImpl(clientMock, API_PATH);
        ExchangeSymbol[] actualExchangeSymbols = refDataEndpoint.requestExchangeSymbols();

        assertThat(actualExchangeSymbols).isEqualTo(expectedExchangeSymbols);
        verifyCorrectPaths(REF_DATA_PATH, SYMBOLS_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldCallExchangeSymbolsPathWithRequestFilter() {
        final ExchangeSymbol[] expectedExchangeSymbols = new ExchangeSymbol[]{defaultExchangeSymbol()};
        final String columnFilterList = "symbol;name";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(ExchangeSymbol[].class)).thenReturn(expectedExchangeSymbols);

        RefDataEndpoint refDataEndpoint = new RefDataEndpointImpl(clientMock, API_PATH);
        ExchangeSymbol[] actualExchangeSymbols = refDataEndpoint.requestExchangeSymbols(requestFilter);

        assertThat(actualExchangeSymbols).isEqualTo(expectedExchangeSymbols);
        verifyCorrectPaths(REF_DATA_PATH, SYMBOLS_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

}
