package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Ownership;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class InstitutionalOwnershipRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateInstitutionalOwnershipRequest() {
        final String symbol = "AAPL";

        final RestRequest<List<Ownership>> request = new InstitutionalOwnershipRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/institutional-ownership");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Ownership>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
