package pl.zankowski.iextrading4j.sample.rest;

import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalDailyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.HistoricalStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.IntradayStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecentStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;

import java.time.YearMonth;
import java.util.List;

public class StatsSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final StatsSample sampleSuite = new StatsSample();

        sampleSuite.intradayRequestSample();
        sampleSuite.recentRequestSample();
        sampleSuite.recordsRequestSample();
        sampleSuite.historicalRequestSample();
        sampleSuite.historicalDailyRequestSample();
    }

    private void intradayRequestSample() {
        final IntradayStats intradayStats = iexTradingClient.executeRequest(new IntradayStatsRequestBuilder()
                .build());
        System.out.println(intradayStats);
    }

    private void recentRequestSample() {
        final List<RecentStats> recentStats = iexTradingClient.executeRequest(new RecentStatsRequestBuilder()
                .build());
        System.out.println(recentStats);
    }

    private void recordsRequestSample() {
        final RecordsStats recordsStats = iexTradingClient.executeRequest(new RecordStatsRequestBuilder()
                .build());
        System.out.println(recordsStats);
    }

    private void historicalRequestSample() {
        final List<HistoricalStats> historicalStatsList = iexTradingClient.executeRequest(new HistoricalStatsRequestBuilder()
                .withDate(YearMonth.of(2017, 5))
                .build());
        System.out.println(historicalStatsList);
    }

    private void historicalDailyRequestSample() {
        final List<HistoricalDailyStats> historicalDailyStatsList = iexTradingClient.executeRequest(new HistoricalDailyStatsRequestBuilder()
                .withLast(10)
                .build());
        System.out.println(historicalDailyStatsList);
    }

}
