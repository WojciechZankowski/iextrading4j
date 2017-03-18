package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStatsTest {

    @Test
    public void shouldSuccessfullyCreateEmptyHistoricalStats() {
        HistoricalStats historicalStats = new HistoricalStats();

        assertHistoricalStats(historicalStats, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d, 0d, 0d, 0d,
                0d, 0d, 0d);
    }

    @Test
    public void shouldSuccessfullyCreateHistoricalStats() {
        final double averageDailyVolume = 123.23d;
        final double averageDailyRoutedVolume = 123.23d;
        final double averageMarketShare = 123.23d;
        final double averageOrderSize = 123.23d;
        final double averageFillSize = 123.23d;
        final double bin100Percent = 45.32d;
        final double bin101Percent = 45.32d;
        final double bin200Percent = 45.32d;
        final double bin300Percent = 45.32d;
        final double bin400Percent = 45.32d;
        final double bin500Percent = 45.32d;
        final double bin1000Percent = 45.32d;
        final double bin5000Percent = 45.32d;
        final double bin10000Percent = 45.32d;
        final double bin10000Trades = 313d;
        final double bin20000Trades = 423d;
        final double bin50000Trades = 423d;
        final double uniqueSymbolsTraded = 423d;
        final double blockPercent = 75.43d;
        final double selfCrossPercent = 43.41d;
        final double etfPercent = 1.23d;
        final double largeCapPercent = 23.42d;
        final double midCapPercent = 23.42d;
        final double smallCapPercent = 23.42d;
        final double venueARCXFirstWaveWeight = 23.42d;
        final double venueBATSFirstWaveWeight = 23.42d;
        final double venueBATYFirstWaveWeight = 23.42d;
        final double venueEDGAFirstWaveWeight = 23.42d;
        final double venueEDGXFirstWaveWeight = 23.42d;
        final double venueOverallFirstWaveWeight = 23.42d;
        final double venueXASEFirstWaveWeight = 23.42d;
        final double venueXBOSFirstWaveWeight = 23.42d;
        final double venueXCHIFirstWaveWeight = 23.42d;
        final double venueXCISFirstWaveWeight = 23.42d;
        final double venueXNGSFirstWaveWeight = 23.42d;
        final double venueXNYSFirstWaveWeight = 23.42d;
        final double venueXPHLFirstWaveWeight = 23.42d;
        final double venueARCXFirstWaveRate = 23.42d;
        final double venueBATSFirstWaveRate = 23.42d;
        final double venueBATYFirstWaveRate = 23.42d;
        final double venueEDGAFirstWaveRate = 23.42d;
        final double venueEDGXFirstWaveRate = 23.42d;
        final double venueOverallFirstWaveRate = 23.42d;
        final double venueXASEFirstWaveRate = 23.42d;
        final double venueXBOSFirstWaveRate = 23.42d;
        final double venueXCHIFirstWaveRate = 23.42d;
        final double venueXCISFirstWaveRate = 23.42d;
        final double venueXNGSFirstWaveRate = 23.42d;
        final double venueXNYSFirstWaveRate = 23.42d;
        final double venueXPHLFirstWaveRate = 23.42d;

        HistoricalStats historicalStats = new HistoricalStats(averageDailyVolume, averageDailyRoutedVolume, averageMarketShare, averageOrderSize, averageFillSize,
                bin100Percent, bin101Percent, bin200Percent, bin300Percent, bin400Percent, bin500Percent, bin1000Percent, bin5000Percent,
                bin10000Percent, bin10000Trades, bin20000Trades, bin50000Trades, uniqueSymbolsTraded, blockPercent, selfCrossPercent,
                etfPercent, largeCapPercent, midCapPercent, smallCapPercent, venueARCXFirstWaveWeight, venueBATSFirstWaveWeight, venueBATYFirstWaveWeight,
                venueEDGAFirstWaveWeight, venueEDGXFirstWaveWeight, venueOverallFirstWaveWeight, venueXASEFirstWaveWeight, venueXBOSFirstWaveWeight,
                venueXCHIFirstWaveWeight, venueXCISFirstWaveWeight, venueXNGSFirstWaveWeight, venueXNYSFirstWaveWeight, venueXPHLFirstWaveWeight,
                venueARCXFirstWaveRate, venueBATSFirstWaveRate, venueBATYFirstWaveRate, venueEDGAFirstWaveRate, venueEDGXFirstWaveRate,
                venueOverallFirstWaveRate, venueXASEFirstWaveRate, venueXBOSFirstWaveRate, venueXCHIFirstWaveRate, venueXCISFirstWaveRate, venueXNGSFirstWaveRate,
                venueXNYSFirstWaveRate, venueXPHLFirstWaveRate);

        assertHistoricalStats(historicalStats, averageDailyVolume, averageDailyRoutedVolume, averageMarketShare, averageOrderSize, averageFillSize,
                bin100Percent, bin101Percent, bin200Percent, bin300Percent, bin400Percent, bin500Percent, bin1000Percent, bin5000Percent,
                bin10000Percent, bin10000Trades, bin20000Trades, bin50000Trades, uniqueSymbolsTraded, blockPercent, selfCrossPercent,
                etfPercent, largeCapPercent, midCapPercent, smallCapPercent, venueARCXFirstWaveWeight, venueBATSFirstWaveWeight, venueBATYFirstWaveWeight,
                venueEDGAFirstWaveWeight, venueEDGXFirstWaveWeight, venueOverallFirstWaveWeight, venueXASEFirstWaveWeight, venueXBOSFirstWaveWeight,
                venueXCHIFirstWaveWeight, venueXCISFirstWaveWeight, venueXNGSFirstWaveWeight, venueXNYSFirstWaveWeight, venueXPHLFirstWaveWeight,
                venueARCXFirstWaveRate, venueBATSFirstWaveRate, venueBATYFirstWaveRate, venueEDGAFirstWaveRate, venueEDGXFirstWaveRate,
                venueOverallFirstWaveRate, venueXASEFirstWaveRate, venueXBOSFirstWaveRate, venueXCHIFirstWaveRate, venueXCISFirstWaveRate, venueXNGSFirstWaveRate,
                venueXNYSFirstWaveRate, venueXPHLFirstWaveRate);
    }

    private void assertHistoricalStats(HistoricalStats historicalStats, double averageDailyVolume, double averageDailyRoutedVolume, double averageMarketShare,
                                       double averageOrderSize, double averageFillSize, double bin100Percent, double bin101Percent,
                                       double bin200Percent, double bin300Percent, double bin400Percent, double bin500Percent,
                                       double bin1000Percent, double bin5000Percent, double bin10000Percent, double bin10000Trades,
                                       double bin20000Trades, double bin50000Trades, double uniqueSymbolsTraded, double blockPercent,
                                       double selfCrossPercent, double etfPercent, double largeCapPercent, double midCapPercent,
                                       double smallCapPercent, double venueARCXFirstWaveWeight, double venueBATSFirstWaveWeight,
                                       double venueBATYFirstWaveWeight, double venueEDGAFirstWaveWeight, double venueEDGXFirstWaveWeight,
                                       double venueOverallFirstWaveWeight, double venueXASEFirstWaveWeight, double venueXBOSFirstWaveWeight,
                                       double venueXCHIFirstWaveWeight, double venueXCISFirstWaveWeight, double venueXNGSFirstWaveWeight,
                                       double venueXNYSFirstWaveWeight, double venueXPHLFirstWaveWeight, double venueARCXFirstWaveRate,
                                       double venueBATSFirstWaveRate, double venueBATYFirstWaveRate, double venueEDGAFirstWaveRate,
                                       double venueEDGXFirstWaveRate, double venueOverallFirstWaveRate, double venueXASEFirstWaveRate,
                                       double venueXBOSFirstWaveRate, double venueXCHIFirstWaveRate, double venueXCISFirstWaveRate,
                                       double venueXNGSFirstWaveRate, double venueXNYSFirstWaveRate, double venueXPHLFirstWaveRate) {
        assertThat(historicalStats.getAverageDailyVolume()).isEqualTo(averageDailyVolume);
        assertThat(historicalStats.getAverageDailyRoutedVolume()).isEqualTo(averageDailyRoutedVolume);
        assertThat(historicalStats.getAverageMarketShare()).isEqualTo(averageMarketShare);
        assertThat(historicalStats.getAverageOrderSize()).isEqualTo(averageOrderSize);
        assertThat(historicalStats.getAverageFillSize()).isEqualTo(averageFillSize);
        assertThat(historicalStats.getBin100Percent()).isEqualTo(bin100Percent);
        assertThat(historicalStats.getBin101Percent()).isEqualTo(bin101Percent);
        assertThat(historicalStats.getBin200Percent()).isEqualTo(bin200Percent);
        assertThat(historicalStats.getBin300Percent()).isEqualTo(bin300Percent);
        assertThat(historicalStats.getBin400Percent()).isEqualTo(bin400Percent);
        assertThat(historicalStats.getBin500Percent()).isEqualTo(bin500Percent);
        assertThat(historicalStats.getBin1000Percent()).isEqualTo(bin1000Percent);
        assertThat(historicalStats.getBin5000Percent()).isEqualTo(bin5000Percent);
        assertThat(historicalStats.getBin10000Percent()).isEqualTo(bin10000Percent);
        assertThat(historicalStats.getBin10000Trades()).isEqualTo(bin10000Trades);
        assertThat(historicalStats.getBin20000Trades()).isEqualTo(bin20000Trades);
        assertThat(historicalStats.getBin50000Trades()).isEqualTo(bin50000Trades);
        assertThat(historicalStats.getUniqueSymbolsTraded()).isEqualTo(uniqueSymbolsTraded);
        assertThat(historicalStats.getBlockPercent()).isEqualTo(blockPercent);
        assertThat(historicalStats.getSelfCrossPercent()).isEqualTo(selfCrossPercent);
        assertThat(historicalStats.getEtfPercent()).isEqualTo(etfPercent);
        assertThat(historicalStats.getLargeCapPercent()).isEqualTo(largeCapPercent);
        assertThat(historicalStats.getMidCapPercent()).isEqualTo(midCapPercent);
        assertThat(historicalStats.getSmallCapPercent()).isEqualTo(smallCapPercent);
        assertThat(historicalStats.getVenueARCXFirstWaveWeight()).isEqualTo(venueARCXFirstWaveWeight);
        assertThat(historicalStats.getVenueBATSFirstWaveWeight()).isEqualTo(venueBATSFirstWaveWeight);
        assertThat(historicalStats.getVenueBATYFirstWaveWeight()).isEqualTo(venueBATYFirstWaveWeight);
        assertThat(historicalStats.getVenueEDGAFirstWaveWeight()).isEqualTo(venueEDGAFirstWaveWeight);
        assertThat(historicalStats.getVenueEDGXFirstWaveWeight()).isEqualTo(venueEDGXFirstWaveWeight);
        assertThat(historicalStats.getVenueOverallFirstWaveWeight()).isEqualTo(venueOverallFirstWaveWeight);
        assertThat(historicalStats.getVenueXASEFirstWaveWeight()).isEqualTo(venueXASEFirstWaveWeight);
        assertThat(historicalStats.getVenueXBOSFirstWaveWeight()).isEqualTo(venueXBOSFirstWaveWeight);
        assertThat(historicalStats.getVenueXCHIFirstWaveWeight()).isEqualTo(venueXCHIFirstWaveWeight);
        assertThat(historicalStats.getVenueXCISFirstWaveWeight()).isEqualTo(venueXCISFirstWaveWeight);
        assertThat(historicalStats.getVenueXNGSFirstWaveWeight()).isEqualTo(venueXNGSFirstWaveWeight);
        assertThat(historicalStats.getVenueXNYSFirstWaveWeight()).isEqualTo(venueXNYSFirstWaveWeight);
        assertThat(historicalStats.getVenueXPHLFirstWaveWeight()).isEqualTo(venueXPHLFirstWaveWeight);
        assertThat(historicalStats.getVenueARCXFirstWaveRate()).isEqualTo(venueARCXFirstWaveRate);
        assertThat(historicalStats.getVenueBATSFirstWaveRate()).isEqualTo(venueBATSFirstWaveRate);
        assertThat(historicalStats.getVenueBATYFirstWaveRate()).isEqualTo(venueBATYFirstWaveRate);
        assertThat(historicalStats.getVenueEDGAFirstWaveRate()).isEqualTo(venueEDGAFirstWaveRate);
        assertThat(historicalStats.getVenueEDGXFirstWaveRate()).isEqualTo(venueEDGXFirstWaveRate);
        assertThat(historicalStats.getVenueOverallFirstWaveRate()).isEqualTo(venueOverallFirstWaveRate);
        assertThat(historicalStats.getVenueXASEFirstWaveRate()).isEqualTo(venueXASEFirstWaveRate);
        assertThat(historicalStats.getVenueXBOSFirstWaveRate()).isEqualTo(venueXBOSFirstWaveRate);
        assertThat(historicalStats.getVenueXCHIFirstWaveRate()).isEqualTo(venueXCHIFirstWaveRate);
        assertThat(historicalStats.getVenueXCISFirstWaveRate()).isEqualTo(venueXCISFirstWaveRate);
        assertThat(historicalStats.getVenueXNGSFirstWaveRate()).isEqualTo(venueXNGSFirstWaveRate);
        assertThat(historicalStats.getVenueXNYSFirstWaveRate()).isEqualTo(venueXNYSFirstWaveRate);
        assertThat(historicalStats.getVenueXPHLFirstWaveRate()).isEqualTo(venueXPHLFirstWaveRate);
    }

}
