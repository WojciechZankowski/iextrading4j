package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PriceTarget implements Serializable {

    private static final long serialVersionUID = 2641199116590474197L;

    private final String symbol;
    private final LocalDate updatedDate;
    private final BigDecimal priceTargetAverage;
    private final BigDecimal priceTargetHigh;
    private final BigDecimal priceTargetLow;
    private final BigDecimal numberOfAnalysts;

    @JsonCreator
    public PriceTarget(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("updatedDate") final LocalDate updatedDate,
            @JsonProperty("priceTargetAverage") final BigDecimal priceTargetAverage,
            @JsonProperty("priceTargetHigh") final BigDecimal priceTargetHigh,
            @JsonProperty("priceTargetLow") final BigDecimal priceTargetLow,
            @JsonProperty("numberOfAnalysts") final BigDecimal numberOfAnalysts) {
        this.symbol = symbol;
        this.updatedDate = updatedDate;
        this.priceTargetAverage = priceTargetAverage;
        this.priceTargetHigh = priceTargetHigh;
        this.priceTargetLow = priceTargetLow;
        this.numberOfAnalysts = numberOfAnalysts;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PriceTarget that = (PriceTarget) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(updatedDate, that.updatedDate) &&
                Objects.equal(priceTargetAverage, that.priceTargetAverage) &&
                Objects.equal(priceTargetHigh, that.priceTargetHigh) &&
                Objects.equal(priceTargetLow, that.priceTargetLow) &&
                Objects.equal(numberOfAnalysts, that.numberOfAnalysts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, updatedDate, priceTargetAverage, priceTargetHigh, priceTargetLow, numberOfAnalysts);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("updatedDate", updatedDate)
                .add("priceTargetAverage", priceTargetAverage)
                .add("priceTargetHigh", priceTargetHigh)
                .add("priceTargetLow", priceTargetLow)
                .add("numberOfAnalysts", numberOfAnalysts)
                .toString();
    }

}
