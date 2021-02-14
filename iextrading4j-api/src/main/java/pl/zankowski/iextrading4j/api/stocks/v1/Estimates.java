package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class Estimates implements Serializable {

    private static final long serialVersionUID = 6255534164444638078L;

    private final String symbol;
    private final List<Estimate> estimates;

    @JsonCreator
    public Estimates(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("estimates") final List<Estimate> estimates) {
        this.symbol = symbol;
        this.estimates = immutableList(estimates);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<Estimate> getEstimates() {
        return estimates;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Estimates estimates1 = (Estimates) o;
        return Objects.equal(symbol, estimates1.symbol) &&
                Objects.equal(estimates, estimates1.estimates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, estimates);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("estimates", estimates)
                .toString();
    }

}
