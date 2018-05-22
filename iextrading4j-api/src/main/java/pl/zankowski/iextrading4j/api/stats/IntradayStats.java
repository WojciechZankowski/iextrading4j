package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"volume", "symbolsTraded", "routedVolume", "notional", "marketShare"})
public class IntradayStats implements Serializable {

    private final IntradayStat volume;
    private final IntradayStat symbolsTraded;
    private final IntradayStat routedVolume;
    private final IntradayStat notional;
    private final IntradayStat marketShare;

    @JsonCreator
    public IntradayStats(
            @JsonProperty("volume") final IntradayStat volume,
            @JsonProperty("symbolsTraded") final IntradayStat symbolsTraded,
            @JsonProperty("routedVolume") final IntradayStat routedVolume,
            @JsonProperty("notional") final IntradayStat notional,
            @JsonProperty("marketShare") final IntradayStat marketShare) {
        this.volume = volume;
        this.symbolsTraded = symbolsTraded;
        this.routedVolume = routedVolume;
        this.notional = notional;
        this.marketShare = marketShare;
    }

    public IntradayStat getVolume() {
        return volume;
    }

    public IntradayStat getSymbolsTraded() {
        return symbolsTraded;
    }

    public IntradayStat getRoutedVolume() {
        return routedVolume;
    }

    public IntradayStat getNotional() {
        return notional;
    }

    public IntradayStat getMarketShare() {
        return marketShare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntradayStats that = (IntradayStats) o;
        return Objects.equal(volume, that.volume) &&
                Objects.equal(symbolsTraded, that.symbolsTraded) &&
                Objects.equal(routedVolume, that.routedVolume) &&
                Objects.equal(notional, that.notional) &&
                Objects.equal(marketShare, that.marketShare);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(volume, symbolsTraded, routedVolume, notional, marketShare);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("volume", volume)
                .add("symbolsTraded", symbolsTraded)
                .add("routedVolume", routedVolume)
                .add("notional", notional)
                .add("marketShare", marketShare)
                .toString();
    }
}
