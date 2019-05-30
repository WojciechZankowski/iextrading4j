package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MutualFundSymbolsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateMutualFundsSymbolsRequest() {
        final RestRequest<List<ExchangeSymbol>> request = new MutualFundSymbolsRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/mutual-funds/symbols");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ExchangeSymbol>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
