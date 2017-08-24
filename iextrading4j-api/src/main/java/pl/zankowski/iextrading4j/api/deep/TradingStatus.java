package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class TradingStatus {

    private final String status;
    private final String reason;
    private final long timestamp;

    @JsonCreator
    public TradingStatus(@JsonProperty("status") String status,
                         @JsonProperty("reason") String reason,
                         @JsonProperty("timestamp") long timestamp) {
        this.status = status;
        this.reason = reason;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradingStatus that = (TradingStatus) o;

        if (timestamp != that.timestamp) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return reason != null ? reason.equals(that.reason) : that.reason == null;

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TradingStatus{" +
                "status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
