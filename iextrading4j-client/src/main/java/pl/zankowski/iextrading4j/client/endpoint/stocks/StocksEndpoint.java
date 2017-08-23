package pl.zankowski.iextrading4j.client.endpoint.stocks;

import pl.zankowski.iextrading4j.api.stocks.*;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.ChartRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.NewsRequest;
import pl.zankowski.iextrading4j.client.endpoint.stocks.request.StockRequest;

/**
 * @author Wojciech Zankowski
 */
public interface StocksEndpoint {

    Quote requestQuote(StockRequest stockRequest);

    Chart[] requestChart(ChartRequest chartRequest);

    Company requestCompany(StockRequest stockRequest);

    KeyStats requestKeyStats(StockRequest stockRequest);

    News[] requestNews(NewsRequest newsRequest);

    Financials requestFinancials(StockRequest stockRequest);

    Earnings requestEarnings(StockRequest stockRequest);

    Logo requestLogo(StockRequest stockRequest);

    double requestPrice(StockRequest stockRequest);

    DelayedQuote requestDelayedQuote(StockRequest stockRequest);

}
