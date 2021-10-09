package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolDescription;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class SearchSymbolRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String fragment = "apple";

        final RestRequest<List<SymbolDescription>> request = new SearchSymbolRequestBuilder()
                .withFragment(fragment)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/search/{fragment}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<SymbolDescription>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("fragment", fragment));
        assertThat(request.getQueryParams()).isEmpty();
    }


}
