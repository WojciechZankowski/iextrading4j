package pl.zankowski.iextrading4j.client.rest.request.stats;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;
import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_YEAR_MONTH_FORMATTER;

public class HistoricalDailyStatsRequestBuilder extends AbstractRequestFilterBuilder<List<HistoricalDailyStats>, HistoricalDailyStatsRequestBuilder> {

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
                    .put("date", IEX_YEAR_MONTH_FORMATTER.format(date))
                    .build();
        } else if (fullDate != null) {
            return ImmutableMap.<String, String>builder()
                    .put("date", IEX_DATE_FORMATTER.format(fullDate))
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
        return RestRequestBuilder.<List<HistoricalDailyStats>>builder()
                .withPath("/stats/historical/daily").get()
                .withResponse(new GenericType<List<HistoricalDailyStats>>() {})
                .addQueryParam(getDateParams())
                .addQueryParam(getFilterParams())
                .build();
    }
}
