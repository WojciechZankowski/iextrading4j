package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStats {

    private final Double averageDailyVolume;
    private final Double averageDailyRoutedVolume;
    private final Double averageMarketShare;
    private final Double averageOrderSize;
    private final Double averageFillSize;
    private final Double bin100Percent;
    private final Double bin101Percent;
    private final Double bin200Percent;
    private final Double bin300Percent;
    private final Double bin400Percent;
    private final Double bin500Percent;
    private final Double bin1000Percent;
    private final Double bin5000Percent;
    private final Double bin10000Percent;
    private final Double bin10000Trades;
    private final Double bin20000Trades;
    private final Double bin50000Trades;
    private final Double uniqueSymbolsTraded;
    private final Double blockPercent;
    private final Double selfCrossPercent;
    private final Double etfPercent;
    private final Double largeCapPercent;
    private final Double midCapPercent;
    private final Double smallCapPercent;
    private final Double venueARCXFirstWaveWeight;
    private final Double venueBATSFirstWaveWeight;
    private final Double venueBATYFirstWaveWeight;
    private final Double venueEDGAFirstWaveWeight;
    private final Double venueEDGXFirstWaveWeight;
    private final Double venueOverallFirstWaveWeight;
    private final Double venueXASEFirstWaveWeight;
    private final Double venueXBOSFirstWaveWeight;
    private final Double venueXCHIFirstWaveWeight;
    private final Double venueXCISFirstWaveWeight;
    private final Double venueXNGSFirstWaveWeight;
    private final Double venueXNYSFirstWaveWeight;
    private final Double venueXPHLFirstWaveWeight;
    private final Double venueARCXFirstWaveRate;
    private final Double venueBATSFirstWaveRate;
    private final Double venueBATYFirstWaveRate;
    private final Double venueEDGAFirstWaveRate;
    private final Double venueEDGXFirstWaveRate;
    private final Double venueOverallFirstWaveRate;
    private final Double venueXASEFirstWaveRate;
    private final Double venueXBOSFirstWaveRate;
    private final Double venueXCHIFirstWaveRate;
    private final Double venueXCISFirstWaveRate;
    private final Double venueXNGSFirstWaveRate;
    private final Double venueXNYSFirstWaveRate;
    private final Double venueXPHLFirstWaveRate;

    @JsonCreator
    public HistoricalStats(@JsonProperty("averageDailyVolume") Double averageDailyVolume,
                           @JsonProperty("averageDailyRoutedVolume") Double averageDailyRoutedVolume,
                           @JsonProperty("averageMarketShare") Double averageMarketShare,
                           @JsonProperty("averageOrderSize") Double averageOrderSize,
                           @JsonProperty("averageFillSize") Double averageFillSize,
                           @JsonProperty("bin100Percent") Double bin100Percent,
                           @JsonProperty("bin101Percent") Double bin101Percent,
                           @JsonProperty("bin200Percent") Double bin200Percent,
                           @JsonProperty("bin300Percent") Double bin300Percent,
                           @JsonProperty("bin400Percent") Double bin400Percent,
                           @JsonProperty("bin500Percent") Double bin500Percent,
                           @JsonProperty("bin1000Percent") Double bin1000Percent,
                           @JsonProperty("bin5000Percent") Double bin5000Percent,
                           @JsonProperty("bin10000Percent") Double bin10000Percent,
                           @JsonProperty("bin10000Trades") Double bin10000Trades,
                           @JsonProperty("bin20000Trades") Double bin20000Trades,
                           @JsonProperty("bin50000Trades") Double bin50000Trades,
                           @JsonProperty("uniqueSymbolsTraded") Double uniqueSymbolsTraded,
                           @JsonProperty("blockPercent") Double blockPercent,
                           @JsonProperty("selfCrossPercent") Double selfCrossPercent,
                           @JsonProperty("etfPercent") Double etfPercent,
                           @JsonProperty("largeCapPercent") Double largeCapPercent,
                           @JsonProperty("midCapPercent") Double midCapPercent,
                           @JsonProperty("smallCapPercent") Double smallCapPercent,
                           @JsonProperty("venueARCXFirstWaveWeight") Double venueARCXFirstWaveWeight,
                           @JsonProperty("venueBATSFirstWaveWeight") Double venueBATSFirstWaveWeight,
                           @JsonProperty("venueBATYFirstWaveWeight") Double venueBATYFirstWaveWeight,
                           @JsonProperty("venueEDGAFirstWaveWeight") Double venueEDGAFirstWaveWeight,
                           @JsonProperty("venueEDGXFirstWaveWeight") Double venueEDGXFirstWaveWeight,
                           @JsonProperty("venueOverallFirstWaveWeight") Double venueOverallFirstWaveWeight,
                           @JsonProperty("venueXASEFirstWaveWeight") Double venueXASEFirstWaveWeight,
                           @JsonProperty("venueXBOSFirstWaveWeight") Double venueXBOSFirstWaveWeight,
                           @JsonProperty("venueXCHIFirstWaveWeight") Double venueXCHIFirstWaveWeight,
                           @JsonProperty("venueXCISFirstWaveWeight") Double venueXCISFirstWaveWeight,
                           @JsonProperty("venueXNGSFirstWaveWeight") Double venueXNGSFirstWaveWeight,
                           @JsonProperty("venueXNYSFirstWaveWeight") Double venueXNYSFirstWaveWeight,
                           @JsonProperty("venueXPHLFirstWaveWeight") Double venueXPHLFirstWaveWeight,
                           @JsonProperty("venueARCXFirstWaveRate") Double venueARCXFirstWaveRate,
                           @JsonProperty("venueBATSFirstWaveRate") Double venueBATSFirstWaveRate,
                           @JsonProperty("venueBATYFirstWaveRate") Double venueBATYFirstWaveRate,
                           @JsonProperty("venueEDGAFirstWaveRate") Double venueEDGAFirstWaveRate,
                           @JsonProperty("venueEDGXFirstWaveRate") Double venueEDGXFirstWaveRate,
                           @JsonProperty("venueOverallFirstWaveRate") Double venueOverallFirstWaveRate,
                           @JsonProperty("venueXASEFirstWaveRate") Double venueXASEFirstWaveRate,
                           @JsonProperty("venueXBOSFirstWaveRate") Double venueXBOSFirstWaveRate,
                           @JsonProperty("venueXCHIFirstWaveRate") Double venueXCHIFirstWaveRate,
                           @JsonProperty("venueXCISFirstWaveRate") Double venueXCISFirstWaveRate,
                           @JsonProperty("venueXNGSFirstWaveRate") Double venueXNGSFirstWaveRate,
                           @JsonProperty("venueXNYSFirstWaveRate") Double venueXNYSFirstWaveRate,
                           @JsonProperty("venueXPHLFirstWaveRate") Double venueXPHLFirstWaveRate) {
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

    public Double getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public Double getAverageDailyRoutedVolume() {
        return averageDailyRoutedVolume;
    }

    public Double getAverageMarketShare() {
        return averageMarketShare;
    }

    public Double getAverageOrderSize() {
        return averageOrderSize;
    }

    public Double getAverageFillSize() {
        return averageFillSize;
    }

    public Double getBin100Percent() {
        return bin100Percent;
    }

    public Double getBin101Percent() {
        return bin101Percent;
    }

    public Double getBin200Percent() {
        return bin200Percent;
    }

    public Double getBin300Percent() {
        return bin300Percent;
    }

    public Double getBin400Percent() {
        return bin400Percent;
    }

    public Double getBin500Percent() {
        return bin500Percent;
    }

    public Double getBin1000Percent() {
        return bin1000Percent;
    }

    public Double getBin5000Percent() {
        return bin5000Percent;
    }

    public Double getBin10000Percent() {
        return bin10000Percent;

    }

    public Double getBin10000Trades() {
        return bin10000Trades;
    }

    public Double getBin20000Trades() {
        return bin20000Trades;
    }

    public Double getBin50000Trades() {
        return bin50000Trades;
    }

    public Double getUniqueSymbolsTraded() {
        return uniqueSymbolsTraded;
    }

    public Double getBlockPercent() {
        return blockPercent;
    }

    public Double getSelfCrossPercent() {
        return selfCrossPercent;
    }

    public Double getEtfPercent() {
        return etfPercent;
    }

    public Double getLargeCapPercent() {
        return largeCapPercent;
    }

    public Double getMidCapPercent() {
        return midCapPercent;
    }

    public Double getSmallCapPercent() {
        return smallCapPercent;
    }

    public Double getVenueARCXFirstWaveWeight() {
        return venueARCXFirstWaveWeight;
    }

    public Double getVenueBATSFirstWaveWeight() {
        return venueBATSFirstWaveWeight;
    }

    public Double getVenueBATYFirstWaveWeight() {
        return venueBATYFirstWaveWeight;
    }

    public Double getVenueEDGAFirstWaveWeight() {
        return venueEDGAFirstWaveWeight;
    }

    public Double getVenueEDGXFirstWaveWeight() {
        return venueEDGXFirstWaveWeight;
    }

    public Double getVenueOverallFirstWaveWeight() {
        return venueOverallFirstWaveWeight;
    }

    public Double getVenueXASEFirstWaveWeight() {
        return venueXASEFirstWaveWeight;
    }

    public Double getVenueXBOSFirstWaveWeight() {
        return venueXBOSFirstWaveWeight;
    }

    public Double getVenueXCHIFirstWaveWeight() {
        return venueXCHIFirstWaveWeight;
    }

    public Double getVenueXCISFirstWaveWeight() {
        return venueXCISFirstWaveWeight;
    }

    public Double getVenueXNGSFirstWaveWeight() {
        return venueXNGSFirstWaveWeight;
    }

    public Double getVenueXNYSFirstWaveWeight() {
        return venueXNYSFirstWaveWeight;
    }

    public Double getVenueXPHLFirstWaveWeight() {
        return venueXPHLFirstWaveWeight;
    }

    public Double getVenueARCXFirstWaveRate() {
        return venueARCXFirstWaveRate;
    }

    public Double getVenueBATSFirstWaveRate() {
        return venueBATSFirstWaveRate;
    }

    public Double getVenueBATYFirstWaveRate() {
        return venueBATYFirstWaveRate;
    }

    public Double getVenueEDGAFirstWaveRate() {
        return venueEDGAFirstWaveRate;
    }

    public Double getVenueEDGXFirstWaveRate() {
        return venueEDGXFirstWaveRate;
    }

    public Double getVenueOverallFirstWaveRate() {
        return venueOverallFirstWaveRate;
    }

    public Double getVenueXASEFirstWaveRate() {
        return venueXASEFirstWaveRate;
    }

    public Double getVenueXBOSFirstWaveRate() {
        return venueXBOSFirstWaveRate;
    }

    public Double getVenueXCHIFirstWaveRate() {
        return venueXCHIFirstWaveRate;
    }

    public Double getVenueXCISFirstWaveRate() {
        return venueXCISFirstWaveRate;
    }

    public Double getVenueXNGSFirstWaveRate() {
        return venueXNGSFirstWaveRate;
    }

    public Double getVenueXNYSFirstWaveRate() {
        return venueXNYSFirstWaveRate;
    }

    public Double getVenueXPHLFirstWaveRate() {
        return venueXPHLFirstWaveRate;
    }

    @Override
    public String toString() {
        return "HistoricalStats{" +
                "averageDailyVolume=" + DoubleUtil.printDouble(averageDailyVolume) +
                ", averageDailyRoutedVolume=" + DoubleUtil.printDouble(averageDailyRoutedVolume) +
                ", averageMarketShare=" + DoubleUtil.printDouble(averageMarketShare) +
                ", averageOrderSize=" + DoubleUtil.printDouble(averageOrderSize) +
                ", averageFillSize=" + DoubleUtil.printDouble(averageFillSize) +
                ", bin100Percent=" + DoubleUtil.printDouble(bin100Percent) +
                ", bin101Percent=" + DoubleUtil.printDouble(bin101Percent) +
                ", bin200Percent=" + DoubleUtil.printDouble(bin200Percent) +
                ", bin300Percent=" + DoubleUtil.printDouble(bin300Percent) +
                ", bin400Percent=" + DoubleUtil.printDouble(bin400Percent) +
                ", bin500Percent=" + DoubleUtil.printDouble(bin500Percent) +
                ", bin1000Percent=" + DoubleUtil.printDouble(bin1000Percent) +
                ", bin5000Percent=" + DoubleUtil.printDouble(bin5000Percent) +
                ", bin10000Percent=" + DoubleUtil.printDouble(bin10000Percent) +
                ", bin10000Trades=" + DoubleUtil.printDouble(bin10000Trades) +
                ", bin20000Trades=" + DoubleUtil.printDouble(bin20000Trades) +
                ", bin50000Trades=" + DoubleUtil.printDouble(bin50000Trades) +
                ", uniqueSymbolsTraded=" + DoubleUtil.printDouble(uniqueSymbolsTraded) +
                ", blockPercent=" + DoubleUtil.printDouble(blockPercent) +
                ", selfCrossPercent=" + DoubleUtil.printDouble(selfCrossPercent) +
                ", etfPercent=" + DoubleUtil.printDouble(etfPercent) +
                ", largeCapPercent=" + DoubleUtil.printDouble(largeCapPercent) +
                ", midCapPercent=" + DoubleUtil.printDouble(midCapPercent) +
                ", smallCapPercent=" + DoubleUtil.printDouble(smallCapPercent) +
                ", venueARCXFirstWaveWeight=" + DoubleUtil.printDouble(venueARCXFirstWaveWeight) +
                ", venueBATSFirstWaveWeight=" + DoubleUtil.printDouble(venueBATSFirstWaveWeight) +
                ", venueBATYFirstWaveWeight=" + DoubleUtil.printDouble(venueBATYFirstWaveWeight) +
                ", venueEDGAFirstWaveWeight=" + DoubleUtil.printDouble(venueEDGAFirstWaveWeight) +
                ", venueEDGXFirstWaveWeight=" + DoubleUtil.printDouble(venueEDGXFirstWaveWeight) +
                ", venueOverallFirstWaveWeight=" + DoubleUtil.printDouble(venueOverallFirstWaveWeight) +
                ", venueXASEFirstWaveWeight=" + DoubleUtil.printDouble(venueXASEFirstWaveWeight) +
                ", venueXBOSFirstWaveWeight=" + DoubleUtil.printDouble(venueXBOSFirstWaveWeight) +
                ", venueXCHIFirstWaveWeight=" + DoubleUtil.printDouble(venueXCHIFirstWaveWeight) +
                ", venueXCISFirstWaveWeight=" + DoubleUtil.printDouble(venueXCISFirstWaveWeight) +
                ", venueXNGSFirstWaveWeight=" + DoubleUtil.printDouble(venueXNGSFirstWaveWeight) +
                ", venueXNYSFirstWaveWeight=" + DoubleUtil.printDouble(venueXNYSFirstWaveWeight) +
                ", venueXPHLFirstWaveWeight=" + DoubleUtil.printDouble(venueXPHLFirstWaveWeight) +
                ", venueARCXFirstWaveRate=" + DoubleUtil.printDouble(venueARCXFirstWaveRate) +
                ", venueBATSFirstWaveRate=" + DoubleUtil.printDouble(venueBATSFirstWaveRate) +
                ", venueBATYFirstWaveRate=" + DoubleUtil.printDouble(venueBATYFirstWaveRate) +
                ", venueEDGAFirstWaveRate=" + DoubleUtil.printDouble(venueEDGAFirstWaveRate) +
                ", venueEDGXFirstWaveRate=" + DoubleUtil.printDouble(venueEDGXFirstWaveRate) +
                ", venueOverallFirstWaveRate=" + DoubleUtil.printDouble(venueOverallFirstWaveRate) +
                ", venueXASEFirstWaveRate=" + DoubleUtil.printDouble(venueXASEFirstWaveRate) +
                ", venueXBOSFirstWaveRate=" + DoubleUtil.printDouble(venueXBOSFirstWaveRate) +
                ", venueXCHIFirstWaveRate=" + DoubleUtil.printDouble(venueXCHIFirstWaveRate) +
                ", venueXCISFirstWaveRate=" + DoubleUtil.printDouble(venueXCISFirstWaveRate) +
                ", venueXNGSFirstWaveRate=" + DoubleUtil.printDouble(venueXNGSFirstWaveRate) +
                ", venueXNYSFirstWaveRate=" + DoubleUtil.printDouble(venueXNYSFirstWaveRate) +
                ", venueXPHLFirstWaveRate=" + DoubleUtil.printDouble(venueXPHLFirstWaveRate) +
                '}';
    }

}
