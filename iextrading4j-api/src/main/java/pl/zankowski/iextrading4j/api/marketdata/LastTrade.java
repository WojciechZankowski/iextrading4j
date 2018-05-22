package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "price", "size", "time"})
public class LastTrade implements Serializable {

    private final String symbol;
    private final BigDecimal price;
    private final BigDecimal size;
    private final Long time;

    @JsonCreator
    public LastTrade(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("size") final BigDecimal size,
            @JsonProperty("time") final Long time) {
        this.symbol = symbol;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastTrade lastTrade = (LastTrade) o;
        return Objects.equal(symbol, lastTrade.symbol) &&
                Objects.equal(price, lastTrade.price) &&
                Objects.equal(size, lastTrade.size) &&
                Objects.equal(time, lastTrade.time);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, price, size, time);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("price", price)
                .add("size", size)
                .add("time", time)
                .toString();
    }
}
