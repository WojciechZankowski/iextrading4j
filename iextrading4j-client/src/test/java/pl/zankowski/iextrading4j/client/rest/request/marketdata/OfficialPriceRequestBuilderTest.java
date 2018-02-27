package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.OfficialPrice;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class OfficialPriceRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<Map<String, OfficialPrice>> request = new OfficialPriceRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/deep/official-price");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, OfficialPrice>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("symbols", symbol));
    }

}
