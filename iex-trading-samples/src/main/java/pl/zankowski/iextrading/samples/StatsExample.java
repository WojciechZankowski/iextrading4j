package pl.zankowski.iextrading.samples;

import pl.zankowski.iextrading.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading.api.stats.HistoricalStats;
import pl.zankowski.iextrading.api.stats.IntradayStats;
import pl.zankowski.iextrading.api.stats.RecentStats;
import pl.zankowski.iextrading.api.stats.RecordsStats;
import pl.zankowski.iextrading.rest.client.IEXTradingClient;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class StatsExample {

    public static void main(String[] args) {
        IEXTradingClient iexTradingClient = IEXTradingClient.create();

        requestIntradayStats(iexTradingClient);
        requestRecentStats(iexTradingClient);
        requestRecordsStat(iexTradingClient);

        requestLastDayHistoricalStats(iexTradingClient);
        requestFilteredHistoricalStatsByYearMonth(iexTradingClient);

        requestLastDayHistoricalDailyStats(iexTradingClient);
        requestFilteredHistoricalDailyStatsByYearMonth(iexTradingClient);
        requestFilteredHistoricalDailyStatsByYearMonthDay(iexTradingClient);
        requestLastHistoricalDailyStats(iexTradingClient);
    }

    private static void requestIntradayStats(IEXTradingClient iexTradingClient) {
        IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats();
        System.out.println(intradayStats);
    }

    private static void requestRecentStats(IEXTradingClient iexTradingClient) {
        RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat();
        Arrays.stream(recentStats).forEach(System.out::println);
    }

    private static void requestRecordsStat(IEXTradingClient iexTradingClient) {
        RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat();
        System.out.println(recordsStat);
    }

    private static void requestLastDayHistoricalStats(IEXTradingClient iexTradingClient) {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats();
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestFilteredHistoricalStatsByYearMonth(IEXTradingClient iexTradingClient) {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(YearMonth.of(2017, 3));
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestLastDayHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats();
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestFilteredHistoricalDailyStatsByYearMonth(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(YearMonth.of(2017,3));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestFilteredHistoricalDailyStatsByYearMonthDay(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(LocalDate.of(2017, 3, 6));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestLastHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(13);
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

}
