package pl.zankowski.iextrading4j.client.endpoint.stats;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;

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
