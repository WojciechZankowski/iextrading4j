package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class SecurityEvent {

    private final String securityEvent;
    private final long timestamp;

    @JsonCreator
    public SecurityEvent(@JsonProperty("securityEvent") String securityEvent,
                         @JsonProperty("timestamp") long timestamp) {
        this.securityEvent = securityEvent;
        this.timestamp = timestamp;
    }

    public String getSecurityEvent() {
        return securityEvent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecurityEvent that = (SecurityEvent) o;

        if (timestamp != that.timestamp) return false;
        return securityEvent != null ? securityEvent.equals(that.securityEvent) : that.securityEvent == null;

    }

    @Override
    public int hashCode() {
        int result = securityEvent != null ? securityEvent.hashCode() : 0;
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SecurityEvent{" +
                "securityEvent='" + securityEvent + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
