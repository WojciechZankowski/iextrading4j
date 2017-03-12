package pl.zankowski.iextrading.api.stats;

import java.math.BigDecimal;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStats {

    private BigDecimal averageDailyVolume;
    private BigDecimal averageDailyRoutedVolume;
    private BigDecimal averageMarketShare;
    private BigDecimal averageOrderSize;
    private BigDecimal averageFillSize;
    private BigDecimal bin100Percent;
    private BigDecimal bin101Percent;
    private BigDecimal bin200Percent;
    private BigDecimal bin300Percent;
    private BigDecimal bin400Percent;
    private BigDecimal bin500Percent;
    private BigDecimal bin1000Percent;
    private BigDecimal bin5000Percent;
    private BigDecimal bin10000Percent;
    private BigDecimal bin10000Trades;
    private BigDecimal bin20000Trades;
    private BigDecimal bin50000Trades;
    private BigDecimal uniqueSymbolsTraded;
    private BigDecimal blockPercent;
    private BigDecimal selfCrossPercent;
    private BigDecimal etfPercent;
    private BigDecimal largeCapPercent;
    private BigDecimal midCapPercent;
    private BigDecimal smallCapPercent;
    private BigDecimal venueARCXFirstWaveWeight;
    private BigDecimal venueBATSFirstWaveWeight;
    private BigDecimal venueBATYFirstWaveWeight;
    private BigDecimal venueEDGAFirstWaveWeight;
    private BigDecimal venueEDGXFirstWaveWeight;
    private BigDecimal venueOverallFirstWaveWeight;
    private BigDecimal venueXASEFirstWaveWeight;
    private BigDecimal venueXBOSFirstWaveWeight;
    private BigDecimal venueXCHIFirstWaveWeight;
    private BigDecimal venueXCISFirstWaveWeight;
    private BigDecimal venueXNGSFirstWaveWeight;
    private BigDecimal venueXNYSFirstWaveWeight;
    private BigDecimal venueXPHLFirstWaveWeight;
    private BigDecimal venueARCXFirstWaveRate;
    private BigDecimal venueBATSFirstWaveRate;
    private BigDecimal venueBATYFirstWaveRate;
    private BigDecimal venueEDGAFirstWaveRate;
    private BigDecimal venueEDGXFirstWaveRate;
    private BigDecimal venueOverallFirstWaveRate;
    private BigDecimal venueXASEFirstWaveRate;
    private BigDecimal venueXBOSFirstWaveRate;
    private BigDecimal venueXCHIFirstWaveRate;
    private BigDecimal venueXCISFirstWaveRate;
    private BigDecimal venueXNGSFirstWaveRate;
    private BigDecimal venueXNYSFirstWaveRate;
    private BigDecimal venueXPHLFirstWaveRate;

    public HistoricalStats() {}

    public HistoricalStats(BigDecimal averageDailyVolume, BigDecimal averageDailyRoutedVolume, BigDecimal averageMarketShare,
                           BigDecimal averageOrderSize, BigDecimal averageFillSize, BigDecimal bin100Percent, BigDecimal bin101Percent,
                           BigDecimal bin200Percent, BigDecimal bin300Percent, BigDecimal bin400Percent, BigDecimal bin500Percent,
                           BigDecimal bin1000Percent, BigDecimal bin5000Percent, BigDecimal bin10000Percent, BigDecimal bin10000Trades,
                           BigDecimal bin20000Trades, BigDecimal bin50000Trades, BigDecimal uniqueSymbolsTraded, BigDecimal blockPercent,
                           BigDecimal selfCrossPercent, BigDecimal etfPercent, BigDecimal largeCapPercent, BigDecimal midCapPercent,
                           BigDecimal smallCapPercent, BigDecimal venueARCXFirstWaveWeight, BigDecimal venueBATSFirstWaveWeight,
                           BigDecimal venueBATYFirstWaveWeight, BigDecimal venueEDGAFirstWaveWeight, BigDecimal venueEDGXFirstWaveWeight,
                           BigDecimal venueOverallFirstWaveWeight, BigDecimal venueXASEFirstWaveWeight, BigDecimal venueXBOSFirstWaveWeight,
                           BigDecimal venueXCHIFirstWaveWeight, BigDecimal venueXCISFirstWaveWeight, BigDecimal venueXNGSFirstWaveWeight,
                           BigDecimal venueXNYSFirstWaveWeight, BigDecimal venueXPHLFirstWaveWeight, BigDecimal venueARCXFirstWaveRate,
                           BigDecimal venueBATSFirstWaveRate, BigDecimal venueBATYFirstWaveRate, BigDecimal venueEDGAFirstWaveRate,
                           BigDecimal venueEDGXFirstWaveRate, BigDecimal venueOverallFirstWaveRate, BigDecimal venueXASEFirstWaveRate,
                           BigDecimal venueXBOSFirstWaveRate, BigDecimal venueXCHIFirstWaveRate, BigDecimal venueXCISFirstWaveRate,
                           BigDecimal venueXNGSFirstWaveRate, BigDecimal venueXNYSFirstWaveRate, BigDecimal venueXPHLFirstWaveRate) {
        this.averageDailyVolume = averageDailyVolume;
        this.averageDailyRoutedVolume = averageDailyRoutedVolume;
        this.averageMarketShare = averageMarketShare;
        this.averageOrderSize = averageOrderSize;
        this.averageFillSize = averageFillSize;
        this.bin100Percent = bin100Percent;
        this.bin101Percent = bin101Percent;
        this.bin200Percent = bin200Percent;
        this.bin300Percent = bin300Percent;
        this.bin400Percent = bin400Percent;
        this.bin500Percent = bin500Percent;
        this.bin1000Percent = bin1000Percent;
        this.bin5000Percent = bin5000Percent;
        this.bin10000Percent = bin10000Percent;
        this.bin10000Trades = bin10000Trades;
        this.bin20000Trades = bin20000Trades;
        this.bin50000Trades = bin50000Trades;
        this.uniqueSymbolsTraded = uniqueSymbolsTraded;
        this.blockPercent = blockPercent;
        this.selfCrossPercent = selfCrossPercent;
        this.etfPercent = etfPercent;
        this.largeCapPercent = largeCapPercent;
        this.midCapPercent = midCapPercent;
        this.smallCapPercent = smallCapPercent;
        this.venueARCXFirstWaveWeight = venueARCXFirstWaveWeight;
        this.venueBATSFirstWaveWeight = venueBATSFirstWaveWeight;
        this.venueBATYFirstWaveWeight = venueBATYFirstWaveWeight;
        this.venueEDGAFirstWaveWeight = venueEDGAFirstWaveWeight;
        this.venueEDGXFirstWaveWeight = venueEDGXFirstWaveWeight;
        this.venueOverallFirstWaveWeight = venueOverallFirstWaveWeight;
        this.venueXASEFirstWaveWeight = venueXASEFirstWaveWeight;
        this.venueXBOSFirstWaveWeight = venueXBOSFirstWaveWeight;
        this.venueXCHIFirstWaveWeight = venueXCHIFirstWaveWeight;
        this.venueXCISFirstWaveWeight = venueXCISFirstWaveWeight;
        this.venueXNGSFirstWaveWeight = venueXNGSFirstWaveWeight;
        this.venueXNYSFirstWaveWeight = venueXNYSFirstWaveWeight;
        this.venueXPHLFirstWaveWeight = venueXPHLFirstWaveWeight;
        this.venueARCXFirstWaveRate = venueARCXFirstWaveRate;
        this.venueBATSFirstWaveRate = venueBATSFirstWaveRate;
        this.venueBATYFirstWaveRate = venueBATYFirstWaveRate;
        this.venueEDGAFirstWaveRate = venueEDGAFirstWaveRate;
        this.venueEDGXFirstWaveRate = venueEDGXFirstWaveRate;
        this.venueOverallFirstWaveRate = venueOverallFirstWaveRate;
        this.venueXASEFirstWaveRate = venueXASEFirstWaveRate;
        this.venueXBOSFirstWaveRate = venueXBOSFirstWaveRate;
        this.venueXCHIFirstWaveRate = venueXCHIFirstWaveRate;
        this.venueXCISFirstWaveRate = venueXCISFirstWaveRate;
        this.venueXNGSFirstWaveRate = venueXNGSFirstWaveRate;
        this.venueXNYSFirstWaveRate = venueXNYSFirstWaveRate;
        this.venueXPHLFirstWaveRate = venueXPHLFirstWaveRate;
    }

    public BigDecimal getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public BigDecimal getAverageDailyRoutedVolume() {
        return averageDailyRoutedVolume;
    }

    public BigDecimal getAverageMarketShare() {
        return averageMarketShare;
    }

    public BigDecimal getAverageOrderSize() {
        return averageOrderSize;
    }

    public BigDecimal getAverageFillSize() {
        return averageFillSize;
    }

    public BigDecimal getBin100Percent() {
        return bin100Percent;
    }

    public BigDecimal getBin101Percent() {
        return bin101Percent;
    }

    public BigDecimal getBin200Percent() {
        return bin200Percent;
    }

    public BigDecimal getBin300Percent() {
        return bin300Percent;
    }

    public BigDecimal getBin400Percent() {
        return bin400Percent;
    }

    public BigDecimal getBin500Percent() {
        return bin500Percent;
    }

    public BigDecimal getBin1000Percent() {
        return bin1000Percent;
    }

    public BigDecimal getBin5000Percent() {
        return bin5000Percent;
    }

    public BigDecimal getBin10000Percent() {
        return bin10000Percent;
    }

    public BigDecimal getBin10000Trades() {
        return bin10000Trades;
    }

    public BigDecimal getBin20000Trades() {
        return bin20000Trades;
    }

    public BigDecimal getBin50000Trades() {
        return bin50000Trades;
    }

    public BigDecimal getUniqueSymbolsTraded() {
        return uniqueSymbolsTraded;
    }

    public BigDecimal getBlockPercent() {
        return blockPercent;
    }

    public BigDecimal getSelfCrossPercent() {
        return selfCrossPercent;
    }

    public BigDecimal getEtfPercent() {
        return etfPercent;
    }

    public BigDecimal getLargeCapPercent() {
        return largeCapPercent;
    }

    public BigDecimal getMidCapPercent() {
        return midCapPercent;
    }

    public BigDecimal getSmallCapPercent() {
        return smallCapPercent;
    }

    public BigDecimal getVenueARCXFirstWaveWeight() {
        return venueARCXFirstWaveWeight;
    }

    public BigDecimal getVenueBATSFirstWaveWeight() {
        return venueBATSFirstWaveWeight;
    }

    public BigDecimal getVenueBATYFirstWaveWeight() {
        return venueBATYFirstWaveWeight;
    }

    public BigDecimal getVenueEDGAFirstWaveWeight() {
        return venueEDGAFirstWaveWeight;
    }

    public BigDecimal getVenueEDGXFirstWaveWeight() {
        return venueEDGXFirstWaveWeight;
    }

    public BigDecimal getVenueOverallFirstWaveWeight() {
        return venueOverallFirstWaveWeight;
    }

    public BigDecimal getVenueXASEFirstWaveWeight() {
        return venueXASEFirstWaveWeight;
    }

    public BigDecimal getVenueXBOSFirstWaveWeight() {
        return venueXBOSFirstWaveWeight;
    }

    public BigDecimal getVenueXCHIFirstWaveWeight() {
        return venueXCHIFirstWaveWeight;
    }

    public BigDecimal getVenueXCISFirstWaveWeight() {
        return venueXCISFirstWaveWeight;
    }

    public BigDecimal getVenueXNGSFirstWaveWeight() {
        return venueXNGSFirstWaveWeight;
    }

    public BigDecimal getVenueXNYSFirstWaveWeight() {
        return venueXNYSFirstWaveWeight;
    }

    public BigDecimal getVenueXPHLFirstWaveWeight() {
        return venueXPHLFirstWaveWeight;
    }

    public BigDecimal getVenueARCXFirstWaveRate() {
        return venueARCXFirstWaveRate;
    }

    public BigDecimal getVenueBATSFirstWaveRate() {
        return venueBATSFirstWaveRate;
    }

    public BigDecimal getVenueBATYFirstWaveRate() {
        return venueBATYFirstWaveRate;
    }

    public BigDecimal getVenueEDGAFirstWaveRate() {
        return venueEDGAFirstWaveRate;
    }

    public BigDecimal getVenueEDGXFirstWaveRate() {
        return venueEDGXFirstWaveRate;
    }

    public BigDecimal getVenueOverallFirstWaveRate() {
        return venueOverallFirstWaveRate;
    }

    public BigDecimal getVenueXASEFirstWaveRate() {
        return venueXASEFirstWaveRate;
    }

    public BigDecimal getVenueXBOSFirstWaveRate() {
        return venueXBOSFirstWaveRate;
    }

    public BigDecimal getVenueXCHIFirstWaveRate() {
        return venueXCHIFirstWaveRate;
    }

    public BigDecimal getVenueXCISFirstWaveRate() {
        return venueXCISFirstWaveRate;
    }

    public BigDecimal getVenueXNGSFirstWaveRate() {
        return venueXNGSFirstWaveRate;
    }

    public BigDecimal getVenueXNYSFirstWaveRate() {
        return venueXNYSFirstWaveRate;
    }

    public BigDecimal getVenueXPHLFirstWaveRate() {
        return venueXPHLFirstWaveRate;
    }

}
