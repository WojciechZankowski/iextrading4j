package pl.zankowski.iextrading.rest.client.endpoint.tops;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.zankowski.iextrading.api.tops.LastTradeDataBuilder.defaultLastTrade;
import static pl.zankowski.iextrading.api.tops.TOPSDataBuilder.defaultTOPS;

import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.rest.client.endpoint.EndpointTestBase;

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
        TOPS[] actualTOPS = topsEndpoint.requestTOPS();

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestTOPSForSingleStock() {
        final String IBM_STOCK = "IBM";
        final TOPS[] expectedTOPS = new TOPS[]{defaultTOPS()};
        when(builderMock.get(TOPS[].class)).thenReturn(expectedTOPS);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(IBM_STOCK);

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
        TOPS[] actualTOPS = topsEndpoint.requestTOPS(IBM_STOCK, MSFT_STOCK);

        assertThat(actualTOPS).isEqualTo(expectedTOPS);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH);
        verify(webTargetMock).queryParam(eq(TOPSEndpointImpl.SYMBOL_QUERY_PARAM), eq(String.join(TOPSEndpointImpl.SYMBOL_DELIMITER, IBM_STOCK, MSFT_STOCK)));
    }

    @Test
    public void shouldRequestLastTradeWithoutParameters() {
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades();

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestLastTradeForSingleStock() {
        final String IBM_STOCK = "IBM";
        final LastTrade[] expectedLastTrade = new LastTrade[]{defaultLastTrade()};
        when(builderMock.get(LastTrade[].class)).thenReturn(expectedLastTrade);

        TOPSEndpoint topsEndpoint = new TOPSEndpointImpl(clientMock, API_PATH);
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(IBM_STOCK);

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
        LastTrade[] actualLastTrade = topsEndpoint.requestLastTrades(IBM_STOCK, MSFT_STOCK);

        assertThat(actualLastTrade).isEqualTo(expectedLastTrade);
        verifyCorrectPaths(TOPSEndpointImpl.TOPS_PATH, TOPSEndpointImpl.LAST_TRADE_PATH);
        verify(webTargetMock, times(1)).queryParam(any(), any());
        verify(webTargetMock).queryParam(eq(TOPSEndpointImpl.SYMBOL_QUERY_PARAM), eq(String.join(TOPSEndpointImpl.SYMBOL_DELIMITER, IBM_STOCK, MSFT_STOCK)));
    }

}
