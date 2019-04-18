package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "delayedPrice", "high", "low", "delayedSize", "delayedPriceTime",
        "totalVolume", "processedTime"})
public class DelayedQuote implements Serializable {

    private final String symbol;
    private final BigDecimal delayedPrice;
    private final BigDecimal delayedSize;
    private final Long delayedPriceTime;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal totalVolume;
    private final Long processedTime;

    @JsonCreator
    public DelayedQuote(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("delayedPrice") final BigDecimal delayedPrice,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("delayedSize") final BigDecimal delayedSize,
            @JsonProperty("delayedPriceTime") final Long delayedPriceTime,
            @JsonProperty("totalVolume") final BigDecimal totalVolume,
            @JsonProperty("processedTime") final Long processedTime) {
        this.symbol = symbol;
        this.delayedPrice = delayedPrice;
        this.high = high;
        this.low = low;
        this.delayedSize = delayedSize;
        this.delayedPriceTime = delayedPriceTime;
        this.totalVolume = totalVolume;
        this.processedTime = processedTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getDelayedPrice() {
        return delayedPrice;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getDelayedSize() {
        return delayedSize;
    }

    public Long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public Long getProcessedTime() {
        return processedTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DelayedQuote that = (DelayedQuote) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(delayedPrice, that.delayedPrice) &&
                Objects.equal(delayedSize, that.delayedSize) &&
                Objects.equal(delayedPriceTime, that.delayedPriceTime) &&
                Objects.equal(high, that.high) &&
                Objects.equal(low, that.low) &&
                Objects.equal(totalVolume, that.totalVolume) &&
                Objects.equal(processedTime, that.processedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, delayedPrice, delayedSize, delayedPriceTime, high, low, totalVolume, processedTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("delayedPrice", delayedPrice)
                .add("delayedSize", delayedSize)
                .add("delayedPriceTime", delayedPriceTime)
                .add("high", high)
                .add("low", low)
                .add("totalVolume", totalVolume)
                .add("processedTime", processedTime)
                .toString();
    }

}
