package pl.zankowski.iextrading4j.client.rest.request.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class HistoricalDailyStatsRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithLast() {
        final int last = 5;

        final RestRequest<List<HistoricalDailyStats>> request = new HistoricalDailyStatsRequestBuilder()
                .withLast(last)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/historical/daily");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HistoricalDailyStats>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("last", String.valueOf(last)));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithYearMonthDate() {
        final YearMonth yearMonth = YearMonth.of(2017, 5);

        final RestRequest<List<HistoricalDailyStats>> request = new HistoricalDailyStatsRequestBuilder()
                .withDate(yearMonth)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/historical/daily");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HistoricalDailyStats>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("date", "201705"));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithFullDate() {
        final LocalDate date = LocalDate.of(2017, 5, 5);

        final RestRequest<List<HistoricalDailyStats>> request = new HistoricalDailyStatsRequestBuilder()
                .withDate(date)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stats/historical/daily");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<HistoricalDailyStats>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("date", "20170505"));
    }

}
