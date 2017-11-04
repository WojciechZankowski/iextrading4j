package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"symbol", "name", "date", "isEnabled"})
public class ExchangeSymbol implements Serializable {

    private final String symbol;
    private final String name;
    private final LocalDate date;
    private final Boolean isEnabled;

    @JsonCreator
    public ExchangeSymbol(@JsonProperty("symbol") final String symbol,
                          @JsonProperty("name") final String name,
                          @JsonProperty("date") final LocalDate date,
                          @JsonProperty("isEnabled") final Boolean isEnabled) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.isEnabled = isEnabled;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeSymbol that = (ExchangeSymbol) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(name, that.name) &&
                Objects.equal(date, that.date) &&
                Objects.equal(isEnabled, that.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, name, date, isEnabled);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("date", date)
                .add("isEnabled", isEnabled)
                .toString();
    }
}
