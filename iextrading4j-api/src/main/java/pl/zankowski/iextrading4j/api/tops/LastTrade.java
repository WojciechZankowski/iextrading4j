package pl.zankowski.iextrading4j.api.tops;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class LastTrade {

    private final String symbol;
    private final double price;
    private final int size;
    private final long time;

    @JsonCreator
    public LastTrade(@JsonProperty("symbol") String symbol,
                     @JsonProperty("price") double price,
                     @JsonProperty("size") int size,
                     @JsonProperty("time") long time) {
        this.symbol = symbol;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LastTrade lastTrade = (LastTrade) o;

        if (Double.compare(lastTrade.price, price) != 0) return false;
        if (size != lastTrade.size) return false;
        if (time != lastTrade.time) return false;
        return symbol != null ? symbol.equals(lastTrade.symbol) : lastTrade.symbol == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + size;
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "LastTrade{" +
                "symbol='" + symbol + '\'' +
                ", price=" + DoubleUtil.printDouble(price) +
                ", size=" + size +
                ", time=" + time +
                '}';
    }

}
