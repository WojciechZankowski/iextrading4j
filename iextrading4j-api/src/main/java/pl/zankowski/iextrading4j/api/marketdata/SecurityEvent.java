package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"securityEvent", "timestamp"})
public class SecurityEvent implements Serializable {

    private final SecurityEventType securityEvent;
    private final long timestamp;

    @JsonCreator
    public SecurityEvent(@JsonProperty("securityEvent") final SecurityEventType securityEvent,
                         @JsonProperty("timestamp") final Long timestamp) {
        this.securityEvent = securityEvent;
        this.timestamp = timestamp;
    }

    public SecurityEventType getSecurityEvent() {
        return securityEvent;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityEvent that = (SecurityEvent) o;
        return timestamp == that.timestamp &&
                securityEvent == that.securityEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(securityEvent, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("securityEvent", securityEvent)
                .add("timestamp", timestamp)
                .toString();
    }
}
