package pl.zankowski.iextrading4j.client.rest.request.stats;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class HistoricalDailyStatsRequestBuilder extends AbstractRequestFilterBuilder<List<HistoricalDailyStats>, HistoricalDailyStatsRequestBuilder> {

    private static final DateTimeFormatter YEARMONTH_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private Integer last;
    private YearMonth date;
    private LocalDate fullDate;

    public HistoricalDailyStatsRequestBuilder withDate(final YearMonth date) {
        this.date = date;
        return this;
    }

    public HistoricalDailyStatsRequestBuilder withDate(final LocalDate date) {
        this.fullDate = date;
        return this;
    }

    public HistoricalDailyStatsRequestBuilder withLast(final Integer last) {
        this.last = last;
        return this;
    }

    private Map<String, String> getDateParams() {
        if (date != null) {
            return ImmutableMap.<String, String>builder()
                    .put("date", YEARMONTH_PARAM_FORMATTER.format(date))
                    .build();
        } else if (fullDate != null) {
            return ImmutableMap.<String, String>builder()
                    .put("date", DATE_PARAM_FORMATTER.format(fullDate))
                    .build();
        } else if (last != null) {
            return ImmutableMap.<String, String>builder()
                    .put("last", String.valueOf(last))
                    .build();
        }
        return ImmutableMap.of();
    }

    @Override
    public RestRequest<List<HistoricalDailyStats>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stats/historical/daily").get()
                .withResponse(new GenericType<List<HistoricalDailyStats>>() {})
                .addQueryParam(getDateParams())
                .addQueryParam(getFilterParams())
                .build();
    }
}
