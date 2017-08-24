package pl.zankowski.iextrading4j.client.endpoint.stats.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.time.YearMonth;
import java.util.Optional;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStatsRequest extends StatsRequest {

    private final YearMonth date;

    public HistoricalStatsRequest(RequestFilter requestFilter, YearMonth date) {
        super(requestFilter);
        this.date = date;
    }

    public Optional<YearMonth> getDate() {
        return Optional.ofNullable(date);
    }

    public static class Builder {

        private YearMonth date;
        private RequestFilter requestFilter;

        public HistoricalStatsRequest.Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public HistoricalStatsRequest.Builder withDate(YearMonth date) {
            this.date = date;
            return this;
        }

        public HistoricalStatsRequest build() {
            return new HistoricalStatsRequest(requestFilter, date);
        }

    }

}
