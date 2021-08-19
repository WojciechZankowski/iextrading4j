package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class SectorPerformance implements Serializable {

    private static final long serialVersionUID = 1840798428261698611L;

    private final String symbol;
    private final String type;
    private final String name;
    private final BigDecimal performance;
    private final Long lastUpdated;

    @JsonCreator
    public SectorPerformance(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("type") final String type,
            @JsonProperty("name") final String name,
            @JsonProperty("performance") final BigDecimal performance,
            @JsonProperty("lastUpdated") final Long lastUpdated) {
        this.symbol = symbol;
        this.type = type;
        this.name = name;
        this.performance = performance;
        this.lastUpdated = lastUpdated;
    }

    public String getSymbol() {
        return symbol;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SectorPerformance that = (SectorPerformance) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(type, that.type) &&
                Objects.equals(name, that.name) &&
                Objects.equals(performance, that.performance) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, type, name, performance, lastUpdated);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SectorPerformance.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("type='" + type + "'")
                .add("name='" + name + "'")
                .add("performance=" + performance)
                .add("lastUpdated=" + lastUpdated)
                .toString();
    }
}
