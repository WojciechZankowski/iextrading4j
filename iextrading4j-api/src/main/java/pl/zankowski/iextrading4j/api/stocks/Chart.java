package pl.zankowski.iextrading4j.api.stocks;

/**
 * @author Wojciech Zankowski
 */
public class Chart {

    private String minute;
    private double average;
    private double notional;
    private long numberOfTrades;
    private double high;
    private double low;
    private long volume;
    private String date;
    private double open;
    private double close;
    private double unadjustedClose;
    private long unadjustedVolume;
    private double change;
    private double changePercent;
    private double vwap;
    private String label;
    private double changeOverTime;

    public Chart() {
    }

    public Chart(String minute, double average, double notional, long numberOfTrades, double high, double low, long volume, String date, double open, double close, double unadjustedClose, long unadjustedVolume, double change, double changePercent, double vwap, String label, double changeOverTime) {
        this.minute = minute;
        this.average = average;
        this.notional = notional;
        this.numberOfTrades = numberOfTrades;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.date = date;
        this.open = open;
        this.close = close;
        this.unadjustedClose = unadjustedClose;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.vwap = vwap;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getNotional() {
        return notional;
    }

    public void setNotional(double notional) {
        this.notional = notional;
    }

    public long getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(long numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getUnadjustedClose() {
        return unadjustedClose;
    }

    public void setUnadjustedClose(double unadjustedClose) {
        this.unadjustedClose = unadjustedClose;
    }

    public long getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public void setUnadjustedVolume(long unadjustedVolume) {
        this.unadjustedVolume = unadjustedVolume;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public double getVwap() {
        return vwap;
    }

    public void setVwap(double vwap) {
        this.vwap = vwap;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getChangeOverTime() {
        return changeOverTime;
    }

    public void setChangeOverTime(double changeOverTime) {
        this.changeOverTime = changeOverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chart chart = (Chart) o;

        if (Double.compare(chart.average, average) != 0) return false;
        if (Double.compare(chart.notional, notional) != 0) return false;
        if (numberOfTrades != chart.numberOfTrades) return false;
        if (Double.compare(chart.high, high) != 0) return false;
        if (Double.compare(chart.low, low) != 0) return false;
        if (volume != chart.volume) return false;
        if (Double.compare(chart.open, open) != 0) return false;
        if (Double.compare(chart.close, close) != 0) return false;
        if (Double.compare(chart.unadjustedClose, unadjustedClose) != 0) return false;
        if (unadjustedVolume != chart.unadjustedVolume) return false;
        if (Double.compare(chart.change, change) != 0) return false;
        if (Double.compare(chart.changePercent, changePercent) != 0) return false;
        if (Double.compare(chart.vwap, vwap) != 0) return false;
        if (Double.compare(chart.changeOverTime, changeOverTime) != 0) return false;
        if (minute != null ? !minute.equals(chart.minute) : chart.minute != null) return false;
        if (date != null ? !date.equals(chart.date) : chart.date != null) return false;
        return label != null ? label.equals(chart.label) : chart.label == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = minute != null ? minute.hashCode() : 0;
        temp = Double.doubleToLongBits(average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(notional);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (numberOfTrades ^ (numberOfTrades >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(open);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(close);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(unadjustedClose);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (unadjustedVolume ^ (unadjustedVolume >>> 32));
        temp = Double.doubleToLongBits(change);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(changePercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vwap);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (label != null ? label.hashCode() : 0);
        temp = Double.doubleToLongBits(changeOverTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "minute='" + minute + '\'' +
                ", average=" + average +
                ", notional=" + notional +
                ", numberOfTrades=" + numberOfTrades +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", unadjustedClose=" + unadjustedClose +
                ", unadjustedVolume=" + unadjustedVolume +
                ", change=" + change +
                ", changePercent=" + changePercent +
                ", vwap=" + vwap +
                ", label='" + label + '\'' +
                ", changeOverTime=" + changeOverTime +
                '}';
    }

}
