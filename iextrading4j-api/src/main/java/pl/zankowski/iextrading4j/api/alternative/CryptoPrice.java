package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class CryptoPrice implements Serializable {

    private static final long serialVersionUID = 2703606379124034042L;

    private final BigDecimal price;
    private final String symbol;

    @JsonCreator
    public CryptoPrice(
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("symbol") final String symbol) {
        this.price = price;
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CryptoPrice that = (CryptoPrice) o;
        return Objects.equal(price, that.price) &&
                Objects.equal(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, symbol);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("symbol", symbol)
                .toString();
    }

}
