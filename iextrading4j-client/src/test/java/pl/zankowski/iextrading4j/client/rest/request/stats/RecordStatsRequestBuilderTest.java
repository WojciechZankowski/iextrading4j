package pl.zankowski.iextrading4j.client.rest.request.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordStatsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithYearMonthDate() {
        final RestRequest<RecordsStats> request = new RecordStatsRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/records");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<RecordsStats>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
