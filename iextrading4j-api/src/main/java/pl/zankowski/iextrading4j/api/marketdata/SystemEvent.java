package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"systemEvent", "timestamp"})
public class SystemEvent implements Serializable {

    private final SystemEventType systemEvent;
    private final long timestamp;

    @JsonCreator
    public SystemEvent(@JsonProperty("systemEvent") final Character systemEvent,
                       @JsonProperty("timestamp") final Long timestamp) {
        this.systemEvent = SystemEventType.getSystemEventType(systemEvent);
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
        return timestamp == that.timestamp &&
                systemEvent == that.systemEvent;
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
