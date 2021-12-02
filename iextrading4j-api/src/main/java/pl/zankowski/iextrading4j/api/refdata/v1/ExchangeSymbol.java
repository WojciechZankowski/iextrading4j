package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class ExchangeSymbol implements Serializable {

    private static final long serialVersionUID = -5740262153957115684L;

    private final String symbol;
    private final String exchange;
    private final String exchangeSuffix;
    private final String exchangeName;
    private final String exchangeSegment;
    private final String exchangeSegmentName;
    private final String name;
    private final LocalDate date;
    private final SymbolType type;
    private final String iexId;
    private final String region;
    private final String currency;
    private final Boolean isEnabled;
    private final String figi;
    private final String cik;
    private final String lei;

    @JsonCreator
    public ExchangeSymbol(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("exchangeSuffix") final String exchangeSuffix,
            @JsonProperty("exchangeName") final String exchangeName,
            @JsonProperty("exchangeSegment") final String exchangeSegment,
            @JsonProperty("exchangeSegmentName") final String exchangeSegmentName,
            @JsonProperty("name") final String name,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("type") final SymbolType type,
            @JsonProperty("iexId") final String iexId,
            @JsonProperty("region") final String region,
            @JsonProperty("currency") final String currency,
            @JsonProperty("isEnabled") final Boolean isEnabled,
            @JsonProperty("figi") final String figi,
            @JsonProperty("cik") final String cik,
            @JsonProperty("lei") final String lei) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.exchangeSuffix = exchangeSuffix;
        this.exchangeName = exchangeName;
        this.exchangeSegment = exchangeSegment;
        this.exchangeSegmentName = exchangeSegmentName;
        this.name = name;
        this.date = date;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
        this.isEnabled = isEnabled;
        this.figi = figi;
        this.cik = cik;
        this.lei = lei;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public String getExchangeSuffix() {
        return exchangeSuffix;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getExchangeSegment() {
        return exchangeSegment;
    }

    public String getExchangeSegmentName() {
        return exchangeSegmentName;
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

    public String getLei() {
        return lei;
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
        return Objects.equals(symbol, that.symbol) && Objects.equals(exchange, that.exchange) &&
                Objects.equals(exchangeSuffix, that.exchangeSuffix) &&
                Objects.equals(exchangeName, that.exchangeName) &&
                Objects.equals(exchangeSegment, that.exchangeSegment) &&
                Objects.equals(exchangeSegmentName, that.exchangeSegmentName) &&
                Objects.equals(name, that.name) && Objects.equals(date, that.date) &&
                type == that.type && Objects.equals(iexId, that.iexId) &&
                Objects.equals(region, that.region) && Objects.equals(currency, that.currency) &&
                Objects.equals(isEnabled, that.isEnabled) && Objects.equals(figi, that.figi) &&
                Objects.equals(cik, that.cik) && Objects.equals(lei, that.lei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, exchange, exchangeSuffix, exchangeName, exchangeSegment, exchangeSegmentName, name,
                date, type, iexId, region, currency, isEnabled, figi, cik, lei);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExchangeSymbol.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("exchange='" + exchange + "'")
                .add("exchangeSuffix='" + exchangeSuffix + "'")
                .add("exchangeName='" + exchangeName + "'")
                .add("exchangeSegment='" + exchangeSegment + "'")
                .add("exchangeSegmentName='" + exchangeSegmentName + "'")
                .add("name='" + name + "'")
                .add("date=" + date)
                .add("type=" + type)
                .add("iexId='" + iexId + "'")
                .add("region='" + region + "'")
                .add("currency='" + currency + "'")
                .add("isEnabled=" + isEnabled)
                .add("figi='" + figi + "'")
                .add("cik='" + cik + "'")
                .add("lei='" + lei + "'")
                .add("enabled=" + getEnabled())
                .toString();
    }
}
