package pl.zankowski.iextrading4j.api.system;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

@JsonPropertyOrder({"status", "version", "time", "currentMonthAPICalls"})
public class SystemStatus implements Serializable {

    private static final long serialVersionUID = 3320852096256614294L;

    private final String status;
    private final String version;
    private final Long time;
    private final BigDecimal currentMonthAPICalls;

    @JsonCreator
    public SystemStatus(
            @JsonProperty("status") final String status,
            @JsonProperty("version") final String version,
            @JsonProperty("time") final Long time,
            @JsonProperty("currentMonthAPICalls") final BigDecimal currentMonthAPICalls) {
        this.status = status;
        this.version = version;
        this.time = time;
        this.currentMonthAPICalls = currentMonthAPICalls;
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

    public BigDecimal getCurrentMonthAPICalls() {
        return currentMonthAPICalls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemStatus that = (SystemStatus) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(version, that.version) &&
                Objects.equals(time, that.time) &&
                Objects.equals(currentMonthAPICalls, that.currentMonthAPICalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, version, time, currentMonthAPICalls);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SystemStatus.class.getSimpleName() + "[", "]")
                .add("status='" + status + "'")
                .add("version='" + version + "'")
                .add("time=" + time)
                .add("currentMonthAPICalls=" + currentMonthAPICalls)
                .toString();
    }
}
