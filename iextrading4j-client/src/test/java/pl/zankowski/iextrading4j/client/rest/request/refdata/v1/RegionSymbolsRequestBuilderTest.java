package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class RegionSymbolsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRegionSymbolsRequest() {
        final String region = "US";

        final RestRequest<List<ExchangeSymbol>> request = new RegionSymbolsRequestBuilder()
                .withRegion(region)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/region/{region}/symbols");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<ExchangeSymbol>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("region", region));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
