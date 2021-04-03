package pl.zankowski.iextrading4j.client.rest.request.corporate;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedSplits;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class AdvancedSplitsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<List<AdvancedSplits>> request = new AdvancedSplitsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/time-series/{id}/{key}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<AdvancedSplits>>() {});
        assertThat(request.getPathParams()).containsExactly(entry("id", "advanced_splits"), entry("key", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
