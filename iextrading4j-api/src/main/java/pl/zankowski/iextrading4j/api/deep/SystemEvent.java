package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class SystemEvent {

    private final String systemEvent;
    private final long timestmap;

    @JsonCreator
    public SystemEvent(@JsonProperty("systemEvent") String systemEvent,
                       @JsonProperty("timestamp") long timestmap) {
        this.systemEvent = systemEvent;
        this.timestmap = timestmap;
    }

    public String getSystemEvent() {
        return systemEvent;
    }

    public long getTimestmap() {
        return timestmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemEvent that = (SystemEvent) o;

        if (timestmap != that.timestmap) return false;
        return systemEvent != null ? systemEvent.equals(that.systemEvent) : that.systemEvent == null;

    }

    @Override
    public int hashCode() {
        int result = systemEvent != null ? systemEvent.hashCode() : 0;
        result = 31 * result + (int) (timestmap ^ (timestmap >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SystemEvent{" +
                "systemEvent='" + systemEvent + '\'' +
                ", timestmap=" + timestmap +
                '}';
    }
}
