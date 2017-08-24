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

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (routedVolume != null ? !routedVolume.equals(that.routedVolume) : that.routedVolume != null) return false;
        if (marketShare != null ? !marketShare.equals(that.marketShare) : that.marketShare != null) return false;
        if (isHalfday != null ? !isHalfday.equals(that.isHalfday) : that.isHalfday != null) return false;
        return litVolume != null ? litVolume.equals(that.litVolume) : that.litVolume == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (routedVolume != null ? routedVolume.hashCode() : 0);
        result = 31 * result + (marketShare != null ? marketShare.hashCode() : 0);
        result = 31 * result + (isHalfday != null ? isHalfday.hashCode() : 0);
        result = 31 * result + (litVolume != null ? litVolume.hashCode() : 0);
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
