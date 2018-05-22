package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"volume", "symbolsTraded", "routedVolume", "notional"})
public class RecordsStats implements Serializable {

    private final Record volume;
    private final Record symbolsTraded;
    private final Record routedVolume;
    private final Record notional;

    @JsonCreator
    public RecordsStats(
            @JsonProperty("volume") final Record volume,
            @JsonProperty("symbolsTraded") final Record symbolsTraded,
            @JsonProperty("routedVolume") final Record routedVolume,
            @JsonProperty("notional") final Record notional) {
        this.volume = volume;
        this.symbolsTraded = symbolsTraded;
        this.routedVolume = routedVolume;
        this.notional = notional;
    }

    public Record getVolume() {
        return volume;
    }

    public Record getSymbolsTraded() {
        return symbolsTraded;
    }

    public Record getRoutedVolume() {
        return routedVolume;
    }

    public Record getNotional() {
        return notional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordsStats that = (RecordsStats) o;
        return Objects.equal(volume, that.volume) &&
                Objects.equal(symbolsTraded, that.symbolsTraded) &&
                Objects.equal(routedVolume, that.routedVolume) &&
                Objects.equal(notional, that.notional);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(volume, symbolsTraded, routedVolume, notional);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("volume", volume)
                .add("symbolsTraded", symbolsTraded)
                .add("routedVolume", routedVolume)
                .add("notional", notional)
                .toString();
    }
}
