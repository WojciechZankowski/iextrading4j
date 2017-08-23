package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class DelayedQuote {

    private final String symbol;
    private final double delayedPrice;
    private final long delayedSize;
    private final long delayedPriceTime;
    private final long processedTime;

    @JsonCreator
    public DelayedQuote(@JsonProperty("symbol") String symbol,
                        @JsonProperty("delayedPrice") double delayedPrice,
                        @JsonProperty("delayedSize") long delayedSize,
                        @JsonProperty("delayedPriceTime") long delayedPriceTime,
                        @JsonProperty("processedTime") long processedTime) {
        this.symbol = symbol;
        this.delayedPrice = delayedPrice;
        this.delayedSize = delayedSize;
        this.delayedPriceTime = delayedPriceTime;
        this.processedTime = processedTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getDelayedPrice() {
        return delayedPrice;
    }

    public long getDelayedSize() {
        return delayedSize;
    }

    public long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public long getProcessedTime() {
        return processedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DelayedQuote that = (DelayedQuote) o;

        if (Double.compare(that.delayedPrice, delayedPrice) != 0) return false;
        if (delayedSize != that.delayedSize) return false;
        if (delayedPriceTime != that.delayedPriceTime) return false;
        if (processedTime != that.processedTime) return false;
        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(delayedPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (delayedSize ^ (delayedSize >>> 32));
        result = 31 * result + (int) (delayedPriceTime ^ (delayedPriceTime >>> 32));
        result = 31 * result + (int) (processedTime ^ (processedTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DelayedQuote{" +
                "symbol='" + symbol + '\'' +
                ", delayedPrice=" + delayedPrice +
                ", delayedSize=" + delayedSize +
                ", delayedPriceTime=" + delayedPriceTime +
                ", processedTime=" + processedTime +
                '}';
    }

}
