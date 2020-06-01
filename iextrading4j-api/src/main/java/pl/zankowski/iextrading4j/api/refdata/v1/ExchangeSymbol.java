package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@JsonPropertyOrder({"symbol", "exchange", "name", "date", "type",
        "iexId", "region", "currency", "isEnabled", "figi", "cik"})
public class ExchangeSymbol implements Serializable {

    private static final long serialVersionUID = -5740262153957115684L;

    private final String symbol;
    private final String exchange;
    private final String name;
    private final LocalDate date;
    private final SymbolType type;
    private final String iexId;
    private final String region;
    private final String currency;
    private final Boolean isEnabled;
    private final String figi;
    private final String cik;

    @JsonCreator
    public ExchangeSymbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("name") final String name,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("type") final SymbolType type,
            @JsonProperty("iexId") final String iexId,
            @JsonProperty("region") final String region,
            @JsonProperty("currency") final String currency,
            @JsonProperty("isEnabled") final Boolean isEnabled,
            @JsonProperty("figi") final String figi,
            @JsonProperty("cik")  final String cik) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.name = name;
        this.date = date;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
        this.isEnabled = isEnabled;
        this.figi = figi;
        this.cik = cik;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExchange() {
        return exchange;
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

    public String getFigi() {
        return figi;
    }

    public String getCik() {
        return cik;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ExchangeSymbol that = (ExchangeSymbol) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(exchange, that.exchange) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                type == that.type &&
                Objects.equals(iexId, that.iexId) &&
                Objects.equals(region, that.region) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(isEnabled, that.isEnabled) &&
                Objects.equals(figi, that.figi) &&
                Objects.equals(cik, that.cik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, exchange, name, date, type, iexId, region, currency,
                isEnabled, figi, cik);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExchangeSymbol.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("exchange='" + exchange + "'")
                .add("name='" + name + "'")
                .add("date=" + date)
                .add("type=" + type)
                .add("iexId='" + iexId + "'")
                .add("region='" + region + "'")
                .add("currency='" + currency + "'")
                .add("isEnabled=" + isEnabled)
                .add("figi='" + figi + "'")
                .add("cik='" + cik + "'")
                .toString();
    }
}
