package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"volume", "venue", "venueName", "date", "marketPercent",
        "avgMarketPercent"})
public class VenueVolume implements Serializable {

    private final BigDecimal volume;
    private final String venue;
    private final String venueName;
    private final LocalDate date;
    private final BigDecimal marketPercent;
    private final BigDecimal avgMarketPercent;

    @JsonCreator
    public VenueVolume(
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("venue") final String venue,
            @JsonProperty("venueName") final String venueName,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("marketPercent") final BigDecimal marketPercent,
            @JsonProperty("avgMarketPercent") final BigDecimal avgMarketPercent) {
        this.volume = volume;
        this.venue = venue;
        this.venueName = venueName;
        this.date = date;
        this.marketPercent = marketPercent;
        this.avgMarketPercent = avgMarketPercent;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public String getVenue() {
        return venue;
    }

    public String getVenueName() {
        return venueName;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getMarketPercent() {
        return marketPercent;
    }

    public BigDecimal getAvgMarketPercent() {
        return avgMarketPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenueVolume that = (VenueVolume) o;
        return Objects.equal(volume, that.volume) &&
                Objects.equal(venue, that.venue) &&
                Objects.equal(venueName, that.venueName) &&
                Objects.equal(date, that.date) &&
                Objects.equal(marketPercent, that.marketPercent) &&
                Objects.equal(avgMarketPercent, that.avgMarketPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(volume, venue, venueName, date, marketPercent, avgMarketPercent);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("volume", volume)
                .add("venue", venue)
                .add("venueName", venueName)
                .add("date", date)
                .add("marketPercent", marketPercent)
                .add("avgMarketPercent", avgMarketPercent)
                .toString();
    }
}
