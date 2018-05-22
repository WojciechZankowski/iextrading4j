package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class HistoricalStats implements Serializable {

    private final BigDecimal averageDailyVolume;
    private final BigDecimal averageDailyRoutedVolume;
    private final BigDecimal averageMarketShare;
    private final BigDecimal averageOrderSize;
    private final BigDecimal averageFillSize;
    private final BigDecimal bin100Percent;
    private final BigDecimal bin101Percent;
    private final BigDecimal bin200Percent;
    private final BigDecimal bin300Percent;
    private final BigDecimal bin400Percent;
    private final BigDecimal bin500Percent;
    private final BigDecimal bin1000Percent;
    private final BigDecimal bin5000Percent;
    private final BigDecimal bin10000Percent;
    private final BigDecimal bin10000Trades;
    private final BigDecimal bin20000Trades;
    private final BigDecimal bin50000Trades;
    private final BigDecimal uniqueSymbolsTraded;
    private final BigDecimal blockPercent;
    private final BigDecimal selfCrossPercent;
    private final BigDecimal etfPercent;
    private final BigDecimal largeCapPercent;
    private final BigDecimal midCapPercent;
    private final BigDecimal smallCapPercent;
    private final BigDecimal venueARCXFirstWaveWeight;
    private final BigDecimal venueBATSFirstWaveWeight;
    private final BigDecimal venueBATYFirstWaveWeight;
    private final BigDecimal venueEDGAFirstWaveWeight;
    private final BigDecimal venueEDGXFirstWaveWeight;
    private final BigDecimal venueOverallFirstWaveWeight;
    private final BigDecimal venueXASEFirstWaveWeight;
    private final BigDecimal venueXBOSFirstWaveWeight;
    private final BigDecimal venueXCHIFirstWaveWeight;
    private final BigDecimal venueXCISFirstWaveWeight;
    private final BigDecimal venueXNGSFirstWaveWeight;
    private final BigDecimal venueXNYSFirstWaveWeight;
    private final BigDecimal venueXPHLFirstWaveWeight;
    private final BigDecimal venueARCXFirstWaveRate;
    private final BigDecimal venueBATSFirstWaveRate;
    private final BigDecimal venueBATYFirstWaveRate;
    private final BigDecimal venueEDGAFirstWaveRate;
    private final BigDecimal venueEDGXFirstWaveRate;
    private final BigDecimal venueOverallFirstWaveRate;
    private final BigDecimal venueXASEFirstWaveRate;
    private final BigDecimal venueXBOSFirstWaveRate;
    private final BigDecimal venueXCHIFirstWaveRate;
    private final BigDecimal venueXCISFirstWaveRate;
    private final BigDecimal venueXNGSFirstWaveRate;
    private final BigDecimal venueXNYSFirstWaveRate;
    private final BigDecimal venueXPHLFirstWaveRate;

    @JsonCreator
    public HistoricalStats(
            @JsonProperty("averageDailyVolume") final BigDecimal averageDailyVolume,
            @JsonProperty("averageDailyRoutedVolume") final BigDecimal averageDailyRoutedVolume,
            @JsonProperty("averageMarketShare") final BigDecimal averageMarketShare,
            @JsonProperty("averageOrderSize") final BigDecimal averageOrderSize,
            @JsonProperty("averageFillSize") final BigDecimal averageFillSize,
            @JsonProperty("bin100Percent") final BigDecimal bin100Percent,
            @JsonProperty("bin101Percent") final BigDecimal bin101Percent,
            @JsonProperty("bin200Percent") final BigDecimal bin200Percent,
            @JsonProperty("bin300Percent") final BigDecimal bin300Percent,
            @JsonProperty("bin400Percent") final BigDecimal bin400Percent,
            @JsonProperty("bin500Percent") final BigDecimal bin500Percent,
            @JsonProperty("bin1000Percent") final BigDecimal bin1000Percent,
            @JsonProperty("bin5000Percent") final BigDecimal bin5000Percent,
            @JsonProperty("bin10000Percent") final BigDecimal bin10000Percent,
            @JsonProperty("bin10000Trades") final BigDecimal bin10000Trades,
            @JsonProperty("bin20000Trades") final BigDecimal bin20000Trades,
            @JsonProperty("bin50000Trades") final BigDecimal bin50000Trades,
            @JsonProperty("uniqueSymbolsTraded") final BigDecimal uniqueSymbolsTraded,
            @JsonProperty("blockPercent") final BigDecimal blockPercent,
            @JsonProperty("selfCrossPercent") final BigDecimal selfCrossPercent,
            @JsonProperty("etfPercent") final BigDecimal etfPercent,
            @JsonProperty("largeCapPercent") final BigDecimal largeCapPercent,
            @JsonProperty("midCapPercent") final BigDecimal midCapPercent,
            @JsonProperty("smallCapPercent") final BigDecimal smallCapPercent,
            @JsonProperty("venueARCXFirstWaveWeight") final BigDecimal venueARCXFirstWaveWeight,
            @JsonProperty("venueBATSFirstWaveWeight") final BigDecimal venueBATSFirstWaveWeight,
            @JsonProperty("venueBATYFirstWaveWeight") final BigDecimal venueBATYFirstWaveWeight,
            @JsonProperty("venueEDGAFirstWaveWeight") final BigDecimal venueEDGAFirstWaveWeight,
            @JsonProperty("venueEDGXFirstWaveWeight") final BigDecimal venueEDGXFirstWaveWeight,
            @JsonProperty("venueOverallFirstWaveWeight") final BigDecimal venueOverallFirstWaveWeight,
            @JsonProperty("venueXASEFirstWaveWeight") final BigDecimal venueXASEFirstWaveWeight,
            @JsonProperty("venueXBOSFirstWaveWeight") final BigDecimal venueXBOSFirstWaveWeight,
            @JsonProperty("venueXCHIFirstWaveWeight") final BigDecimal venueXCHIFirstWaveWeight,
            @JsonProperty("venueXCISFirstWaveWeight") final BigDecimal venueXCISFirstWaveWeight,
            @JsonProperty("venueXNGSFirstWaveWeight") final BigDecimal venueXNGSFirstWaveWeight,
            @JsonProperty("venueXNYSFirstWaveWeight") final BigDecimal venueXNYSFirstWaveWeight,
            @JsonProperty("venueXPHLFirstWaveWeight") final BigDecimal venueXPHLFirstWaveWeight,
            @JsonProperty("venueARCXFirstWaveRate") final BigDecimal venueARCXFirstWaveRate,
            @JsonProperty("venueBATSFirstWaveRate") final BigDecimal venueBATSFirstWaveRate,
            @JsonProperty("venueBATYFirstWaveRate") final BigDecimal venueBATYFirstWaveRate,
            @JsonProperty("venueEDGAFirstWaveRate") final BigDecimal venueEDGAFirstWaveRate,
            @JsonProperty("venueEDGXFirstWaveRate") final BigDecimal venueEDGXFirstWaveRate,
            @JsonProperty("venueOverallFirstWaveRate") final BigDecimal venueOverallFirstWaveRate,
            @JsonProperty("venueXASEFirstWaveRate") final BigDecimal venueXASEFirstWaveRate,
            @JsonProperty("venueXBOSFirstWaveRate") final BigDecimal venueXBOSFirstWaveRate,
            @JsonProperty("venueXCHIFirstWaveRate") final BigDecimal venueXCHIFirstWaveRate,
            @JsonProperty("venueXCISFirstWaveRate") final BigDecimal venueXCISFirstWaveRate,
            @JsonProperty("venueXNGSFirstWaveRate") final BigDecimal venueXNGSFirstWaveRate,
            @JsonProperty("venueXNYSFirstWaveRate") final BigDecimal venueXNYSFirstWaveRate,
            @JsonProperty("venueXPHLFirstWaveRate") final BigDecimal venueXPHLFirstWaveRate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricalStats that = (HistoricalStats) o;
        return Objects.equal(averageDailyVolume, that.averageDailyVolume) &&
                Objects.equal(averageDailyRoutedVolume, that.averageDailyRoutedVolume) &&
                Objects.equal(averageMarketShare, that.averageMarketShare) &&
                Objects.equal(averageOrderSize, that.averageOrderSize) &&
                Objects.equal(averageFillSize, that.averageFillSize) &&
                Objects.equal(bin100Percent, that.bin100Percent) &&
                Objects.equal(bin101Percent, that.bin101Percent) &&
                Objects.equal(bin200Percent, that.bin200Percent) &&
                Objects.equal(bin300Percent, that.bin300Percent) &&
                Objects.equal(bin400Percent, that.bin400Percent) &&
                Objects.equal(bin500Percent, that.bin500Percent) &&
                Objects.equal(bin1000Percent, that.bin1000Percent) &&
                Objects.equal(bin5000Percent, that.bin5000Percent) &&
                Objects.equal(bin10000Percent, that.bin10000Percent) &&
                Objects.equal(bin10000Trades, that.bin10000Trades) &&
                Objects.equal(bin20000Trades, that.bin20000Trades) &&
                Objects.equal(bin50000Trades, that.bin50000Trades) &&
                Objects.equal(uniqueSymbolsTraded, that.uniqueSymbolsTraded) &&
                Objects.equal(blockPercent, that.blockPercent) &&
                Objects.equal(selfCrossPercent, that.selfCrossPercent) &&
                Objects.equal(etfPercent, that.etfPercent) &&
                Objects.equal(largeCapPercent, that.largeCapPercent) &&
                Objects.equal(midCapPercent, that.midCapPercent) &&
                Objects.equal(smallCapPercent, that.smallCapPercent) &&
                Objects.equal(venueARCXFirstWaveWeight, that.venueARCXFirstWaveWeight) &&
                Objects.equal(venueBATSFirstWaveWeight, that.venueBATSFirstWaveWeight) &&
                Objects.equal(venueBATYFirstWaveWeight, that.venueBATYFirstWaveWeight) &&
                Objects.equal(venueEDGAFirstWaveWeight, that.venueEDGAFirstWaveWeight) &&
                Objects.equal(venueEDGXFirstWaveWeight, that.venueEDGXFirstWaveWeight) &&
                Objects.equal(venueOverallFirstWaveWeight, that.venueOverallFirstWaveWeight) &&
                Objects.equal(venueXASEFirstWaveWeight, that.venueXASEFirstWaveWeight) &&
                Objects.equal(venueXBOSFirstWaveWeight, that.venueXBOSFirstWaveWeight) &&
                Objects.equal(venueXCHIFirstWaveWeight, that.venueXCHIFirstWaveWeight) &&
                Objects.equal(venueXCISFirstWaveWeight, that.venueXCISFirstWaveWeight) &&
                Objects.equal(venueXNGSFirstWaveWeight, that.venueXNGSFirstWaveWeight) &&
                Objects.equal(venueXNYSFirstWaveWeight, that.venueXNYSFirstWaveWeight) &&
                Objects.equal(venueXPHLFirstWaveWeight, that.venueXPHLFirstWaveWeight) &&
                Objects.equal(venueARCXFirstWaveRate, that.venueARCXFirstWaveRate) &&
                Objects.equal(venueBATSFirstWaveRate, that.venueBATSFirstWaveRate) &&
                Objects.equal(venueBATYFirstWaveRate, that.venueBATYFirstWaveRate) &&
                Objects.equal(venueEDGAFirstWaveRate, that.venueEDGAFirstWaveRate) &&
                Objects.equal(venueEDGXFirstWaveRate, that.venueEDGXFirstWaveRate) &&
                Objects.equal(venueOverallFirstWaveRate, that.venueOverallFirstWaveRate) &&
                Objects.equal(venueXASEFirstWaveRate, that.venueXASEFirstWaveRate) &&
                Objects.equal(venueXBOSFirstWaveRate, that.venueXBOSFirstWaveRate) &&
                Objects.equal(venueXCHIFirstWaveRate, that.venueXCHIFirstWaveRate) &&
                Objects.equal(venueXCISFirstWaveRate, that.venueXCISFirstWaveRate) &&
                Objects.equal(venueXNGSFirstWaveRate, that.venueXNGSFirstWaveRate) &&
                Objects.equal(venueXNYSFirstWaveRate, that.venueXNYSFirstWaveRate) &&
                Objects.equal(venueXPHLFirstWaveRate, that.venueXPHLFirstWaveRate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(averageDailyVolume, averageDailyRoutedVolume, averageMarketShare,
                averageOrderSize, averageFillSize, bin100Percent, bin101Percent, bin200Percent, bin300Percent,
                bin400Percent, bin500Percent, bin1000Percent, bin5000Percent, bin10000Percent, bin10000Trades,
                bin20000Trades, bin50000Trades, uniqueSymbolsTraded, blockPercent, selfCrossPercent, etfPercent,
                largeCapPercent, midCapPercent, smallCapPercent, venueARCXFirstWaveWeight, venueBATSFirstWaveWeight,
                venueBATYFirstWaveWeight, venueEDGAFirstWaveWeight, venueEDGXFirstWaveWeight, venueOverallFirstWaveWeight,
                venueXASEFirstWaveWeight, venueXBOSFirstWaveWeight, venueXCHIFirstWaveWeight, venueXCISFirstWaveWeight,
                venueXNGSFirstWaveWeight, venueXNYSFirstWaveWeight, venueXPHLFirstWaveWeight, venueARCXFirstWaveRate,
                venueBATSFirstWaveRate, venueBATYFirstWaveRate, venueEDGAFirstWaveRate, venueEDGXFirstWaveRate,
                venueOverallFirstWaveRate, venueXASEFirstWaveRate, venueXBOSFirstWaveRate, venueXCHIFirstWaveRate,
                venueXCISFirstWaveRate, venueXNGSFirstWaveRate, venueXNYSFirstWaveRate, venueXPHLFirstWaveRate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("averageDailyVolume", averageDailyVolume)
                .add("averageDailyRoutedVolume", averageDailyRoutedVolume)
                .add("averageMarketShare", averageMarketShare)
                .add("averageOrderSize", averageOrderSize)
                .add("averageFillSize", averageFillSize)
                .add("bin100Percent", bin100Percent)
                .add("bin101Percent", bin101Percent)
                .add("bin200Percent", bin200Percent)
                .add("bin300Percent", bin300Percent)
                .add("bin400Percent", bin400Percent)
                .add("bin500Percent", bin500Percent)
                .add("bin1000Percent", bin1000Percent)
                .add("bin5000Percent", bin5000Percent)
                .add("bin10000Percent", bin10000Percent)
                .add("bin10000Trades", bin10000Trades)
                .add("bin20000Trades", bin20000Trades)
                .add("bin50000Trades", bin50000Trades)
                .add("uniqueSymbolsTraded", uniqueSymbolsTraded)
                .add("blockPercent", blockPercent)
                .add("selfCrossPercent", selfCrossPercent)
                .add("etfPercent", etfPercent)
                .add("largeCapPercent", largeCapPercent)
                .add("midCapPercent", midCapPercent)
                .add("smallCapPercent", smallCapPercent)
                .add("venueARCXFirstWaveWeight", venueARCXFirstWaveWeight)
                .add("venueBATSFirstWaveWeight", venueBATSFirstWaveWeight)
                .add("venueBATYFirstWaveWeight", venueBATYFirstWaveWeight)
                .add("venueEDGAFirstWaveWeight", venueEDGAFirstWaveWeight)
                .add("venueEDGXFirstWaveWeight", venueEDGXFirstWaveWeight)
                .add("venueOverallFirstWaveWeight", venueOverallFirstWaveWeight)
                .add("venueXASEFirstWaveWeight", venueXASEFirstWaveWeight)
                .add("venueXBOSFirstWaveWeight", venueXBOSFirstWaveWeight)
                .add("venueXCHIFirstWaveWeight", venueXCHIFirstWaveWeight)
                .add("venueXCISFirstWaveWeight", venueXCISFirstWaveWeight)
                .add("venueXNGSFirstWaveWeight", venueXNGSFirstWaveWeight)
                .add("venueXNYSFirstWaveWeight", venueXNYSFirstWaveWeight)
                .add("venueXPHLFirstWaveWeight", venueXPHLFirstWaveWeight)
                .add("venueARCXFirstWaveRate", venueARCXFirstWaveRate)
                .add("venueBATSFirstWaveRate", venueBATSFirstWaveRate)
                .add("venueBATYFirstWaveRate", venueBATYFirstWaveRate)
                .add("venueEDGAFirstWaveRate", venueEDGAFirstWaveRate)
                .add("venueEDGXFirstWaveRate", venueEDGXFirstWaveRate)
                .add("venueOverallFirstWaveRate", venueOverallFirstWaveRate)
                .add("venueXASEFirstWaveRate", venueXASEFirstWaveRate)
                .add("venueXBOSFirstWaveRate", venueXBOSFirstWaveRate)
                .add("venueXCHIFirstWaveRate", venueXCHIFirstWaveRate)
                .add("venueXCISFirstWaveRate", venueXCISFirstWaveRate)
                .add("venueXNGSFirstWaveRate", venueXNGSFirstWaveRate)
                .add("venueXNYSFirstWaveRate", venueXNYSFirstWaveRate)
                .add("venueXPHLFirstWaveRate", venueXPHLFirstWaveRate)
                .toString();
    }
}
