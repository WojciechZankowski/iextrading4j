package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol", "earnings"})
public class Earnings implements Serializable {

    private final String symbol;
    private final List<Earning> earnings;

    @JsonCreator
    public Earnings(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("earnings") final List<Earning> earnings) {
        this.symbol = symbol;
        this.earnings = immutableList(earnings);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<Earning> getEarnings() {
        return earnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earnings earnings1 = (Earnings) o;
        return Objects.equal(symbol, earnings1.symbol) &&
                Objects.equal(earnings, earnings1.earnings);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, earnings);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("earnings", earnings)
                .toString();
    }
}
