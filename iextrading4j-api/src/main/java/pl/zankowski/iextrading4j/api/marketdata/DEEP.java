package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol", "marketPercent", "volume", "lastSalePrice", "lastSaleSize",
        "lastSaleTime", "bids", "asks", "systemEvent", "tradingStatus", "opHaltStatus",
        "ssrStatus", "securityEvent", "trades", "tradeBreaks", "auction", "officialPrice"})
public class DEEP implements Serializable {

    private final String symbol;
    private final BigDecimal marketPercent;
    private final BigDecimal volume;
    private final BigDecimal lastSalePrice;
    private final BigDecimal lastSaleSize;
    private final Long lastSaleTime;
    private final Long lastUpdated;
    private final List<BookEntry> bids;
    private final List<BookEntry> asks;
    private final SystemEvent systemEvent;
    private final TradingStatus tradingStatus;
    private final OpHaltStatus opHaltStatus;
    private final SsrStatus ssrStatus;
    private final SecurityEvent securityEvent;
    private final List<Trade> trades;
    private final List<Trade> tradeBreaks;
    private final Auction auction;
    private final OfficialPrice officialPrice;

    @JsonCreator
    public DEEP(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("marketPercent") final BigDecimal marketPercent,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("lastSalePrice") final BigDecimal lastSalePrice,
            @JsonProperty("lastSaleSize") final BigDecimal lastSaleSize,
            @JsonProperty("lastSaleTime") final Long lastSaleTime,
            @JsonProperty("lastUpdated") final Long lastUpdated,
            @JsonProperty("bids") final List<BookEntry> bids,
            @JsonProperty("asks") final List<BookEntry> asks,
            @JsonProperty("systemEvent") final SystemEvent systemEvent,
            @JsonProperty("tradingStatus") final TradingStatus tradingStatus,
            @JsonProperty("opHaltStatus") final OpHaltStatus opHaltStatus,
            @JsonProperty("ssrStatus") final SsrStatus ssrStatus,
            @JsonProperty("securityEvent") final SecurityEvent securityEvent,
            @JsonProperty("trades") final List<Trade> trades,
            @JsonProperty("tradeBreaks") final List<Trade> tradeBreaks,
            @JsonProperty("auction") final Auction auction,
            @JsonProperty("officialPrice") final OfficialPrice officialPrice) {
        this.symbol = symbol;
        this.marketPercent = marketPercent;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
        this.bids = immutableList(bids);
        this.asks = immutableList(asks);
        this.systemEvent = systemEvent;
        this.tradingStatus = tradingStatus;
        this.opHaltStatus = opHaltStatus;
        this.ssrStatus = ssrStatus;
        this.securityEvent = securityEvent;
        this.trades = immutableList(trades);
        this.tradeBreaks = immutableList(tradeBreaks);
        this.auction = auction;
        this.officialPrice = officialPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getMarketPercent() {
        return marketPercent;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getLastSalePrice() {
        return lastSalePrice;
    }

    public BigDecimal getLastSaleSize() {
        return lastSaleSize;
    }

    public Long getLastSaleTime() {
        return lastSaleTime;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public List<BookEntry> getBids() {
        return bids;
    }

    public List<BookEntry> getAsks() {
        return asks;
    }

    public SystemEvent getSystemEvent() {
        return systemEvent;
    }

    public TradingStatus getTradingStatus() {
        return tradingStatus;
    }

    public OpHaltStatus getOpHaltStatus() {
        return opHaltStatus;
    }

    public SsrStatus getSsrStatus() {
        return ssrStatus;
    }

    public SecurityEvent getSecurityEvent() {
        return securityEvent;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public List<Trade> getTradeBreaks() {
        return tradeBreaks;
    }

    public Auction getAuction() {
        return auction;
    }

    public OfficialPrice getOfficialPrice() {
        return officialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DEEP deep = (DEEP) o;
        return Objects.equal(symbol, deep.symbol) &&
                Objects.equal(marketPercent, deep.marketPercent) &&
                Objects.equal(volume, deep.volume) &&
                Objects.equal(lastSalePrice, deep.lastSalePrice) &&
                Objects.equal(lastSaleSize, deep.lastSaleSize) &&
                Objects.equal(lastSaleTime, deep.lastSaleTime) &&
                Objects.equal(lastUpdated, deep.lastUpdated) &&
                Objects.equal(bids, deep.bids) &&
                Objects.equal(asks, deep.asks) &&
                Objects.equal(systemEvent, deep.systemEvent) &&
                Objects.equal(tradingStatus, deep.tradingStatus) &&
                Objects.equal(opHaltStatus, deep.opHaltStatus) &&
                Objects.equal(ssrStatus, deep.ssrStatus) &&
                Objects.equal(securityEvent, deep.securityEvent) &&
                Objects.equal(trades, deep.trades) &&
                Objects.equal(tradeBreaks, deep.tradeBreaks) &&
                Objects.equal(auction, deep.auction) &&
                Objects.equal(officialPrice, deep.officialPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, marketPercent, volume, lastSalePrice, lastSaleSize,
                lastSaleTime, lastUpdated, bids, asks, systemEvent, tradingStatus, opHaltStatus,
                ssrStatus, securityEvent, trades, tradeBreaks, auction, officialPrice);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("marketPercent", marketPercent)
                .add("volume", volume)
                .add("lastSalePrice", lastSalePrice)
                .add("lastSaleSize", lastSaleSize)
                .add("lastSaleTime", lastSaleTime)
                .add("lastUpdated", lastUpdated)
                .add("bids", bids)
                .add("asks", asks)
                .add("systemEvent", systemEvent)
                .add("tradingStatus", tradingStatus)
                .add("opHaltStatus", opHaltStatus)
                .add("ssrStatus", ssrStatus)
                .add("securityEvent", securityEvent)
                .add("trades", trades)
                .add("tradeBreaks", tradeBreaks)
                .add("auction", auction)
                .add("officialPrice", officialPrice)
                .toString();
    }
}
