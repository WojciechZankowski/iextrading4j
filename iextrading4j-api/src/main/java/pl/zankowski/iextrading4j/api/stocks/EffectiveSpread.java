package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"volume", "venue", "venueName", "effectiveSpread", "effectiveQuoted", "priceImprovement"})
public class EffectiveSpread implements Serializable {

    private final BigDecimal volume;
    private final String venue;
    private final String venueName;
    private final BigDecimal effectiveSpread;
    private final BigDecimal effectiveQuoted;
    private final BigDecimal priceImprovement;

    @JsonCreator
    public EffectiveSpread(
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("venue") final String venue,
            @JsonProperty("venueName") final String venueName,
            @JsonProperty("effectiveSpread") final BigDecimal effectiveSpread,
            @JsonProperty("effectiveQuoted") final BigDecimal effectiveQuoted,
            @JsonProperty("priceImprovement") BigDecimal priceImprovement) {
        this.volume = volume;
        this.venue = venue;
        this.venueName = venueName;
        this.effectiveSpread = effectiveSpread;
        this.effectiveQuoted = effectiveQuoted;
        this.priceImprovement = priceImprovement;
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

    public BigDecimal getEffectiveSpread() {
        return effectiveSpread;
    }

    public BigDecimal getEffectiveQuoted() {
        return effectiveQuoted;
    }

    public BigDecimal getPriceImprovement() {
        return priceImprovement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EffectiveSpread that = (EffectiveSpread) o;
        return Objects.equal(volume, that.volume) &&
                Objects.equal(venue, that.venue) &&
                Objects.equal(venueName, that.venueName) &&
                Objects.equal(effectiveSpread, that.effectiveSpread) &&
                Objects.equal(effectiveQuoted, that.effectiveQuoted) &&
                Objects.equal(priceImprovement, that.priceImprovement);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(volume, venue, venueName, effectiveSpread,
                effectiveQuoted, priceImprovement);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("volume", volume)
                .add("venue", venue)
                .add("venueName", venueName)
                .add("effectiveSpread", effectiveSpread)
                .add("effectiveQuoted", effectiveQuoted)
                .add("priceImprovement", priceImprovement)
                .toString();
    }
}
