package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.Serializable;

public class SymbolDescription implements Serializable {

    private static final long serialVersionUID = -7928382775445887294L;

    private final String symbol;
    private final String cik;
    private final String securityName;
    private final SymbolType securityType;
    private final String region;
    private final String exchange;
    private final String sector;
    private final String currency;

    @JsonCreator
    public SymbolDescription(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("cik") final String cik,
            @JsonProperty("securityName") final String securityName,
            @JsonProperty("securityType") final SymbolType securityType,
            @JsonProperty("region") final String region,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("sector") final String sector,
            @JsonProperty("currency") final String currency) {
        this.symbol = symbol;
        this.cik = cik;
        this.securityName = securityName;
        this.securityType = securityType;
        this.region = region;
        this.exchange = exchange;
        this.sector = sector;
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCik() {
        return cik;
    }

    public String getSecurityName() {
        return securityName;
    }

    public SymbolType getSecurityType() {
        return securityType;
    }

    public String getRegion() {
        return region;
    }

    public String getExchange() {
        return exchange;
    }

    public String getSector() {
        return sector;
    }

    public String getCurrency() {
        return currency;
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
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(cik, that.cik) &&
                Objects.equal(securityName, that.securityName) &&
                securityType == that.securityType &&
                Objects.equal(region, that.region) &&
                Objects.equal(sector, that.sector) &&
                Objects.equal(exchange, that.exchange) &&
                Objects.equal(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, cik, securityName, securityType, region, exchange, sector, currency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("cik", cik)
                .add("securityName", securityName)
                .add("securityType", securityType)
                .add("region", region)
                .add("exchange", exchange)
                .add("sector", sector)
                .add("currency", currency)
                .toString();
    }

}
