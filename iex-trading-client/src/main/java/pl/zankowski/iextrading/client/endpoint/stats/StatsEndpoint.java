package pl.zankowski.iextrading.client.endpoint.stats;

import pl.zankowski.iextrading.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading.api.stats.HistoricalStats;
import pl.zankowski.iextrading.api.stats.IntradayStats;
import pl.zankowski.iextrading.api.stats.RecentStats;
import pl.zankowski.iextrading.api.stats.RecordsStats;
import pl.zankowski.iextrading.client.endpoint.Endpoint;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author Wojciech Zankowski
 */
public interface StatsEndpoint extends Endpoint {

    IntradayStats requestIntradayStats();

    RecentStats[] requestRecentStat();

    RecordsStats requestRecordsStat();

    HistoricalStats[] requestHistoricalStats();

    HistoricalStats[] requestHistoricalStats(YearMonth date);

    HistoricalDailyStats[] requestHistoricalDailyStats();

    HistoricalDailyStats[] requestHistoricalDailyStats(YearMonth date);

    HistoricalDailyStats[] requestHistoricalDailyStats(LocalDate date);

    HistoricalDailyStats[] requestHistoricalDailyStats(int last);

}
