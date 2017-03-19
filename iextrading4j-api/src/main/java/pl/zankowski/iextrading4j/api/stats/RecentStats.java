package pl.zankowski.iextrading4j.api.stats;

import pl.zankowski.iextrading4j.api.util.DoubleUtil;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class RecentStats {

    private LocalDate date;
    private long volume;
    private long routedVolume;
    private double marketShare;
    private boolean isHalfday;
    private long litVolume;

    public RecentStats() {}

    public RecentStats(LocalDate date, long volume, long routedVolume, double marketShare, boolean isHalfday, long litVolume) {
        this.date = date;
        this.volume = volume;
        this.routedVolume = routedVolume;
        this.marketShare = marketShare;
        this.isHalfday = isHalfday;
        this.litVolume = litVolume;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getRoutedVolume() {
        return routedVolume;
    }

    public void setRoutedVolume(long routedVolume) {
        this.routedVolume = routedVolume;
    }

    public double getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(double marketShare) {
        this.marketShare = marketShare;
    }

    public boolean isHalfday() {
        return isHalfday;
    }

    public void setIsHalfday(boolean halfday) {
        isHalfday = halfday;
    }

    public long getLitVolume() {
        return litVolume;
    }

    public void setLitVolume(long litVolume) {
        this.litVolume = litVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecentStats that = (RecentStats) o;

        if (volume != that.volume) return false;
        if (routedVolume != that.routedVolume) return false;
        if (Double.compare(that.marketShare, marketShare) != 0) return false;
        if (isHalfday != that.isHalfday) return false;
        if (litVolume != that.litVolume) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        result = 31 * result + (int) (routedVolume ^ (routedVolume >>> 32));
        temp = Double.doubleToLongBits(marketShare);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isHalfday ? 1 : 0);
        result = 31 * result + (int) (litVolume ^ (litVolume >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RecentStats{" +
                "date=" + date +
                ", volume=" + volume +
                ", routedVolume=" + routedVolume +
                ", marketShare=" + DoubleUtil.printDouble(marketShare) +
                ", isHalfday=" + isHalfday +
                ", litVolume=" + litVolume +
                '}';
    }

}
