package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.TodayIpos;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class TodayIposRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<TodayIpos> request = new TodayIposRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/market/today-ipos");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<TodayIpos>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
