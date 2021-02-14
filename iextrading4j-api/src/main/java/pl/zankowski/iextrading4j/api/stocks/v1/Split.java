package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Split implements Serializable {

    private static final long serialVersionUID = -6189411289398426730L;

    private final LocalDate exDate;
    private final LocalDate declaredDate;
    private final BigDecimal ratio;
    private final BigDecimal toFactor;
    private final BigDecimal fromFactor;
    private final String description;
    private final LocalDate date;

    @JsonCreator
    public Split(
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("declaredDate") final LocalDate declaredDate,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("fromFactor") final BigDecimal fromFactor,
            @JsonProperty("description") final String description,
            @JsonProperty("date") final LocalDate date) {
        this.exDate = exDate;
        this.declaredDate = declaredDate;
        this.ratio = ratio;
        this.toFactor = toFactor;
        this.fromFactor = fromFactor;
        this.description = description;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Split split = (Split) o;
        return Objects.equals(exDate, split.exDate) &&
                Objects.equals(declaredDate, split.declaredDate) &&
                Objects.equals(ratio, split.ratio) &&
                Objects.equals(toFactor, split.toFactor) &&
                Objects.equals(fromFactor, split.fromFactor) &&
                Objects.equals(description, split.description) &&
                Objects.equals(date, split.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exDate, declaredDate, ratio, toFactor, fromFactor,
                description, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Split.class.getSimpleName() + "[", "]")
                .add("exDate=" + exDate)
                .add("declaredDate=" + declaredDate)
                .add("ratio=" + ratio)
                .add("toFactor=" + toFactor)
                .add("fromFactor=" + fromFactor)
                .add("description='" + description + "'")
                .add("date=" + date)
                .toString();
    }
}

