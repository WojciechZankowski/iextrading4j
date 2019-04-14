package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class FxSymbol implements Serializable {

    private final List<Currency> currencies;
    private final List<Pair> pairs;

    @JsonCreator
    public FxSymbol(
            @JsonProperty("currencies") final List<Currency> currencies,
            @JsonProperty("pairs") final List<Pair> pairs) {
        this.currencies = immutableList(currencies);
        this.pairs = immutableList(pairs);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FxSymbol)) return false;
        final FxSymbol fxSymbol = (FxSymbol) o;
        return Objects.equal(currencies, fxSymbol.currencies) &&
                Objects.equal(pairs, fxSymbol.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currencies, pairs);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currencies", currencies)
                .add("pairs", pairs)
                .toString();
    }

}
