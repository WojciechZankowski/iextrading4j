package pl.zankowski.iextrading4j.client.rest.request.alternative;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoBook;
import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CryptoBookRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "BTCUSD";

        final RestRequest<CryptoBook> request = new CryptoBookRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/crypto/{symbol}/book");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<CryptoBook>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
