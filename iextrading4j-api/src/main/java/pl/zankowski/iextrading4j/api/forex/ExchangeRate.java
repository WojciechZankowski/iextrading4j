package pl.zankowski.iextrading4j.api.forex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = -7550737092058691758L;

    private final LocalDate date;
    private final String fromCurrency;
    private final String toCurrency;
    private final BigDecimal rate;

    @JsonCreator
    public ExchangeRate(
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("fromCurrency") final String fromCurrency,
            @JsonProperty("toCurrency") final String toCurrency,
            @JsonProperty("rate") final BigDecimal rate) {
        this.date = date;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ExchangeRate that = (ExchangeRate) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(fromCurrency, that.fromCurrency) &&
                Objects.equal(toCurrency, that.toCurrency) &&
                Objects.equal(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, fromCurrency, toCurrency, rate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("fromCurrency", fromCurrency)
                .add("toCurrency", toCurrency)
                .add("rate", rate)
                .toString();
    }
}
