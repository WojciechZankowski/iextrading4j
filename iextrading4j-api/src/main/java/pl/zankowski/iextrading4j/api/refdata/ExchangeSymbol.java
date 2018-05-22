package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"symbol", "name", "date", "isEnabled", "type", "iexId"})
public class ExchangeSymbol implements Serializable {

    private final String symbol;
    private final String name;
    private final LocalDate date;
    private final Boolean isEnabled;
    private final SymbolType type;
    private final Long iexId;

    @JsonCreator
    public ExchangeSymbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("name") final String name,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("isEnabled") final Boolean isEnabled,
            @JsonProperty("type") final SymbolType type,
            @JsonProperty("iexId") final Long iexId) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.isEnabled = isEnabled;
        this.type = type;
        this.iexId = iexId;
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

    public SymbolType getType() {
        return type;
    }

    public Long getIexId() {
        return iexId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeSymbol that = (ExchangeSymbol) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(name, that.name) &&
                Objects.equal(date, that.date) &&
                Objects.equal(isEnabled, that.isEnabled) &&
                Objects.equal(type, that.type) &&
                Objects.equal(iexId, that.iexId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, name, date, isEnabled, type, iexId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("date", date)
                .add("isEnabled", isEnabled)
                .add("type", type)
                .add("iexId", iexId)
                .toString();
    }
}
