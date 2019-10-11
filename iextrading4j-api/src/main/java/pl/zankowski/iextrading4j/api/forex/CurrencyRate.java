package pl.zankowski.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "rate", "timestamp"})
public class CurrencyRate implements Serializable {

    private static final long serialVersionUID = -5880260943698563399L;

    private final String symbol;
    private final BigDecimal rate;
    private final Long timestamp;

    @JsonCreator
    public CurrencyRate(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("rate") final BigDecimal rate,
            @JsonProperty("timestamp") final Long timestamp) {
        this.symbol = symbol;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getRate() {
        return rate;
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
        final CurrencyRate rate1 = (CurrencyRate) o;
        return Objects.equal(symbol, rate1.symbol) &&
                Objects.equal(rate, rate1.rate) &&
                Objects.equal(timestamp, rate1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, rate, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("rate", rate)
                .add("timestamp", timestamp)
                .toString();
    }
}
