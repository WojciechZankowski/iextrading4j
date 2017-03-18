package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.RecentStats;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class RecentStatsDataBuilder {

    private LocalDate date = LocalDate.now();
    private long volume = 12345L;
    private long routedVolume = 123456L;
    private double marketShare = 32.43d;
    private boolean isHalfday = true;
    private long litVolume = 23412L;

    public static RecentStats defaultRecentStats() {
        return aRecentStats().build();
    }

    public static RecentStatsDataBuilder aRecentStats() {
        return new RecentStatsDataBuilder();
    }

    public RecentStatsDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public RecentStatsDataBuilder withVolume(long volume) {
        this.volume = volume;
        return this;
    }

    public RecentStatsDataBuilder withRoutedVolume(long routedVolume) {
        this.routedVolume = routedVolume;
        return this;
    }

    public RecentStatsDataBuilder withMarketShare(double marketShare) {
        this.marketShare = marketShare;
        return this;
    }

    public RecentStatsDataBuilder withHalfday(boolean isHalfday) {
        this.isHalfday = isHalfday;
        return this;
    }

    public RecentStatsDataBuilder withLitVolume(long litVolume) {
        this.litVolume = litVolume;
        return this;
    }

    public RecentStats build() {
        return new RecentStats(date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

}
