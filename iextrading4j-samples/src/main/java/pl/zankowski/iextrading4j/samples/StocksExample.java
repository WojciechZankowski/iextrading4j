package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.stocks.*;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.endpoint.stocks.StocksEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.ChartRange;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.ChartRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.NewsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.StockRequest;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class StocksExample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        StocksExample stocksExample = new StocksExample();
//        stocksExample.testQuote();
        stocksExample.testChart();
//        stocksExample.testCompany();
//        stocksExample.testKeyStats();
//        stocksExample.testNews();
//        stocksExample.testFinancials();
//        stocksExample.testEarnings();
//        stocksExample.testLogo();
//        stocksExample.testPrice();
//        stocksExample.testDelayedQuote();
    }

    private void testQuote() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Quote quote = stocksEndpoint.requestQuote(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(quote);
    }

    private void testChart() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Chart[] chartArray = stocksEndpoint.requestChart(new ChartRequest.Builder()
                .withSymbol("AAPL")
                .withChartRange(ChartRange.THREE_MONTHS)
                .build());
        Arrays.stream(chartArray).forEach(System.out::println);
    }

    private void testCompany() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Company company = stocksEndpoint.requestCompany(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    private void testKeyStats() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        KeyStats keyStats = stocksEndpoint.requestKeyStats(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(keyStats);
    }

    private void testNews() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        News[] newsArray = stocksEndpoint.requestNews(new NewsRequest.Builder()
                .withSymbol("AAPL")
                .withRange(5)
                .build());
        Arrays.stream(newsArray).forEach(System.out::println);
    }

    private void testFinancials() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Financials financials = stocksEndpoint.requestFinancials(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(financials);
    }

    private void testEarnings() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Earnings earnings = stocksEndpoint.requestEarnings(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(earnings);
    }

    private void testLogo() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        Logo logo  = stocksEndpoint.requestLogo(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(logo);
    }

    private void testPrice() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        double price = stocksEndpoint.requestPrice(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(price);
    }

    private void testDelayedQuote() {
        StocksEndpoint stocksEndpoint = iexTradingClient.getStocksEndpoint();
        DelayedQuote delayedQuote = stocksEndpoint.requestDelayedQuote(StockRequest.builder()
                .withSymbol("AAPL")
                .build());
        System.out.println(delayedQuote);
    }

}
