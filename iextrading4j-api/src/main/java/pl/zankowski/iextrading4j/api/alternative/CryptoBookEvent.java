package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"price", "size", "timestamp"})
public class CryptoBookEvent implements Serializable {

    private static final long serialVersionUID = 6995586430607181195L;

    private final BigDecimal price;
    private final BigDecimal size;
    private final Long timestamp;

    @JsonCreator
    public CryptoBookEvent(
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("size") final BigDecimal size,
            @JsonProperty("timestamp") final Long timestamp) {
        this.price = price;
        this.size = size;
        this.timestamp = timestamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CryptoBookEvent that = (CryptoBookEvent) o;
        return Objects.equal(price, that.price) &&
                Objects.equal(size, that.size) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, size, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("size", size)
                .add("timestamp", timestamp)
                .toString();
    }

}
