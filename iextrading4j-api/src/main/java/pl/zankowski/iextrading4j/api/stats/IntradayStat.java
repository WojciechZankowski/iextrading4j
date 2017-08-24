package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStat {

    private final double value;
    private final long lastUpdated;

    @JsonCreator
    public IntradayStat(@JsonProperty("value") double value,
                        @JsonProperty("lastUpdated") long lastUpdated) {
        this.value = value;
        this.lastUpdated = lastUpdated;
    }

    public double getValue() {
        return value;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntradayStat that = (IntradayStat) o;

        if (Double.compare(that.value, value) != 0) return false;
        return lastUpdated == that.lastUpdated;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "IntradayStat{" +
                "value=" + DoubleUtil.printDouble(value) +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
