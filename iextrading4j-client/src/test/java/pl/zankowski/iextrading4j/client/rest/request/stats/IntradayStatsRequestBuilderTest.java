package pl.zankowski.iextrading4j.client.rest.request.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class IntradayStatsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithYearMonthDate() {
        final RestRequest<IntradayStats> request = new IntradayStatsRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/intraday");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<IntradayStats>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
