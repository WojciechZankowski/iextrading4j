package pl.zankowski.iextrading4j.api.stats;

/**
 * @author Wojciech Zankowski
 */
public class RecordsStats {

    private Record volume;
    private Record symbolsTraded;
    private Record routedVolume;
    private Record notional;

    public RecordsStats() {}

    public RecordsStats(Record volume, Record symbolsTraded, Record routedVolume, Record notional) {
        this.volume = volume;
        this.symbolsTraded = symbolsTraded;
        this.routedVolume = routedVolume;
        this.notional = notional;
    }

    public Record getVolume() {
        return volume;
    }

    public void setVolume(Record volume) {
        this.volume = volume;
    }

    public Record getSymbolsTraded() {
        return symbolsTraded;
    }

    public void setSymbolsTraded(Record symbolsTraded) {
        this.symbolsTraded = symbolsTraded;
    }

    public Record getRoutedVolume() {
        return routedVolume;
    }

    public void setRoutedVolume(Record routedVolume) {
        this.routedVolume = routedVolume;
    }

    public Record getNotional() {
        return notional;
    }

    public void setNotional(Record notional) {
        this.notional = notional;
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
