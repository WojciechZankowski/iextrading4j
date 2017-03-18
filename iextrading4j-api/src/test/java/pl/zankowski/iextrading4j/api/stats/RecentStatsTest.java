package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.RecentStatsDataBuilder.defaultRecentStats;

/**
 * @author Wojciech Zankowski
 */
public class RecentStatsTest {

    @Test
    public void shouldSuccessfullyCreateEmptyRecentStats() {
        RecentStats recentStats = new RecentStats();

        assertThat(recentStats.getDate()).isNull();
        assertThat(recentStats.getVolume()).isEqualTo(0L);
        assertThat(recentStats.getRoutedVolume()).isEqualTo(0L);
        assertThat(recentStats.getMarketShare()).isEqualTo(0d);
        assertThat(recentStats.isHalfday()).isFalse();
        assertThat(recentStats.getLitVolume()).isEqualTo(0L);
    }

    @Test
    public void shouldSuccessfullySetDataIntoRecentStats() {
        final LocalDate date = LocalDate.now();
        final long volume = 12345L;
        final long routedVolume = 123456L;
        final double marketShare = 32.43d;
        final boolean isHalfday = true;
        final long litVolume = 23412L;

        RecentStats recentStats = new RecentStats();
        recentStats.setDate(date);
        recentStats.setVolume(volume);
        recentStats.setRoutedVolume(routedVolume);
        recentStats.setMarketShare(marketShare);
        recentStats.setIsHalfday(isHalfday);
        recentStats.setLitVolume(litVolume);

        assertRecentStats(recentStats, date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

    @Test
    public void shouldSuccessfullyCreateRecentStats() {
        final LocalDate date = LocalDate.now();
        final long volume = 12345L;
        final long routedVolume = 123456L;
        final double marketShare = 32.43d;
        final boolean isHalfday = true;
        final long litVolume = 23412L;

        RecentStats recentStats = new RecentStats(date, volume, routedVolume, marketShare, isHalfday, litVolume);
        assertRecentStats(recentStats, date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

    @Test
    public void shouldSuccessfullyEqualTwoRecentStats() {
        RecentStats recentStats_1 = defaultRecentStats();
        RecentStats recentStats_2 = defaultRecentStats();

        assertThat(recentStats_1.equals(recentStats_2)).isTrue();
        assertThat(recentStats_1.hashCode()).isEqualTo(recentStats_2.hashCode());
    }

    private void assertRecentStats(RecentStats recentStats, LocalDate date, long volume, long routedVolume,
                                   double marketShare, boolean isHalfday, long litVolume) {
        assertThat(recentStats.getDate()).isEqualTo(date);
        assertThat(recentStats.getVolume()).isEqualTo(volume);
        assertThat(recentStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(recentStats.getMarketShare()).isEqualTo(marketShare);
        assertThat(recentStats.isHalfday()).isEqualTo(isHalfday);
        assertThat(recentStats.getLitVolume()).isEqualTo(litVolume);
    }

}
