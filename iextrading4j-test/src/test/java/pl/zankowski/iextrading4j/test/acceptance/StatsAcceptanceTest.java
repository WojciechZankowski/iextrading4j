package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalDailyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.IntradayStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecentStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;

import java.time.YearMonth;
import java.util.List;

public class StatsAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void intradayAcceptanceTest() {
        final IntradayStats intradayStats = iexTradingClient.executeRequest(new IntradayStatsRequestBuilder()
                .build());
    }

    @Ignore
    @Test
    public void recentAcceptanceTest() {
        final List<RecentStats> recentStats = iexTradingClient.executeRequest(new RecentStatsRequestBuilder()
                .build());
    }

    @Test
    public void recordsAcceptanceTest() {
        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
    }

    @Test
    public void historicalAcceptanceTest() {
        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2017, 5))
                .build());
    }

    @Test
    public void historicalDailyAcceptanceTest() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(new HistoricalDailyStatsRequestBuilder()
                .withLast(10)
                .build());
    }

}
