package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class SsrStatus {

    private final boolean isSSR;
    private final String detail;
    private final long timestamp;

    @JsonCreator
    public SsrStatus(@JsonProperty("isSSR") boolean isSSR,
                     @JsonProperty("detail") String detail,
                     @JsonProperty("timestamp") long timestamp) {
        this.isSSR = isSSR;
        this.detail = detail;
        this.timestamp = timestamp;
    }

    public boolean isSSR() {
        return isSSR;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsrStatus ssrStatus = (SsrStatus) o;

        if (isSSR != ssrStatus.isSSR) return false;
        if (timestamp != ssrStatus.timestamp) return false;
        return detail != null ? detail.equals(ssrStatus.detail) : ssrStatus.detail == null;

    }

    @Override
    public int hashCode() {
        int result = (isSSR ? 1 : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SsrStatus{" +
                "isSSR=" + isSSR +
                ", detail='" + detail + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
