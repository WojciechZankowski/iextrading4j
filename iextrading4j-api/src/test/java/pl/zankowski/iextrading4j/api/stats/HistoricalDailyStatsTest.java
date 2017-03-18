package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.HistoricalDailyStatsDataBuilder.defaultHistoricalDailyStats;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalDailyStatsTest {

    @Test
    public void shouldSuccessfullyCreateEmptyHistoricalDailyStats() {
        HistoricalDailyStats historicalDailyStats = new HistoricalDailyStats();

        assertThat(historicalDailyStats.getDate()).isNull();
        assertThat(historicalDailyStats.getVolume()).isEqualTo(0L);
        assertThat(historicalDailyStats.getRoutedVolume()).isEqualTo(0L);
        assertThat(historicalDailyStats.getMarketShare()).isEqualTo(0d);
        assertThat(historicalDailyStats.isHalfday()).isFalse();
        assertThat(historicalDailyStats.getLitVolume()).isEqualTo(0L);
    }

    @Test
    public void shouldSuccessfullyCreateHistoricalDailyStats() {
        final LocalDate date = LocalDate.now();
        final long volume = 123L;
        final long routedVolume = 234L;
        final double marketShare = 53.12d;
        final boolean isHalfday = true;
        final long litVolume = 432L;

        HistoricalDailyStats historicalDailyStats = new HistoricalDailyStats(date, volume, routedVolume,
                marketShare, isHalfday, litVolume);

        assertHistoricalDailyStats(historicalDailyStats, date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

    @Test
    public void shouldSuccessfullySetDataIntoHistoricalDailyStats() {
        final LocalDate date = LocalDate.now();
        final long volume = 123L;
        final long routedVolume = 234L;
        final double marketShare = 53.12d;
        final boolean isHalfday = true;
        final long litVolume = 432L;

        HistoricalDailyStats historicalDailyStats = new HistoricalDailyStats();
        historicalDailyStats.setDate(date);
        historicalDailyStats.setVolume(volume);
        historicalDailyStats.setRoutedVolume(routedVolume);
        historicalDailyStats.setMarketShare(marketShare);
        historicalDailyStats.setIsHalfday(isHalfday);
        historicalDailyStats.setLitVolume(litVolume);

        assertHistoricalDailyStats(historicalDailyStats, date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

    @Test
    public void shouldSuccessfullyEqualTwoHistoricalDailyStats() {
        HistoricalDailyStats historicalDailyStats_1 = defaultHistoricalDailyStats();
        HistoricalDailyStats historicalDailyStats_2 = defaultHistoricalDailyStats();

        assertThat(historicalDailyStats_1.equals(historicalDailyStats_2)).isTrue();
        assertThat(historicalDailyStats_1.hashCode()).isEqualTo(historicalDailyStats_2.hashCode());
    }

    private void assertHistoricalDailyStats(HistoricalDailyStats historicalDailyStats, LocalDate date, long volume,
                                            long routedVolume, double marketShare, boolean isHalfday, long litVolume) {
        assertThat(historicalDailyStats.getDate()).isEqualTo(date);
        assertThat(historicalDailyStats.getVolume()).isEqualTo(volume);
        assertThat(historicalDailyStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(historicalDailyStats.getMarketShare()).isEqualTo(marketShare);
        assertThat(historicalDailyStats.isHalfday()).isEqualTo(isHalfday);
        assertThat(historicalDailyStats.getLitVolume()).isEqualTo(litVolume);
    }

}
