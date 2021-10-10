package pl.zankowski.iextrading4j.client.rest.request.corporate;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedDistribution;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class AdvancedDistributionRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<AdvancedDistribution>> request = new AdvancedDistributionRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series/{id}/{key}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<AdvancedDistribution>>() {});
        assertThat(request.getPathParams()).containsExactly(entry("id", "advanced_distribution"), entry("key", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
