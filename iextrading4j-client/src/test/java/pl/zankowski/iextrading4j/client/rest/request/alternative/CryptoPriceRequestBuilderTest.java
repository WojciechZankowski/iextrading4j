package pl.zankowski.iextrading4j.client.rest.request.alternative;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CryptoPriceRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "BTCUSD";

        final RestRequest<CryptoPrice> request = new CryptoPriceRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/crypto/{symbol}/price");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<CryptoPrice>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
