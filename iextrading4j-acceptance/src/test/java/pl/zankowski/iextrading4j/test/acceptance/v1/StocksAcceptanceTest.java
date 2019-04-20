package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.api.stocks.Dividends;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.EffectiveSpread;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.api.stocks.v1.Estimates;
import pl.zankowski.iextrading4j.api.stocks.v1.Financials;
import pl.zankowski.iextrading4j.api.stocks.v1.FundOwnership;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CollectionType;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DelayedQuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.EffectiveSpreadRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayEarningsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.AdvancedStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.CashFlowRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.EstimatesRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FinancialsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FundOwnershipRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IncomeStatementRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.Period;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StocksAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Ignore // Not free tier
    @Test
    public void advancedStatsTest() {
        final AdvancedStats result = cloudClient.executeRequest(new AdvancedStatsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void balanceSheetTest() {
        final BalanceSheets result = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void balanceSheetWithPeriodAndLastTest() {
        final BalanceSheets result = cloudClient.executeRequest(new BalanceSheetRequestBuilder().withSymbol("AAPL")
                .withPeriod(Period.ANNUAL)
                .withLast(2)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void bookTest() {
        final Book result = cloudClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void cashFlowTest() {
        final CashFlows result = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void cashFlowWithLastAndPeriodTest() {
        final CashFlows result = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void sectorCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.SECTOR)
                .withCollectionName("Financials")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void listCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.LIST)
                .withCollectionName("iexvolume")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void tagCollectionTest() {
        final List<Quote> result = cloudClient.executeRequest(new CollectionRequestBuilder()
                .withCollectionType(CollectionType.TAG)
                .withCollectionName("Technology")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void companyTest() {
        final Company result = cloudClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void delayedQuoteTest() {
        final DelayedQuote result = cloudClient.executeRequest(new DelayedQuoteRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void dividendsTest() {
        final List<Dividends> result = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void earningsTest() {
        final Earnings result = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void earningsWithLastTest() {
        final Earnings result = cloudClient.executeRequest(new EarningsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void todayEarningsTest() {
        final TodayEarnings todayEarnings = cloudClient.executeRequest(new TodayEarningsRequestBuilder()
                .build());
        assertThat(todayEarnings).isNotNull();
    }

    @Test
    public void effectiveSpreadTest() {
        final List<EffectiveSpread> result = cloudClient.executeRequest(new EffectiveSpreadRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void estimatesTest() {
        final Estimates estimates = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(estimates).isNotNull();
    }

    @Test
    public void estimatesWithLastAndPeriodTest() {
        final Estimates result = cloudClient.executeRequest(new EstimatesRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void financialsTest() {
        final Financials result = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void financialsWithLastAndPeriodTest() {
        final Financials result = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

    @Ignore // Not free tier
    @Test
    public void fundOwnershipTest() {
        final List<FundOwnership> result = cloudClient.executeRequest(new FundOwnershipRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void incomeStatementTest() {
        final IncomeStatements result = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void incomeStatementWithLastAndPeriodTest() {
        final IncomeStatements result = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .withLast(2)
                .withPeriod(Period.ANNUAL)
                .build());
        assertThat(result).isNotNull();
    }

}
