package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class SymbolDescription implements Serializable {

    private static final long serialVersionUID = -7928382775445887294L;

    private final String symbol;
    private final String exchange;
    private final String exchangeSuffix;
    private final String exchangeName;
    private final String name;
    private final String type;
    private final String iexId;
    private final String region;
    private final String currency;
    private final String figi;
    private final String cik;
    private final String lei;
    private final String securityName;
    private final SymbolType securityType;
    private final String sector;


    @JsonCreator
    public SymbolDescription(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("exchangeSuffix") final String exchangeSuffix,
            @JsonProperty("exchangeName") final String exchangeName,
            @JsonProperty("name") final String name,
            @JsonProperty("type") final String type,
            @JsonProperty("iexId") final String iexId,
            @JsonProperty("region") final String region,
            @JsonProperty("currency") final String currency,
            @JsonProperty("figi") final String figi,
            @JsonProperty("cik") final String cik,
            @JsonProperty("lei") final String lei,
            @JsonProperty("securityName") final String securityName,
            @JsonProperty("securityType") final SymbolType securityType,
            @JsonProperty("sector") final String sector) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.exchangeSuffix = exchangeSuffix;
        this.exchangeName = exchangeName;
        this.name = name;
        this.type = type;
        this.iexId = iexId;
        this.figi = figi;
        this.cik = cik;
        this.lei = lei;
        this.securityName = securityName;
        this.securityType = securityType;
        this.region = region;
        this.sector = sector;
        this.currency = currency;
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

    public String getName() {
        return name;
    }

    public String getType() {
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

    public String getFigi() {
        return figi;
    }

    public String getCik() {
        return cik;
    }

    public String getLei() {
        return lei;
    }

    public String getSecurityName() {
        return securityName;
    }

    public SymbolType getSecurityType() {
        return securityType;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SymbolDescription that = (SymbolDescription) o;
        return Objects.equals(symbol, that.symbol) && Objects.equals(exchange, that.exchange) &&
                Objects.equals(exchangeSuffix, that.exchangeSuffix) &&
                Objects.equals(exchangeName, that.exchangeName) && Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) && Objects.equals(iexId, that.iexId) &&
                Objects.equals(region, that.region) && Objects.equals(currency, that.currency) &&
                Objects.equals(figi, that.figi) && Objects.equals(cik, that.cik) &&
                Objects.equals(lei, that.lei) && Objects.equals(securityName, that.securityName) &&
                securityType == that.securityType && Objects.equals(sector, that.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, exchange, exchangeSuffix, exchangeName, name, type, iexId,
                region, currency, figi, cik, lei, securityName, securityType, sector);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SymbolDescription.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("exchange='" + exchange + "'")
                .add("exchangeSuffix='" + exchangeSuffix + "'")
                .add("exchangeName='" + exchangeName + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("iexId='" + iexId + "'")
                .add("region='" + region + "'")
                .add("currency='" + currency + "'")
                .add("figi='" + figi + "'")
                .add("cik='" + cik + "'")
                .add("lei='" + lei + "'")
                .add("securityName='" + securityName + "'")
                .add("securityType=" + securityType)
                .add("sector='" + sector + "'")
                .toString();
    }
}
