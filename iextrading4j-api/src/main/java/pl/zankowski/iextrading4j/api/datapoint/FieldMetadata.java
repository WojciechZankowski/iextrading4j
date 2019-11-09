package pl.zankowski.iextrading4j.api.datapoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"type"})
public class FieldMetadata implements Serializable {

    private static final long serialVersionUID = -4105749852777766636L;

    private final String type;

    @JsonCreator
    public FieldMetadata(
            @JsonProperty("type") final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FieldMetadata that = (FieldMetadata) o;
        return Objects.equal(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .toString();
    }

}
