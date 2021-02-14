package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class PriceTarget implements Serializable {

    private static final long serialVersionUID = 2641199116590474197L;

    private final String symbol;
    private final LocalDate updatedDate;
    private final BigDecimal priceTargetAverage;
    private final BigDecimal priceTargetHigh;
    private final BigDecimal priceTargetLow;
    private final BigDecimal numberOfAnalysts;
    private final String currency;

    @JsonCreator
    public PriceTarget(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("updatedDate") final LocalDate updatedDate,
            @JsonProperty("priceTargetAverage") final BigDecimal priceTargetAverage,
            @JsonProperty("priceTargetHigh") final BigDecimal priceTargetHigh,
            @JsonProperty("priceTargetLow") final BigDecimal priceTargetLow,
            @JsonProperty("numberOfAnalysts") final BigDecimal numberOfAnalysts,
            @JsonProperty("currency") final String currency) {
        this.symbol = symbol;
        this.updatedDate = updatedDate;
        this.priceTargetAverage = priceTargetAverage;
        this.priceTargetHigh = priceTargetHigh;
        this.priceTargetLow = priceTargetLow;
        this.numberOfAnalysts = numberOfAnalysts;
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public BigDecimal getPriceTargetAverage() {
        return priceTargetAverage;
    }

    public BigDecimal getPriceTargetHigh() {
        return priceTargetHigh;
    }

    public BigDecimal getPriceTargetLow() {
        return priceTargetLow;
    }

    public BigDecimal getNumberOfAnalysts() {
        return numberOfAnalysts;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceTarget that = (PriceTarget) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(priceTargetAverage, that.priceTargetAverage) &&
                Objects.equals(priceTargetHigh, that.priceTargetHigh) &&
                Objects.equals(priceTargetLow, that.priceTargetLow) &&
                Objects.equals(numberOfAnalysts, that.numberOfAnalysts) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, updatedDate, priceTargetAverage, priceTargetHigh, priceTargetLow,
                numberOfAnalysts, currency);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PriceTarget.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("updatedDate=" + updatedDate)
                .add("priceTargetAverage=" + priceTargetAverage)
                .add("priceTargetHigh=" + priceTargetHigh)
                .add("priceTargetLow=" + priceTargetLow)
                .add("numberOfAnalysts=" + numberOfAnalysts)
                .add("currency='" + currency + "'")
                .toString();
    }
}
