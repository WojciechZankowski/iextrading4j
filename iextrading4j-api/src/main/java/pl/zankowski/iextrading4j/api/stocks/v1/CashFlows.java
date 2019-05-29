package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol", "cashflow"})
public class CashFlows implements Serializable {

    private static final long serialVersionUID = -3557377121216732338L;

    private final String symbol;
    private final List<CashFlow> cashFlow;

    @JsonCreator
    public CashFlows(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("cashflow") final List<CashFlow> cashFlow) {
        this.symbol = symbol;
        this.cashFlow = immutableList(cashFlow);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<CashFlow> getCashFlow() {
        return cashFlow;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CashFlows cashFlows = (CashFlows) o;
        return Objects.equal(symbol, cashFlows.symbol) &&
                Objects.equal(cashFlow, cashFlows.cashFlow);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, cashFlow);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("cashFlow", cashFlow)
                .toString();
    }

}
