package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.Record;
import pl.zankowski.iextrading4j.api.stats.RecordsStats;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class RecordsStatsDataBuilder {

    private Record volume = new Record(12d, LocalDate.now(), 11d, 10d);
    private Record symbolsTraded = new Record(23d, LocalDate.now(), 22d, 21d);
    private Record routedVolume = new Record(34d, LocalDate.now(), 32d, 31d);
    private Record notional = new Record(45d, LocalDate.now(), 43d, 42d);

    public static RecordsStats defaultRecordsStats() {
        return aRecordsStats().build();
    }

    public static RecordsStatsDataBuilder aRecordsStats() {
        return new RecordsStatsDataBuilder();
    }

    public RecordsStatsDataBuilder withVolume(Record volume) {
        this.volume = volume;
        return this;
    }

    public RecordsStatsDataBuilder withSymbolsTraded(Record symbolsTraded) {
        this.symbolsTraded = symbolsTraded;
        return this;
    }

    public RecordsStatsDataBuilder withRoutedVolume(Record routedVolume) {
        this.routedVolume = routedVolume;
        return this;
    }

    public RecordsStatsDataBuilder withNotional(Record notional) {
        this.notional = notional;
        return this;
    }

    public RecordsStats build() {
        return new RecordsStats(volume, symbolsTraded, routedVolume, notional);
    }

}
