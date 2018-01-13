package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ListRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final ListType listType = ListType.IEXVOLUME;

        final RestRequest<List<Quote>> request = new ListRequestBuilder()
                .withListType(listType)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/market/list/{type}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Quote>>() {});
        assertThat(request.getPathParams()).containsExactly(entry("type", "iexvolume"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
