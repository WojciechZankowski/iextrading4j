package pl.zankowski.iextrading.rest.client.endpoint.stats;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading.api.stats.HistoricalStats;
import pl.zankowski.iextrading.api.stats.IntradayStats;
import pl.zankowski.iextrading.api.stats.RecentStats;
import pl.zankowski.iextrading.api.stats.RecordsStats;
import pl.zankowski.iextrading.rest.client.endpoint.Endpoint;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author Wojciech Zankowski
 */
public interface StatsEndpoint extends Endpoint {

    IntradayStats requestIntradayStats();

    IntradayStats requestIntradayStats(RequestFilter requestFilter);

    RecentStats[] requestRecentStat();

    RecentStats[] requestRecentStat(RequestFilter requestFilter);

    RecordsStats requestRecordsStat();

    RecordsStats requestRecordsStat(RequestFilter requestFilter);

    HistoricalStats[] requestHistoricalStats();

    HistoricalStats[] requestHistoricalStats(RequestFilter requestFilter);

    HistoricalStats[] requestHistoricalStats(YearMonth date);

    HistoricalStats[] requestHistoricalStats(RequestFilter requestFilter, YearMonth date);

    HistoricalDailyStats[] requestHistoricalDailyStats();

    HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter);

    HistoricalDailyStats[] requestHistoricalDailyStats(YearMonth date);

    HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, YearMonth date);

    HistoricalDailyStats[] requestHistoricalDailyStats(LocalDate date);

    HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, LocalDate date);

    HistoricalDailyStats[] requestHistoricalDailyStats(int last);

    HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, int last);

}
