package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"type", "name", "performance", "lastUpdated"})
public class SectorPerformance implements Serializable {

    private final String type;
    private final String name;
    private final BigDecimal performance;
    private final Long lastUpdated;

    @JsonCreator
    public SectorPerformance(
            @JsonProperty("type") final String type,
            @JsonProperty("name") final String name,
            @JsonProperty("performance") final BigDecimal performance,
            @JsonProperty("lastUpdated") final Long lastUpdated) {
        this.type = type;
        this.name = name;
        this.performance = performance;
        this.lastUpdated = lastUpdated;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SectorPerformance that = (SectorPerformance) o;
        return Objects.equal(type, that.type) &&
                Objects.equal(name, that.name) &&
                Objects.equal(performance, that.performance) &&
                Objects.equal(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, name, performance, lastUpdated);
    }

    @Override
    public String toString() {
        return "SectorPerformance{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", performance=" + performance +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
