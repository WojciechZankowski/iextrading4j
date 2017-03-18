package pl.zankowski.iextrading4j.client.socket.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class AsyncRequestTest {

    @Test
    public void shouldCorrectlyCreateAsyncRequest() {
        final String symbolList = "IBM;MSFT";
        final AsyncRequestType asyncRequestType = AsyncRequestType.TOPS;

        AsyncRequest asyncRequest = new AsyncRequest(asyncRequestType, symbolList);

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        assertThat(asyncRequest.getSymbolList()).isEqualTo(symbolList);
    }

    @Test
    public void shouldCorrectlyCreateAsyncRequestWithoutSymbolsByBuild() {
        final AsyncRequestType asyncRequestType = AsyncRequestType.TOPS;

        AsyncRequest asyncRequest = AsyncRequest.builder()
                .withAsyncRequestType(asyncRequestType)
                .build();

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        assertThat(asyncRequest.getSymbolList()).isEmpty();
    }

    @Test
    public void shouldCorrectlyCreateAsyncRequestWithSingleSymbolByBuilder() {
        final AsyncRequestType asyncRequestType = AsyncRequestType.LAST;
        final String symbol = "IBM";

        AsyncRequest asyncRequest = AsyncRequest.builder()
                .withAsyncRequestType(asyncRequestType)
                .withSymbol(symbol)
                .build();

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        assertThat(asyncRequest.getSymbolList()).isEqualTo(symbol);
    }

    @Test
    public void shouldCorrecltCreateAsyncRequestWithMultipleSymbolByBuilder() {
        final AsyncRequestType asyncRequestType = AsyncRequestType.TOPS;
        final String symbol_1 = "IBM";
        final String symbol_2 = "MSFT";

        AsyncRequest asyncRequest = AsyncRequest.builder()
                .withAsyncRequestType(asyncRequestType)
                .withSymbol(symbol_1)
                .withSymbol(symbol_2)
                .build();

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        String[] elements = asyncRequest.getSymbolList().split(AsyncRequest.SYMBOL_DELIMITER);
        assertThat(elements).contains(symbol_1);
        assertThat(elements).contains(symbol_2);
    }

    @Test
    public void shouldCorrectlyCreateAsyncRequestWithAllSymbolsByBuilder() {
        final AsyncRequestType asyncRequestType = AsyncRequestType.LAST;

        AsyncRequest asyncRequest = AsyncRequest.builder()
                .withAsyncRequestType(asyncRequestType)
                .withAllSymbols()
                .build();

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        assertThat(asyncRequest.getSymbolList()).isEqualTo(AsyncRequest.ALL_SYMBOLS);
    }

    @Test
    public void shouldOverrideSingleSymbolWithAllSymbols() {
        final AsyncRequestType asyncRequestType = AsyncRequestType.LAST;
        final String symbol = "IBM";

        AsyncRequest asyncRequest = AsyncRequest.builder()
                .withAsyncRequestType(asyncRequestType)
                .withSymbol(symbol)
                .withAllSymbols()
                .build();

        assertThat(asyncRequest.getAsyncRequestType()).isEqualTo(asyncRequestType);
        assertThat(asyncRequest.getSymbolList()).isEqualTo(AsyncRequest.ALL_SYMBOLS);
    }


}
