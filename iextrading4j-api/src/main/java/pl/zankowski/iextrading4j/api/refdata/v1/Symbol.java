package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Symbol implements Serializable {

    private static final long serialVersionUID = -7224324582516753026L;

    private final String symbol;
    private final LocalDate date;
    private final Boolean isEnabled;
    private final String name;

    @JsonCreator
    public Symbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("isEnabled") final Boolean isEnabled,
            @JsonProperty("name") final String name) {
        this.symbol = symbol;
        this.date = date;
        this.isEnabled = isEnabled;
        this.name = name;
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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Symbol symbol1 = (Symbol) o;
        return Objects.equals(symbol, symbol1.symbol) &&
                Objects.equals(date, symbol1.date) &&
                Objects.equals(isEnabled, symbol1.isEnabled) &&
                Objects.equals(name, symbol1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, date, isEnabled, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Symbol.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("date=" + date)
                .add("isEnabled=" + isEnabled)
                .add("name='" + name + "'")
                .add("enabled=" + getEnabled())
                .toString();
    }
}
