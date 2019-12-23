package pl.zankowski.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"date", "symbol", "rate", "timestamp", "isDerived"})
public class HistoricalCurrencyRate extends CurrencyRate {

    private static final long serialVersionUID = 6127152263842018048L;

    private final LocalDate date;

    @JsonCreator
    public HistoricalCurrencyRate(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("rate") final BigDecimal rate,
            @JsonProperty("timestamp") final Long timestamp,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("isDerived") final Boolean isDerived) {
        super(symbol, rate, timestamp, isDerived);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
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
        final HistoricalCurrencyRate that = (HistoricalCurrencyRate) o;
        return Objects.equal(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), date);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .toString();
    }

}
