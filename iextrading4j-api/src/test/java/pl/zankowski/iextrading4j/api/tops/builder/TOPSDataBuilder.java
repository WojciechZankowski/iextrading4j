package pl.zankowski.iextrading4j.api.tops.builder;

import pl.zankowski.iextrading4j.api.tops.TOPS;

/**
 * @author Wojciech Zankowski
 */
public class TOPSDataBuilder {

    private String symbol = "IBM";
    private double marketPercent = 0.0179;
    private int bidSize = 0;
    private double bidPrice = 0.0;
    private int askSize = 0;
    private double askPrice = 0.0;
    private long volume = 62344;
    private double lastSalePrice = 176.45;
    private int lastSaleSize = 100;
    private long lastSaleTime = 1489435198942L;
    private long lastUpdated = 1489435200006L;
    private String sector = "pharmaceuticalsbiotechnology";
    private String securityType = "commonstock";

    public static TOPS defaultTOPS() {
        return aTOPSDataBuilder().build();
    }

    public static TOPSDataBuilder aTOPSDataBuilder() {
        return new TOPSDataBuilder();
    }

    public TOPSDataBuilder withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public TOPSDataBuilder withMarketPercent(double marketPercent) {
        this.marketPercent = marketPercent;
        return this;
    }

    public TOPSDataBuilder withBidSize(int bidSize) {
        this.bidSize = bidSize;
        return this;
    }

    public TOPSDataBuilder withBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public TOPSDataBuilder withAskSize(int askSize) {
        this.askSize = askSize;
        return this;
    }

    public TOPSDataBuilder withAskPrice(double askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public TOPSDataBuilder withVolume(long volume) {
        this.volume = volume;
        return this;
    }

    public TOPSDataBuilder withLastSalePrice(double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
        return this;
    }

    public TOPSDataBuilder withLastSaleSize(int lastSaleSize) {
        this.lastSaleSize = lastSaleSize;
        return this;
    }

    public TOPSDataBuilder withLastSaleTime(long lastSaleTime) {
        this.lastSaleTime = lastSaleTime;
        return this;
    }

    public TOPSDataBuilder withLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public TOPSDataBuilder withSector(String sector) {
        this.sector = sector;
        return this;
    }

    public TOPSDataBuilder withSecurityType(String securityType) {
        this.securityType = securityType;
        return this;
    }

    public TOPS build() {
        return new TOPS(symbol, marketPercent, bidSize, bidPrice, askSize, askPrice, volume, lastSalePrice,
                lastSaleSize, lastSaleTime, lastUpdated, sector, securityType);
    }

}
