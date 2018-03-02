package pl.zankowski.iextrading4j.client.rest.request.stats;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_YEAR_MONTH_FORMATTER;

public class HistoricalStatsRequestBuilder extends AbstractRequestFilterBuilder<List<HistoricalStats>, HistoricalStatsRequestBuilder> {

    private YearMonth date;

    public HistoricalStatsRequestBuilder withDate(YearMonth date) {
        this.date = date;
        return this;
    }

    private Map<String, String> getDateParams() {
        if (date != null) {
            return ImmutableMap.<String, String>builder()
                    .put("date", IEX_YEAR_MONTH_FORMATTER.format(date))
                    .build();
        }
        return ImmutableMap.of();
    }

    @Override
    public RestRequest<List<HistoricalStats>> build() {
        return RestRequestBuilder.<List<HistoricalStats>>builder()
                .withPath("/stats/historical").get()
                .withResponse(new GenericType<List<HistoricalStats>>() {})
                .addQueryParam(getDateParams())
                .addQueryParam(getFilterParams())
                .build();
    }
}
