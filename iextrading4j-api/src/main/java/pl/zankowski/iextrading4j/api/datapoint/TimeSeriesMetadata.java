package pl.zankowski.iextrading4j.api.datapoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TimeSeriesMetadata implements Serializable {

    private static final long serialVersionUID = -6089147392234388332L;

    private final String id;
    private final String description;
    private final TimeSeriesSchema schema;
    private final String weightKey;
    private final BigDecimal weight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime lastUpdated;

    @JsonCreator
    public TimeSeriesMetadata(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("schema") final TimeSeriesSchema schema,
            @JsonProperty("weightKey") final String weightKey,
            @JsonProperty("weight") final BigDecimal weight,
            @JsonProperty("created") final LocalDateTime created,
            @JsonProperty("lastUpdated") final LocalDateTime lastUpdated) {
        this.id = id;
        this.description = description;
        this.schema = schema;
        this.weightKey = weightKey;
        this.weight = weight;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TimeSeriesSchema getSchema() {
        return schema;
    }

    public String getWeightKey() {
        return weightKey;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastUpdated() {
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
        final TimeSeriesMetadata that = (TimeSeriesMetadata) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(description, that.description) &&
                Objects.equal(schema, that.schema) &&
                Objects.equal(weightKey, that.weightKey) &&
                Objects.equal(weight, that.weight) &&
                Objects.equal(created, that.created) &&
                Objects.equal(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, description, schema, weightKey, weight, created, lastUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("description", description)
                .add("schema", schema)
                .add("weightKey", weightKey)
                .add("weight", weight)
                .add("created", created)
                .add("lastUpdated", lastUpdated)
                .toString();
    }

}
