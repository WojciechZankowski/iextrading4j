package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.api.stocks.Dividends;
import pl.zankowski.iextrading4j.api.stocks.DynamicChart;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.Financials;
import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.api.stocks.LargestTrade;
import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.api.stocks.News;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.Relevant;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.api.stocks.Split;
import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.request.stocks.*;

import java.math.BigDecimal;
import java.util.List;

public class StocksAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void batchBookRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.BOOK)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchChartRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.CHART)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchCompanyRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.COMPANY)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchDelayedQuoteRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.DELAYED_QUOTE)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchDividendsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.DIVIDENDS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchEffectiveSpreadRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.EFFECTIVE_SPREAD)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchFinancialsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.FINANCIALS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchThresholdSecuritiesRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.THRESHOLD_SECURITIES)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchShortInterestRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.SHORT_INTEREST)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchKeyStatsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.KEY_STATS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchLargestTradesRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LARGEST_TRADES)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchLogoRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LOGO)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchNewsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.NEWS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchOhlcRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.OHLC)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchPeersRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PEERS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchPreviousRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PREVIOUS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchPriceRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PRICE)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchQuoteRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.QUOTE)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchRelevantRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.RELEVANT)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchSplitsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.SPLITS)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void batchVolumeByVenueRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.VOLUME_BY_VENUE)
                .build());
        System.out.println(batchStocks);
    }

    @Test
    public void bookRequestAcceptanceTest() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(book);
    }

    @Test
    public void oneDayChartRequestAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_DAY)
                .withSymbol("AAPL")
                .build());
        System.out.println(chartList);
    }

    @Test
    public void oneMonthChartRequestAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
        System.out.println(chartList);
    }

    @Test
    public void chartWithResetAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartReset()
                .build());
        System.out.println(chartList);
    }

    @Test
    public void chartWithSimplifyAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartSimplify()
                .build());
        System.out.println(chartList);
    }

    @Test
    public void chartWithIntervalAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartInterval(4)
                .build());
        System.out.println(chartList);
    }

    @Test
    public void chartWithChangeFromCloseAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChangeFromClose()
                .build());
        System.out.println(chartList);
    }

    @Test
    public void chartWithLastAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartLast(4)
                .build());
        System.out.println(chartList);
    }

    @Test
    public void dynamicChartAcceptanceTest() {
        final DynamicChart dynamicChart = iexTradingClient.executeRequest(new DynamicChartRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(dynamicChart);
    }

    @Test
    public void companyAcceptanceTest() {
        final Company company = iexTradingClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    @Test
    public void delayedQuoteAcceptanceTest() {
        final DelayedQuote delayedQuote = iexTradingClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(delayedQuote);
    }

    @Test
    public void dividendsAcceptanceTest() {
        final List<Dividends> dividends = iexTradingClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("AAPL")
                .withDividendRange(DividendRange.SIX_MONTHS)
                .build());
        System.out.println(dividends);
    }

    @Test
    public void earningsAcceptanceTest() {
        final Earnings earnings = iexTradingClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(earnings);
    }

    @Test
    public void effectiveSpreadAcceptanceTest() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
    }

    @Test
    public void financialsAcceptanceTest() {
        final Financials financials = iexTradingClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(financials);
    }

    @Test
    public void keyStatsAcceptanceTest() {
        final KeyStats keyStats = iexTradingClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(keyStats);
    }


    @Test
    public void largestTradeAcceptanceTest() {
        final List<LargestTrade> largestTradeList = iexTradingClient.executeRequest(new LargestTradeRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(largestTradeList);
    }

    @Test
    public void listAcceptanceTest() {
        final List<Quote> quoteList = iexTradingClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
        System.out.println(quoteList);
    }

    @Test
    public void logoAcceptanceTest() {
        final Logo logo = iexTradingClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(logo);
    }

    @Test
    public void newsAcceptanceTest() {
        final List<News> newsList = iexTradingClient.executeRequest(new NewsRequestBuilder()
                .withWorldNews()
                .build());
        System.out.println(newsList);
    }

    @Test
    public void openCloseAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ohlc);
    }

    @Test
    public void peersAcceptanceTest() {
        final List<String> peers = iexTradingClient.executeRequest(new PeersRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(peers);
    }

    @Test
    public void previousAcceptanceTest() {
        final BarData bar = iexTradingClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(bar);
    }

    @Test
    public void priceAcceptanceTest() {
        final BigDecimal price = iexTradingClient.executeRequest(new PriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(price);
    }

    @Test
    public void quoteAcceptanceTest() {
        final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(quote);
    }

    @Test
    public void relevantAcceptanceTest() {
        final Relevant relevant = iexTradingClient.executeRequest(new RelevantRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(relevant);
    }

    @Test
    public void splitsAcceptanceTest() {
        final List<Split> splitList = iexTradingClient.executeRequest(new SplitsRequestBuilder()
                .withSymbol("AAPL")
                .withSplitsRange(SplitsRange.FIVE_YEARS)
                .build());
        System.out.println(splitList);
    }

    @Test
    public void venueVolumeAcceptanceTest() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(venueVolumeList);
    }

    @Test
    public void ohlcAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(ohlc);
    }

    @Test
    public void shortInterestAcceptanceTest() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(shortInterestList);
    }

    @Test
    public void timeSeriesAcceptanceTest() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
        System.out.println(timeSeriesList);
    }

    @Test
    public void thresholdSecuritiesAcceptanceTest() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
        System.out.println(thresholdSecuritiesList);
    }

}
