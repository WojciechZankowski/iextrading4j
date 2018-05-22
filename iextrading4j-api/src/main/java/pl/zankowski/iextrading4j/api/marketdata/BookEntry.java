package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"price", "size", "timestamp"})
public class BookEntry implements Serializable {

    private final BigDecimal price;
    private final BigDecimal size;
    private final Long timestamp;

    @JsonCreator
    public BookEntry(
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntry bookEntry = (BookEntry) o;
        return Objects.equal(price, bookEntry.price) &&
                Objects.equal(size, bookEntry.size) &&
                Objects.equal(timestamp, bookEntry.timestamp);
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
