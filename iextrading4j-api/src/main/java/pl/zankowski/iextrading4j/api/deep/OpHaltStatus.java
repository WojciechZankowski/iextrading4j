package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class OpHaltStatus {

    private final boolean isHalted;
    private final long timestamp;

    @JsonCreator
    public OpHaltStatus(@JsonProperty("isHalted") boolean isHalted,
                        @JsonProperty("timestamp") long timestamp) {
        this.isHalted = isHalted;
        this.timestamp = timestamp;
    }

    public boolean isHalted() {
        return isHalted;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpHaltStatus that = (OpHaltStatus) o;

        if (isHalted != that.isHalted) return false;
        return timestamp == that.timestamp;

    }

    @Override
    public int hashCode() {
        int result = (isHalted ? 1 : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "OpHaltStatus{" +
                "isHalted=" + isHalted +
                ", timestamp=" + timestamp +
                '}';
    }

}
