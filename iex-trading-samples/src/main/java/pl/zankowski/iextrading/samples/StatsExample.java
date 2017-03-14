package pl.zankowski.iextrading.samples;

import pl.zankowski.iextrading.api.filter.RequestFilter;
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
        requestColumnFilteredIntradayStats(iexTradingClient);

        requestRecentStats(iexTradingClient);
        requestColumnFilteredRecentStats(iexTradingClient);

        requestRecordsStat(iexTradingClient);
        requestColumnFilteredRecordsStat(iexTradingClient);

        requestLastDayHistoricalStats(iexTradingClient);
        requestColumnFilteredLastDayHistoricalStats(iexTradingClient);

        requestYearMonthFilteredHistoricalStats(iexTradingClient);
        requestYearMonthAndColumnFilteredHistoricalStats(iexTradingClient);

        requestLastDayHistoricalDailyStats(iexTradingClient);
        requestColumnFilteredLastDayHistoricalDailyStats(iexTradingClient);

        requestYearMonthFilteredHistoricalDailyStats(iexTradingClient);
        requestYearMonthAndColumnFilteredHistoricalDailyStats(iexTradingClient);

        requestDateFilteredHistoricalDailyStats(iexTradingClient);
        requestDateAndColumnFilteredHistoricalDailyStats(iexTradingClient);

        requestLastHistoricalDailyStats(iexTradingClient);
        requestColumnFilteredLastHistoricalDailyStats(iexTradingClient);
    }

    private static void requestIntradayStats(IEXTradingClient iexTradingClient) {
        IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats();
        System.out.println(intradayStats);
    }

    private static void requestColumnFilteredIntradayStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("marketShare")
                .build();
        IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats(requestFilter);
        System.out.println(intradayStats);
    }

    private static void requestRecentStats(IEXTradingClient iexTradingClient) {
        RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat();
        Arrays.stream(recentStats).forEach(System.out::println);
    }

    private static void requestColumnFilteredRecentStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("routedVolume")
                .build();
        RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat(requestFilter);
        Arrays.stream(recentStats).forEach(System.out::println);
    }

    private static void requestRecordsStat(IEXTradingClient iexTradingClient) {
        RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat();
        System.out.println(recordsStat);
    }

    private static void requestColumnFilteredRecordsStat(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("symbolsTraded")
                .build();
        RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat(requestFilter);
        System.out.println(recordsStat);
    }

    private static void requestLastDayHistoricalStats(IEXTradingClient iexTradingClient) {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats();
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestColumnFilteredLastDayHistoricalStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("averageDailyVolume")
                .with("largeCapPercent")
                .build();
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(requestFilter);
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestYearMonthFilteredHistoricalStats(IEXTradingClient iexTradingClient) {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(YearMonth.of(2017, 3));
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestYearMonthAndColumnFilteredHistoricalStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("averageDailyVolume")
                .with("largeCapPercent")
                .build();
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(requestFilter, YearMonth.of(2017, 3));
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private static void requestLastDayHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats();
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestColumnFilteredLastDayHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(requestFilter);
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestYearMonthFilteredHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(YearMonth.of(2017,3));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestYearMonthAndColumnFilteredHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(requestFilter, YearMonth.of(2017,3));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestDateFilteredHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(LocalDate.of(2017, 3, 6));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestDateAndColumnFilteredHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(requestFilter, LocalDate.of(2017, 3, 6));
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestLastHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(13);
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private static void requestColumnFilteredLastHistoricalDailyStats(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(requestFilter,13);
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

}
