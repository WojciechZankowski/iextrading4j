package pl.zankowski.iextrading4j.client.rest.request.options;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.options.Option;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class OptionsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateOptionsRequest() {
        final String symbol = "AAPL";

        final RestRequest<List<String>> request = new OptionsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/options");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<String>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateOptionsRequestWithExpirationDate() {
        final String symbol = "AAPL";
        final String expirationDate = "201907";

        final RestRequest<List<Option>> request = new OptionsRequestBuilder()
                .withSymbol(symbol)
                .withExpirationDate(expirationDate)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/options/{expirationDate}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Option>>() {
        });
        assertThat(request.getPathParams()).contains(entry("symbol", symbol),
                entry("expirationDate", expirationDate));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateOptionsRequestWithExpirationDateAndSide() {
        final String symbol = "AAPL";
        final String expirationDate = "201907";
        final OptionSide side = OptionSide.CALL;

        final RestRequest<List<Option>> request = new OptionsRequestBuilder()
                .withSymbol(symbol)
                .withExpirationDate(expirationDate)
                .withSide(side)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/options/{expirationDate}/{side}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Option>>() {
        });
        assertThat(request.getPathParams()).contains(entry("symbol", symbol),
                entry("expirationDate", expirationDate), entry("side", side.getName()));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
