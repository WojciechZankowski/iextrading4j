package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class CryptoEvent implements Serializable {

    private static final long serialVersionUID = 9151409423809814546L;

    private final String symbol;
    private final CryptoEventType eventType;
    private final Long timestamp;
    private final CryptoEventReason reason;
    private final BigDecimal price;
    private final BigDecimal size;
    private final CryptoSide side;

    @JsonCreator
    public CryptoEvent(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("eventType") final CryptoEventType eventType,
            @JsonProperty("timestamp") final Long timestamp,
            @JsonProperty("reason") final CryptoEventReason reason,
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("size") final BigDecimal size,
            @JsonProperty("side") final CryptoSide side) {
        this.symbol = symbol;
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.reason = reason;
        this.price = price;
        this.size = size;
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public CryptoEventType getEventType() {
        return eventType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public CryptoEventReason getReason() {
        return reason;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public CryptoSide getSide() {
        return side;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CryptoEvent that = (CryptoEvent) o;
        return Objects.equal(symbol, that.symbol) &&
                eventType == that.eventType &&
                Objects.equal(timestamp, that.timestamp) &&
                reason == that.reason &&
                Objects.equal(price, that.price) &&
                Objects.equal(size, that.size) &&
                side == that.side;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, eventType, timestamp, reason, price, size, side);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("eventType", eventType)
                .add("timestamp", timestamp)
                .add("reason", reason)
                .add("price", price)
                .add("size", size)
                .add("side", side)
                .toString();
    }

}
