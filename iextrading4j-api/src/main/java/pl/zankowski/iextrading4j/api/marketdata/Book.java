package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class Book implements DeepResult {

    private static final long serialVersionUID = -5500382403416100795L;

    private final String symbol;
    private final List<BookEntry> bids;
    private final List<BookEntry> asks;

    @JsonCreator
    public Book(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("bids") final List<BookEntry> bids,
            @JsonProperty("asks") final List<BookEntry> asks) {
        this.symbol = symbol;
        this.bids = immutableList(bids);
        this.asks = immutableList(asks);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<BookEntry> getBids() {
        return bids;
    }

    public List<BookEntry> getAsks() {
        return asks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equal(symbol, book.symbol) &&
                Objects.equal(bids, book.bids) &&
                Objects.equal(asks, book.asks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, bids, asks);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("bids", bids)
                .add("asks", asks)
                .toString();
    }
}
