package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

public class Symbol implements Serializable {

    private static final long serialVersionUID = -7224324582516753026L;

    private final String symbol;
    private final LocalDate date;
    private final Boolean isEnabled;

    @JsonCreator
    public Symbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("isEnabled") final Boolean isEnabled) {
        this.symbol = symbol;
        this.date = date;
        this.isEnabled = isEnabled;
    }

    public String getSymbol() {
        return symbol;
    }

    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("isEnabled")
    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Symbol symbol1 = (Symbol) o;
        return Objects.equal(symbol, symbol1.symbol) &&
                Objects.equal(date, symbol1.date) &&
                Objects.equal(isEnabled, symbol1.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, date, isEnabled);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("date", date)
                .add("isEnabled", isEnabled)
                .toString();
    }

}
