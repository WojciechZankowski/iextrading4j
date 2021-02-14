package pl.zankowski.iextrading4j.api.datapoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;
import static pl.zankowski.iextrading4j.api.util.MapUtil.immutableMap;

public class TimeSeriesSchema implements Serializable {

    private static final long serialVersionUID = 925614403539934677L;

    private final String type;
    private final Map<String, FieldMetadata> properties;
    private final List<String> required;
    private final boolean additionalProperties;

    @JsonCreator
    public TimeSeriesSchema(
            @JsonProperty("type") final String type,
            @JsonProperty("properties") final Map<String, FieldMetadata> properties,
            @JsonProperty("required") final List<String> required,
            @JsonProperty("additionalProperties") final boolean additionalProperties) {
        this.type = type;
        this.properties = immutableMap(properties);
        this.required = immutableList(required);
        this.additionalProperties = additionalProperties;
    }

    public String getType() {
        return type;
    }

    public Map<String, FieldMetadata> getProperties() {
        return properties;
    }

    public List<String> getRequired() {
        return required;
    }

    public boolean isAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TimeSeriesSchema that = (TimeSeriesSchema) o;
        return additionalProperties == that.additionalProperties &&
                Objects.equal(type, that.type) &&
                Objects.equal(properties, that.properties) &&
                Objects.equal(required, that.required);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, properties, required, additionalProperties);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("properties", properties)
                .add("required", required)
                .add("additionalProperties", additionalProperties)
                .toString();
    }

}
