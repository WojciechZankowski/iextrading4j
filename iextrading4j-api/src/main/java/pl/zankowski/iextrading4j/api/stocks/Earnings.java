package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class Earnings {

    private final String symbol;
    private final Earning[] earningArray;

    @JsonCreator
    public Earnings(@JsonProperty("symbol") String symbol,
                    @JsonProperty("earnings") Earning[] earningArray) {
        this.symbol = symbol;
        this.earningArray = earningArray;
    }

    @Override
    public String toString() {
        return "Earnings{" +
                "symbol='" + symbol + '\'' +
                ", earningArray=" + Arrays.toString(earningArray) +
                '}';
    }

}
