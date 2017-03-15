package pl.zankowski.iextrading4j.api.stats;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStat {

    private double value;
    private long lastUpdated;

    public IntradayStat() {}

    public IntradayStat(double value, long lastUpdated) {
        this.value = value;

        this.lastUpdated = lastUpdated;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
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
                "value=" + value +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
