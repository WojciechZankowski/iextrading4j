package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"date", "volume", "routedVolume", "marketShare", "isHalfday", "litVolume"})
public class RecentStats implements Serializable {

    private final LocalDate date;
    private final Long volume;
    private final Long routedVolume;
    private final Double marketShare;
    private final Boolean isHalfday;
    private final Long litVolume;

    @JsonCreator
    public RecentStats(@JsonProperty("date") final LocalDate date,
                       @JsonProperty("volume") final Long volume,
                       @JsonProperty("routedVolume") final Long routedVolume,
                       @JsonProperty("marketShare") final Double marketShare,
                       @JsonProperty("isHalfday") final Boolean isHalfday,
                       @JsonProperty("litVolume") final Long litVolume) {
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
        RecentStats that = (RecentStats) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(volume, that.volume) &&
                Objects.equal(routedVolume, that.routedVolume) &&
                Objects.equal(marketShare, that.marketShare) &&
                Objects.equal(isHalfday, that.isHalfday) &&
                Objects.equal(litVolume, that.litVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("volume", volume)
                .add("routedVolume", routedVolume)
                .add("marketShare", marketShare)
                .add("isHalfday", isHalfday)
                .add("litVolume", litVolume)
                .toString();
    }
}
