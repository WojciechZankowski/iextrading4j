package pl.zankowski.iextrading4j.client.rest.request.forex;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyConversion;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CurrencyConversionRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<CurrencyConversion>> request = new CurrencyConversionRequestBuilder()
                .withSymbol("USDGPB")
                .withAmount(BigDecimal.ONE)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/fx/convert");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<CurrencyConversion>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(
                entry("symbols", "USDGPB"),
                entry("amount", "1"));
    }

}
