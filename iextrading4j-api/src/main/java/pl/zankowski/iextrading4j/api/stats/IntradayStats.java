package pl.zankowski.iextrading4j.api.stats;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStats {

    private IntradayStat volume;
    private IntradayStat symbolsTraded;
    private IntradayStat routedVolume;
    private IntradayStat notional;
    private IntradayStat marketShare;

    public IntradayStats() {}

    public IntradayStats(IntradayStat volume, IntradayStat symbolsTraded, IntradayStat routedVolume, IntradayStat notional, IntradayStat marketShare) {
        this.volume = volume;

        this.symbolsTraded = symbolsTraded;
        this.routedVolume = routedVolume;
        this.notional = notional;
        this.marketShare = marketShare;
    }

    public IntradayStat getVolume() {
        return volume;
    }

    public void setVolume(IntradayStat volume) {
        this.volume = volume;
    }

    public IntradayStat getSymbolsTraded() {
        return symbolsTraded;
    }

    public void setSymbolsTraded(IntradayStat symbolsTraded) {
        this.symbolsTraded = symbolsTraded;
    }

    public IntradayStat getRoutedVolume() {
        return routedVolume;
    }

    public void setRoutedVolume(IntradayStat routedVolume) {
        this.routedVolume = routedVolume;
    }

    public IntradayStat getNotional() {
        return notional;
    }

    public void setNotional(IntradayStat notional) {
        this.notional = notional;
    }

    public IntradayStat getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(IntradayStat marketShare) {
        this.marketShare = marketShare;
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
