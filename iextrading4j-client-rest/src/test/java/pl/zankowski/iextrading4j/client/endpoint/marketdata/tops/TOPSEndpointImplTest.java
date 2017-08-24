package pl.zankowski.iextrading4j.client.endpoint.marketdata.tops;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.zankowski.iextrading4j.api.tops.builder.LastTradeDataBuilder.defaultLastTrade;
import static pl.zankowski.iextrading4j.api.tops.builder.TOPSDataBuilder.defaultTOPS;

import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.endpoint.EndpointTestBase;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request.TOPSRequest;

/**
 * @author Wojciech Zankowski
 */
public class TOPSEndpointImplTest extends EndpointTestBase {

    final UriBuilder API_PATH = UriBuilder.fromPath("http://localhost:8080");

    @Test
    public void shouldRequestTOPSWithoutParameters() {
        final TOPS[] expectedTOPS = new TOPS[]{defaultTOPS()};
        when(builderMock.get(TOPS[].class)).thenReturn(expectedTOPS);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(TOPSRequest.builder().withAllSymbols().build());

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestTOPSWithRequestFilter() {
        final TOPS[] expectedTOPS = new TOPS[]{defaultTOPS()};
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(TOPS[].class)).thenReturn(expectedTOPS);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(TOPSRequest.builder().withRequestFilter(requestFilter).build());

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestTOPSForSingleStock() {
        final String IBM_STOCK = "IBM";
        final TOPS[] expectedTOPS = new TOPS[]{defaultTOPS()};
        when(builderMock.get(TOPS[].class)).thenReturn(expectedTOPS);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(TOPSRequest.builder().withSymbol(IBM_STOCK).build());

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
        verify(webTargetMock).queryParam(eq(TOPSEndpointImpl.SYMBOL_QUERY_PARAM), eq(IBM_STOCK));
    }

    @Test
    public void shouldRequestTOPSForMultipleStocks() {
        final String IBM_STOCK = "IBM";
        final String MSFT_STOCK = "MSFT";
        final TOPS[] expectedTOPS = new TOPS[]{defaultTOPS()};
        when(builderMock.get(TOPS[].class)).thenReturn(expectedTOPS);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(TOPSRequest.builder().withSymbols(IBM_STOCK, MSFT_STOCK).build());

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
    }

    @Test
    public void shouldRequestLastTradeWithoutParameters() {
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(TOPSRequest.builder().build());

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestLastTradeWithRequestFilter() {
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(TOPSRequest.builder().withRequestFilter(requestFilter).build());

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestLastTradeForSingleStock() {
        final String IBM_STOCK = "IBM";
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(TOPSRequest.builder().withSymbol(IBM_STOCK).build());

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verify(webTargetMock, times(1)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestLastTradeForMultipleStocks() {
        final String IBM_STOCK = "IBM";
        final String MSFT_STOCK = "MSFT";
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(TOPSRequest.builder().withSymbols(IBM_STOCK, MSFT_STOCK).build());

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verify(webTargetMock, times(1)).queryParam(any(), any());
    }

}
