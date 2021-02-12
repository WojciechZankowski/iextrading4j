package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class BatchStocks implements Serializable {

    private static final long serialVersionUID = -1000412562192933682L;

    private final AdvancedStats advancedStats;
    private final BalanceSheets balanceSheets;
    private final Book book;
    private final CashFlows cashFlows;
    private final List<Chart> chart;
    private final Company company;
    private final DelayedQuote delayedQuote;
    private final List<Dividends> dividends;
    private final Earnings earnings;
    private final TodayEarnings earningsToday;
    private final Estimates estimates;
    private final Financials financials;
    private final List<FundOwnership> fundOwnership;
    private final IncomeStatements incomeStatements;
    private final List<InsiderRoster> insiderRoster;
    private final List<InsiderSummary> insiderSummary;
    private final List<InsiderTransaction> insiderTransaction;
    private final List<Ownership> institutionalOwnership;
    private final List<Intraday> intradayPrices;
    private final KeyStats keyStats;
    private final List<LargestTrade> largestTrades;
    private final Logo logo;
    private final List<News> news;
    private final Ohlc ohlc;
    private final List<String> options;
    private final List<String> peers;
    private final BarData previous;
    private final BigDecimal price;
    private final PriceTarget priceTarget;
    private final Quote quote;
    private final List<RecommendationTrends> recommendationTrends;
    private final List<Split> splits;
    private final List<VenueVolume> volumeByVenue;

    @JsonCreator
    public BatchStocks(
            @JsonProperty("advanced-stats") final AdvancedStats advancedStats,
            @JsonProperty("balance-sheet") final BalanceSheets balanceSheets,
            @JsonProperty("book") final Book book,
            @JsonProperty("cash-flow") final CashFlows cashFlows,
            @JsonProperty("chart") final List<Chart> chart,
            @JsonProperty("company") final Company company,
            @JsonProperty("delayed-quote") final DelayedQuote delayedQuote,
            @JsonProperty("dividends") final List<Dividends> dividends,
            @JsonProperty("earnings") final Earnings earnings,
            @JsonProperty("today-earnings") final TodayEarnings earningsToday,
            @JsonProperty("estimates") final Estimates estimates,
            @JsonProperty("financials") final Financials financials,
            @JsonProperty("fund-ownership") final List<FundOwnership> fundOwnership,
            @JsonProperty("income") final IncomeStatements incomeStatements,
            @JsonProperty("insider-roster") final List<InsiderRoster> insiderRoster,
            @JsonProperty("insider-summary") final List<InsiderSummary> insiderSummary,
            @JsonProperty("insider-transactions") final List<InsiderTransaction> insiderTransaction,
            @JsonProperty("institutional-ownership") final List<Ownership> institutionalOwnership,
            @JsonProperty("intraday-prices") final List<Intraday> intradayPrices,
            @JsonProperty("stats") final KeyStats keyStats,
            @JsonProperty("largest-trades") final List<LargestTrade> largestTrades,
            @JsonProperty("logo") final Logo logo,
            @JsonProperty("news") final List<News> news,
            @JsonProperty("ohlc") final Ohlc ohlc,
            @JsonProperty("options") final List<String> options,
            @JsonProperty("peers") final List<String> peers,
            @JsonProperty("previous") final BarData previous,
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("price-target") final PriceTarget priceTarget,
            @JsonProperty("quote") final Quote quote,
            @JsonProperty("recommendation-trends") final List<RecommendationTrends> recommendationTrends,
            @JsonProperty("splits") final List<Split> splits,
            @JsonProperty("volume-by-venue") final List<VenueVolume> volumeByVenue) {
        this.advancedStats = advancedStats;
        this.balanceSheets = balanceSheets;
        this.book = book;
        this.cashFlows = cashFlows;
        this.chart = immutableList(chart);
        this.company = company;
        this.delayedQuote = delayedQuote;
        this.dividends = immutableList(dividends);
        this.earnings = earnings;
        this.earningsToday = earningsToday;
        this.estimates = estimates;
        this.financials = financials;
        this.fundOwnership = immutableList(fundOwnership);
        this.incomeStatements = incomeStatements;
        this.insiderRoster = immutableList(insiderRoster);
        this.insiderSummary = immutableList(insiderSummary);
        this.insiderTransaction = immutableList(insiderTransaction);
        this.institutionalOwnership = immutableList(institutionalOwnership);
        this.intradayPrices = immutableList(intradayPrices);
        this.keyStats = keyStats;
        this.largestTrades = immutableList(largestTrades);
        this.logo = logo;
        this.news = immutableList(news);
        this.ohlc = ohlc;
        this.options = immutableList(options);
        this.peers = immutableList(peers);
        this.previous = previous;
        this.price = price;
        this.priceTarget = priceTarget;
        this.quote = quote;
        this.recommendationTrends = immutableList(recommendationTrends);
        this.splits = immutableList(splits);
        this.volumeByVenue = immutableList(volumeByVenue);
    }

    @JsonProperty("advanced-stats")
    public AdvancedStats getAdvancedStats() {
        return advancedStats;
    }

    @JsonProperty("balance-sheet")
    public BalanceSheets getBalanceSheets() {
        return balanceSheets;
    }

    public Book getBook() {
        return book;
    }

    @JsonProperty("cash-flow")
    public CashFlows getCashFlows() {
        return cashFlows;
    }

    public List<Chart> getChart() {
        return chart;
    }

    public Company getCompany() {
        return company;
    }

    @JsonProperty("delayed-quote")
    public DelayedQuote getDelayedQuote() {
        return delayedQuote;
    }

    public List<Dividends> getDividends() {
        return dividends;
    }

    public Earnings getEarnings() {
        return earnings;
    }

    @JsonProperty("today-earnings")
    public TodayEarnings getEarningsToday() {
        return earningsToday;
    }

    public Estimates getEstimates() {
        return estimates;
    }

    public Financials getFinancials() {
        return financials;
    }

    @JsonProperty("fund-ownership")
    public List<FundOwnership> getFundOwnership() {
        return fundOwnership;
    }

    @JsonProperty("income")
    public IncomeStatements getIncomeStatements() {
        return incomeStatements;
    }

    @JsonProperty("insider-roster")
    public List<InsiderRoster> getInsiderRoster() {
        return insiderRoster;
    }

    @JsonProperty("insider-summary")
    public List<InsiderSummary> getInsiderSummary() {
        return insiderSummary;
    }

    @JsonProperty("insider-transactions")
    public List<InsiderTransaction> getInsiderTransaction() {
        return insiderTransaction;
    }

    @JsonProperty("institutional-ownership")
    public List<Ownership> getInstitutionalOwnership() {
        return institutionalOwnership;
    }

    @JsonProperty("intraday-prices")
    public List<Intraday> getIntradayPrices() {
        return intradayPrices;
    }

    @JsonProperty("stats")
    public KeyStats getKeyStats() {
        return keyStats;
    }

    @JsonProperty("largest-trades")
    public List<LargestTrade> getLargestTrades() {
        return largestTrades;
    }

    public Logo getLogo() {
        return logo;
    }

    public List<News> getNews() {
        return news;
    }

    public Ohlc getOhlc() {
        return ohlc;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<String> getPeers() {
        return peers;
    }

    public BarData getPrevious() {
        return previous;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PriceTarget getPriceTarget() {
        return priceTarget;
    }

    public Quote getQuote() {
        return quote;
    }

    @JsonProperty("recommendation-trends")
    public List<RecommendationTrends> getRecommendationTrends() {
        return recommendationTrends;
    }

    public List<Split> getSplits() {
        return splits;
    }

    @JsonProperty("volume-by-venue")
    public List<VenueVolume> getVolumeByVenue() {
        return volumeByVenue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BatchStocks that = (BatchStocks) o;
        return Objects.equal(advancedStats, that.advancedStats) &&
                Objects.equal(balanceSheets, that.balanceSheets) &&
                Objects.equal(book, that.book) &&
                Objects.equal(cashFlows, that.cashFlows) &&
                Objects.equal(chart, that.chart) &&
                Objects.equal(company, that.company) &&
                Objects.equal(delayedQuote, that.delayedQuote) &&
                Objects.equal(dividends, that.dividends) &&
                Objects.equal(earnings, that.earnings) &&
                Objects.equal(earningsToday, that.earningsToday) &&
                Objects.equal(estimates, that.estimates) &&
                Objects.equal(financials, that.financials) &&
                Objects.equal(fundOwnership, that.fundOwnership) &&
                Objects.equal(incomeStatements, that.incomeStatements) &&
                Objects.equal(insiderRoster, that.insiderRoster) &&
                Objects.equal(insiderSummary, that.insiderSummary) &&
                Objects.equal(insiderTransaction, that.insiderTransaction) &&
                Objects.equal(institutionalOwnership, that.institutionalOwnership) &&
                Objects.equal(intradayPrices, that.intradayPrices) &&
                Objects.equal(keyStats, that.keyStats) &&
                Objects.equal(largestTrades, that.largestTrades) &&
                Objects.equal(logo, that.logo) &&
                Objects.equal(news, that.news) &&
                Objects.equal(ohlc, that.ohlc) &&
                Objects.equal(options, that.options) &&
                Objects.equal(peers, that.peers) &&
                Objects.equal(previous, that.previous) &&
                Objects.equal(price, that.price) &&
                Objects.equal(priceTarget, that.priceTarget) &&
                Objects.equal(quote, that.quote) &&
                Objects.equal(recommendationTrends, that.recommendationTrends) &&
                Objects.equal(splits, that.splits) &&
                Objects.equal(volumeByVenue, that.volumeByVenue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(advancedStats, balanceSheets, book, cashFlows, chart, company,
                delayedQuote, dividends, earnings, earningsToday, estimates, financials, fundOwnership,
                incomeStatements, insiderRoster, insiderSummary, insiderTransaction, institutionalOwnership,
                intradayPrices, keyStats, largestTrades, logo, news, ohlc, options, peers, previous,
                price, priceTarget, quote, recommendationTrends, splits, volumeByVenue);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("advancedStats", advancedStats)
                .add("balanceSheets", balanceSheets)
                .add("book", book)
                .add("cashFlows", cashFlows)
                .add("chart", chart)
                .add("company", company)
                .add("delayedQuote", delayedQuote)
                .add("dividends", dividends)
                .add("earnings", earnings)
                .add("earningsToday", earningsToday)
                .add("estimates", estimates)
                .add("financials", financials)
                .add("fundOwnership", fundOwnership)
                .add("incomeStatements", incomeStatements)
                .add("insiderRoster", insiderRoster)
                .add("insiderSummary", insiderSummary)
                .add("insiderTransaction", insiderTransaction)
                .add("institutionalOwnership", institutionalOwnership)
                .add("intradayPrices", intradayPrices)
                .add("keyStats", keyStats)
                .add("largestTrades", largestTrades)
                .add("logo", logo)
                .add("news", news)
                .add("ohlc", ohlc)
                .add("options", options)
                .add("peers", peers)
                .add("previous", previous)
                .add("price", price)
                .add("priceTarget", priceTarget)
                .add("quote", quote)
                .add("recommendationTrends", recommendationTrends)
                .add("splits", splits)
                .add("volumeByVenue", volumeByVenue)
                .toString();
    }

}
