package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

@JsonPropertyOrder({"symbol", "companyName", "primaryExchange", "sector", "calculationPrice",
        "open", "openTime", "openSource", "close", "closeTime", "closeSource", "high", "highTime", "highSource",
        "low", "lowTime", "lowSource", "latestPrice", "latestSource", "latestTime",
        "latestUpdate", "latestVolume", "iexRealtimePrice", "iexRealtimeSize", "iexLastUpdated",
        "delayedPrice", "delayedPriceTime", "extendedPrice", "extendedChange", "extendedChangePercent",
        "extendedPriceTime", "previousClose", "change", "changePercent", "iexMarketPercent", "iexVolume",
        "avgTotalVolume", "iexBidPrice", "iexBidSize", "iexAskPrice", "iexAskSize", "iexOpen", "iexOpenTime",
        "iexClose", "iexCloseTime", "marketCap", "peRatio", "week52High", "week52Low", "ytdChange", "bidPrice",
        "bidSize", "askPrice", "askSize", "lastTradeTime", "isUSMarketOpen", "oddLotDelayedPrice",
        "oddLotDelayedPriceTime"})
public class Quote implements Serializable {

    private static final long serialVersionUID = 6474500411156050266L;

    private final String symbol;
    private final String companyName;
    private final String primaryExchange;
    private final String sector;
    private final String calculationPrice;
    private final BigDecimal open;
    private final Long openTime;
    private final String openSource;
    private final BigDecimal close;
    private final Long closeTime;
    private final String closeSource;
    private final BigDecimal high;
    private final Long highTime;
    private final String highSource;
    private final BigDecimal low;
    private final Long lowTime;
    private final String lowSource;
    private final BigDecimal volume;
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
    private final BigDecimal previousVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal iexMarketPercent;
    private final BigDecimal iexVolume;
    private final BigDecimal avgTotalVolume;
    private final BigDecimal iexBidPrice;
    private final BigDecimal iexBidSize;
    private final BigDecimal iexAskPrice;
    private final BigDecimal iexAskSize;
    private final BigDecimal iexOpen;
    private final Long iexOpenTime;
    private final BigDecimal iexClose;
    private final Long iexCloseTime;
    private final BigDecimal marketCap;
    private final BigDecimal peRatio;
    private final BigDecimal week52High;
    private final BigDecimal week52Low;
    private final BigDecimal ytdChange;
    private final BigDecimal bidPrice;
    private final BigDecimal bidSize;
    private final BigDecimal askPrice;
    private final BigDecimal askSize;
    private final Long lastTradeTime;
    private final Boolean isUSMarketOpen;
    private final BigDecimal oddLotDelayedPrice;
    private final Long oddLotDelayedPriceTime;

    @JsonCreator
    public Quote(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("primaryExchange") final String primaryExchange,
            @JsonProperty("sector") final String sector,
            @JsonProperty("calculationPrice") final String calculationPrice,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("openTime") final Long openTime,
            @JsonProperty("openSource") final String openSource,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("closeTime") final Long closeTime,
            @JsonProperty("closeSource") final String closeSource,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("highTime") final Long highTime,
            @JsonProperty("highSource") final String highSource,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("lowTime") final Long lowTime,
            @JsonProperty("lowSource") final String lowSource,
            @JsonProperty("volume") final BigDecimal volume,
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
            @JsonProperty("previousVolume") final BigDecimal previousVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("iexMarketPercent") final BigDecimal iexMarketPercent,
            @JsonProperty("iexVolume") final BigDecimal iexVolume,
            @JsonProperty("avgTotalVolume") final BigDecimal avgTotalVolume,
            @JsonProperty("iexBidPrice") final BigDecimal iexBidPrice,
            @JsonProperty("iexBidSize") final BigDecimal iexBidSize,
            @JsonProperty("iexAskPrice") final BigDecimal iexAskPrice,
            @JsonProperty("iexAskSize") final BigDecimal iexAskSize,
            @JsonProperty("iexOpen") final BigDecimal iexOpen,
            @JsonProperty("iexOpenTime") final Long iexOpenTime,
            @JsonProperty("iexClose") final BigDecimal iexClose,
            @JsonProperty("iexCloseTime") final Long iexCloseTime,
            @JsonProperty("marketCap") final BigDecimal marketCap,
            @JsonProperty("peRatio") final BigDecimal peRatio,
            @JsonProperty("week52High") final BigDecimal week52High,
            @JsonProperty("week52Low") final BigDecimal week52Low,
            @JsonProperty("ytdChange") final BigDecimal ytdChange,
            @JsonProperty("bidPrice") final BigDecimal bidPrice,
            @JsonProperty("bidSize") final BigDecimal bidSize,
            @JsonProperty("askPrice") final BigDecimal askPrice,
            @JsonProperty("askSize") final BigDecimal askSize,
            @JsonProperty("lastTradeTime") final Long lastTradeTime,
            @JsonProperty("isUSMarketOpen") final Boolean isUSMarketOpen,
            @JsonProperty("oddLotDelayedPrice") final BigDecimal oddLotDelayedPrice,
            @JsonProperty("oddLotDelayedPriceTime") final Long oddLotDelayedPriceTime) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.primaryExchange = primaryExchange;
        this.sector = sector;
        this.calculationPrice = calculationPrice;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.close = close;
        this.closeTime = closeTime;
        this.closeSource = closeSource;
        this.high = high;
        this.highTime = highTime;
        this.highSource = highSource;
        this.low = low;
        this.lowTime = lowTime;
        this.lowSource = lowSource;
        this.volume = volume;
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
        this.previousVolume = previousVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.iexMarketPercent = iexMarketPercent;
        this.iexVolume = iexVolume;
        this.avgTotalVolume = avgTotalVolume;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
        this.lastTradeTime = lastTradeTime;
        this.isUSMarketOpen = isUSMarketOpen;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
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

    public String getOpenSource() {
        return openSource;
    }

    public BigDecimal getClose() {
        return close;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public String getCloseSource() {
        return closeSource;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public Long getHighTime() {
        return highTime;
    }

    public String getHighSource() {
        return highSource;
    }

    public BigDecimal getLow() {
        return low;
    }

    public Long getLowTime() {
        return lowTime;
    }

    public String getLowSource() {
        return lowSource;
    }

    public BigDecimal getVolume() {
        return volume;
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

    public BigDecimal getPreviousVolume() {
        return previousVolume;
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

    public BigDecimal getIexOpen() {
        return iexOpen;
    }

    public Long getIexOpenTime() {
        return iexOpenTime;
    }

    public BigDecimal getIexClose() {
        return iexClose;
    }

    public Long getIexCloseTime() {
        return iexCloseTime;
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

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public BigDecimal getBidSize() {
        return bidSize;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public BigDecimal getAskSize() {
        return askSize;
    }

    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    @JsonProperty("isUSMarketOpen")
    public Boolean isUSMarketOpen() {
        return isUSMarketOpen;
    }

    public BigDecimal getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    public Long getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(symbol, quote.symbol) &&
                Objects.equals(companyName, quote.companyName) &&
                Objects.equals(primaryExchange, quote.primaryExchange) &&
                Objects.equals(sector, quote.sector) &&
                Objects.equals(calculationPrice, quote.calculationPrice) &&
                Objects.equals(open, quote.open) &&
                Objects.equals(openTime, quote.openTime) &&
                Objects.equals(openSource, quote.openSource) &&
                Objects.equals(close, quote.close) &&
                Objects.equals(closeTime, quote.closeTime) &&
                Objects.equals(closeSource, quote.closeSource) &&
                Objects.equals(high, quote.high) &&
                Objects.equals(highTime, quote.highTime) &&
                Objects.equals(highSource, quote.highSource) &&
                Objects.equals(low, quote.low) &&
                Objects.equals(lowTime, quote.lowTime) &&
                Objects.equals(lowSource, quote.lowSource) &&
                Objects.equals(volume, quote.volume) &&
                Objects.equals(latestPrice, quote.latestPrice) &&
                Objects.equals(latestSource, quote.latestSource) &&
                Objects.equals(latestTime, quote.latestTime) &&
                Objects.equals(latestUpdate, quote.latestUpdate) &&
                Objects.equals(latestVolume, quote.latestVolume) &&
                Objects.equals(iexRealtimePrice, quote.iexRealtimePrice) &&
                Objects.equals(iexRealtimeSize, quote.iexRealtimeSize) &&
                Objects.equals(iexLastUpdated, quote.iexLastUpdated) &&
                Objects.equals(delayedPrice, quote.delayedPrice) &&
                Objects.equals(delayedPriceTime, quote.delayedPriceTime) &&
                Objects.equals(extendedPrice, quote.extendedPrice) &&
                Objects.equals(extendedChange, quote.extendedChange) &&
                Objects.equals(extendedChangePercent, quote.extendedChangePercent) &&
                Objects.equals(extendedPriceTime, quote.extendedPriceTime) &&
                Objects.equals(previousClose, quote.previousClose) &&
                Objects.equals(previousVolume, quote.previousVolume) &&
                Objects.equals(change, quote.change) &&
                Objects.equals(changePercent, quote.changePercent) &&
                Objects.equals(iexMarketPercent, quote.iexMarketPercent) &&
                Objects.equals(iexVolume, quote.iexVolume) &&
                Objects.equals(avgTotalVolume, quote.avgTotalVolume) &&
                Objects.equals(iexBidPrice, quote.iexBidPrice) &&
                Objects.equals(iexBidSize, quote.iexBidSize) &&
                Objects.equals(iexAskPrice, quote.iexAskPrice) &&
                Objects.equals(iexAskSize, quote.iexAskSize) &&
                Objects.equals(iexOpen, quote.iexOpen) &&
                Objects.equals(iexOpenTime, quote.iexOpenTime) &&
                Objects.equals(iexClose, quote.iexClose) &&
                Objects.equals(iexCloseTime, quote.iexCloseTime) &&
                Objects.equals(marketCap, quote.marketCap) &&
                Objects.equals(peRatio, quote.peRatio) &&
                Objects.equals(week52High, quote.week52High) &&
                Objects.equals(week52Low, quote.week52Low) &&
                Objects.equals(ytdChange, quote.ytdChange) &&
                Objects.equals(bidPrice, quote.bidPrice) &&
                Objects.equals(bidSize, quote.bidSize) &&
                Objects.equals(askPrice, quote.askPrice) &&
                Objects.equals(askSize, quote.askSize) &&
                Objects.equals(lastTradeTime, quote.lastTradeTime) &&
                Objects.equals(isUSMarketOpen, quote.isUSMarketOpen) &&
                Objects.equals(oddLotDelayedPrice, quote.oddLotDelayedPrice) &&
                Objects.equals(oddLotDelayedPriceTime, quote.oddLotDelayedPriceTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, companyName, primaryExchange, sector, calculationPrice, open, openTime,
                openSource, close, closeTime, closeSource, high, highTime, highSource, low, lowTime, lowSource,
                volume, latestPrice, latestSource, latestTime, latestUpdate, latestVolume, iexRealtimePrice,
                iexRealtimeSize, iexLastUpdated, delayedPrice, delayedPriceTime, extendedPrice, extendedChange,
                extendedChangePercent, extendedPriceTime, previousClose, previousVolume, change, changePercent,
                iexMarketPercent, iexVolume, avgTotalVolume, iexBidPrice, iexBidSize, iexAskPrice, iexAskSize,
                iexOpen, iexOpenTime, iexClose, iexCloseTime, marketCap, peRatio, week52High, week52Low, ytdChange,
                bidPrice, bidSize, askPrice, askSize, lastTradeTime, isUSMarketOpen, oddLotDelayedPrice,
                oddLotDelayedPriceTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Quote.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("companyName='" + companyName + "'")
                .add("primaryExchange='" + primaryExchange + "'")
                .add("sector='" + sector + "'")
                .add("calculationPrice='" + calculationPrice + "'")
                .add("open=" + open)
                .add("openTime=" + openTime)
                .add("openSource='" + openSource + "'")
                .add("close=" + close)
                .add("closeTime=" + closeTime)
                .add("closeSource='" + closeSource + "'")
                .add("high=" + high)
                .add("highTime=" + highTime)
                .add("highSource='" + highSource + "'")
                .add("low=" + low)
                .add("lowTime=" + lowTime)
                .add("lowSource='" + lowSource + "'")
                .add("volume=" + volume)
                .add("latestPrice=" + latestPrice)
                .add("latestSource='" + latestSource + "'")
                .add("latestTime='" + latestTime + "'")
                .add("latestUpdate=" + latestUpdate)
                .add("latestVolume=" + latestVolume)
                .add("iexRealtimePrice=" + iexRealtimePrice)
                .add("iexRealtimeSize=" + iexRealtimeSize)
                .add("iexLastUpdated=" + iexLastUpdated)
                .add("delayedPrice=" + delayedPrice)
                .add("delayedPriceTime=" + delayedPriceTime)
                .add("extendedPrice=" + extendedPrice)
                .add("extendedChange=" + extendedChange)
                .add("extendedChangePercent=" + extendedChangePercent)
                .add("extendedPriceTime=" + extendedPriceTime)
                .add("previousClose=" + previousClose)
                .add("previousVolume=" + previousVolume)
                .add("change=" + change)
                .add("changePercent=" + changePercent)
                .add("iexMarketPercent=" + iexMarketPercent)
                .add("iexVolume=" + iexVolume)
                .add("avgTotalVolume=" + avgTotalVolume)
                .add("iexBidPrice=" + iexBidPrice)
                .add("iexBidSize=" + iexBidSize)
                .add("iexAskPrice=" + iexAskPrice)
                .add("iexAskSize=" + iexAskSize)
                .add("iexOpen=" + iexOpen)
                .add("iexOpenTime=" + iexOpenTime)
                .add("iexClose=" + iexClose)
                .add("iexCloseTime=" + iexCloseTime)
                .add("marketCap=" + marketCap)
                .add("peRatio=" + peRatio)
                .add("week52High=" + week52High)
                .add("week52Low=" + week52Low)
                .add("ytdChange=" + ytdChange)
                .add("bidPrice=" + bidPrice)
                .add("bidSize=" + bidSize)
                .add("askPrice=" + askPrice)
                .add("askSize=" + askSize)
                .add("lastTradeTime=" + lastTradeTime)
                .add("isUSMarketOpen=" + isUSMarketOpen)
                .add("oddLotDelayedPrice=" + oddLotDelayedPrice)
                .add("oddLotDelayedPriceTime=" + oddLotDelayedPriceTime)
                .toString();
    }
}
