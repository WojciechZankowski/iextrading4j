package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class IntradayStat implements Serializable {

    private static final long serialVersionUID = 2592939764468529774L;

    private final BigDecimal value;
    private final Long lastUpdated;

    @JsonCreator
    public IntradayStat(
            @JsonProperty("value") final BigDecimal value,
            @JsonProperty("lastUpdated") final Long lastUpdated) {
        this.value = value;
        this.lastUpdated = lastUpdated;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntradayStat that = (IntradayStat) o;
        return Objects.equal(value, that.value) &&
                Objects.equal(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, lastUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .add("lastUpdated", lastUpdated)
                .toString();
    }
}
