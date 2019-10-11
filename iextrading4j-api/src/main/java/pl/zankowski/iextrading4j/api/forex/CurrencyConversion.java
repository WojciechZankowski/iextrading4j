package pl.zankowski.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"symbol", "rate", "timestamp", "amount"})
public class CurrencyConversion implements Serializable {

    private static final long serialVersionUID = 7375544334448807375L;

    private final String symbol;
    private final BigDecimal rate;
    private final Long timestamp;
    private final BigDecimal amount;

    @JsonCreator
    public CurrencyConversion(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("rate") final BigDecimal rate,
            @JsonProperty("timestamp") final Long timestamp,
            @JsonProperty("amount") final BigDecimal amount) {
        this.symbol = symbol;
        this.rate = rate;
        this.timestamp = timestamp;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CurrencyConversion that = (CurrencyConversion) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(rate, that.rate) &&
                Objects.equal(timestamp, that.timestamp) &&
                Objects.equal(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, rate, timestamp, amount);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("rate", rate)
                .add("timestamp", timestamp)
                .add("amount", amount)
                .toString();
    }

}
