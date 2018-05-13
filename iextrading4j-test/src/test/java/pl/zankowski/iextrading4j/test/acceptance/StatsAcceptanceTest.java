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
        System.out.println(intradayStats);
    }

    @Ignore
    @Test
    public void recentAcceptanceTest() {
        final List<RecentStats> recentStats = iexTradingClient.executeRequest(new RecentStatsRequestBuilder()
                .build());
        System.out.println(recentStats);
    }

    @Test
    public void recordsAcceptanceTest() {
        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
        System.out.println(recordsStats);
    }

    @Test
    public void historicalAcceptanceTest() {
        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2017, 5))
                .build());
        System.out.println(historicalStatsList);
    }

    @Test
    public void historicalDailyAcceptanceTest() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(new HistoricalDailyStatsRequestBuilder()
                .withLast(10)
                .build());
        System.out.println(historicalDailyStatsList);
    }

}
