package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class SecurityEvent implements DeepResult {

    private static final long serialVersionUID = -2467665799653457170L;

    private final SecurityEventType securityEvent;
    private final Long timestamp;

    @JsonCreator
    public SecurityEvent(
            @JsonProperty("securityEvent") final SecurityEventType securityEvent,
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
        return securityEvent == that.securityEvent &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSecurityEvent(), getTimestamp());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("securityEvent", securityEvent)
                .add("timestamp", timestamp)
                .toString();
    }
}
