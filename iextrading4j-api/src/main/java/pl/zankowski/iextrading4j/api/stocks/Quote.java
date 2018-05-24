package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "companyName", "primaryExchange", "sector", "calculationPrice",
        "open", "openTime", "close", "closeTime", "high", "low", "latestPrice", "latestSource", "latestTime",
        "latestUpdate", "latestVolume", "iexRealtimePrice", "iexRealtimeSize", "iexLastUpdated",
        "delayedPrice", "delayedPriceTime", "extendedPrice", "extendedChange", "extendedChangePercent",
        "extendedPriceTime", "previousClose", "change", "changePercent", "iexMarketPercent", "iexVolume",
        "avgTotalVolume", "iexBidPrice", "iexBidSize", "iexAskPrice", "iexAskSize", "marketCap", "peRatio",
        "week52High", "week52Low", "ytdChange"})
public class Quote implements Serializable {

    private final String symbol;
    private final String companyName;
    private final String primaryExchange;
    private final String sector;
    private final String calculationPrice;
    private final BigDecimal open;
    private final Long openTime;
    private final BigDecimal close;
    private final Long closeTime;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal latestPrice;
    private final String latestSource;
    private final String latestTime;
    private final Long latestUpdate;
    private final BigDecimal latestVolume;
    private final BigDecimal iexRealtimePrice;
    private final BigDecimal iexRealtimeSize;
    private final Long iexLastUpdated;
    private final BigDecimal delayedPrice;
    private final Long delayedPriceTime;
    private final BigDecimal extendedPrice;
    private final BigDecimal extendedChange;
    private final BigDecimal extendedChangePercent;
    private final Long extendedPriceTime;
    private final BigDecimal previousClose;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal iexMarketPercent;
    private final BigDecimal iexVolume;
    private final BigDecimal avgTotalVolume;
    private final BigDecimal iexBidPrice;
    private final BigDecimal iexBidSize;
    private final BigDecimal iexAskPrice;
    private final BigDecimal iexAskSize;
    private final BigDecimal marketCap;
    private final BigDecimal peRatio;
    private final BigDecimal week52High;
    private final BigDecimal week52Low;
    private final BigDecimal ytdChange;

    @JsonCreator
    public Quote(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("primaryExchange") final String primaryExchange,
            @JsonProperty("sector") final String sector,
            @JsonProperty("calculationPrice") final String calculationPrice,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("openTime") final Long openTime,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("closeTime") final Long closeTime,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("latestPrice") final BigDecimal latestPrice,
            @JsonProperty("latestSource") final String latestSource,
            @JsonProperty("latestTime") final String latestTime,
            @JsonProperty("latestUpdate") final Long latestUpdate,
            @JsonProperty("latestVolume") final BigDecimal latestVolume,
            @JsonProperty("iexRealtimePrice") final BigDecimal iexRealtimePrice,
            @JsonProperty("iexRealtimeSize") final BigDecimal iexRealtimeSize,
            @JsonProperty("iexLastUpdated") final Long iexLastUpdated,
            @JsonProperty("delayedPrice") final BigDecimal delayedPrice,
            @JsonProperty("delayedPriceTime") final Long delayedPriceTime,
            @JsonProperty("extendedPrice") final BigDecimal extendedPrice,
            @JsonProperty("extendedChange") final BigDecimal extendedChange,
            @JsonProperty("extendedChangePercent") final BigDecimal extendedChangePercent,
            @JsonProperty("extendedPriceTime") final Long extendedPriceTime,
            @JsonProperty("previousClose") final BigDecimal previousClose,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("iexMarketPercent") final BigDecimal iexMarketPercent,
            @JsonProperty("iexVolume") final BigDecimal iexVolume,
            @JsonProperty("avgTotalVolume") final BigDecimal avgTotalVolume,
            @JsonProperty("iexBidPrice") final BigDecimal iexBidPrice,
            @JsonProperty("iexBidSize") final BigDecimal iexBidSize,
            @JsonProperty("iexAskPrice") final BigDecimal iexAskPrice,
            @JsonProperty("iexAskSize") final BigDecimal iexAskSize,
            @JsonProperty("marketCap") final BigDecimal marketCap,
            @JsonProperty("peRatio") final BigDecimal peRatio,
            @JsonProperty("week52High") final BigDecimal week52High,
            @JsonProperty("week52Low") final BigDecimal week52Low,
            @JsonProperty("ytdChange") final BigDecimal ytdChange) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.primaryExchange = primaryExchange;
        this.sector = sector;
        this.calculationPrice = calculationPrice;
        this.open = open;
        this.openTime = openTime;
        this.close = close;
        this.closeTime = closeTime;
        this.high = high;
        this.low = low;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexLastUpdated = iexLastUpdated;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.extendedPrice = extendedPrice;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPriceTime = extendedPriceTime;
        this.previousClose = previousClose;
        this.change = change;
        this.changePercent = changePercent;
        this.iexMarketPercent = iexMarketPercent;
        this.iexVolume = iexVolume;
        this.avgTotalVolume = avgTotalVolume;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public String getSector() {
        return sector;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public BigDecimal getClose() {
        return close;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public Long getLatestUpdate() {
        return latestUpdate;
    }

    public BigDecimal getLatestVolume() {
        return latestVolume;
    }

    public BigDecimal getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public BigDecimal getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public Long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public BigDecimal getDelayedPrice() {
        return delayedPrice;
    }

    public Long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public BigDecimal getExtendedChange() {
        return extendedChange;
    }

    public BigDecimal getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public Long getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public BigDecimal getIexMarketPercent() {
        return iexMarketPercent;
    }

    public BigDecimal getIexVolume() {
        return iexVolume;
    }

    public BigDecimal getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public BigDecimal getIexBidPrice() {
        return iexBidPrice;
    }

    public BigDecimal getIexBidSize() {
        return iexBidSize;
    }

    public BigDecimal getIexAskPrice() {
        return iexAskPrice;
    }

    public BigDecimal getIexAskSize() {
        return iexAskSize;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public BigDecimal getWeek52High() {
        return week52High;
    }

    public BigDecimal getWeek52Low() {
        return week52Low;
    }

    public BigDecimal getYtdChange() {
        return ytdChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equal(symbol, quote.symbol) &&
                Objects.equal(companyName, quote.companyName) &&
                Objects.equal(primaryExchange, quote.primaryExchange) &&
                Objects.equal(sector, quote.sector) &&
                Objects.equal(calculationPrice, quote.calculationPrice) &&
                Objects.equal(open, quote.open) &&
                Objects.equal(openTime, quote.openTime) &&
                Objects.equal(close, quote.close) &&
                Objects.equal(closeTime, quote.closeTime) &&
                Objects.equal(high, quote.high) &&
                Objects.equal(low, quote.low) &&
                Objects.equal(latestPrice, quote.latestPrice) &&
                Objects.equal(latestSource, quote.latestSource) &&
                Objects.equal(latestTime, quote.latestTime) &&
                Objects.equal(latestUpdate, quote.latestUpdate) &&
                Objects.equal(latestVolume, quote.latestVolume) &&
                Objects.equal(iexRealtimePrice, quote.iexRealtimePrice) &&
                Objects.equal(iexRealtimeSize, quote.iexRealtimeSize) &&
                Objects.equal(iexLastUpdated, quote.iexLastUpdated) &&
                Objects.equal(delayedPrice, quote.delayedPrice) &&
                Objects.equal(delayedPriceTime, quote.delayedPriceTime) &&
                Objects.equal(extendedPrice, quote.extendedPrice) &&
                Objects.equal(extendedChange, quote.extendedChange) &&
                Objects.equal(extendedChangePercent, quote.extendedChangePercent) &&
                Objects.equal(extendedPriceTime, quote.extendedPriceTime) &&
                Objects.equal(previousClose, quote.previousClose) &&
                Objects.equal(change, quote.change) &&
                Objects.equal(changePercent, quote.changePercent) &&
                Objects.equal(iexMarketPercent, quote.iexMarketPercent) &&
                Objects.equal(iexVolume, quote.iexVolume) &&
                Objects.equal(avgTotalVolume, quote.avgTotalVolume) &&
                Objects.equal(iexBidPrice, quote.iexBidPrice) &&
                Objects.equal(iexBidSize, quote.iexBidSize) &&
                Objects.equal(iexAskPrice, quote.iexAskPrice) &&
                Objects.equal(iexAskSize, quote.iexAskSize) &&
                Objects.equal(marketCap, quote.marketCap) &&
                Objects.equal(peRatio, quote.peRatio) &&
                Objects.equal(week52High, quote.week52High) &&
                Objects.equal(week52Low, quote.week52Low) &&
                Objects.equal(ytdChange, quote.ytdChange);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, companyName, primaryExchange, sector, calculationPrice,
                open, openTime, close, closeTime, high, low, latestPrice, latestSource, latestTime,
                latestUpdate, latestVolume, iexRealtimePrice, iexRealtimeSize, iexLastUpdated, delayedPrice,
                delayedPriceTime, extendedPrice, extendedChange, extendedChangePercent, extendedPriceTime,
                previousClose, change, changePercent, iexMarketPercent, iexVolume, avgTotalVolume, iexBidPrice,
                iexBidSize, iexAskPrice, iexAskSize, marketCap, peRatio, week52High, week52Low, ytdChange);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("companyName", companyName)
                .add("primaryExchange", primaryExchange)
                .add("sector", sector)
                .add("calculationPrice", calculationPrice)
                .add("open", open)
                .add("openTime", openTime)
                .add("close", close)
                .add("closeTime", closeTime)
                .add("high", high)
                .add("low", low)
                .add("latestPrice", latestPrice)
                .add("latestSource", latestSource)
                .add("latestTime", latestTime)
                .add("latestUpdate", latestUpdate)
                .add("latestVolume", latestVolume)
                .add("iexRealtimePrice", iexRealtimePrice)
                .add("iexRealtimeSize", iexRealtimeSize)
                .add("iexLastUpdated", iexLastUpdated)
                .add("delayedPrice", delayedPrice)
                .add("delayedPriceTime", delayedPriceTime)
                .add("extendedPrice", extendedPrice)
                .add("extendedChange", extendedChange)
                .add("extendedChangePercent", extendedChangePercent)
                .add("extendedPriceTime", extendedPriceTime)
                .add("previousClose", previousClose)
                .add("change", change)
                .add("changePercent", changePercent)
                .add("iexMarketPercent", iexMarketPercent)
                .add("iexVolume", iexVolume)
                .add("avgTotalVolume", avgTotalVolume)
                .add("iexBidPrice", iexBidPrice)
                .add("iexBidSize", iexBidSize)
                .add("iexAskPrice", iexAskPrice)
                .add("iexAskSize", iexAskSize)
                .add("marketCap", marketCap)
                .add("peRatio", peRatio)
                .add("week52High", week52High)
                .add("week52Low", week52Low)
                .add("ytdChange", ytdChange)
                .toString();
    }
}
