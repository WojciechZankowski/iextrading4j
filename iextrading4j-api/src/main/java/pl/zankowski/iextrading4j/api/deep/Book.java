package pl.zankowski.iextrading4j.api.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class Book {

    private final String symbol;
    private final Quote[] bids;
    private final Quote[] asks;

    @JsonCreator
    public Book(
                @JsonProperty("bids") Quote[] bids,
                @JsonProperty("asks") Quote[] asks) {
        this.symbol = "";
        this.bids = bids;
        this.asks = asks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "symbol='" + symbol + '\'' +
                ", bids=" + Arrays.toString(bids) +
                ", asks=" + Arrays.toString(asks) +
                '}';
    }
}
