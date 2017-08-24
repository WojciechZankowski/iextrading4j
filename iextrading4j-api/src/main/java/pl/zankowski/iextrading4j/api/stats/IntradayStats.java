package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStats {

    private final IntradayStat volume;
    private final IntradayStat symbolsTraded;
    private final IntradayStat routedVolume;
    private final IntradayStat notional;
    private final IntradayStat marketShare;

    @JsonCreator
    public IntradayStats(@JsonProperty("volume") IntradayStat volume,
                         @JsonProperty("symbolsTraded") IntradayStat symbolsTraded,
                         @JsonProperty("routedVolume") IntradayStat routedVolume,
                         @JsonProperty("notional") IntradayStat notional,
                         @JsonProperty("marketShare") IntradayStat marketShare) {
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

        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (symbolsTraded != null ? !symbolsTraded.equals(that.symbolsTraded) : that.symbolsTraded != null)
            return false;
        if (routedVolume != null ? !routedVolume.equals(that.routedVolume) : that.routedVolume != null) return false;
        if (notional != null ? !notional.equals(that.notional) : that.notional != null) return false;
        return marketShare != null ? marketShare.equals(that.marketShare) : that.marketShare == null;
    }

    @Override
    public int hashCode() {
        int result = volume != null ? volume.hashCode() : 0;
        result = 31 * result + (symbolsTraded != null ? symbolsTraded.hashCode() : 0);
        result = 31 * result + (routedVolume != null ? routedVolume.hashCode() : 0);
        result = 31 * result + (notional != null ? notional.hashCode() : 0);
        result = 31 * result + (marketShare != null ? marketShare.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IntradayStats{" +
                "volume=" + volume +
                ", symbolsTraded=" + symbolsTraded +
                ", routedVolume=" + routedVolume +
                ", notional=" + notional +
                ", marketShare=" + marketShare +
                '}';
    }

}
