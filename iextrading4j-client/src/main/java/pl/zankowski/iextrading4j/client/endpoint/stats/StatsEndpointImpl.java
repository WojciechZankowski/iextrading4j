package pl.zankowski.iextrading4j.client.endpoint.stats;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;
import pl.zankowski.iextrading4j.api.stats.HistoricalStats;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;
import pl.zankowski.iextrading4j.api.stats.RecentStats;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalDailyStatsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.HistoricalStatsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stats.request.StatsRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static pl.zankowski.iextrading4j.api.filter.RequestFilter.FILTER_QUERY_NAME;
import static pl.zankowski.iextrading4j.client.util.PathUtil.appendPaths;
import static pl.zankowski.iextrading4j.client.util.PathUtil.appendQuery;

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
    public IntradayStats requestIntradayStats(StatsRequest statsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, INTRADAY_PATH);
        Optional<RequestFilter> requestFilterOptional = statsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(IntradayStats.class);
    }

    @Override
    public RecentStats[] requestRecentStat(StatsRequest statsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECENT_PATH);
        Optional<RequestFilter> requestFilterOptional = statsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecentStats[].class);
    }

    @Override
    public RecordsStats requestRecordsStat(StatsRequest statsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, RECORDS_PATH);
        Optional<RequestFilter> requestFilterOptional = statsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(RecordsStats.class);
    }

    @Override
    public HistoricalStats[] requestHistoricalStats(HistoricalStatsRequest historicalStatsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH);
        Optional<YearMonth> dateOptional = historicalStatsRequest.getDate();
        if (dateOptional.isPresent()) {
            webTarget = webTarget.queryParam(HISTORICAL_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(dateOptional.get()));
        }
        Optional<RequestFilter> requestFilterOptional = historicalStatsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalStats[].class);
    }

    @Override
    public HistoricalDailyStats[] requestHistoricalDailyStats(HistoricalDailyStatsRequest historicalDailyStatsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STATS_PATH, HISTORICAL_PATH, HISTORICAL_DAILY_PATH);
        Optional<YearMonth> dateOptional = historicalDailyStatsRequest.getDate();
        if (dateOptional.isPresent()) {
            webTarget = webTarget.queryParam(HISTORICAL_DATE_PARAM, YEARMONTH_PARAM_FORMATTER.format(dateOptional.get()));
        }
        Optional<LocalDate> fullDateOptional = historicalDailyStatsRequest.getFullDate();
        if (fullDateOptional.isPresent() && !dateOptional.isPresent()) {
            webTarget = webTarget.queryParam(HISTORICAL_DAILY_DATE_PARAM, DATE_PARAM_FORMATTER.format(fullDateOptional.get()));
        }
        Optional<Integer> lastOptional = historicalDailyStatsRequest.getLast();
        if (lastOptional.isPresent() && !fullDateOptional.isPresent() && !dateOptional.isPresent()) {
            webTarget = webTarget.queryParam(HISTORICAL_DAILY_LAST_PARAM, lastOptional.get());
        }
        Optional<RequestFilter> requestFilterOptional = historicalDailyStatsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(HistoricalDailyStats[].class);
    }

}
