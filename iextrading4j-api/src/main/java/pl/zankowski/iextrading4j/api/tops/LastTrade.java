package pl.zankowski.iextrading4j.api.tops;

import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class LastTrade {

    private String symbol;
    private double price;
    private int size;
    private long time;

    public LastTrade() {
    }

    public LastTrade(String symbol, double price, int size, long time) {
        this.symbol = symbol;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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
