package pl.zankowski.iextrading4j.client.endpoint.stats;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.endpoint.EndpointTestBase;

import javax.ws.rs.core.UriBuilder;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.zankowski.iextrading4j.api.stats.builder.HistoricalDailyStatsDataBuilder.defaultHistoricalDailyStats;
import static pl.zankowski.iextrading4j.api.stats.builder.HistoricalStatsDataBuilder.defaultHistoricalStats;
import static pl.zankowski.iextrading4j.api.stats.builder.IntradayStatsDataBuilder.defaultIntradayStats;
import static pl.zankowski.iextrading4j.api.stats.builder.RecentStatsDataBuilder.defaultRecentStats;
import static pl.zankowski.iextrading4j.api.stats.builder.RecordsStatsDataBuilder.defaultRecordsStats;

/**
 * @author Wojciech Zankowski
 */
public class StatsEndpointImplTest extends EndpointTestBase {

    final UriBuilder API_PATH = UriBuilder.fromPath("http://localhost:8080");

    @Test
    public void shouldRequestIntradayStats() {
        final IntradayStats expectedIntradayStats = defaultIntradayStats();
        when(builderMock.get(IntradayStats.class)).thenReturn(expectedIntradayStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        IntradayStats actualIntradayStats = statsEndpoint.requestIntradayStats();

        assertThat(actualIntradayStats).isEqualTo(expectedIntradayStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.INTRADAY_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestIntradayStatsWithRequestFilter() {
        final IntradayStats expectedIntradayStats = defaultIntradayStats();
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(IntradayStats.class)).thenReturn(expectedIntradayStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        IntradayStats actualIntradayStats = statsEndpoint.requestIntradayStats(requestFilter);

        assertThat(actualIntradayStats).isEqualTo(expectedIntradayStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.INTRADAY_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestRecentStats() {
        final RecentStats[] expectedRecentStats = new RecentStats[] {defaultRecentStats()};
        when(builderMock.get(RecentStats[].class)).thenReturn(expectedRecentStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        RecentStats[] actualRecentStats = statsEndpoint.requestRecentStat();

        assertThat(actualRecentStats).isEqualTo(expectedRecentStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.RECENT_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestRecentStatsWithRequestFilter() {
        final RecentStats[] expectedRecentStats = new RecentStats[] {defaultRecentStats()};
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(RecentStats[].class)).thenReturn(expectedRecentStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        RecentStats[] actualRecentStats = statsEndpoint.requestRecentStat(requestFilter);

        assertThat(actualRecentStats).isEqualTo(expectedRecentStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.RECENT_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestRecordsStats() {
        final RecordsStats expectedRecordsStats = defaultRecordsStats();
        when(builderMock.get(RecordsStats.class)).thenReturn(expectedRecordsStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        RecordsStats actualRecordsStats = statsEndpoint.requestRecordsStat();

        assertThat(actualRecordsStats).isEqualTo(expectedRecordsStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.RECORDS_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestRecordsStatsWithRequestFilter() {
        final RecordsStats expectedRecordsStats = defaultRecordsStats();
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(RecordsStats.class)).thenReturn(expectedRecordsStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        RecordsStats actualRecordsStats = statsEndpoint.requestRecordsStat(requestFilter);

        assertThat(actualRecordsStats).isEqualTo(expectedRecordsStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.RECORDS_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalStats() {
        final HistoricalStats[] expectedHistoricalStats = new HistoricalStats[] {defaultHistoricalStats()};
        when(builderMock.get(HistoricalStats[].class)).thenReturn(expectedHistoricalStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalStats[] actualHistoricalStats = statsEndpoint.requestHistoricalStats();

        assertThat(actualHistoricalStats).isEqualTo(expectedHistoricalStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH);
        verify(webTargetMock, times(0)).queryParam(any(), any());
    }

    @Test
    public void shouldRequestHistoricalStatsWithRequestFilter() {
        final HistoricalStats[] expectedHistoricalStats = new HistoricalStats[] {defaultHistoricalStats()};
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalStats[].class)).thenReturn(expectedHistoricalStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalStats[] actualHistoricalStats = statsEndpoint.requestHistoricalStats(requestFilter);

        assertThat(actualHistoricalStats).isEqualTo(expectedHistoricalStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalStatsWithYearMonth() {
        final HistoricalStats[] expectedHistoricalStats = new HistoricalStats[] {defaultHistoricalStats()};
        final YearMonth yearMonth = YearMonth.of(2017, 3);
        when(builderMock.get(HistoricalStats[].class)).thenReturn(expectedHistoricalStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalStats[] actualHistoricalStats = statsEndpoint.requestHistoricalStats(yearMonth);

        assertThat(actualHistoricalStats).isEqualTo(expectedHistoricalStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DATE_PARAM, "201703");
    }

    @Test
    public void shouldRequestHistoricalStatsWithYearMonthAndRequestFilter() {
        final HistoricalStats[] expectedHistoricalStats = new HistoricalStats[] {defaultHistoricalStats()};
        final YearMonth yearMonth = YearMonth.of(2017, 3);
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalStats[].class)).thenReturn(expectedHistoricalStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalStats[] actualHistoricalStats = statsEndpoint.requestHistoricalStats(requestFilter, yearMonth);

        assertThat(actualHistoricalStats).isEqualTo(expectedHistoricalStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DATE_PARAM, "201703");
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalDailyStats() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats();

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithRequestFilter() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(requestFilter);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithYearMonth() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final YearMonth yearMonth = YearMonth.of(2017, 3);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(yearMonth);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_DATE_PARAM, "201703");
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithYearMonthAndRequestFilter() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final YearMonth yearMonth = YearMonth.of(2017, 3);
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(requestFilter, yearMonth);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_DATE_PARAM, "201703");
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithDate() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final LocalDate localDate = LocalDate.of(2017, 3, 5);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(localDate);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_DATE_PARAM, "20170305");
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithDateAndRequestFilter() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final LocalDate localDate = LocalDate.of(2017, 3, 5);
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(requestFilter, localDate);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_DATE_PARAM, "20170305");
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithLast() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final int last = 5;
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(last);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_LAST_PARAM, last);
    }

    @Test
    public void shouldRequestHistoricalDailyStatsWithLastAndRequestFilter() {
        final HistoricalDailyStats[] expectedHistoricalDailyStats = new HistoricalDailyStats[] {defaultHistoricalDailyStats()};
        final int last = 5;
        final String columnFilterList = "symbol;marketPrice";
        final RequestFilter requestFilter = new RequestFilter(columnFilterList);
        when(builderMock.get(HistoricalDailyStats[].class)).thenReturn(expectedHistoricalDailyStats);

        StatsEndpoint statsEndpoint = new StatsEndpointImpl(clientMock, API_PATH);
        HistoricalDailyStats[] actualHistoricalDailyStats = statsEndpoint.requestHistoricalDailyStats(requestFilter, last);

        assertThat(actualHistoricalDailyStats).isEqualTo(expectedHistoricalDailyStats);
        verifyCorrectPaths(StatsEndpointImpl.STATS_PATH, StatsEndpointImpl.HISTORICAL_PATH, StatsEndpointImpl.HISTORICAL_DAILY_PATH);
        verifyCorrectQueries(StatsEndpointImpl.HISTORICAL_DAILY_LAST_PARAM, last);
        verifyCorrectQueries(RequestFilter.FILTER_QUERY_NAME, columnFilterList);
    }

}
