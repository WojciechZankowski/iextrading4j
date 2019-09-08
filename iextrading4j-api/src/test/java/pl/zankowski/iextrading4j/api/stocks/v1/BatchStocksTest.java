package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Book;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.api.stocks.DelayedQuote;
import pl.zankowski.iextrading4j.api.stocks.Earnings;
import pl.zankowski.iextrading4j.api.stocks.LargestTrade;
import pl.zankowski.iextrading4j.api.stocks.Logo;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BatchStocksTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final AdvancedStats advancedStats = fixture.create(AdvancedStats.class);
        final BalanceSheets balanceSheets = fixture.create(BalanceSheets.class);
        final Book book = fixture.create(Book.class);
        final CashFlows cashFlows = fixture.create(CashFlows.class);
        final List<Chart> chart = Lists.newArrayList(fixture.collections().createCollection(Chart.class));
        final Company company = fixture.create(Company.class);
        final DelayedQuote delayedQuote = fixture.create(DelayedQuote.class);
        final List<Dividends> dividends = Lists.newArrayList(fixture.collections().createCollection(Dividends.class));
        final Earnings earnings = fixture.create(Earnings.class);
        final TodayEarnings earningsToday = fixture.create(TodayEarnings.class);
        final Estimates estimates = fixture.create(Estimates.class);
        final Financials financials = fixture.create(Financials.class);
        final FundOwnership fundOwnership = fixture.create(FundOwnership.class);
        final IncomeStatements incomeStatements = fixture.create(IncomeStatements.class);
        final List<InsiderRoster> insiderRoster = Lists.newArrayList(fixture.collections().createCollection(InsiderRoster.class));
        final List<InsiderSummary> insiderSummary = Lists.newArrayList(fixture.collections().createCollection(InsiderSummary.class));
        final List<InsiderTransaction> insiderTransaction = Lists.newArrayList(fixture.collections().createCollection(InsiderTransaction.class));
        final List<Ownership> institutionalOwnership = Lists.newArrayList(fixture.collections().createCollection(Ownership.class));
        final List<Intraday> intradayPrices = Lists.newArrayList(fixture.collections().createCollection(Intraday.class));
        final KeyStats keyStats = fixture.create(KeyStats.class);
        final List<LargestTrade> largestTrades = Lists.newArrayList(fixture.collections().createCollection(LargestTrade.class));
        final Logo logo = fixture.create(Logo.class);
        final List<News> news = Lists.newArrayList(fixture.collections().createCollection(News.class));
        final Ohlc ohlc = fixture.create(Ohlc.class);
        final List<String> options = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final List<String> peers = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final BarData previous = fixture.create(BarData.class);
        final BigDecimal price = fixture.create(BigDecimal.class);
        final PriceTarget priceTarget = fixture.create(PriceTarget.class);
        final Quote quote = fixture.create(Quote.class);
        final List<RecommendationTrends> recommendationTrends = Lists.newArrayList(fixture.collections().createCollection(RecommendationTrends.class));
        final List<Split> splits = Lists.newArrayList(fixture.collections().createCollection(Split.class));
        final VenueVolume volumeByVenue = fixture.create(VenueVolume.class);

        final BatchStocks batchStocks = new BatchStocks(advancedStats, balanceSheets, book, cashFlows, chart,
                company, delayedQuote, dividends, earnings, earningsToday, estimates, financials, fundOwnership,
                incomeStatements, insiderRoster, insiderSummary, insiderTransaction, institutionalOwnership,
                intradayPrices, keyStats, largestTrades, logo, news, ohlc, options, peers, previous, price,
                priceTarget, quote, recommendationTrends, splits, volumeByVenue);

        assertThat(batchStocks.getAdvancedStats()).isEqualTo(advancedStats);
        assertThat(batchStocks.getBalanceSheets()).isEqualTo(balanceSheets);
        assertThat(batchStocks.getBook()).isEqualTo(book);
        assertThat(batchStocks.getCashFlows()).isEqualTo(cashFlows);
        assertThat(batchStocks.getChart()).isEqualTo(chart);
        assertThat(batchStocks.getCompany()).isEqualTo(company);
        assertThat(batchStocks.getDelayedQuote()).isEqualTo(delayedQuote);
        assertThat(batchStocks.getDividends()).isEqualTo(dividends);
        assertThat(batchStocks.getEarnings()).isEqualTo(earnings);
        assertThat(batchStocks.getEarningsToday()).isEqualTo(earningsToday);
        assertThat(batchStocks.getEstimates()).isEqualTo(estimates);
        assertThat(batchStocks.getFinancials()).isEqualTo(financials);
        assertThat(batchStocks.getFundOwnership()).isEqualTo(fundOwnership);
        assertThat(batchStocks.getIncomeStatements()).isEqualTo(incomeStatements);
        assertThat(batchStocks.getInsiderRoster()).isEqualTo(insiderRoster);
        assertThat(batchStocks.getInsiderSummary()).isEqualTo(insiderSummary);
        assertThat(batchStocks.getInsiderTransaction()).isEqualTo(insiderTransaction);
        assertThat(batchStocks.getInstitutionalOwnership()).isEqualTo(institutionalOwnership);
        assertThat(batchStocks.getIntradayPrices()).isEqualTo(intradayPrices);
        assertThat(batchStocks.getKeyStats()).isEqualTo(keyStats);
        assertThat(batchStocks.getLargestTrades()).isEqualTo(largestTrades);
        assertThat(batchStocks.getLogo()).isEqualTo(logo);
        assertThat(batchStocks.getNews()).isEqualTo(news);
        assertThat(batchStocks.getOhlc()).isEqualTo(ohlc);
        assertThat(batchStocks.getOptions()).isEqualTo(options);
        assertThat(batchStocks.getPeers()).isEqualTo(peers);
        assertThat(batchStocks.getPrevious()).isEqualTo(previous);
        assertThat(batchStocks.getPrice()).isEqualTo(price);
        assertThat(batchStocks.getPriceTarget()).isEqualTo(priceTarget);
        assertThat(batchStocks.getQuote()).isEqualTo(quote);
        assertThat(batchStocks.getRecommendationTrends()).isEqualTo(recommendationTrends);
        assertThat(batchStocks.getSplits()).isEqualTo(splits);
        assertThat(batchStocks.getVolumeByVenue()).isEqualTo(volumeByVenue);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(BatchStocks.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BatchStocks.class))
                .verify();
    }

}
