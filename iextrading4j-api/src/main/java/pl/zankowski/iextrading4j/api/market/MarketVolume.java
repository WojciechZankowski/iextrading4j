package pl.zankowski.iextrading4j.api.market;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"mic", "tapeId", "venueName", "volume", "tapeA", "tapeB",
        "tapeC", "marketPercent", "lastUpdated"})
public class MarketVolume implements Serializable {

    private final String mic;
    private final String tapeId;
    private final String venueName;
    private final BigDecimal volume;
    private final BigDecimal tapeA;
    private final BigDecimal tapeB;
    private final BigDecimal tapeC;
    private final BigDecimal marketPercent;
    private final Long lastUpdated;

    @JsonCreator
    public MarketVolume(
            @JsonProperty("mic") final String mic,
            @JsonProperty("tapeId") final String tapeId,
            @JsonProperty("venueName") final String venueName,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("tapeA") final BigDecimal tapeA,
            @JsonProperty("tapeB") final BigDecimal tapeB,
            @JsonProperty("tapeC") final BigDecimal tapeC,
            @JsonProperty("marketPercent") final BigDecimal marketPercent,
            @JsonProperty("lastUpdated") final Long lastUpdated) {
        this.mic = mic;
        this.tapeId = tapeId;
        this.venueName = venueName;
        this.volume = volume;
        this.tapeA = tapeA;
        this.tapeB = tapeB;
        this.tapeC = tapeC;
        this.marketPercent = marketPercent;
        this.lastUpdated = lastUpdated;
    }

    public String getMic() {
        return mic;
    }

    public String getTapeId() {
        return tapeId;
    }

    public String getVenueName() {
        return venueName;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getTapeA() {
        return tapeA;
    }

    public BigDecimal getTapeB() {
        return tapeB;
    }

    public BigDecimal getTapeC() {
        return tapeC;
    }

    public BigDecimal getMarketPercent() {
        return marketPercent;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketVolume that = (MarketVolume) o;
        return Objects.equal(mic, that.mic) &&
                Objects.equal(tapeId, that.tapeId) &&
                Objects.equal(venueName, that.venueName) &&
                Objects.equal(volume, that.volume) &&
                Objects.equal(tapeA, that.tapeA) &&
                Objects.equal(tapeB, that.tapeB) &&
                Objects.equal(tapeC, that.tapeC) &&
                Objects.equal(marketPercent, that.marketPercent) &&
                Objects.equal(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mic, tapeId, venueName, volume, tapeA, tapeB,
                tapeC, marketPercent, lastUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mic", mic)
                .add("tapeId", tapeId)
                .add("venueName", venueName)
                .add("volume", volume)
                .add("tapeA", tapeA)
                .add("tapeB", tapeB)
                .add("tapeC", tapeC)
                .add("marketPercent", marketPercent)
                .add("lastUpdated", lastUpdated)
                .toString();
    }
}
