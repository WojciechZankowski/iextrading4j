package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.HistoricalStats;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStatsDataBuilder {

    private double averageDailyVolume = 123.23d;
    private double averageDailyRoutedVolume = 123.23d;
    private double averageMarketShare = 123.23d;
    private double averageOrderSize = 123.23d;
    private double averageFillSize = 123.23d;
    private double bin100Percent = 45.32d;
    private double bin101Percent = 45.32d;
    private double bin200Percent = 45.32d;
    private double bin300Percent = 45.32d;
    private double bin400Percent = 45.32d;
    private double bin500Percent = 45.32d;
    private double bin1000Percent = 45.32d;
    private double bin5000Percent = 45.32d;
    private double bin10000Percent = 45.32d;
    private double bin10000Trades = 313d;
    private double bin20000Trades = 423d;
    private double bin50000Trades = 423d;
    private double uniqueSymbolsTraded = 423d;
    private double blockPercent = 75.43d;
    private double selfCrossPercent = 43.41d;
    private double etfPercent = 1.23d;
    private double largeCapPercent = 23.42d;
    private double midCapPercent = 23.42d;
    private double smallCapPercent = 23.42d;
    private double venueARCXFirstWaveWeight = 23.42d;
    private double venueBATSFirstWaveWeight = 23.42d;
    private double venueBATYFirstWaveWeight = 23.42d;
    private double venueEDGAFirstWaveWeight = 23.42d;
    private double venueEDGXFirstWaveWeight = 23.42d;
    private double venueOverallFirstWaveWeight = 23.42d;
    private double venueXASEFirstWaveWeight = 23.42d;
    private double venueXBOSFirstWaveWeight = 23.42d;
    private double venueXCHIFirstWaveWeight = 23.42d;
    private double venueXCISFirstWaveWeight = 23.42d;
    private double venueXNGSFirstWaveWeight = 23.42d;
    private double venueXNYSFirstWaveWeight = 23.42d;
    private double venueXPHLFirstWaveWeight = 23.42d;
    private double venueARCXFirstWaveRate = 23.42d;
    private double venueBATSFirstWaveRate = 23.42d;
    private double venueBATYFirstWaveRate = 23.42d;
    private double venueEDGAFirstWaveRate = 23.42d;
    private double venueEDGXFirstWaveRate = 23.42d;
    private double venueOverallFirstWaveRate = 23.42d;
    private double venueXASEFirstWaveRate = 23.42d;
    private double venueXBOSFirstWaveRate = 23.42d;
    private double venueXCHIFirstWaveRate = 23.42d;
    private double venueXCISFirstWaveRate = 23.42d;
    private double venueXNGSFirstWaveRate = 23.42d;
    private double venueXNYSFirstWaveRate = 23.42d;
    private double venueXPHLFirstWaveRate = 23.42d;

    public static HistoricalStats defaultHistoricalStats() {
        return aHistoricalStats().build();
    }

    public static HistoricalStatsDataBuilder aHistoricalStats() {
        return new HistoricalStatsDataBuilder();
    }

    public HistoricalStats build() {
        return new HistoricalStats(averageDailyVolume, averageDailyRoutedVolume, averageMarketShare, averageOrderSize, averageFillSize,
                bin100Percent, bin101Percent, bin200Percent, bin300Percent, bin400Percent, bin500Percent, bin1000Percent, bin5000Percent,
                bin10000Percent, bin10000Trades, bin20000Trades, bin50000Trades, uniqueSymbolsTraded, blockPercent, selfCrossPercent,
                etfPercent, largeCapPercent, midCapPercent, smallCapPercent, venueARCXFirstWaveWeight, venueBATSFirstWaveWeight, venueBATYFirstWaveWeight,
                venueEDGAFirstWaveWeight, venueEDGXFirstWaveWeight, venueOverallFirstWaveWeight, venueXASEFirstWaveWeight, venueXBOSFirstWaveWeight,
                venueXCHIFirstWaveWeight, venueXCISFirstWaveWeight, venueXNGSFirstWaveWeight, venueXNYSFirstWaveWeight, venueXPHLFirstWaveWeight,
                venueARCXFirstWaveRate, venueBATSFirstWaveRate, venueBATYFirstWaveRate, venueEDGAFirstWaveRate, venueEDGXFirstWaveRate,
                venueOverallFirstWaveRate, venueXASEFirstWaveRate, venueXBOSFirstWaveRate, venueXCHIFirstWaveRate, venueXCISFirstWaveRate, venueXNGSFirstWaveRate,
                venueXNYSFirstWaveRate, venueXPHLFirstWaveRate);
    }

}
