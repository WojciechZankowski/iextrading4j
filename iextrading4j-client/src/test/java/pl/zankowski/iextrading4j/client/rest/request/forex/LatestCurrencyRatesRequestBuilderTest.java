package pl.zankowski.iextrading4j.client.rest.request.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LatestCurrencyRatesRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<CurrencyRate>> request = new LatestCurrencyRatesRequestBuilder()
                .withSymbol("USDGPB")
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/fx/latest");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CurrencyRate>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(
                entry("symbols", "USDGPB"));
    }

}
