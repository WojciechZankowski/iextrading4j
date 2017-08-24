package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class Trade {

    private final double price;
    private final int size;
    private final long tradeId;
    private final boolean isISO;
    private final boolean isOddLot;
    private final boolean isOutsideRegularHours;
    private final boolean isSinglePriceCross;
    private final boolean isTradeThroughExempt;
    private final long timestamp;

    @JsonCreator
    public Trade(@JsonProperty("price") double price,
                 @JsonProperty("size") int size,
                 @JsonProperty("tradeId") long tradeId,
                 @JsonProperty("isISO") boolean isISO,
                 @JsonProperty("isOddLot") boolean isOddLot,
                 @JsonProperty("isOutsideRegularHours") boolean isOutsideRegularHours,
                 @JsonProperty("isSinglePriceCross") boolean isSinglePriceCross,
                 @JsonProperty("isTradeThroughExempt") boolean isTradeThroughExempt,
                 @JsonProperty("timestamp") long timestamp) {
        this.price = price;
        this.size = size;
        this.tradeId = tradeId;
        this.isISO = isISO;
        this.isOddLot = isOddLot;
        this.isOutsideRegularHours = isOutsideRegularHours;
        this.isSinglePriceCross = isSinglePriceCross;
        this.isTradeThroughExempt = isTradeThroughExempt;
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public long getTradeId() {
        return tradeId;
    }

    public boolean ISO() {
        return isISO;
    }

    public boolean isOddLot() {
        return isOddLot;
    }

    public boolean isOutsideRegularHours() {
        return isOutsideRegularHours;
    }

    public boolean isSinglePriceCross() {
        return isSinglePriceCross;
    }

    public boolean isTradeThroughExempt() {
        return isTradeThroughExempt;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (Double.compare(trade.price, price) != 0) return false;
        if (size != trade.size) return false;
        if (tradeId != trade.tradeId) return false;
        if (isISO != trade.isISO) return false;
        if (isOddLot != trade.isOddLot) return false;
        if (isOutsideRegularHours != trade.isOutsideRegularHours) return false;
        if (isSinglePriceCross != trade.isSinglePriceCross) return false;
        if (isTradeThroughExempt != trade.isTradeThroughExempt) return false;
        return timestamp == trade.timestamp;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + size;
        result = 31 * result + (int) (tradeId ^ (tradeId >>> 32));
        result = 31 * result + (isISO ? 1 : 0);
        result = 31 * result + (isOddLot ? 1 : 0);
        result = 31 * result + (isOutsideRegularHours ? 1 : 0);
        result = 31 * result + (isSinglePriceCross ? 1 : 0);
        result = 31 * result + (isTradeThroughExempt ? 1 : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                ", size=" + size +
                ", tradeId=" + tradeId +
                ", isISO=" + isISO +
                ", isOddLot=" + isOddLot +
                ", isOutsideRegularHours=" + isOutsideRegularHours +
                ", isSinglePriceCross=" + isSinglePriceCross +
                ", isTradeThroughExempt=" + isTradeThroughExempt +
                ", timestamp=" + timestamp +
                '}';
    }

}
