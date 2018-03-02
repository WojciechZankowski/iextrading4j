package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"TradeDate", "SymbolinINETSymbology", "SymbolinCQSSymbology", "SymbolinCMSSymbology",
        "CUSIP", "SecurityName"})
public class ThresholdSecurities implements Serializable {

    private final LocalDate tradeDate;
    private final String symbolInINETSymbology;
    private final String symbolInCQSSymbology;
    private final String symbolInCMSSymbology;
    private final String cusip;
    private final String securityName;

    @JsonCreator
    public ThresholdSecurities(
            @JsonProperty("TradeDate") @JsonFormat(pattern = "yyyyMMdd") final LocalDate tradeDate,
            @JsonProperty("SymbolinINETSymbology") final String symbolInINETSymbology,
            @JsonProperty("SymbolinCQSSymbology") final String symbolInCQSSymbology,
            @JsonProperty("SymbolinCMSSymbology") final String symbolInCMSSymbology,
            @JsonProperty("CUSIP") final String cusip,
            @JsonProperty("SecurityName") final String securityName) {
        this.tradeDate = tradeDate;
        this.symbolInINETSymbology = symbolInINETSymbology;
        this.symbolInCQSSymbology = symbolInCQSSymbology;
        this.symbolInCMSSymbology = symbolInCMSSymbology;
        this.cusip = cusip;
        this.securityName = securityName;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public String getSymbolInINETSymbology() {
        return symbolInINETSymbology;
    }

    public String getSymbolInCQSSymbology() {
        return symbolInCQSSymbology;
    }

    public String getSymbolInCMSSymbology() {
        return symbolInCMSSymbology;
    }

    public String getCusip() {
        return cusip;
    }

    public String getSecurityName() {
        return securityName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ThresholdSecurities that = (ThresholdSecurities) o;
        return Objects.equal(tradeDate, that.tradeDate) &&
                Objects.equal(symbolInINETSymbology, that.symbolInINETSymbology) &&
                Objects.equal(symbolInCQSSymbology, that.symbolInCQSSymbology) &&
                Objects.equal(symbolInCMSSymbology, that.symbolInCMSSymbology) &&
                Objects.equal(cusip, that.cusip) &&
                Objects.equal(securityName, that.securityName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tradeDate, symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology,
                cusip, securityName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tradeDate", tradeDate)
                .add("symbolInINETSymbology", symbolInINETSymbology)
                .add("symbolInCQSSymbology", symbolInCQSSymbology)
                .add("symbolInCMSSymbology", symbolInCMSSymbology)
                .add("cusip", cusip)
                .add("securityName", securityName)
                .toString();
    }
}
