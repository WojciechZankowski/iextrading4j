package pl.zankowski.iextrading4j.client.endpoint.stats;

import pl.zankowski.iextrading4j.client.endpoint.stats.request.StatsRequest;
import pl.zankowski.iextrading4j.api.stats.*;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalDailyStatsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalStatsRequest;

/**
 * @author Wojciech Zankowski
 */
public interface StatsEndpoint extends Endpoint {

    IntradayStats requestIntradayStats(StatsRequest statsRequest);

    RecentStats[] requestRecentStat(StatsRequest statsRequest);

    RecordsStats requestRecordsStat(StatsRequest statsRequest);

    HistoricalStats[] requestHistoricalStats(HistoricalStatsRequest historicalStatsRequest);

    HistoricalDailyStats[] requestHistoricalDailyStats(HistoricalDailyStatsRequest historicalDailyStatsRequest);

}
