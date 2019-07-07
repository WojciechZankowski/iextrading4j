package pl.zankowski.iextrading4j.api.system;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"status", "version", "time"})
public class SystemStatus implements Serializable {

    private static final long serialVersionUID = 3320852096256614294L;

    private final String status;
    private final String version;
    private final Long time;

    @JsonCreator
    public SystemStatus(
            @JsonProperty("status") final String status,
            @JsonProperty("version") final String version,
            @JsonProperty("time") final Long time) {
        this.status = status;
        this.version = version;
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public String getVersion() {
        return version;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SystemStatus systemStatus1 = (SystemStatus) o;
        return Objects.equal(status, systemStatus1.status) &&
                Objects.equal(version, systemStatus1.version) &&
                Objects.equal(time, systemStatus1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status, version, time);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("version", version)
                .add("time", time)
                .toString();
    }

}
