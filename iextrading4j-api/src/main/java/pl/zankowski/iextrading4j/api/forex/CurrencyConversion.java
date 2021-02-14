package pl.zankowski.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

public class CurrencyConversion extends CurrencyRate {

    private static final long serialVersionUID = 7375544334448807375L;

    private final BigDecimal amount;

    @JsonCreator
    public CurrencyConversion(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("rate") final BigDecimal rate,
            @JsonProperty("timestamp") final Long timestamp,
            @JsonProperty("amount") final BigDecimal amount,
            @JsonProperty("isDerived") final Boolean isDerived) {
        super(symbol, rate, timestamp, isDerived);
        this.amount = amount;
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
        if (!super.equals(o)) {
            return false;
        }
        final CurrencyConversion that = (CurrencyConversion) o;
        return Objects.equal(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), amount);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("amount", amount)
                .toString();
    }

}
