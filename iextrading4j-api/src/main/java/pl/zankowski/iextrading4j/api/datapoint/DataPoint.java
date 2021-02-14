package pl.zankowski.iextrading4j.api.datapoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DataPoint implements Serializable {

    private static final long serialVersionUID = 1943500259622072479L;

    private final String key;
    private final BigDecimal weight;
    private final String description;
    private final OffsetDateTime lastUpdated;

    @JsonCreator
    public DataPoint(
            @JsonProperty("key") final String key,
            @JsonProperty("weight") final BigDecimal weight,
            @JsonProperty("description") final String description,
            @JsonProperty("lastUpdated") final OffsetDateTime lastUpdated) {
        this.key = key;
        this.weight = weight;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public String getKey() {
        return key;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DataPoint dataPoint = (DataPoint) o;
        return Objects.equal(key, dataPoint.key) &&
                Objects.equal(weight, dataPoint.weight) &&
                Objects.equal(description, dataPoint.description) &&
                Objects.equal(lastUpdated, dataPoint.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key, weight, description, lastUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("weight", weight)
                .add("description", description)
                .add("lastUpdated", lastUpdated)
                .toString();
    }

}
