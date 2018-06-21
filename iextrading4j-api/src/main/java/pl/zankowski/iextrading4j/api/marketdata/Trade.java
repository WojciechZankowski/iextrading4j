package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

@JsonPropertyOrder({"price", "size", "tradeId", "isISO", "isOddLot", "isOutsideRegularHours",
        "isSinglePriceCross", "isTradeThroughExempt", "timestamp"})
public class Trade extends DeepResult {

    private final BigDecimal price;
    private final BigDecimal size;
    private final Long tradeId;
    private final Boolean isISO;
    private final Boolean isOddLot;
    private final Boolean isOutsideRegularHours;
    private final Boolean isSinglePriceCross;
    private final Boolean isTradeThroughExempt;
    private final Long timestamp;

    @JsonCreator
    public Trade(
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("size") final BigDecimal size,
            @JsonProperty("tradeId") final Long tradeId,
            @JsonProperty("isISO") final Boolean isISO,
            @JsonProperty("isOddLot") final Boolean isOddLot,
            @JsonProperty("isOutsideRegularHours") final Boolean isOutsideRegularHours,
            @JsonProperty("isSinglePriceCross") final Boolean isSinglePriceCross,
            @JsonProperty("isTradeThroughExempt") final Boolean isTradeThroughExempt,
            @JsonProperty("timestamp") final Long timestamp) {
        this.price = price;
        this.size = size;
        this.tradeId = tradeId;
        this.isISO = isISO;
        this.isOddLot = isOddLot;
        this.isOutsideRegularHours = isOutsideRegularHours;
        this.isSinglePriceCross = isSinglePriceCross;
        this.isTradeThroughExempt = isTradeThroughExempt;
        this.timestamp = timestamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public Boolean isISO() {
        return isISO;
    }

    public Boolean isOddLot() {
        return isOddLot;
    }

    public Boolean isOutsideRegularHours() {
        return isOutsideRegularHours;
    }

    public Boolean isSinglePriceCross() {
        return isSinglePriceCross;
    }

    public Boolean isTradeThroughExempt() {
        return isTradeThroughExempt;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equal(price, trade.price) &&
                Objects.equal(size, trade.size) &&
                Objects.equal(tradeId, trade.tradeId) &&
                Objects.equal(isISO, trade.isISO) &&
                Objects.equal(isOddLot, trade.isOddLot) &&
                Objects.equal(isOutsideRegularHours, trade.isOutsideRegularHours) &&
                Objects.equal(isSinglePriceCross, trade.isSinglePriceCross) &&
                Objects.equal(isTradeThroughExempt, trade.isTradeThroughExempt) &&
                Objects.equal(timestamp, trade.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, size, tradeId, isISO, isOddLot, isOutsideRegularHours,
                isSinglePriceCross, isTradeThroughExempt, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("size", size)
                .add("tradeId", tradeId)
                .add("isISO", isISO)
                .add("isOddLot", isOddLot)
                .add("isOutsideRegularHours", isOutsideRegularHours)
                .add("isSinglePriceCross", isSinglePriceCross)
                .add("isTradeThroughExempt", isTradeThroughExempt)
                .add("timestamp", timestamp)
                .toString();
    }
}
