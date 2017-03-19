package pl.zankowski.iextrading4j.api.tops;

import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class TOPS {

    private String symbol;
    private double marketPercent;
    private int bidSize;
    private double bidPrice;
    private int askSize;
    private double askPrice;
    private long volume;
    private double lastSalePrice;
    private int lastSaleSize;
    private long lastSaleTime;
    private long lastUpdated;

    public TOPS() {}

    public TOPS(String symbol, double marketPercent, int bidSize, double bidPrice, int askSize, double askPrice,
                long volume, double lastSalePrice, int lastSaleSize, long lastSaleTime, long lastUpdated) {
        this.symbol = symbol;
        this.marketPercent = marketPercent;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askSize = askSize;
        this.askPrice = askPrice;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getMarketPercent() {
        return marketPercent;
    }

    public void setMarketPercent(double marketPercent) {
        this.marketPercent = marketPercent;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    public int getLastSaleSize() {
        return lastSaleSize;
    }

    public void setLastSaleSize(int lastSaleSize) {
        this.lastSaleSize = lastSaleSize;
    }

    public long getLastSaleTime() {
        return lastSaleTime;
    }

    public void setLastSaleTime(long lastSaleTime) {
        this.lastSaleTime = lastSaleTime;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOPS tops = (TOPS) o;

        if (Double.compare(tops.marketPercent, marketPercent) != 0) return false;
        if (bidSize != tops.bidSize) return false;
        if (Double.compare(tops.bidPrice, bidPrice) != 0) return false;
        if (askSize != tops.askSize) return false;
        if (Double.compare(tops.askPrice, askPrice) != 0) return false;
        if (volume != tops.volume) return false;
        if (Double.compare(tops.lastSalePrice, lastSalePrice) != 0) return false;
        if (lastSaleSize != tops.lastSaleSize) return false;
        if (lastSaleTime != tops.lastSaleTime) return false;
        if (lastUpdated != tops.lastUpdated) return false;
        return symbol != null ? symbol.equals(tops.symbol) : tops.symbol == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(marketPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bidSize;
        temp = Double.doubleToLongBits(bidPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + askSize;
        temp = Double.doubleToLongBits(askPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        temp = Double.doubleToLongBits(lastSalePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + lastSaleSize;
        result = 31 * result + (int) (lastSaleTime ^ (lastSaleTime >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TOPS{" +
                "symbol='" + symbol + '\'' +
                ", marketPercent=" + DoubleUtil.printDouble(marketPercent) +
                ", bidSize=" + bidSize +
                ", bidPrice=" + DoubleUtil.printDouble(bidPrice) +
                ", askSize=" + askSize +
                ", askPrice=" + DoubleUtil.printDouble(askPrice) +
                ", volume=" + volume +
                ", lastSalePrice=" + DoubleUtil.printDouble(lastSalePrice) +
                ", lastSaleSize=" + lastSaleSize +
                ", lastSaleTime=" + lastSaleTime +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
