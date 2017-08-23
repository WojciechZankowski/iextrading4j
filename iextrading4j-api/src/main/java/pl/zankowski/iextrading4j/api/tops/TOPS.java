package pl.zankowski.iextrading4j.api.tops;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class TOPS {

    private final String symbol;
    private final double marketPercent;
    private final int bidSize;
    private final double bidPrice;
    private final int askSize;
    private final double askPrice;
    private final long volume;
    private final double lastSalePrice;
    private final int lastSaleSize;
    private final long lastSaleTime;
    private final long lastUpdated;
    private final String sector;
    private final String securityType;

    @JsonCreator
    public TOPS(@JsonProperty("symbol") String symbol,
                @JsonProperty("marketPercent") double marketPercent,
                @JsonProperty("bidSize") int bidSize,
                @JsonProperty("bidPrice") double bidPrice,
                @JsonProperty("askSize") int askSize,
                @JsonProperty("askPrice") double askPrice,
                @JsonProperty("volume") long volume,
                @JsonProperty("lastSalePrice") double lastSalePrice,
                @JsonProperty("lastSaleSize") int lastSaleSize,
                @JsonProperty("lastSaleTime") long lastSaleTime,
                @JsonProperty("lastUpdated") long lastUpdated,
                @JsonProperty("sector") String sector,
                @JsonProperty("securityType") String securityType) {
        this.symbol = symbol;
        this.marketPercent = marketPercent;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askSize = askSize;
        this.askPrice = askPrice;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
        this.sector = sector;
        this.securityType = securityType;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMarketPercent() {
        return marketPercent;
    }

    public int getBidSize() {
        return bidSize;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public double getAskPrice() {
        return askPrice;
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

    public String getSector() {
        return sector;
    }

    public String getSecurityType() {
        return securityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOPS tops = (TOPS) o;

        if (Double.compare(tops.marketPercent, marketPercent) != 0) return false;
        if (bidSize != tops.bidSize) return false;
        if (Double.compare(tops.bidPrice, bidPrice) != 0) return false;
        if (askSize != tops.askSize) return false;
        if (Double.compare(tops.askPrice, askPrice) != 0) return false;
        if (volume != tops.volume) return false;
        if (Double.compare(tops.lastSalePrice, lastSalePrice) != 0) return false;
        if (lastSaleSize != tops.lastSaleSize) return false;
        if (lastSaleTime != tops.lastSaleTime) return false;
        if (lastUpdated != tops.lastUpdated) return false;
        if (symbol != null ? !symbol.equals(tops.symbol) : tops.symbol != null) return false;
        if (sector != null ? !sector.equals(tops.sector) : tops.sector != null) return false;
        return securityType != null ? securityType.equals(tops.securityType) : tops.securityType == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(marketPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bidSize;
        temp = Double.doubleToLongBits(bidPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + askSize;
        temp = Double.doubleToLongBits(askPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        temp = Double.doubleToLongBits(lastSalePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + lastSaleSize;
        result = 31 * result + (int) (lastSaleTime ^ (lastSaleTime >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (securityType != null ? securityType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TOPS{" +
                "symbol='" + symbol + '\'' +
                ", marketPercent=" + marketPercent +
                ", bidSize=" + bidSize +
                ", bidPrice=" + bidPrice +
                ", askSize=" + askSize +
                ", askPrice=" + askPrice +
                ", volume=" + volume +
                ", lastSalePrice=" + lastSalePrice +
                ", lastSaleSize=" + lastSaleSize +
                ", lastSaleTime=" + lastSaleTime +
                ", lastUpdated=" + lastUpdated +
                ", sector='" + sector + '\'' +
                ", securityType='" + securityType + '\'' +
                '}';
    }

}
