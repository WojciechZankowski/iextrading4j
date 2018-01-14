package pl.zankowski.iextrading4j.client.rest.request.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.YearMonth;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class HistoricalStatsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithYearMonthDate() {
        final YearMonth yearMonth = YearMonth.of(2017, 5);

        final RestRequest<List<HistoricalStats>> request = new HistoricalStatsRequestBuilder()
                .withDate(yearMonth)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/historical");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HistoricalStats>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("date", "201705"));
    }

}
