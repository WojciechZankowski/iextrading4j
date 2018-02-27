package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Quote quote = fixture.create(Quote.class);
        final List<BookEntry> bids = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));
        final List<BookEntry> asks = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));
        final List<Trade> trades = Lists.newArrayList(fixture.collections()
                .createCollection(Trade.class, 2));
        final SystemEvent systemEvent = fixture.create(SystemEvent.class);

        final Book book = new Book(quote, bids, asks, trades, systemEvent);

        assertThat(book.getQuote()).isEqualTo(quote);
        assertThat(book.getBids()).isEqualTo(bids);
        assertThat(book.getAsks()).isEqualTo(asks);
        assertThat(book.getTrades()).isEqualTo(trades);
        assertThat(book.getSystemEvent()).isEqualTo(systemEvent);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Book.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Book.class))
                .verify();
    }

}
