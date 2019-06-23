package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "open", "close", "high", "low", "volume"})
public class Ohlc implements Serializable {

    private static final long serialVersionUID = -7796960089826811278L;

    private final String symbol;
    private final Point open;
    private final Point close;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal volume;

    @JsonCreator
    public Ohlc(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("open") final Point open,
            @JsonProperty("close") final Point close,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("volume") final BigDecimal volume) {
        this.symbol = symbol;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
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

    public BigDecimal getVolume() {
        return volume;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ohlc ohlc = (Ohlc) o;
        return Objects.equal(symbol, ohlc.symbol) &&
                Objects.equal(open, ohlc.open) &&
                Objects.equal(close, ohlc.close) &&
                Objects.equal(high, ohlc.high) &&
                Objects.equal(low, ohlc.low) &&
                Objects.equal(volume, ohlc.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, open, close, high, low, volume);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("open", open)
                .add("close", close)
                .add("high", high)
                .add("low", low)
                .add("volume", volume)
                .toString();
    }

}
