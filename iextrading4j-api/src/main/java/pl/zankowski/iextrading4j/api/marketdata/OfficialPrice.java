package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"priceType", "price", "timestamp"})
public class OfficialPrice implements Serializable {

    private final PriceType priceType;
    private final BigDecimal price;
    private final Long timestamp;

    @JsonCreator
    public OfficialPrice(
            @JsonProperty("priceType") final PriceType priceType,
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("timestamp") final Long timestamp) {
        this.priceType = priceType;
        this.price = price;
        this.timestamp = timestamp;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OfficialPrice that = (OfficialPrice) o;
        return priceType == that.priceType &&
                Objects.equal(price, that.price) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(priceType, price, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("priceType", priceType)
                .add("price", price)
                .add("timestamp", timestamp)
                .toString();
    }
}
