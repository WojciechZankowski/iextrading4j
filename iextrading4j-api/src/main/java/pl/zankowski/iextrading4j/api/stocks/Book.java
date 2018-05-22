package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.Trade;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"quote", "bids", "asks", "trades", "systemEvent"})
public class Book implements Serializable {

    private final Quote quote;
    private final List<BookEntry> bids;
    private final List<BookEntry> asks;
    private final List<Trade> trades;
    private final SystemEvent systemEvent;

    @JsonCreator
    public Book(
            @JsonProperty("quote") final Quote quote,
            @JsonProperty("bids") final List<BookEntry> bids,
            @JsonProperty("asks") final List<BookEntry> asks,
            @JsonProperty("trades") final List<Trade> trades,
            @JsonProperty("systemEvent") final SystemEvent systemEvent) {
        this.quote = quote;
        this.bids = immutableList(bids);
        this.asks = immutableList(asks);
        this.trades = immutableList(trades);
        this.systemEvent = systemEvent;
    }

    public Quote getQuote() {
        return quote;
    }

    public List<BookEntry> getBids() {
        return bids;
    }

    public List<BookEntry> getAsks() {
        return asks;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public SystemEvent getSystemEvent() {
        return systemEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equal(quote, book.quote) &&
                Objects.equal(bids, book.bids) &&
                Objects.equal(asks, book.asks) &&
                Objects.equal(trades, book.trades) &&
                Objects.equal(systemEvent, book.systemEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quote, bids, asks, trades, systemEvent);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("quote", quote)
                .add("bids", bids)
                .add("asks", asks)
                .add("trades", trades)
                .add("systemEvent", systemEvent)
                .toString();
    }
}
