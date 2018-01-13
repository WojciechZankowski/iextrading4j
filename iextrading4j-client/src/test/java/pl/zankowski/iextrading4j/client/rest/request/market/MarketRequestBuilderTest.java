package pl.zankowski.iextrading4j.client.rest.request.market;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<List<MarketVolume>> request = new MarketRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/market");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<MarketVolume>>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
