package pl.zankowski.iextrading4j.client.sse.request.alternative;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoDetailedBook;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CryptoBookSseRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SseRequest<List<CryptoDetailedBook>> request = new CryptoBookSseRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/cryptoBook");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CryptoDetailedBook>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"), entry("symbols", symbol));
    }

}
