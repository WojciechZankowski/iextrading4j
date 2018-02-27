package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"open", "close", "high", "low"})
public class Ohlc implements Serializable {

    private final Point open;
    private final Point close;
    private final BigDecimal high;
    private final BigDecimal low;

    @JsonCreator
    public Ohlc(
            @JsonProperty("open") final Point open,
            @JsonProperty("close") final Point close,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public Point getOpen() {
        return open;
    }

    public Point getClose() {
        return close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ohlc ohlc = (Ohlc) o;
        return Objects.equal(open, ohlc.open) &&
                Objects.equal(close, ohlc.close) &&
                Objects.equal(high, ohlc.high) &&
                Objects.equal(low, ohlc.low);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(open, close, high, low);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("open", open)
                .add("close", close)
                .add("high", high)
                .add("low", low)
                .toString();
    }
}
