package pl.zankowski.iextrading.api.stats;

/**
 * @author Wojciech Zankowski
 */
public class HistoricalStats {

    private double averageDailyVolume;
    private double averageDailyRoutedVolume;
    private double averageMarketShare;
    private double averageOrderSize;
    private double averageFillSize;
    private double bin100Percent;
    private double bin101Percent;
    private double bin200Percent;
    private double bin300Percent;
    private double bin400Percent;
    private double bin500Percent;
    private double bin1000Percent;
    private double bin5000Percent;
    private double bin10000Percent;
    private double bin10000Trades;
    private double bin20000Trades;
    private double bin50000Trades;
    private double uniqueSymbolsTraded;
    private double blockPercent;
    private double selfCrossPercent;
    private double etfPercent;
    private double largeCapPercent;
    private double midCapPercent;
    private double smallCapPercent;
    private double venueARCXFirstWaveWeight;
    private double venueBATSFirstWaveWeight;
    private double venueBATYFirstWaveWeight;
    private double venueEDGAFirstWaveWeight;
    private double venueEDGXFirstWaveWeight;
    private double venueOverallFirstWaveWeight;
    private double venueXASEFirstWaveWeight;
    private double venueXBOSFirstWaveWeight;
    private double venueXCHIFirstWaveWeight;
    private double venueXCISFirstWaveWeight;
    private double venueXNGSFirstWaveWeight;
    private double venueXNYSFirstWaveWeight;
    private double venueXPHLFirstWaveWeight;
    private double venueARCXFirstWaveRate;
    private double venueBATSFirstWaveRate;
    private double venueBATYFirstWaveRate;
    private double venueEDGAFirstWaveRate;
    private double venueEDGXFirstWaveRate;
    private double venueOverallFirstWaveRate;
    private double venueXASEFirstWaveRate;
    private double venueXBOSFirstWaveRate;
    private double venueXCHIFirstWaveRate;
    private double venueXCISFirstWaveRate;
    private double venueXNGSFirstWaveRate;
    private double venueXNYSFirstWaveRate;
    private double venueXPHLFirstWaveRate;

    public HistoricalStats() {
    }

    public HistoricalStats(double averageDailyVolume, double averageDailyRoutedVolume, double averageMarketShare,
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

    public double getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(double averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public double getAverageDailyRoutedVolume() {
        return averageDailyRoutedVolume;
    }

    public void setAverageDailyRoutedVolume(double averageDailyRoutedVolume) {
        this.averageDailyRoutedVolume = averageDailyRoutedVolume;
    }

    public double getAverageMarketShare() {
        return averageMarketShare;
    }

    public void setAverageMarketShare(double averageMarketShare) {
        this.averageMarketShare = averageMarketShare;
    }

    public double getAverageOrderSize() {
        return averageOrderSize;
    }

    public void setAverageOrderSize(double averageOrderSize) {
        this.averageOrderSize = averageOrderSize;
    }

    public double getAverageFillSize() {
        return averageFillSize;
    }

    public void setAverageFillSize(double averageFillSize) {
        this.averageFillSize = averageFillSize;
    }

    public double getBin100Percent() {
        return bin100Percent;
    }

    public void setBin100Percent(double bin100Percent) {
        this.bin100Percent = bin100Percent;
    }

    public double getBin101Percent() {
        return bin101Percent;
    }

    public void setBin101Percent(double bin101Percent) {
        this.bin101Percent = bin101Percent;
    }

    public double getBin200Percent() {
        return bin200Percent;
    }

    public void setBin200Percent(double bin200Percent) {
        this.bin200Percent = bin200Percent;
    }

    public double getBin300Percent() {
        return bin300Percent;
    }

    public void setBin300Percent(double bin300Percent) {
        this.bin300Percent = bin300Percent;
    }

    public double getBin400Percent() {
        return bin400Percent;
    }

    public void setBin400Percent(double bin400Percent) {
        this.bin400Percent = bin400Percent;
    }

    public double getBin500Percent() {
        return bin500Percent;
    }

    public void setBin500Percent(double bin500Percent) {
        this.bin500Percent = bin500Percent;
    }

    public double getBin1000Percent() {
        return bin1000Percent;
    }

    public void setBin1000Percent(double bin1000Percent) {
        this.bin1000Percent = bin1000Percent;
    }

    public double getBin5000Percent() {
        return bin5000Percent;
    }

    public void setBin5000Percent(double bin5000Percent) {
        this.bin5000Percent = bin5000Percent;
    }

    public double getBin10000Percent() {
        return bin10000Percent;

    }

    public void setBin10000Percent(double bin10000Percent) {
        this.bin10000Percent = bin10000Percent;
    }

    public double getBin10000Trades() {
        return bin10000Trades;
    }

    public void setBin10000Trades(double bin10000Trades) {
        this.bin10000Trades = bin10000Trades;
    }

    public double getBin20000Trades() {
        return bin20000Trades;
    }

    public void setBin20000Trades(double bin20000Trades) {
        this.bin20000Trades = bin20000Trades;
    }

    public double getBin50000Trades() {
        return bin50000Trades;
    }

    public void setBin50000Trades(double bin50000Trades) {
        this.bin50000Trades = bin50000Trades;
    }

    public double getUniqueSymbolsTraded() {
        return uniqueSymbolsTraded;
    }

    public void setUniqueSymbolsTraded(double uniqueSymbolsTraded) {
        this.uniqueSymbolsTraded = uniqueSymbolsTraded;
    }

    public double getBlockPercent() {
        return blockPercent;
    }

    public void setBlockPercent(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    public double getSelfCrossPercent() {
        return selfCrossPercent;
    }

    public void setSelfCrossPercent(double selfCrossPercent) {
        this.selfCrossPercent = selfCrossPercent;
    }

    public double getEtfPercent() {
        return etfPercent;
    }

    public void setEtfPercent(double etfPercent) {
        this.etfPercent = etfPercent;
    }

    public double getLargeCapPercent() {
        return largeCapPercent;
    }

    public void setLargeCapPercent(double largeCapPercent) {
        this.largeCapPercent = largeCapPercent;
    }

    public double getMidCapPercent() {
        return midCapPercent;
    }

    public void setMidCapPercent(double midCapPercent) {
        this.midCapPercent = midCapPercent;
    }

    public double getSmallCapPercent() {
        return smallCapPercent;
    }

    public void setSmallCapPercent(double smallCapPercent) {
        this.smallCapPercent = smallCapPercent;
    }

    public double getVenueARCXFirstWaveWeight() {
        return venueARCXFirstWaveWeight;
    }

    public void setVenueARCXFirstWaveWeight(double venueARCXFirstWaveWeight) {
        this.venueARCXFirstWaveWeight = venueARCXFirstWaveWeight;
    }

    public double getVenueBATSFirstWaveWeight() {
        return venueBATSFirstWaveWeight;
    }

    public void setVenueBATSFirstWaveWeight(double venueBATSFirstWaveWeight) {
        this.venueBATSFirstWaveWeight = venueBATSFirstWaveWeight;
    }

    public double getVenueBATYFirstWaveWeight() {
        return venueBATYFirstWaveWeight;
    }

    public void setVenueBATYFirstWaveWeight(double venueBATYFirstWaveWeight) {
        this.venueBATYFirstWaveWeight = venueBATYFirstWaveWeight;
    }

    public double getVenueEDGAFirstWaveWeight() {
        return venueEDGAFirstWaveWeight;
    }

    public void setVenueEDGAFirstWaveWeight(double venueEDGAFirstWaveWeight) {
        this.venueEDGAFirstWaveWeight = venueEDGAFirstWaveWeight;
    }

    public double getVenueEDGXFirstWaveWeight() {
        return venueEDGXFirstWaveWeight;
    }

    public void setVenueEDGXFirstWaveWeight(double venueEDGXFirstWaveWeight) {
        this.venueEDGXFirstWaveWeight = venueEDGXFirstWaveWeight;
    }

    public double getVenueOverallFirstWaveWeight() {
        return venueOverallFirstWaveWeight;
    }

    public void setVenueOverallFirstWaveWeight(double venueOverallFirstWaveWeight) {
        this.venueOverallFirstWaveWeight = venueOverallFirstWaveWeight;
    }

    public double getVenueXASEFirstWaveWeight() {
        return venueXASEFirstWaveWeight;
    }

    public void setVenueXASEFirstWaveWeight(double venueXASEFirstWaveWeight) {
        this.venueXASEFirstWaveWeight = venueXASEFirstWaveWeight;
    }

    public double getVenueXBOSFirstWaveWeight() {
        return venueXBOSFirstWaveWeight;
    }

    public void setVenueXBOSFirstWaveWeight(double venueXBOSFirstWaveWeight) {
        this.venueXBOSFirstWaveWeight = venueXBOSFirstWaveWeight;
    }

    public double getVenueXCHIFirstWaveWeight() {
        return venueXCHIFirstWaveWeight;
    }

    public void setVenueXCHIFirstWaveWeight(double venueXCHIFirstWaveWeight) {
        this.venueXCHIFirstWaveWeight = venueXCHIFirstWaveWeight;
    }

    public double getVenueXCISFirstWaveWeight() {
        return venueXCISFirstWaveWeight;
    }

    public void setVenueXCISFirstWaveWeight(double venueXCISFirstWaveWeight) {
        this.venueXCISFirstWaveWeight = venueXCISFirstWaveWeight;
    }

    public double getVenueXNGSFirstWaveWeight() {
        return venueXNGSFirstWaveWeight;
    }

    public void setVenueXNGSFirstWaveWeight(double venueXNGSFirstWaveWeight) {
        this.venueXNGSFirstWaveWeight = venueXNGSFirstWaveWeight;
    }

    public double getVenueXNYSFirstWaveWeight() {
        return venueXNYSFirstWaveWeight;
    }

    public void setVenueXNYSFirstWaveWeight(double venueXNYSFirstWaveWeight) {
        this.venueXNYSFirstWaveWeight = venueXNYSFirstWaveWeight;
    }

    public double getVenueXPHLFirstWaveWeight() {
        return venueXPHLFirstWaveWeight;
    }

    public void setVenueXPHLFirstWaveWeight(double venueXPHLFirstWaveWeight) {
        this.venueXPHLFirstWaveWeight = venueXPHLFirstWaveWeight;
    }

    public double getVenueARCXFirstWaveRate() {
        return venueARCXFirstWaveRate;
    }

    public void setVenueARCXFirstWaveRate(double venueARCXFirstWaveRate) {
        this.venueARCXFirstWaveRate = venueARCXFirstWaveRate;
    }

    public double getVenueBATSFirstWaveRate() {
        return venueBATSFirstWaveRate;
    }

    public void setVenueBATSFirstWaveRate(double venueBATSFirstWaveRate) {
        this.venueBATSFirstWaveRate = venueBATSFirstWaveRate;
    }

    public double getVenueBATYFirstWaveRate() {
        return venueBATYFirstWaveRate;
    }

    public void setVenueBATYFirstWaveRate(double venueBATYFirstWaveRate) {
        this.venueBATYFirstWaveRate = venueBATYFirstWaveRate;
    }

    public double getVenueEDGAFirstWaveRate() {
        return venueEDGAFirstWaveRate;
    }

    public void setVenueEDGAFirstWaveRate(double venueEDGAFirstWaveRate) {
        this.venueEDGAFirstWaveRate = venueEDGAFirstWaveRate;
    }

    public double getVenueEDGXFirstWaveRate() {
        return venueEDGXFirstWaveRate;
    }

    public void setVenueEDGXFirstWaveRate(double venueEDGXFirstWaveRate) {
        this.venueEDGXFirstWaveRate = venueEDGXFirstWaveRate;
    }

    public double getVenueOverallFirstWaveRate() {
        return venueOverallFirstWaveRate;
    }

    public void setVenueOverallFirstWaveRate(double venueOverallFirstWaveRate) {
        this.venueOverallFirstWaveRate = venueOverallFirstWaveRate;
    }

    public double getVenueXASEFirstWaveRate() {
        return venueXASEFirstWaveRate;
    }

    public void setVenueXASEFirstWaveRate(double venueXASEFirstWaveRate) {
        this.venueXASEFirstWaveRate = venueXASEFirstWaveRate;
    }

    public double getVenueXBOSFirstWaveRate() {
        return venueXBOSFirstWaveRate;
    }

    public void setVenueXBOSFirstWaveRate(double venueXBOSFirstWaveRate) {
        this.venueXBOSFirstWaveRate = venueXBOSFirstWaveRate;
    }

    public double getVenueXCHIFirstWaveRate() {
        return venueXCHIFirstWaveRate;
    }

    public void setVenueXCHIFirstWaveRate(double venueXCHIFirstWaveRate) {
        this.venueXCHIFirstWaveRate = venueXCHIFirstWaveRate;
    }

    public double getVenueXCISFirstWaveRate() {
        return venueXCISFirstWaveRate;
    }

    public void setVenueXCISFirstWaveRate(double venueXCISFirstWaveRate) {
        this.venueXCISFirstWaveRate = venueXCISFirstWaveRate;
    }

    public double getVenueXNGSFirstWaveRate() {
        return venueXNGSFirstWaveRate;
    }

    public void setVenueXNGSFirstWaveRate(double venueXNGSFirstWaveRate) {
        this.venueXNGSFirstWaveRate = venueXNGSFirstWaveRate;
    }

    public double getVenueXNYSFirstWaveRate() {
        return venueXNYSFirstWaveRate;
    }

    public void setVenueXNYSFirstWaveRate(double venueXNYSFirstWaveRate) {
        this.venueXNYSFirstWaveRate = venueXNYSFirstWaveRate;
    }

    public double getVenueXPHLFirstWaveRate() {
        return venueXPHLFirstWaveRate;
    }

    public void setVenueXPHLFirstWaveRate(double venueXPHLFirstWaveRate) {
        this.venueXPHLFirstWaveRate = venueXPHLFirstWaveRate;
    }

    @Override
    public String toString() {
        return "HistoricalStats{" +
                "averageDailyVolume=" + averageDailyVolume +
                ", averageDailyRoutedVolume=" + averageDailyRoutedVolume +
                ", averageMarketShare=" + averageMarketShare +
                ", averageOrderSize=" + averageOrderSize +
                ", averageFillSize=" + averageFillSize +
                ", bin100Percent=" + bin100Percent +
                ", bin101Percent=" + bin101Percent +
                ", bin200Percent=" + bin200Percent +
                ", bin300Percent=" + bin300Percent +
                ", bin400Percent=" + bin400Percent +
                ", bin500Percent=" + bin500Percent +
                ", bin1000Percent=" + bin1000Percent +
                ", bin5000Percent=" + bin5000Percent +
                ", bin10000Percent=" + bin10000Percent +
                ", bin10000Trades=" + bin10000Trades +
                ", bin20000Trades=" + bin20000Trades +
                ", bin50000Trades=" + bin50000Trades +
                ", uniqueSymbolsTraded=" + uniqueSymbolsTraded +
                ", blockPercent=" + blockPercent +
                ", selfCrossPercent=" + selfCrossPercent +
                ", etfPercent=" + etfPercent +
                ", largeCapPercent=" + largeCapPercent +
                ", midCapPercent=" + midCapPercent +
                ", smallCapPercent=" + smallCapPercent +
                ", venueARCXFirstWaveWeight=" + venueARCXFirstWaveWeight +
                ", venueBATSFirstWaveWeight=" + venueBATSFirstWaveWeight +
                ", venueBATYFirstWaveWeight=" + venueBATYFirstWaveWeight +
                ", venueEDGAFirstWaveWeight=" + venueEDGAFirstWaveWeight +
                ", venueEDGXFirstWaveWeight=" + venueEDGXFirstWaveWeight +
                ", venueOverallFirstWaveWeight=" + venueOverallFirstWaveWeight +
                ", venueXASEFirstWaveWeight=" + venueXASEFirstWaveWeight +
                ", venueXBOSFirstWaveWeight=" + venueXBOSFirstWaveWeight +
                ", venueXCHIFirstWaveWeight=" + venueXCHIFirstWaveWeight +
                ", venueXCISFirstWaveWeight=" + venueXCISFirstWaveWeight +
                ", venueXNGSFirstWaveWeight=" + venueXNGSFirstWaveWeight +
                ", venueXNYSFirstWaveWeight=" + venueXNYSFirstWaveWeight +
                ", venueXPHLFirstWaveWeight=" + venueXPHLFirstWaveWeight +
                ", venueARCXFirstWaveRate=" + venueARCXFirstWaveRate +
                ", venueBATSFirstWaveRate=" + venueBATSFirstWaveRate +
                ", venueBATYFirstWaveRate=" + venueBATYFirstWaveRate +
                ", venueEDGAFirstWaveRate=" + venueEDGAFirstWaveRate +
                ", venueEDGXFirstWaveRate=" + venueEDGXFirstWaveRate +
                ", venueOverallFirstWaveRate=" + venueOverallFirstWaveRate +
                ", venueXASEFirstWaveRate=" + venueXASEFirstWaveRate +
                ", venueXBOSFirstWaveRate=" + venueXBOSFirstWaveRate +
                ", venueXCHIFirstWaveRate=" + venueXCHIFirstWaveRate +
                ", venueXCISFirstWaveRate=" + venueXCISFirstWaveRate +
                ", venueXNGSFirstWaveRate=" + venueXNGSFirstWaveRate +
                ", venueXNYSFirstWaveRate=" + venueXNYSFirstWaveRate +
                ", venueXPHLFirstWaveRate=" + venueXPHLFirstWaveRate +
                '}';
    }

}
