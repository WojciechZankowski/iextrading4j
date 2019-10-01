package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

@JsonPropertyOrder({"symbol", "asks", "bids"})
public class CryptoDetailedBook extends CryptoBook {

    private static final long serialVersionUID = -2249655496972607126L;

    private final String symbol;

    @JsonCreator
    public CryptoDetailedBook(
            @JsonProperty("bids") final List<CryptoBookEvent> bids,
            @JsonProperty("asks") final List<CryptoBookEvent> asks,
            @JsonProperty("symbol") final String symbol) {
        super(bids, asks);
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CryptoDetailedBook that = (CryptoDetailedBook) o;
        return Objects.equal(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), symbol);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .toString();
    }

}
