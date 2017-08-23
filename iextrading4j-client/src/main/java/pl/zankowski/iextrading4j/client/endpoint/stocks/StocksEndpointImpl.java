package pl.zankowski.iextrading4j.client.endpoint.stocks;

import pl.zankowski.iextrading4j.api.stocks.*;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.ChartRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.NewsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.StockRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import static pl.zankowski.iextrading4j.client.util.PathUtil.appendPaths;

/**
 * @author Wojciech Zankowski
 */
public class StocksEndpointImpl implements StocksEndpoint {

    public static final String STOCK_PATH = "stock";

    public static final String QUOTE_PATH = "quote";
    public static final String CHART_PATH = "chart";
    public static final String KEY_STATS_PATH = "stats";
    public static final String NEWS_PATH = "news";
    public static final String NEWS_RANGE_PATH = "last";
    public static final String FINANCIALS_PATH = "financials";
    public static final String EARNINGS = "earnings";
    public static final String COMPANY_PATH = "company";
    public static final String LOGO_PATH = "logo";
    public static final String PRICE_PATH = "price";
    public static final String DELAYED_QUOTE_PATH = "delayed-quote";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public StocksEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public Quote requestQuote(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), QUOTE_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Quote.class);
    }

    @Override
    public Chart[] requestChart(ChartRequest chartRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, chartRequest.getSymbol(), CHART_PATH, chartRequest.getChartRange().getCode());
        return webTarget.request(MediaType.APPLICATION_JSON).get(Chart[].class);
    }

    @Override
    public Company requestCompany(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), COMPANY_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Company.class);
    }

    @Override
    public KeyStats requestKeyStats(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), KEY_STATS_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(KeyStats.class);
    }

    @Override
    public News[] requestNews(NewsRequest newsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, newsRequest.getSymbol(), NEWS_PATH, NEWS_RANGE_PATH, String.valueOf(newsRequest.getRange()));
        return webTarget.request(MediaType.APPLICATION_JSON).get(News[].class);
    }

    @Override
    public Financials requestFinancials(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), FINANCIALS_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Financials.class);
    }

    @Override
    public Earnings requestEarnings(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), EARNINGS);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Earnings.class);
    }

    @Override
    public Logo requestLogo(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), LOGO_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Logo.class);
    }

    @Override
    public double requestPrice(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), PRICE_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(Double.class);
    }

    @Override
    public DelayedQuote requestDelayedQuote(StockRequest stockRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, STOCK_PATH, stockRequest.getSymbol(), DELAYED_QUOTE_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(DelayedQuote.class);
    }
}
