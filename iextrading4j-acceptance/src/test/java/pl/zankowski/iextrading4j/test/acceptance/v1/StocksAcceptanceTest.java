package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.Ipos;
import pl.zankowski.iextrading4j.api.stocks.LargestTrade;
import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.SectorPerformance;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.api.stocks.TodayIpos;
import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.api.stocks.v1.Dividends;
import pl.zankowski.iextrading4j.api.stocks.v1.Estimates;
import pl.zankowski.iextrading4j.api.stocks.v1.Financials;
import pl.zankowski.iextrading4j.api.stocks.v1.FundOwnership;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderRoster;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderSummary;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderTransaction;
import pl.zankowski.iextrading4j.api.stocks.v1.Intraday;
import pl.zankowski.iextrading4j.api.stocks.v1.KeyStats;
import pl.zankowski.iextrading4j.api.stocks.v1.News;
import pl.zankowski.iextrading4j.api.stocks.v1.Ownership;
import pl.zankowski.iextrading4j.api.stocks.v1.PriceTarget;
import pl.zankowski.iextrading4j.api.stocks.v1.Split;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicator;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicatorType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DelayedQuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.LargestTradeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ListType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.LogoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.OpenCloseRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PeersRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SectorPerformanceRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayEarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayIposRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.UpcomingIposRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.AdvancedStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BatchMarketStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BatchStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BatchStocksType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.CashFlowRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.DividendsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.EstimatesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FinancialsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FundOwnershipRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IncomeStatementRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderRosterRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderSummaryRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderTransactionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InstitutionalOwnershipRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IntradayRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.NewsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.Period;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.PriceTargetRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.SplitsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.TechnicalIndicatorRequestBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StocksAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    void advancedStatsTest() {
        final AdvancedStats result = cloudClient.executeRequest(new AdvancedStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void balanceSheetTest() {
        final BalanceSheets result = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void balanceSheetWithPeriodAndLastTest() {
        final BalanceSheets result = cloudClient.executeRequest(new BalanceSheetRequestBuilder().withSymbol("AAPL")
                .withPeriod(Period.ANNUAL)
                .withLast(2)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void bookTest() {
        final Book result = cloudClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void cashFlowTest() {
        final CashFlows result = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void cashFlowWithLastAndPeriodTest() {
        final CashFlows result = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void sectorCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.SECTOR)
                .withCollectionName("Financials")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void listCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.LIST)
                .withCollectionName("iexvolume")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void tagCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.TAG)
                .withCollectionName("Technology")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void companyTest() {
        final Company result = cloudClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void quoteTest() {
        final Quote result = cloudClient.executeRequest(new QuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void delayedQuoteTest() {
        final DelayedQuote result = cloudClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void dividendsTest() {
        final List<Dividends> result = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("KO")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void nextDividendsTest() {
        final List<Dividends> result = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("KO")
                .withDividendRange(DividendRange.NEXT)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void previousDividendsTest() {
        final List<Dividends> result = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("KO")
                .withDividendRange(DividendRange.FIVE_YEARS)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void earningsTest() {
        final Earnings result = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void earningsWithLastTest() {
        final Earnings result = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void todayEarningsTest() {
        final TodayEarnings todayEarnings = cloudClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());
        assertThat(todayEarnings).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void estimatesTest() {
        final Estimates estimates = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(estimates).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void estimatesWithLastAndPeriodTest() {
        final Estimates result = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void financialsTest() {
        final Financials result = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void financialsWithLastAndPeriodTest() {
        final Financials result = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void fundOwnershipTest() {
        final List<FundOwnership> result = cloudClient.executeRequest(new FundOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void incomeStatementTest() {
        final IncomeStatements result = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void incomeStatementWithLastAndPeriodTest() {
        final IncomeStatements result = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void insiderRosterTest() {
        final List<InsiderRoster> result = cloudClient.executeRequest(new InsiderRosterRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void insiderSummaryTest() {
        final List<InsiderSummary> result = cloudClient.executeRequest(new InsiderSummaryRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void insiderTransactions() {
        final List<InsiderTransaction> result = cloudClient.executeRequest(new InsiderTransactionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void institutionalOwnershipTest() {
        final List<Ownership> result = cloudClient.executeRequest(new InstitutionalOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void intradayPricesTest() {
        final List<Intraday> result = cloudClient.executeRequest(new IntradayRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void intradayPricesWithIexOnlyTest() {
        final List<Intraday> result = cloudClient.executeRequest(new IntradayRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("This endpoint is temporarily unavailable while we identify a new source.")
    @Test
    void upcomingIposTest() {
        final Ipos result = cloudClient.executeRequest(new UpcomingIposRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("This endpoint is temporarily unavailable while we identify a new source.")
    @Test
    void todayIposTest() {
        final TodayIpos result = cloudClient.executeRequest(new TodayIposRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void keyStatsTest() {
        final KeyStats result = cloudClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void largestTradesTest() {
        final List<LargestTrade> result = cloudClient.executeRequest(new LargestTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void listTest() {
        final List<Quote> result = cloudClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void logoTest() {
        final Logo result = cloudClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void newsTest() {
        final List<News> result = cloudClient.executeRequest(new NewsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(10)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void peersTest() {
        final List<String> result = cloudClient.executeRequest(new PeersRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void priceTest() {
        final BigDecimal result = cloudClient.executeRequest(new PriceRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void sectorPerformanceTest() {
        final List<SectorPerformance> result = cloudClient.executeRequest(new SectorPerformanceRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void maxChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.MAX)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void todayChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.INTRADAY)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void oneDayChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withSymbol("AAPL")
                .withDate(LocalDate.of(2020, 12, 29))
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void fiveDaysChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.FIVE_DAYS)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void fiveDays10MinIntervalChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.FIVE_DAYS_10_MIN_INTERVAL)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void oneMonthChartRequestAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void oneMonth30MinIntervalAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH_30_MIN_INTERVAL)
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void chartWithResetAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartReset()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void chartWithSimplifyAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartSimplify()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void chartWithIntervalAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartInterval(4)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void chartWithChangeFromCloseAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChangeFromClose()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void chartWithLastAcceptanceTest() {
        final List<Chart> result = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .withChartLast(4)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void openCloseAcceptanceTest() {
        final Ohlc result = cloudClient.executeRequest(new OpenCloseRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void batchFirstPartAcceptanceTest() {
        final BatchStocks result = cloudClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.ADVANCED_STATS)
                .addType(BatchStocksType.BALANCE_SHEET)
                .addType(BatchStocksType.BOOK)
                .addType(BatchStocksType.CASH_FLOW)
                .addType(BatchStocksType.CHART)
                .addType(BatchStocksType.COMPANY)
                .addType(BatchStocksType.DELAYED_QUOTE)
                .addType(BatchStocksType.DIVIDENDS)
                .addType(BatchStocksType.EARNINGS)
                .addType(BatchStocksType.TODAY_EARNINGS)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void batchSecondPartAcceptanceTest() {
        final BatchStocks result = cloudClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.ESTIMATES)
                .addType(BatchStocksType.FINANCIALS)
                .addType(BatchStocksType.FUND_OWNERSHIP)
                .addType(BatchStocksType.INCOME)
                .addType(BatchStocksType.INSIDER_ROSTER)
                .addType(BatchStocksType.INSIDER_SUMMARY)
                .addType(BatchStocksType.INSIDER_TRANSACTIONS)
                .addType(BatchStocksType.INSTITUTIONAL_OWNERSHIP)
                .addType(BatchStocksType.INTRADAY_PRICES)
                .addType(BatchStocksType.KEY_STATS)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void batchThirdPartAcceptanceTest() {
        final BatchStocks result = cloudClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LARGEST_TRADES)
                .addType(BatchStocksType.LOGO)
                .addType(BatchStocksType.NEWS)
                .addType(BatchStocksType.OHLC)
                .addType(BatchStocksType.OPTIONS)
                .addType(BatchStocksType.PEERS)
                .addType(BatchStocksType.PREVIOUS)
                .addType(BatchStocksType.PRICE)
                .addType(BatchStocksType.PRICE_TARGET)
                .addType(BatchStocksType.QUOTE)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void batchFourthPartAcceptanceTest() {
        final BatchStocks result = cloudClient.executeRequest(new BatchStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.RECOMMENDATION_TRENDS)
                .addType(BatchStocksType.SPLITS)
                .addType(BatchStocksType.VOLUME_BY_VENUE)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void splitsTest() {
        final List<Split> result = cloudClient.executeRequest(new SplitsRequestBuilder()
                .withSymbol("IRCP")
                .withSplitsRange(SplitsRange.TWO_YEARS)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void marketBatchAcceptanceTest() {
        final Map<String, BatchStocks> result = cloudClient.executeRequest(new BatchMarketStocksRequestBuilder()
                .withSymbol("AAPL")
                .addType(BatchStocksType.LARGEST_TRADES)
                .addType(BatchStocksType.LOGO)
                .addType(BatchStocksType.NEWS)
                .addType(BatchStocksType.OHLC)
                .addType(BatchStocksType.OPTIONS)
                .addType(BatchStocksType.PEERS)
                .addType(BatchStocksType.PREVIOUS)
                .addType(BatchStocksType.PRICE)
                .addType(BatchStocksType.PRICE_TARGET)
                .addType(BatchStocksType.QUOTE)
                .build());
        assertThat(result).isNotNull();

        final BatchStocks aapl = result.get("AAPL");
        assertThat(aapl).isNotNull();
    }

    @Test
    void technicalIndicatorTest() {
        final TechnicalIndicator result = cloudClient.executeRequest(new TechnicalIndicatorRequestBuilder()
                .withSymbol("TWTR")
                .withTechnicalIndicatorType(TechnicalIndicatorType.BBANDS)
                .withRange(ChartRange.SIX_MONTHS)
                .build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: The requested data requires permission to access.")
    @Test
    void priceTargetTest() {
        final PriceTarget priceTarget = cloudClient.executeRequest(new PriceTargetRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(priceTarget);
        assertThat(priceTarget).isNotNull();
    }

}
