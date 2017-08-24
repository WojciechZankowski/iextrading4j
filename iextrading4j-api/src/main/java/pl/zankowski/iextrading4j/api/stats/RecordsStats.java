package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class RecordsStats {

    private final Record volume;
    private final Record symbolsTraded;
    private final Record routedVolume;
    private final Record notional;

    @JsonCreator
    public RecordsStats(@JsonProperty("volume") Record volume,
                        @JsonProperty("symbolsTraded") Record symbolsTraded,
                        @JsonProperty("routedVolume") Record routedVolume,
                        @JsonProperty("notional") Record notional) {
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

        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (symbolsTraded != null ? !symbolsTraded.equals(that.symbolsTraded) : that.symbolsTraded != null)
            return false;
        if (routedVolume != null ? !routedVolume.equals(that.routedVolume) : that.routedVolume != null) return false;
        return notional != null ? notional.equals(that.notional) : that.notional == null;
    }

    @Override
    public int hashCode() {
        int result = volume != null ? volume.hashCode() : 0;
        result = 31 * result + (symbolsTraded != null ? symbolsTraded.hashCode() : 0);
        result = 31 * result + (routedVolume != null ? routedVolume.hashCode() : 0);
        result = 31 * result + (notional != null ? notional.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecordsStats{" +
                "volume=" + volume +
                ", symbolsTraded=" + symbolsTraded +
                ", routedVolume=" + routedVolume +
                ", notional=" + notional +
                '}';
    }

}
