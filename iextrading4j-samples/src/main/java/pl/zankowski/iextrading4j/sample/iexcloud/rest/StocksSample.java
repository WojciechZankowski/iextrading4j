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

//        stocksSample.keyStatsRequestSample();
//        stocksSample.balanceSheetRequestSample();
//        stocksSample.bookRequestSample();
//        stocksSample.cashFlowRequestSample();
//        stocksSample.delayedQuoteRequestSample();
//        stocksSample.companyRequestSample();
//        stocksSample.collectionRequestSample();
        stocksSample.dividendsRequestSample();
        stocksSample.earningsRequestSample();
        stocksSample.todayEarningsRequestSample();
        stocksSample.effectiveSpreadRequestSample();
        stocksSample.estimatesRequestSample();
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

}
