package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CryptoSymbols implements Serializable {

    private static final long serialVersionUID = 1072113924357554487L;

    private final String symbol;
    private final String name;
    private final String exchange;
    private final LocalDate date;
    private final String type;
    private final String region;
    private final String currency;
    private final Boolean isEnabled;

    @JsonCreator
    public CryptoSymbols(@JsonProperty("symbol") final String symbol,
                         @JsonProperty("name") final String name,
                         @JsonProperty("exchange") final String exchange,
                         @JsonProperty("date") final LocalDate date,
                         @JsonProperty("type") final String type,
                         @JsonProperty("region") final String region,
                         @JsonProperty("currency") final String currency,
                         @JsonProperty("isEnabled") final Boolean isEnabled) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.date = date;
        this.type = type;
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

    public String getExchange() {
        return exchange;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CryptoSymbols that = (CryptoSymbols) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(name, that.name) &&
                Objects.equals(exchange, that.exchange) &&
                Objects.equals(date, that.date) &&
                Objects.equals(type, that.type) &&
                Objects.equals(region, that.region) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(isEnabled, that.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name, exchange, date, type, region, currency, isEnabled);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("exchange", exchange)
                .add("date", date)
                .add("type", type)
                .add("region", region)
                .add("currency", currency)
                .add("isEnabled", isEnabled)
                .toString();
    }

}
