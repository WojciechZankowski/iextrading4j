package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "marketPercent", "bidSize", "bidPrice", "askSize", "askPrice",
        "volume", "lastSalePrice", "lastSaleSize", "lastSaleTime", "lastUpdated", "sector",
        "securityType"})
public class TOPS implements Serializable {

    private final String symbol;
    private final BigDecimal marketPercent;
    private final BigDecimal bidSize;
    private final BigDecimal bidPrice;
    private final BigDecimal askSize;
    private final BigDecimal askPrice;
    private final BigDecimal volume;
    private final BigDecimal lastSalePrice;
    private final BigDecimal lastSaleSize;
    private final Long lastSaleTime;
    private final Long lastUpdated;
    private final String sector;
    private final String securityType;

    @JsonCreator
    public TOPS(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("marketPercent") final BigDecimal marketPercent,
            @JsonProperty("bidSize") final BigDecimal bidSize,
            @JsonProperty("bidPrice") final BigDecimal bidPrice,
            @JsonProperty("askSize") final BigDecimal askSize,
            @JsonProperty("askPrice") final BigDecimal askPrice,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("lastSalePrice") final BigDecimal lastSalePrice,
            @JsonProperty("lastSaleSize") final BigDecimal lastSaleSize,
            @JsonProperty("lastSaleTime") final Long lastSaleTime,
            @JsonProperty("lastUpdated") final Long lastUpdated,
            @JsonProperty("sector") final String sector,
            @JsonProperty("securityType") final String securityType) {
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

    public BigDecimal getMarketPercent() {
        return marketPercent;
    }

    public BigDecimal getBidSize() {
        return bidSize;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public BigDecimal getAskSize() {
        return askSize;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
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
        return Objects.equal(symbol, tops.symbol) &&
                Objects.equal(marketPercent, tops.marketPercent) &&
                Objects.equal(bidSize, tops.bidSize) &&
                Objects.equal(bidPrice, tops.bidPrice) &&
                Objects.equal(askSize, tops.askSize) &&
                Objects.equal(askPrice, tops.askPrice) &&
                Objects.equal(volume, tops.volume) &&
                Objects.equal(lastSalePrice, tops.lastSalePrice) &&
                Objects.equal(lastSaleSize, tops.lastSaleSize) &&
                Objects.equal(lastSaleTime, tops.lastSaleTime) &&
                Objects.equal(lastUpdated, tops.lastUpdated) &&
                Objects.equal(sector, tops.sector) &&
                Objects.equal(securityType, tops.securityType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, marketPercent, bidSize, bidPrice, askSize, askPrice,
                volume, lastSalePrice, lastSaleSize, lastSaleTime, lastUpdated, sector, securityType);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("marketPercent", marketPercent)
                .add("bidSize", bidSize)
                .add("bidPrice", bidPrice)
                .add("askSize", askSize)
                .add("askPrice", askPrice)
                .add("volume", volume)
                .add("lastSalePrice", lastSalePrice)
                .add("lastSaleSize", lastSaleSize)
                .add("lastSaleTime", lastSaleTime)
                .add("lastUpdated", lastUpdated)
                .add("sector", sector)
                .add("securityType", securityType)
                .toString();
    }
}
