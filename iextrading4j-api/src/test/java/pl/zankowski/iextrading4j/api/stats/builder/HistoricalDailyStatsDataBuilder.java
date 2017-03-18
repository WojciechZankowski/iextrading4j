package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.HistoricalDailyStats;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalDailyStatsDataBuilder {

    private LocalDate date = LocalDate.now();
    private long volume = 123L;
    private long routedVolume = 234L;
    private double marketShare = 53.12d;
    private boolean isHalfday = true;
    private long litVolume = 432L;

    public static HistoricalDailyStats defaultHistoricalDailyStats() {
        return aHistoricalDailyStats().build();
    }

    public static HistoricalDailyStatsDataBuilder aHistoricalDailyStats() {
        return new HistoricalDailyStatsDataBuilder();
    }

    public HistoricalDailyStatsDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public HistoricalDailyStatsDataBuilder withVolume(long volume) {
        this.volume = volume;
        return this;
    }

    public HistoricalDailyStatsDataBuilder withRoutedVolume(long routedVolume) {
        this.routedVolume = routedVolume;
        return this;
    }

    public HistoricalDailyStatsDataBuilder withMarketShare(double marketShare) {
        this.marketShare = marketShare;
        return this;
    }

    public HistoricalDailyStatsDataBuilder withHalfday(boolean halfday) {
        this.isHalfday = halfday;
        return this;
    }

    public HistoricalDailyStatsDataBuilder withLitVolume(long litVolume) {
        this.litVolume = litVolume;
        return this;
    }

    public HistoricalDailyStats build() {
        return new HistoricalDailyStats(date, volume, routedVolume, marketShare, isHalfday, litVolume);
    }

}
