package pl.zankowski.iextrading.client.endpoint.stats;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading.api.stats.HistoricalStats;
import pl.zankowski.iextrading.api.stats.IntradayStats;
import pl.zankowski.iextrading.api.stats.RecentStats;
import pl.zankowski.iextrading.api.stats.RecordsStats;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static pl.zankowski.iextrading.api.filter.RequestFilter.FILTER_QUERY_NAME;
import static pl.zankowski.iextrading.client.util.PathUtil.appendPaths;
import static pl.zankowski.iextrading.client.util.PathUtil.appendQuery;

/**
 * @author Wojciech Zankowski
 */
public class StatsEndpointImpl implements StatsEndpoint {

    public static final String STATS_PATH = "stats";
    public static final String INTRADAY_PATH = "intraday";
    public static final String RECENT_PATH = "recent";
    public static final String RECORDS_PATH = "records";

    public static final String HISTORICAL_PATH = "historical";
    public static final String HISTORICAL_DATE_PARAM = "date";

    public static final String HISTORICAL_DAILY_PATH = "daily";
    public static final String HISTORICAL_DAILY_DATE_PARAM = "date";
    public static final String HISTORICAL_DAILY_LAST_PARAM = "last";

    private static final DateTimeFormatter YEARMONTH_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public StatsEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public IntradayStats requestIntradayStats() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, INTRADAY_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(IntradayStats.class);
    }

    @Override
    public IntradayStats requestIntradayStats(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, INTRADAY_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(IntradayStats.class);
    }

    @Override
    public RecentStats[] requestRecentStat() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECENT_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecentStats[].class);
    }

    @Override
    public RecentStats[] requestRecentStat(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECENT_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecentStats[].class);
    }

    @Override
    public RecordsStats requestRecordsStat() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECORDS_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecordsStats.class);
    }

    @Override
    public RecordsStats requestRecordsStat(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECORDS_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecordsStats.class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats(YearMonth date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats(RequestFilter requestFilter, YearMonth date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(date));
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(YearMonth date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, YearMonth date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(date));
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(LocalDate date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, DATE_PARAM_FORMATTER.format(date));
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, LocalDate date) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, DATE_PARAM_FORMATTER.format(date));
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(int last) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_LAST_PARAM, last);
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(RequestFilter requestFilter, int last) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        webTarget = webTarget.queryParam(HISTORICAL_DAILY_LAST_PARAM, last);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

}
