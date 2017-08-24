package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class DEEP {

    private final String symbol;
    private final double marketPercent;
    private final long volume;
    private final double lastSalePrice;
    private final int lastSaleSize;
    private final long lastSaleTime;
    private final long lastUpdated;
    private final Quote[] bids;
    private final Quote[] asks;
    private final SystemEvent systemEvent;
    private final TradingStatus tradingStatus;
    private final OpHaltStatus opHaltStatus;
    private final SsrStatus ssrStatus;
    private final SecurityEvent securityEvent;
    private final Trade[] trades;
    private final Trade[] tradeBreaks;

    @JsonCreator
    public DEEP(@JsonProperty("symbol") String symbol,
                @JsonProperty("marketPercent") double marketPercent,
                @JsonProperty("volume") long volume,
                @JsonProperty("lastSalePrice") double lastSalePrice,
                @JsonProperty("lastSaleSize") int lastSaleSize,
                @JsonProperty("lastSaleTime") long lastSaleTime,
                @JsonProperty("lastUpdated") long lastUpdated,
                @JsonProperty("bids") Quote[] bids,
                @JsonProperty("asks") Quote[] asks,
                @JsonProperty("systemEvent") SystemEvent systemEvent,
                @JsonProperty("tradingStatus") TradingStatus tradingStatus,
                @JsonProperty("opHaltStatus") OpHaltStatus opHaltStatus,
                @JsonProperty("ssrStatus") SsrStatus ssrStatus,
                @JsonProperty("securityEvent") SecurityEvent securityEvent,
                @JsonProperty("trades") Trade[] trades,
                @JsonProperty("tradeBreaks") Trade[] tradeBreaks) {
        this.symbol = symbol;
        this.marketPercent = marketPercent;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
        this.bids = bids;
        this.asks = asks;
        this.systemEvent = systemEvent;
        this.tradingStatus = tradingStatus;
        this.opHaltStatus = opHaltStatus;
        this.ssrStatus = ssrStatus;
        this.securityEvent = securityEvent;
        this.trades = trades;
        this.tradeBreaks = tradeBreaks;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMarketPercent() {
        return marketPercent;
    }

    public long getVolume() {
        return volume;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public int getLastSaleSize() {
        return lastSaleSize;
    }

    public long getLastSaleTime() {
        return lastSaleTime;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public Quote[] getBids() {
        return bids;
    }

    public Quote[] getAsks() {
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

    public Trade[] getTrades() {
        return trades;
    }

    public Trade[] getTradeBreaks() {
        return tradeBreaks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DEEP deep = (DEEP) o;

        if (Double.compare(deep.marketPercent, marketPercent) != 0) return false;
        if (volume != deep.volume) return false;
        if (Double.compare(deep.lastSalePrice, lastSalePrice) != 0) return false;
        if (lastSaleSize != deep.lastSaleSize) return false;
        if (lastSaleTime != deep.lastSaleTime) return false;
        if (lastUpdated != deep.lastUpdated) return false;
        if (symbol != null ? !symbol.equals(deep.symbol) : deep.symbol != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(bids, deep.bids)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(asks, deep.asks)) return false;
        if (systemEvent != null ? !systemEvent.equals(deep.systemEvent) : deep.systemEvent != null) return false;
        if (tradingStatus != null ? !tradingStatus.equals(deep.tradingStatus) : deep.tradingStatus != null)
            return false;
        if (opHaltStatus != null ? !opHaltStatus.equals(deep.opHaltStatus) : deep.opHaltStatus != null) return false;
        if (ssrStatus != null ? !ssrStatus.equals(deep.ssrStatus) : deep.ssrStatus != null) return false;
        if (securityEvent != null ? !securityEvent.equals(deep.securityEvent) : deep.securityEvent != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(trades, deep.trades)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(tradeBreaks, deep.tradeBreaks);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(marketPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        temp = Double.doubleToLongBits(lastSalePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + lastSaleSize;
        result = 31 * result + (int) (lastSaleTime ^ (lastSaleTime >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        result = 31 * result + Arrays.hashCode(bids);
        result = 31 * result + Arrays.hashCode(asks);
        result = 31 * result + (systemEvent != null ? systemEvent.hashCode() : 0);
        result = 31 * result + (tradingStatus != null ? tradingStatus.hashCode() : 0);
        result = 31 * result + (opHaltStatus != null ? opHaltStatus.hashCode() : 0);
        result = 31 * result + (ssrStatus != null ? ssrStatus.hashCode() : 0);
        result = 31 * result + (securityEvent != null ? securityEvent.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(trades);
        result = 31 * result + Arrays.hashCode(tradeBreaks);
        return result;
    }

    @Override
    public String toString() {
        return "DEEP{" +
                "symbol='" + symbol + '\'' +
                ", marketPercent=" + marketPercent +
                ", volume=" + volume +
                ", lastSalePrice=" + lastSalePrice +
                ", lastSaleSize=" + lastSaleSize +
                ", lastSaleTime=" + lastSaleTime +
                ", lastUpdated=" + lastUpdated +
                ", bids=" + Arrays.toString(bids) +
                ", asks=" + Arrays.toString(asks) +
                ", systemEvent=" + systemEvent +
                ", tradingStatus=" + tradingStatus +
                ", opHaltStatus=" + opHaltStatus +
                ", ssrStatus=" + ssrStatus +
                ", securityEvent=" + securityEvent +
                ", trades=" + Arrays.toString(trades) +
                ", tradeBreaks=" + Arrays.toString(tradeBreaks) +
                '}';
    }
}
