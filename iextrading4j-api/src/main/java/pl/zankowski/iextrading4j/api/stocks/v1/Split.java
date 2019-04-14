package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"exDate", "declaredDate", "ratio", "toFactor",
        "fromFactor", "description"})
public class Split implements Serializable {

    private final LocalDate exDate;
    private final LocalDate declaredDate;
    private final BigDecimal ratio;
    private final BigDecimal toFactor;
    private final BigDecimal fromFactor;
    private final String description;

    @JsonCreator
    public Split(
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("declaredDate") final LocalDate declaredDate,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("fromFactor") final BigDecimal fromFactor,
            @JsonProperty("description") final String description) {
        this.exDate = exDate;
        this.declaredDate = declaredDate;
        this.ratio = ratio;
        this.toFactor = toFactor;
        this.fromFactor = fromFactor;
        this.description = description;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getDeclaredDate() {
        return declaredDate;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public BigDecimal getToFactor() {
        return toFactor;
    }

    public BigDecimal getFromFactor() {
        return fromFactor;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Split)) return false;
        final Split split = (Split) o;
        return Objects.equal(exDate, split.exDate) &&
                Objects.equal(declaredDate, split.declaredDate) &&
                Objects.equal(ratio, split.ratio) &&
                Objects.equal(toFactor, split.toFactor) &&
                Objects.equal(fromFactor, split.fromFactor) &&
                Objects.equal(description, split.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exDate, declaredDate, ratio, toFactor,
                fromFactor, description);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exDate", exDate)
                .add("declaredDate", declaredDate)
                .add("ratio", ratio)
                .add("toFactor", toFactor)
                .add("fromFactor", fromFactor)
                .add("description", description)
                .toString();
    }

}

