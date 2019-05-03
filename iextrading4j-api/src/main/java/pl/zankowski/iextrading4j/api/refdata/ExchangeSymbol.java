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
    private final Boolean enabled;
    private final SymbolType type;
    private final String iexId;
    private final String region;
    private final String currency;

    @JsonCreator
    public ExchangeSymbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("name") final String name,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("isEnabled") final Boolean isEnabled,
            @JsonProperty("type") final SymbolType type,
            @JsonProperty("iexId") final String iexId,
            @JsonProperty("region") final String region,
            @JsonProperty("currency") final String currency) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.enabled = isEnabled;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
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

    public Boolean isEnabled() {
        return enabled;
    }

    public SymbolType getType() {
        return type;
    }

    public String getIexId() {
        return iexId;
    }

    public String getRegion() {
        return region;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeSymbol that = (ExchangeSymbol) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(name, that.name) &&
                Objects.equal(date, that.date) &&
                Objects.equal(enabled, that.enabled) &&
                Objects.equal(type, that.type) &&
                Objects.equal(region, that.region) &&
                Objects.equal(currency, that.currency) &&
                Objects.equal(iexId, that.iexId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, name, date, enabled, type, iexId, region, currency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("date", date)
                .add("enabled", enabled)
                .add("type", type)
                .add("iexId", iexId)
                .add("region", region)
                .add("currency", currency)
                .toString();
    }
}
