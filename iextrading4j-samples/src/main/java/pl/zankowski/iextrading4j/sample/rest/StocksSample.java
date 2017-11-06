package pl.zankowski.iextrading4j.sample.rest;

import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.api.stocks.Dividends;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.Financials;
import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.api.stocks.News;
import pl.zankowski.iextrading4j.api.stocks.OpenClose;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.Relevant;
import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DelayedQuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.FinancialsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.LogoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.NewsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OpenCloseRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PeersRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PreviousRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.RelevantRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.math.BigDecimal;
import java.util.List;

public class StocksSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final StocksSample sampleSuite = new StocksSample();

        sampleSuite.bookRequestSample();
        sampleSuite.chartRequestSample();
        sampleSuite.companyRequestSample();
        sampleSuite.delayedQuoteRequestSample();
        sampleSuite.dividendsRequestSample();
        sampleSuite.earningsRequestSample();
        sampleSuite.effectiveSpreadRequestSample();
        sampleSuite.financialsRequestSample();
        sampleSuite.keyStatsRequestSample();
        sampleSuite.listRequestSample();
        sampleSuite.logoRequestSample();
        sampleSuite.newsRequestSample();
        sampleSuite.openCloseRequestSample();
        sampleSuite.peersRequestSample();
        sampleSuite.previousRequestSample();
        sampleSuite.priceRequestSample();
        sampleSuite.quoteRequestSample();
        sampleSuite.relevantRequestSample();
        sampleSuite.splitsRequestSample();
        sampleSuite.venueVolumeRequestSample();
    }

    private void bookRequestSample() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(book);
    }

    private void chartRequestSample() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
        System.out.println(chartList);
    }

    private void companyRequestSample() {
        final Company company = iexTradingClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    private void delayedQuoteRequestSample() {
        final DelayedQuote delayedQuote = iexTradingClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(delayedQuote);
    }

    private void dividendsRequestSample() {
        final List<Dividends> dividends = iexTradingClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("AAPL")
                .withDividendRange(DividendRange.SIX_MONTHS)
                .build());
    }

    private void earningsRequestSample() {
        final Earnings earnings = iexTradingClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(earnings);
    }

    private void effectiveSpreadRequestSample() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
    }

    private void financialsRequestSample() {
        final Financials financials = iexTradingClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(financials);
    }

    private void keyStatsRequestSample() {
        final KeyStats keyStats = iexTradingClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(keyStats);
    }

    private void listRequestSample() {
        final List<Quote> quoteList = iexTradingClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
        System.out.println(quoteList);
    }

    private void logoRequestSample() {
        final Logo logo = iexTradingClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(logo);
    }

    private void newsRequestSample() {
        final List<News> newsList = iexTradingClient.executeRequest(new NewsRequestBuilder()
                .withWorldNews()
                .build());
        System.out.println(newsList);
    }

    private void openCloseRequestSample() {
        final OpenClose openClose = iexTradingClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(openClose);
    }

    private void peersRequestSample() {
        final List<String> peers = iexTradingClient.executeRequest(new PeersRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(peers);
    }

    private void previousRequestSample() {
        final BarData bar = iexTradingClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(bar);
    }

    private void priceRequestSample() {
        final BigDecimal price = iexTradingClient.executeRequest(new PriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(price);
    }

    private void quoteRequestSample() {
        final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(quote);
    }

    private void relevantRequestSample() {
        final Relevant relevant = iexTradingClient.executeRequest(new RelevantRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(relevant);
    }

    private void splitsRequestSample() {
        final List<Split> splitList = iexTradingClient.executeRequest(new SplitsRequestBuilder()
                .withSymbol("AAPL")
                .withSplitsRange(SplitsRange.FIVE_YEARS)
                .build());
        System.out.println(splitList);
    }

    private void venueVolumeRequestSample() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(venueVolumeList);
    }

}
