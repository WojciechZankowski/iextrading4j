package pl.zankowski.iextrading4j.client.rest.request.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ExchangeRateRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateExchangeRateRequest() {
        final String from = "BTC";
        final String to = "USDT";

        final RestRequest<ExchangeRate> request = new ExchangeRateRequestBuilder()
                .withPair(new Pair(from, to))
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/fx/rate/{from}/{to}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<ExchangeRate>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("from", from), entry("to", to));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
