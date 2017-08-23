package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class Financials {

    private final String symbol;
    private final Financial[] financialArray;

    @JsonCreator
    public Financials(@JsonProperty("symbol") String symbol,
                      @JsonProperty("financials") Financial[] financialArray) {
        this.symbol = symbol;
        this.financialArray = financialArray;
    }

    public String getSymbol() {
        return symbol;
    }

    public Financial[] getFinancialArray() {
        return financialArray;
    }

    @Override
    public String toString() {
        return "Financials{" +
                "symbol='" + symbol + '\'' +
                ", financialArray=" + Arrays.toString(financialArray) +
                '}';
    }

}
