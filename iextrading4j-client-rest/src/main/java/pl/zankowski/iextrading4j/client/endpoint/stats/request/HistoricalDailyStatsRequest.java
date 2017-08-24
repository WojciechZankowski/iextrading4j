package pl.zankowski.iextrading4j.client.endpoint.stats.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalDailyStatsRequest extends HistoricalStatsRequest {

    private final LocalDate fullDate;
    private final int last;

    public HistoricalDailyStatsRequest(RequestFilter requestFilter, YearMonth date, LocalDate fullDate, int last) {
        super(requestFilter, date);
        this.fullDate = fullDate;
        this.last = last;
    }

    public Optional<LocalDate> getFullDate() {
        return Optional.ofNullable(fullDate);
    }

    public Optional<Integer> getLast() {
        return Optional.ofNullable(last);
    }

    public static class Builder {

        private int last;
        private YearMonth date;
        private LocalDate fullDate;
        private RequestFilter requestFilter;

        public HistoricalDailyStatsRequest.Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public HistoricalDailyStatsRequest.Builder withDate(YearMonth date) {
            this.date = date;
            return this;
        }

        public HistoricalDailyStatsRequest.Builder withDate(LocalDate date) {
            this.fullDate = date;
            return this;
        }

        public HistoricalDailyStatsRequest.Builder withLast(int last) {
            this.last = last;
            return this;
        }

        public HistoricalDailyStatsRequest build() {
            return new HistoricalDailyStatsRequest(requestFilter, date, fullDate, last);
        }

    }

}
