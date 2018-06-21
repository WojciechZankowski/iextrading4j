package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonPropertyOrder({"isSSR", "detail", "timestamp"})
public class SsrStatus extends DeepResult {

    private final Boolean isSSR;
    private final String detail;
    private final Long timestamp;

    @JsonCreator
    public SsrStatus(
            @JsonProperty("isSSR") final Boolean isSSR,
            @JsonProperty("detail") final String detail,
            @JsonProperty("timestamp") final Long timestamp) {
        this.isSSR = isSSR;
        this.detail = detail;
        this.timestamp = timestamp;
    }

    public Boolean isSSR() {
        return isSSR;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsrStatus ssrStatus = (SsrStatus) o;
        return Objects.equal(isSSR, ssrStatus.isSSR) &&
                Objects.equal(detail, ssrStatus.detail) &&
                Objects.equal(timestamp, ssrStatus.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isSSR, detail, timestamp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("isSSR", isSSR)
                .add("detail", detail)
                .add("timestamp", timestamp)
                .toString();
    }
}
