package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.stocks.*;
import pl.zankowski.iextrading4j.api.stocks.v1.*;
import pl.zankowski.iextrading4j.api.stocks.v1.KeyStats;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.*;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.*;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.KeyStatsRequestBuilder;

import java.util.List;

public class StocksSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final StocksSample stocksSample = new StocksSample();

        // The requested data is not available to free tier accounts
        // stocksSample.advancedStatsRequestSample();
        // stocksSample.fundOwnershipRequestSample();
        // stocksSample.insiderRosterRequestSample();
        // stocksSample.insiderSummaryRequestSample();
        // stocksSample.insiderTransactionRequestSample();
        // stocksSample.institutionalOwnershipRequestSample();

//        stocksSample.keyStatsRequestSample();
//        stocksSample.balanceSheetRequestSample();
//        stocksSample.bookRequestSample();
//        stocksSample.cashFlowRequestSample();
//        stocksSample.delayedQuoteRequestSample();
//        stocksSample.companyRequestSample();
//        stocksSample.collectionRequestSample();
//        stocksSample.dividendsRequestSample();
//        stocksSample.earningsRequestSample();
//        stocksSample.todayEarningsRequestSample();
//        stocksSample.effectiveSpreadRequestSample();
//        stocksSample.estimatesRequestSample();
//        stocksSample.financialsRequestSample();
//        stocksSample.chartRequestSample();
//        stocksSample.incomeStatementRequestSample();
//        stocksSample.intradayRequestSample();
//        stocksSample.todayIposRequestSample();
//        stocksSample.upcomingIposRequestSample();
//        stocksSample.largestTradesRequestSample();
//        stocksSample.listRequestSample();
//        stocksSample.logoRequestSample();

    }

    private void advancedStatsRequestSample() {
        final AdvancedStats advancedStats = cloudClient.executeRequest(new AdvancedStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(advancedStats);
    }

    private void keyStatsRequestSample() {
        final KeyStats keyStats = cloudClient.executeRequest(new KeyStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(keyStats);
    }

    private void balanceSheetRequestSample() {
        final BalanceSheets balanceSheets = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        System.out.println(balanceSheets);
    }

    private void bookRequestSample() {
        final Book book = cloudClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(book);
    }

    private void cashFlowRequestSample() {
        final CashFlows cashFlows = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(cashFlows);
    }

    private void collectionRequestSample() {
        final List<Quote> collection = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.LIST)
                .withCollectionName("iexvolume")
                .build());
        System.out.println(collection);
    }

    private void companyRequestSample() {
        final Company company = cloudClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(company);
    }

    private void delayedQuoteRequestSample() {
        final DelayedQuote delayedQuote = cloudClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(delayedQuote);
    }

    private void dividendsRequestSample() {
        final List<Dividends> dividends = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("AAPL")
                .withDividendRange(DividendRange.ONE_YEAR)
                .build());
        System.out.println(dividends);
    }

    private void earningsRequestSample() {
        final Earnings earnings = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(earnings);
    }

    private void todayEarningsRequestSample() {
        final TodayEarnings todayEarnings = cloudClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());
        System.out.println(todayEarnings);
    }

    private void effectiveSpreadRequestSample() {
        final List<EffectiveSpread> effectiveSpreads = cloudClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(effectiveSpreads);
    }

    private void estimatesRequestSample() {
        final Estimates estimates = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(estimates);
    }

    private void financialsRequestSample() {
        final Financials financials = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(financials);
    }

    private void fundOwnershipRequestSample() {
        final List<FundOwnership> fundOwnerships = cloudClient.executeRequest(new FundOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(fundOwnerships);
    }

    private void chartRequestSample() {
        final List<Chart> charts = cloudClient.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());
        System.out.println(charts);
    }

    private void incomeStatementRequestSample() {
        final IncomeStatements incomeStatements = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        System.out.println(incomeStatements);
    }

    private void insiderRosterRequestSample() {
        final List<InsiderRoster> insiderRosters = cloudClient.executeRequest(new InsiderRosterRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(insiderRosters);
    }

    private void insiderSummaryRequestSample() {
        final List<InsiderSummary> insiderSummaries = cloudClient.executeRequest(new InsiderSummaryRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(insiderSummaries);
    }

    private void insiderTransactionRequestSample() {
        final List<InsiderTransaction> transactions = cloudClient.executeRequest(new InsiderTransactionRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(transactions);
    }

    private void institutionalOwnershipRequestSample() {
        final List<Ownership> ownerships = cloudClient.executeRequest(new InstitutionalOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(ownerships);
    }

    private void intradayRequestSample() {
        final List<Intraday> intradays = cloudClient.executeRequest(new IntradayRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(intradays);
    }

    private void todayIposRequestSample() {
        final TodayIpos todayIpos = cloudClient.executeRequest(new TodayIposRequestBuilder().build());
        System.out.println(todayIpos);
    }

    private void upcomingIposRequestSample() {
        final Ipos ipos = cloudClient.executeRequest(new UpcomingIposRequestBuilder().build());
        System.out.println(ipos);
    }

    private void largestTradesRequestSample() {
        final List<LargestTrade> largestTrades = cloudClient.executeRequest(new LargestTradeRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(largestTrades);
    }

    private void listRequestSample() {
        final List<Quote> quoteList = cloudClient.executeRequest(new ListRequestBuilder()
                .withListType(ListType.IEXVOLUME)
                .build());
        System.out.println(quoteList);
    }

    private void logoRequestSample() {
        final Logo logo = cloudClient.executeRequest(new LogoRequestBuilder()
                .withSymbol("AAPL")
                .build());
        System.out.println(logo);
    }

}
