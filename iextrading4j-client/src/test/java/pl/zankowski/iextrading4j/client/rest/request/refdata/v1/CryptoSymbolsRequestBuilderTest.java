package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import jakarta.ws.rs.core.GenericType;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.CryptoSymbols;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoSymbolsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateCryptoSymbolsRequest() {
        final RestRequest<List<CryptoSymbols>> request = new CryptoSymbolsRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/crypto/symbols");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CryptoSymbols>>() {
        });
        assertThat(request.getQueryParams()).isEmpty();
    }

}
