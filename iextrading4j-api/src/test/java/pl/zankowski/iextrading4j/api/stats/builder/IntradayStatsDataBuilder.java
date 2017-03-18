package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.IntradayStat;
import pl.zankowski.iextrading4j.api.stats.IntradayStats;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStatsDataBuilder {

    private IntradayStat volume = new IntradayStat(12d, 1489435195124L);
    private IntradayStat symbolsTraded = new IntradayStat(23d, 1489435195124L);
    private IntradayStat routedVolume = new IntradayStat(34d, 1489435195124L);
    private IntradayStat notional = new IntradayStat(45d, 1489435195124L);
    private IntradayStat marketShare = new IntradayStat(56d, 1489435195124L);

    public static IntradayStats defaultIntradayStats() {
        return anIntradayStats().build();
    }

    public static IntradayStatsDataBuilder anIntradayStats() {
        return new IntradayStatsDataBuilder();
    }

    public IntradayStatsDataBuilder withVolume(IntradayStat volume) {
        this.volume = volume;
        return this;
    }

    public IntradayStatsDataBuilder withSymbolsTraded(IntradayStat symbolsTraded) {
        this.symbolsTraded = symbolsTraded;
        return this;
    }

    public IntradayStatsDataBuilder withRoutedVolume(IntradayStat routedVolume) {
        this.routedVolume = routedVolume;
        return this;
    }

    public IntradayStatsDataBuilder withNotional(IntradayStat notional) {
        this.notional = notional;
        return this;
    }

    public IntradayStatsDataBuilder withMarketShare(IntradayStat marketShare) {
        this.marketShare = marketShare;
        return this;
    }

    public IntradayStats build() {
        return new IntradayStats(volume, symbolsTraded, routedVolume, notional, marketShare);
    }

}