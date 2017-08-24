package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.util.DoubleUtil;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalDailyStats {

    private final LocalDate date;
    private final Long volume;
    private final Long routedVolume;
    private final Double marketShare;
    private final Boolean isHalfday;
    private final Long litVolume;

    @JsonCreator
    public HistoricalDailyStats(@JsonProperty("date") LocalDate date,
                                @JsonProperty("volume") Long volume,
                                @JsonProperty("routedVolume") Long routedVolume,
                                @JsonProperty("marketShare") Double marketShare,
                                @JsonProperty("isHalfday") Boolean isHalfday,
                                @JsonProperty("litVolume") Long litVolume) {
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

    public Long getVolume() {
        return volume;
    }

    public Long getRoutedVolume() {
        return routedVolume;
    }

    public Double getMarketShare() {
        return marketShare;
    }

    public Boolean isHalfday() {
        return isHalfday;
    }

    public Long getLitVolume() {
        return litVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoricalDailyStats that = (HistoricalDailyStats) o;

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
        return "HistoricalDailyStats{" +
                "date=" + date +
                ", volume=" + volume +
                ", routedVolume=" + routedVolume +
                ", marketShare=" + DoubleUtil.printDouble(marketShare) +
                ", isHalfday=" + isHalfday +
                ", litVolume=" + litVolume +
                '}';
    }

}
