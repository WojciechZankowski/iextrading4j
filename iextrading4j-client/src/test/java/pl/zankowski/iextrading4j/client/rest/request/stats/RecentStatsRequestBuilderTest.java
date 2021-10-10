package pl.zankowski.iextrading4j.client.rest.request.stats;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecentStatsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequestWithYearMonthDate() {
        final RestRequest<List<RecentStats>> request = new RecentStatsRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/recent");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<RecentStats>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
