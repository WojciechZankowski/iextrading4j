package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"exDate", "declaredDate", "recordDate", "paymentDate",
        "ratio", "toFactor", "forFactor"})
public class Split implements Serializable {

    private final LocalDate exDate;
    private final LocalDate declaredDate;
    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final BigDecimal ratio;
    private final BigDecimal toFactor;
    private final BigDecimal forFactor;

    @JsonCreator
    public Split(
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("declaredDate") final LocalDate declaredDate,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("paymentDate") final LocalDate paymentDate,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("forFactor") final BigDecimal forFactor) {
        this.exDate = exDate;
        this.declaredDate = declaredDate;
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.ratio = ratio;
        this.toFactor = toFactor;
        this.forFactor = forFactor;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getDeclaredDate() {
        return declaredDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public BigDecimal getToFactor() {
        return toFactor;
    }

    public BigDecimal getForFactor() {
        return forFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Split split = (Split) o;
        return Objects.equal(exDate, split.exDate) &&
                Objects.equal(declaredDate, split.declaredDate) &&
                Objects.equal(recordDate, split.recordDate) &&
                Objects.equal(paymentDate, split.paymentDate) &&
                Objects.equal(ratio, split.ratio) &&
                Objects.equal(toFactor, split.toFactor) &&
                Objects.equal(forFactor, split.forFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exDate, declaredDate, recordDate, paymentDate, ratio,
                toFactor, forFactor);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exDate", exDate)
                .add("declaredDate", declaredDate)
                .add("recordDate", recordDate)
                .add("paymentDate", paymentDate)
                .add("ratio", ratio)
                .add("toFactor", toFactor)
                .add("forFactor", forFactor)
                .toString();
    }
}
