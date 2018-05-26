package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"book", "chart", "company", "delayed-quote", "dividends", "earnings", "effective-spread",
        "financials", "threshold-securities", "short-interest", "stats", "largest-trades", "logo", "news", "ohlc",
        "peers", "previous", "price", "quote", "relevant", "splits", "volume-by-venue"})
public class BatchStocks implements Serializable {

    private final Book book;
    private final List<Chart> chart;
    private final Company company;
    private final DelayedQuote delayedQuote;
    private final List<Dividends> dividends;
    private final Earnings earnings;
    private final List<EffectiveSpread> effectiveSpread;
    private final Financials financials;
    private final List<ThresholdSecurities> thresholdSecurities;
    private final List<ShortInterest> shortInterest;
    private final KeyStats keyStats;
    private final List<LargestTrade> largestTrades;
    private final Logo logo;
    private final List<News> news;
    private final Ohlc ohlc;
    private final List<String> peers;
    private final BarData previous;
    private final BigDecimal price;
    private final Quote quote;
    private final Relevant relevant;
    private final List<Split> splits;
    private final List<VenueVolume> venueVolume;

    @JsonCreator
    public BatchStocks(
            @JsonProperty("book") final Book book,
            @JsonProperty("chart") final List<Chart> chart,
            @JsonProperty("company") final Company company,
            @JsonProperty("delayed-quote") final DelayedQuote delayedQuote,
            @JsonProperty("dividends") final List<Dividends> dividends,
            @JsonProperty("earnings") final Earnings earnings,
            @JsonProperty("effective-spread") final List<EffectiveSpread> effectiveSpread,
            @JsonProperty("financials") final Financials financials,
            @JsonProperty("threshold-securities") final List<ThresholdSecurities> thresholdSecurities,
            @JsonProperty("short-interest") final List<ShortInterest> shortInterest,
            @JsonProperty("stats") final KeyStats keyStats,
            @JsonProperty("largest-trades") final List<LargestTrade> largestTrades,
            @JsonProperty("logo") final Logo logo,
            @JsonProperty("news") final List<News> news,
            @JsonProperty("ohlc") final Ohlc ohlc,
            @JsonProperty("peers") final List<String> peers,
            @JsonProperty("previous") final BarData previous,
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("quote") final Quote quote,
            @JsonProperty("relevant") final Relevant relevant,
            @JsonProperty("splits") final List<Split> splits,
            @JsonProperty("volume-by-venue") final List<VenueVolume> venueVolume) {
        this.book = book;
        this.chart = immutableList(chart);
        this.company = company;
        this.delayedQuote = delayedQuote;
        this.dividends = immutableList(dividends);
        this.earnings = earnings;
        this.effectiveSpread = immutableList(effectiveSpread);
        this.financials = financials;
        this.thresholdSecurities = immutableList(thresholdSecurities);
        this.shortInterest = immutableList(shortInterest);
        this.keyStats = keyStats;
        this.largestTrades = immutableList(largestTrades);
        this.logo = logo;
        this.news = news;
        this.ohlc = ohlc;
        this.peers = immutableList(peers);
        this.previous = previous;
        this.price = price;
        this.quote = quote;
        this.relevant = relevant;
        this.splits = immutableList(splits);
        this.venueVolume = immutableList(venueVolume);
    }

    public Book getBook() {
        return book;
    }

    public List<Chart> getChart() {
        return chart;
    }

    public Company getCompany() {
        return company;
    }

    public DelayedQuote getDelayedQuote() {
        return delayedQuote;
    }

    public List<Dividends> getDividends() {
        return dividends;
    }

    public Earnings getEarnings() {
        return earnings;
    }

    public List<EffectiveSpread> getEffectiveSpread() {
        return effectiveSpread;
    }

    public Financials getFinancials() {
        return financials;
    }

    public List<ThresholdSecurities> getThresholdSecurities() {
        return thresholdSecurities;
    }

    public List<ShortInterest> getShortInterest() {
        return shortInterest;
    }

    public KeyStats getKeyStats() {
        return keyStats;
    }

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

    public List<String> getPeers() {
        return peers;
    }

    public BarData getPrevious() {
        return previous;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Quote getQuote() {
        return quote;
    }

    public Relevant getRelevant() {
        return relevant;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public List<VenueVolume> getVenueVolume() {
        return venueVolume;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BatchStocks that = (BatchStocks) o;
        return Objects.equal(book, that.book) &&
                Objects.equal(chart, that.chart) &&
                Objects.equal(company, that.company) &&
                Objects.equal(delayedQuote, that.delayedQuote) &&
                Objects.equal(dividends, that.dividends) &&
                Objects.equal(earnings, that.earnings) &&
                Objects.equal(effectiveSpread, that.effectiveSpread) &&
                Objects.equal(financials, that.financials) &&
                Objects.equal(thresholdSecurities, that.thresholdSecurities) &&
                Objects.equal(shortInterest, that.shortInterest) &&
                Objects.equal(keyStats, that.keyStats) &&
                Objects.equal(largestTrades, that.largestTrades) &&
                Objects.equal(logo, that.logo) &&
                Objects.equal(news, that.news) &&
                Objects.equal(ohlc, that.ohlc) &&
                Objects.equal(peers, that.peers) &&
                Objects.equal(previous, that.previous) &&
                Objects.equal(price, that.price) &&
                Objects.equal(quote, that.quote) &&
                Objects.equal(relevant, that.relevant) &&
                Objects.equal(splits, that.splits) &&
                Objects.equal(venueVolume, that.venueVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(book, chart, company, delayedQuote, dividends, earnings, effectiveSpread,
                financials, thresholdSecurities, shortInterest, keyStats, largestTrades, logo, news, ohlc,
                peers, previous, price, quote, relevant, splits, venueVolume);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("book", book)
                .add("chart", chart)
                .add("company", company)
                .add("delayedQuote", delayedQuote)
                .add("dividends", dividends)
                .add("earnings", earnings)
                .add("effectiveSpread", effectiveSpread)
                .add("financials", financials)
                .add("thresholdSecurities", thresholdSecurities)
                .add("shortInterest", shortInterest)
                .add("keyStats", keyStats)
                .add("largestTrades", largestTrades)
                .add("logo", logo)
                .add("news", news)
                .add("ohlc", ohlc)
                .add("peers", peers)
                .add("previous", previous)
                .add("price", price)
                .add("quote", quote)
                .add("relevant", relevant)
                .add("splits", splits)
                .add("venueVolume", venueVolume)
                .toString();
    }
}
