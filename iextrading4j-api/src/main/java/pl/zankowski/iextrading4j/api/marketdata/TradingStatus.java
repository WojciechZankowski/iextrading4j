package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonPropertyOrder({"status", "reason", "timestamp"})
public class TradingStatus extends DeepResult {

    private final TradingStatusType status;
    private final TradingStatusReasonType reason;
    private final Long timestamp;

    @JsonCreator
    public TradingStatus(
            @JsonProperty("status") final TradingStatusType status,
            @JsonProperty("reason") final TradingStatusReasonType reason,
            @JsonProperty("timestamp") final Long timestamp) {
        this.status = status;
        this.reason = reason;
        this.timestamp = timestamp;
    }

    public TradingStatusType getStatus() {
        return status;
    }

    public TradingStatusReasonType getReason() {
        return reason;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradingStatus that = (TradingStatus) o;
        return status == that.status &&
                reason == that.reason &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status, reason, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("reason", reason)
                .add("timestamp", timestamp)
                .toString();
    }
}
