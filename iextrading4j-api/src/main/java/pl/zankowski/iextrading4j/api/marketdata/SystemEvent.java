package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class SystemEvent extends DeepResult {

    private static final long serialVersionUID = -726343172725796350L;

    private final SystemEventType systemEvent;
    private final Long timestamp;

    @JsonCreator
    public SystemEvent(
            @JsonProperty("systemEvent") final SystemEventType systemEvent,
            @JsonProperty("timestamp") final Long timestamp) {
        this.systemEvent = systemEvent;
        this.timestamp = timestamp;
    }

    public SystemEventType getSystemEvent() {
        return systemEvent;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEvent that = (SystemEvent) o;
        return systemEvent == that.systemEvent &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(systemEvent, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("systemEvent", systemEvent)
                .add("timestamp", timestamp)
                .toString();
    }
}
