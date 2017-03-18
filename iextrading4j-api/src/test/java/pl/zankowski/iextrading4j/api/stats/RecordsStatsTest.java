package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.RecordsStatsDataBuilder.defaultRecordsStats;

/**
 * @author Wojciech Zankowski
 */
public class RecordsStatsTest {

    @Test
    public void shouldSuccessfullyCreateEmptyRecordsStats() {
        RecordsStats recordsStats = new RecordsStats();

        assertThat(recordsStats.getVolume()).isNull();
        assertThat(recordsStats.getSymbolsTraded()).isNull();
        assertThat(recordsStats.getRoutedVolume()).isNull();
        assertThat(recordsStats.getNotional()).isNull();
    }

    @Test
    public void shouldSuccessfullyCreateRecordsStats() {
        final Record volume = new Record(12d, LocalDate.now(), 11d, 10d);
        final Record symbolsTraded = new Record(23d, LocalDate.now(), 22d, 21d);
        final Record routedVolume = new Record(34d, LocalDate.now(), 32d, 31d);
        final Record notional = new Record(45d, LocalDate.now(), 43d, 42d);

        RecordsStats recordsStats = new RecordsStats(volume, symbolsTraded, routedVolume, notional);
        assertRecordsStats(recordsStats, volume, symbolsTraded, routedVolume, notional);
    }

    @Test
    public void shouldSuccessfullySetDataIntoEmptyRecordsStats() {
        final Record volume = new Record(12d, LocalDate.now(), 11d, 10d);
        final Record symbolsTraded = new Record(23d, LocalDate.now(), 22d, 21d);
        final Record routedVolume = new Record(34d, LocalDate.now(), 32d, 31d);
        final Record notional = new Record(45d, LocalDate.now(), 43d, 42d);

        RecordsStats recordsStats = new RecordsStats();
        recordsStats.setVolume(volume);
        recordsStats.setSymbolsTraded(symbolsTraded);
        recordsStats.setRoutedVolume(routedVolume);
        recordsStats.setNotional(notional);
        assertRecordsStats(recordsStats, volume, symbolsTraded, routedVolume, notional);
    }

    @Test
    public void shouldSuccessfullyEqualTwoRecordsStats() {
        RecordsStats recordsStats_1 = defaultRecordsStats();
        RecordsStats recordsStats_2 = defaultRecordsStats();

        assertThat(recordsStats_1.equals(recordsStats_2)).isTrue();
        assertThat(recordsStats_1.hashCode()).isEqualTo(recordsStats_2.hashCode());
    }

    private void assertRecordsStats(RecordsStats recordsStats, Record volume, Record symbolsTraded,
                                    Record routedVolume, Record notional) {
        assertThat(recordsStats.getVolume()).isEqualTo(volume);
        assertThat(recordsStats.getSymbolsTraded()).isEqualTo(symbolsTraded);
        assertThat(recordsStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(recordsStats.getNotional()).isEqualTo(notional);
    }

}
