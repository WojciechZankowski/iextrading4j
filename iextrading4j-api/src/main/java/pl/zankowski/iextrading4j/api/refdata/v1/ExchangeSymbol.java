package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.Serializable;
import java.time.LocalDate;

public class ExchangeSymbol implements Serializable {

    private static final long serialVersionUID = -5740262153957115684L;

    private final String symbol;
    private final String name;
    private final LocalDate date;
    private final SymbolType type;
    private final String iexId;
    private final String region;
    private final String currency;
    private final Boolean isEnabled;

    @JsonCreator
    public ExchangeSymbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("name") final String name,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("type") final SymbolType type,
            @JsonProperty("iexId") final String iexId,
            @JsonProperty("region") final String region,
            @JsonProperty("currency") final String currency,
            @JsonProperty("isEnabled") final Boolean isEnabled) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
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

    @JsonProperty("isEnabled")
    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ExchangeSymbol that = (ExchangeSymbol) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(name, that.name) &&
                Objects.equal(date, that.date) &&
                type == that.type &&
                Objects.equal(iexId, that.iexId) &&
                Objects.equal(region, that.region) &&
                Objects.equal(currency, that.currency) &&
                Objects.equal(isEnabled, that.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, name, date, type, iexId, region, currency, isEnabled);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("date", date)
                .add("type", type)
                .add("iexId", iexId)
                .add("region", region)
                .add("currency", currency)
                .add("isEnabled", isEnabled)
                .toString();
    }

}
