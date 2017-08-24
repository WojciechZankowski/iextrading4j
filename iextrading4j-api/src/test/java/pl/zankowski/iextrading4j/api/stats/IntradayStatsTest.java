package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.IntradayStatsDataBuilder.defaultIntradayStats;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStatsTest {

//    @Test
//    public void shouldSuccessfullyCreateEmptyIntradayStats() {
//        IntradayStats intradayStats = new IntradayStats();
//
//        assertThat(intradayStats.getVolume()).isNull();
//        assertThat(intradayStats.getSymbolsTraded()).isNull();
//        assertThat(intradayStats.getRoutedVolume()).isNull();
//        assertThat(intradayStats.getNotional()).isNull();
//        assertThat(intradayStats.getMarketShare()).isNull();
//    }

    @Test
    public void shouldSuccessfullyCreateIntradayStats() {
        final IntradayStat volume = new IntradayStat(12d, 1489435195124L);
        final IntradayStat symbolsTraded = new IntradayStat(23d, 1489435195124L);
        final IntradayStat routedVolume = new IntradayStat(34d, 1489435195124L);
        final IntradayStat notional = new IntradayStat(45d, 1489435195124L);
        final IntradayStat marketShare = new IntradayStat(56d, 1489435195124L);

        IntradayStats intradayStats = new IntradayStats(volume, symbolsTraded, routedVolume, notional, marketShare);
        assertIntradayStats(intradayStats, volume, symbolsTraded, routedVolume, notional, marketShare);
    }

//    @Test
//    public void shouldSuccessfullySetDataIntoEmptyIntradayStats() {
//        final IntradayStat volume = new IntradayStat(12d, 1489435195124L);
//        final IntradayStat symbolsTraded = new IntradayStat(23d, 1489435195124L);
//        final IntradayStat routedVolume = new IntradayStat(34d, 1489435195124L);
//        final IntradayStat notional = new IntradayStat(45d, 1489435195124L);
//        final IntradayStat marketShare = new IntradayStat(56d, 1489435195124L);
//
//        IntradayStats intradayStats = new IntradayStats();
//        intradayStats.setVolume(volume);
//        intradayStats.setSymbolsTraded(symbolsTraded);
//        intradayStats.setRoutedVolume(routedVolume);
//        intradayStats.setNotional(notional);
//        intradayStats.setMarketShare(marketShare);
//
//        assertIntradayStats(intradayStats, volume, symbolsTraded, routedVolume, notional, marketShare);
//    }

    @Test
    public void shouldSuccessfullyEqualTwoIntradayStats() {
        IntradayStats intradayStats_1 = defaultIntradayStats();
        IntradayStats intradayStats_2 = defaultIntradayStats();

        assertThat(intradayStats_1.equals(intradayStats_2)).isTrue();
        assertThat(intradayStats_1.hashCode()).isEqualTo(intradayStats_2.hashCode());
    }

    private void assertIntradayStats(IntradayStats intradayStats, IntradayStat volume, IntradayStat symbolsTraded,
                                     IntradayStat routedVolume, IntradayStat notional, IntradayStat marketShare) {
        assertThat(intradayStats.getVolume()).isEqualTo(volume);
        assertThat(intradayStats.getSymbolsTraded()).isEqualTo(symbolsTraded);
        assertThat(intradayStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(intradayStats.getNotional()).isEqualTo(notional);
        assertThat(intradayStats.getMarketShare()).isEqualTo(marketShare);
    }

}
