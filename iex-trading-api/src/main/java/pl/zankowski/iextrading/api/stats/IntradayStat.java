package pl.zankowski.iextrading.api.stats;

import java.math.BigDecimal;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStat {

    private BigDecimal value;
    private long lastUpdated;

    public IntradayStat() {}

    public IntradayStat(BigDecimal value, long lastUpdated) {
        this.value = value;

        this.lastUpdated = lastUpdated;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntradayStat that = (IntradayStat) o;

        if (lastUpdated != that.lastUpdated) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "IntradayStat{" +
                "value=" + value +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
