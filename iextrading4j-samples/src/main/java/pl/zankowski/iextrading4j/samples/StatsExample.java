package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.stats.*;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalDailyStatsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalStatsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.StatsRequest;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class StatsExample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        StatsExample statsExample = new StatsExample();

        statsExample.requestIntradayStats();
        statsExample.requestColumnFilteredIntradayStats();

        statsExample.requestRecentStats();
        statsExample.requestColumnFilteredRecentStats();

        statsExample.requestRecordsStat();
        statsExample.requestColumnFilteredRecordsStat();

        statsExample.requestLastDayHistoricalStats();
        statsExample.requestColumnFilteredLastDayHistoricalStats();

        statsExample.requestYearMonthFilteredHistoricalStats();
        statsExample.requestYearMonthAndColumnFilteredHistoricalStats();

        statsExample.requestLastDayHistoricalDailyStats();
        statsExample.requestColumnFilteredLastDayHistoricalDailyStats();

        statsExample.requestYearMonthFilteredHistoricalDailyStats();
        statsExample.requestYearMonthAndColumnFilteredHistoricalDailyStats();

        statsExample.requestDateFilteredHistoricalDailyStats();
        statsExample.requestDateAndColumnFilteredHistoricalDailyStats();

        statsExample.requestLastHistoricalDailyStats();
        statsExample.requestColumnFilteredLastHistoricalDailyStats();
    }

    private void requestIntradayStats() {
        IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats(StatsRequest.builder().build());
        System.out.println(intradayStats);
    }

    private void requestColumnFilteredIntradayStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("marketShare")
                .build();
        IntradayStats intradayStats = iexTradingClient.getStatsEndpoint().requestIntradayStats(StatsRequest.builder()
                .withRequestFilter(requestFilter)
                .build());
        System.out.println(intradayStats);
    }

    private void requestRecentStats() {
        RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat(StatsRequest.builder().build());
        Arrays.stream(recentStats).forEach(System.out::println);
    }

    private void requestColumnFilteredRecentStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("routedVolume")
                .build();
        RecentStats[] recentStats = iexTradingClient.getStatsEndpoint().requestRecentStat(StatsRequest.builder()
                .withRequestFilter(requestFilter).build());
        Arrays.stream(recentStats).forEach(System.out::println);
    }

    private void requestRecordsStat() {
        RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat(StatsRequest.builder().build());
        System.out.println(recordsStat);
    }

    private void requestColumnFilteredRecordsStat() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("volume")
                .with("symbolsTraded")
                .build();
        RecordsStats recordsStat = iexTradingClient.getStatsEndpoint().requestRecordsStat(StatsRequest.builder()
                .withRequestFilter(requestFilter).build());
        System.out.println(recordsStat);
    }

    private void requestLastDayHistoricalStats() {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(new HistoricalStatsRequest.Builder().build());
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private void requestColumnFilteredLastDayHistoricalStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("averageDailyVolume")
                .with("largeCapPercent")
                .build();
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(new HistoricalStatsRequest.Builder()
                .withRequestFilter(requestFilter).build());
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private void requestYearMonthFilteredHistoricalStats() {
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(new HistoricalStatsRequest.Builder()
                .withDate(YearMonth.of(2017, 3)).build());
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private void requestYearMonthAndColumnFilteredHistoricalStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("averageDailyVolume")
                .with("largeCapPercent")
                .build();
        HistoricalStats[] historicalStats = iexTradingClient.getStatsEndpoint().requestHistoricalStats(new HistoricalStatsRequest.Builder()
                .withRequestFilter(requestFilter)
                .withDate(YearMonth.of(2017, 3)).build());
        Arrays.stream(historicalStats).forEach(System.out::println);
    }

    private void requestLastDayHistoricalDailyStats() {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder().build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestColumnFilteredLastDayHistoricalDailyStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withRequestFilter(requestFilter).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestYearMonthFilteredHistoricalDailyStats() {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withDate(YearMonth.of(2017, 3)).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestYearMonthAndColumnFilteredHistoricalDailyStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withRequestFilter(requestFilter)
                .withDate(YearMonth.of(2017, 3)).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestDateFilteredHistoricalDailyStats() {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withDate(LocalDate.of(2017, 3, 6)).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestDateAndColumnFilteredHistoricalDailyStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withRequestFilter(requestFilter)
                .withDate(LocalDate.of(2017, 3, 6)).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestLastHistoricalDailyStats() {
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withLast(13).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

    private void requestColumnFilteredLastHistoricalDailyStats() {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("date")
                .with("volume")
                .build();
        HistoricalDailyStats[] historicalDailyStats = iexTradingClient.getStatsEndpoint().requestHistoricalDailyStats(new HistoricalDailyStatsRequest.Builder()
                .withRequestFilter(requestFilter)
                .withLast(13).build());
        Arrays.stream(historicalDailyStats).forEach(System.out::println);
    }

}
