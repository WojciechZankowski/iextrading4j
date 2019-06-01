package pl.zankowski.iextrading4j.test.acceptance;

import com.google.common.collect.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.BarData;
import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DynamicChart;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.KeyStats;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.api.stocks.ThresholdSecurities;
import pl.zankowski.iextrading4j.api.stocks.TimeSeries;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchMarketStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DynamicChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
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
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayEarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;

import java.util.List;
import java.util.Map;

@Deprecated
public class StocksAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void batchBookMarketRequestAcceptanceTest() {
        final Map<String, BatchStocks> batchStocksMap = iexTradingClient.executeRequest(new BatchMarketStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.BOOK)
                .build());
    }

    @Test
    public void batchBookRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.BOOK)
                .build());
    }

    @Test
    public void batchChartRequestAcceptanceTest() {
        final Map<String, BatchStocks> batchStocks = iexTradingClient.executeRequest(new BatchMarketStocksRequestBuilder()
                .withSymbols(Lists.newArrayList("AAPL", "MSFT"))
                .addType(BatchStocksType.CHART)
                .withChartRange(ChartRange.ONE_MONTH)
                .build());
    }

    @Test
    public void batchCompanyRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.COMPANY)
                .build());
    }

    @Test
    public void batchDelayedQuoteRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.DELAYED_QUOTE)
                .build());
    }

    @Test
    public void batchDividendsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.DIVIDENDS)
                .build());
    }

    @Test
    public void batchEffectiveSpreadRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.EFFECTIVE_SPREAD)
                .build());
    }

    @Test
    public void batchFinancialsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.FINANCIALS)
                .build());
    }

    @Test
    public void batchThresholdSecuritiesRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.THRESHOLD_SECURITIES)
                .build());
    }

    @Test
    public void batchShortInterestRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.SHORT_INTEREST)
                .build());
    }

    @Test
    public void batchKeyStatsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.KEY_STATS)
                .build());
    }

    @Test
    public void batchLargestTradesRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LARGEST_TRADES)
                .build());
    }

    @Test
    public void batchLogoRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LOGO)
                .build());
    }

    @Test
    public void batchNewsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.NEWS)
                .build());
    }

    @Test
    public void batchOhlcRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.OHLC)
                .build());
    }

    @Test
    public void batchPeersRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PEERS)
                .build());
    }

    @Test
    public void batchPreviousRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PREVIOUS)
                .build());
    }

    @Test
    public void batchPriceRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.PRICE)
                .build());
    }

    @Test
    public void batchQuoteRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.QUOTE)
                .build());
    }

    @Test
    public void batchRelevantRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.RELEVANT)
                .build());
    }

    @Test
    public void batchSplitsRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.SPLITS)
                .build());
    }

    @Test
    public void batchVolumeByVenueRequestAcceptanceTest() {
        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.VOLUME_BY_VENUE)
                .build());
    }

    @Test
    public void bookRequestAcceptanceTest() {
        final Book book = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void oneDayChartRequestAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_DAY)
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void oneMonthChartRequestAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void chartWithResetAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartReset()
                .build());
    }

    @Test
    public void chartWithSimplifyAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartSimplify()
                .build());
    }

    @Test
    public void chartWithIntervalAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartInterval(4)
                .build());
    }

    @Test
    public void chartWithChangeFromCloseAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChangeFromClose()
                .build());
    }

    @Test
    public void chartWithLastAcceptanceTest() {
        final List<Chart> chartList = iexTradingClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartLast(4)
                .build());
    }

    @Test
    public void dynamicChartAcceptanceTest() {
        final DynamicChart dynamicChart = iexTradingClient.executeRequest(new DynamicChartRequestBuilder()
                .withSymbol("aapl")
                .build());
    }

    @Test
    public void companyAcceptanceTest() {
        final Company company = iexTradingClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void earningsAcceptanceTest() {
        final Earnings earnings = iexTradingClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void todayEarningsAcceptanceTest() {
        final TodayEarnings todayEarnings = iexTradingClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());
    }

    @Test
    public void effectiveSpreadAcceptanceTest() {
        final List<EffectiveSpread> effectiveSpreads = iexTradingClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void keyStatsAcceptanceTest() {
        final KeyStats keyStats = iexTradingClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void listAcceptanceTest() {
        final List<Quote> quoteList = iexTradingClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
    }

    @Test
    public void openCloseAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void previousAcceptanceTest() {
        final BarData bar = iexTradingClient.executeRequest(new PreviousRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void quoteAcceptanceTest() {
        final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void venueVolumeAcceptanceTest() {
        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("AAPL")
                .build());
    }

    @Test
    public void ohlcAcceptanceTest() {
        final Ohlc ohlc = iexTradingClient.executeRequest(new OhlcRequestBuilder()
                .withSymbol("aapl")
                .build());
    }

    @Test
    public void shortInterestAcceptanceTest() {
        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSample()
                .withMarket()
                .build());
    }

    @Test
    public void timeSeriesAcceptanceTest() {
        final List<TimeSeries> timeSeriesList = iexTradingClient.executeRequest(new TimeSeriesRequestBuilder()
                .withSymbol("aapl")
                .build());
    }

    @Test
    public void thresholdSecuritiesAcceptanceTest() {
        final List<ThresholdSecurities> thresholdSecuritiesList = iexTradingClient.executeRequest(new ThresholdSecuritiesRequestBuilder()
                .withSample()
                .withMarket()
                .build());
    }

    @Test
    public void ohlcMarketAcceptanceTest() {
        final Map<String, Ohlc> ohlcMap = iexTradingClient.executeRequest(new OhlcMarketRequestBuilder()
                .build());
    }

    @Test
    public void previousMarketAcceptanceTest() {
        final Map<String, BarData> barDataMap = iexTradingClient.executeRequest(new PreviousMarketRequestBuilder()
                .build());
    }

}
