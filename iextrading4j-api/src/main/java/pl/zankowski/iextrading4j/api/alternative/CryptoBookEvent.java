package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class CryptoBookEvent implements Serializable {

    private static final long serialVersionUID = -2249655496972607126L;

    private final String symbol;
    private final List<BookEntry> bid;
    private final List<BookEntry> ask;

    @JsonCreator
    public CryptoBookEvent(
            @JsonProperty("bids") final List<BookEntry> bid,
            @JsonProperty("asks") final List<BookEntry> ask,
            @JsonProperty("symbol") final String symbol) {
        this.symbol = symbol;
        this.bid = immutableList(bid);
        this.ask = immutableList(ask);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<BookEntry> getBid() {
        return bid;
    }

    public List<BookEntry> getAsk() {
        return ask;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CryptoBookEvent that = (CryptoBookEvent) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(bid, that.bid) &&
                Objects.equal(ask, that.ask);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, bid, ask);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("bid", bid)
                .add("ask", ask)
                .toString();
    }

}
