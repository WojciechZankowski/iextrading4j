package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class Quote {

    private final double price;
    private final int size;
    private final long timestamp;

    @JsonCreator
    public Quote(@JsonProperty("price") double price,
                 @JsonProperty("size") int size,
                 @JsonProperty("timestamp") long timestamp) {
        this.price = price;
        this.size = size;
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (Double.compare(quote.price, price) != 0) return false;
        if (size != quote.size) return false;
        return timestamp == quote.timestamp;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + size;
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "price=" + price +
                ", size=" + size +
                ", timestamp=" + timestamp +
                '}';
    }
}
