package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol", "financials"})
public class Financials implements Serializable {

    private final String symbol;
    private final List<Financial> financials;

    @JsonCreator
    public Financials(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("financials") final List<Financial> financials) {
        this.symbol = symbol;
        this.financials = immutableList(financials);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<Financial> getFinancials() {
        return financials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financials that = (Financials) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(financials, that.financials);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, financials);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("financialArray", financials)
                .toString();
    }
}
