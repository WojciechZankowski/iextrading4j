package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonPropertyOrder({"isHalted", "timestamp"})
public class OpHaltStatus extends DeepResult {

    private final Boolean isHalted;
    private final Long timestamp;

    @JsonCreator
    public OpHaltStatus(
            @JsonProperty("isHalted") final Boolean isHalted,
            @JsonProperty("timestamp") final Long timestamp) {
        this.isHalted = isHalted;
        this.timestamp = timestamp;
    }

    public Boolean isHalted() {
        return isHalted;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpHaltStatus that = (OpHaltStatus) o;
        return Objects.equal(isHalted, that.isHalted) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isHalted, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("isHalted", isHalted)
                .add("timestamp", timestamp)
                .toString();
    }
}
