package pl.zankowski.iextrading4j.sample.iexapi.rest;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DynamicChart;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.IEXApiClient;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchMarketStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DynamicChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OhlcMarketRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OhlcRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OpenCloseRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PreviousMarketRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PreviousRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ShortInterestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ThresholdSecuritiesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TimeSeriesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.util.List;
import java.util.Map;

@Deprecated
public class StocksSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final StocksSample sampleSuite = new StocksSample();

        sampleSuite.batchRequestSample();
        sampleSuite.batchMarketRequestSample();
        sampleSuite.bookRequestSample();
        sampleSuite.chartRequestSample();
        sampleSuite.companyRequestSample();
        sampleSuite.dynamicChartRequestSample();
        sampleSuite.effectiveSpreadRequestSample();
        sampleSuite.keyStatsRequestSample();
        sampleSuite.listRequestSample();
        sampleSuite.openCloseRequestSample();
        sampleSuite.previousRequestSample();
        sampleSuite.quoteRequestSample();
        sampleSuite.venueVolumeRequestSample();
        sampleSuite.ohlcRequestSample();
        sampleSuite.shortInterestRequestSample();
        sampleSuite.timeSeriesRequestSample();
        sampleSuite.thresholdSecuritiesRequestSample();
        sampleSuite.ohlcMarketRequestSample();
        sampleSuite.previousMarketRequestSample();
    }

    private void batchRequestSample() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.BOOK)
                .addType(BatchStocksType.COMPANY)
                .addType(BatchStocksType.EARNINGS)
                .build());
        System.out.println(batchStocks);
    }

    private void batchMarketRequestSample() {
        final Map<String, BatchStocks> batchStocksMap = iexTradingClient.executeRequest(new BatchMarketStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.COMPANY)
                .addType(BatchStocksType.EARNINGS)
                .build());
        System.out.println(batchStocksMap);
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

    private void dynamicChartRequestSample() {
        final DynamicChart dynamicChart = iexTradingClient.executeRequest(new DynamicChartRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(dynamicChart);
    }

    private void companyRequestSample() {
        final Company company = iexTradingClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    private void effectiveSpreadRequestSample() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
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

    private void openCloseRequestSample() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ohlc);
    }

    private void previousRequestSample() {
        final BarData bar = iexTradingClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(bar);
    }

    private void previousMarketRequestSample() {
        final Map<String, BarData> barDataMap = iexTradingClient.executeRequest(new PreviousMarketRequestBuilder()
                .build());
        System.out.println(barDataMap);
    }

    private void quoteRequestSample() {
        final List<ExchangeSymbol> exchangeSymbols = iexTradingClient.executeRequest(new SymbolsRequestBuilder().build());
        for (final ExchangeSymbol exchangeSymbol : exchangeSymbols) {
            final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                    .withSymbol(exchangeSymbol.getSymbol())
                    .build());

            System.out.println(quote);
        }
    }

    private void venueVolumeRequestSample() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(venueVolumeList);
    }

    private void ohlcRequestSample() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(ohlc);
    }

    private void ohlcMarketRequestSample() {
        final Map<String, Ohlc> ohlcMap = iexTradingClient.executeRequest(new OhlcMarketRequestBuilder()
                .build());
        System.out.println(ohlcMap);
    }

    private void shortInterestRequestSample() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(shortInterestList);
    }

    private void timeSeriesRequestSample() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(timeSeriesList);
    }

    private void thresholdSecuritiesRequestSample() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(thresholdSecuritiesList);
    }

}
