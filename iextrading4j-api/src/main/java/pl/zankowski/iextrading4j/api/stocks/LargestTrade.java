package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@JsonPropertyOrder({"price", "size", "time", "timeLabel", "venue", "venueName"})
public class LargestTrade implements Serializable {

    private final BigDecimal price;
    private final BigDecimal size;
    private final Long time;
    private final LocalTime timeLabel;
    private final String venue;
    private final String venueName;

    @JsonCreator
    public LargestTrade(
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("size") final BigDecimal size,
            @JsonProperty("time") final Long time,
            @JsonProperty("timeLabel") final LocalTime timeLabel,
            @JsonProperty("venue") final String venue,
            @JsonProperty("venueName") final String venueName) {
        this.price = price;
        this.size = size;
        this.time = time;
        this.timeLabel = timeLabel;
        this.venue = venue;
        this.venueName = venueName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public Long getTime() {
        return time;
    }

    public LocalTime getTimeLabel() {
        return timeLabel;
    }

    public String getVenue() {
        return venue;
    }

    public String getVenueName() {
        return venueName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LargestTrade that = (LargestTrade) o;
        return Objects.equal(price, that.price) &&
                Objects.equal(size, that.size) &&
                Objects.equal(time, that.time) &&
                Objects.equal(timeLabel, that.timeLabel) &&
                Objects.equal(venue, that.venue) &&
                Objects.equal(venueName, that.venueName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, size, time, timeLabel, venue, venueName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("size", size)
                .add("time", time)
                .add("timeLabel", timeLabel)
                .add("venue", venue)
                .add("venueName", venueName)
                .toString();
    }
}
