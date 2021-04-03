package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final List<BookEntry> bids = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));
        final List<BookEntry> asks = Lists.newArrayList(fixture.collections()
                .createCollection(BookEntry.class, 2));

        final Book book = new Book(symbol, bids, asks);

        assertThat(book.getSymbol()).isEqualTo(symbol);
        assertThat(book.getAsks()).isEqualTo(asks);
        assertThat(book.getBids()).isEqualTo(bids);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Book.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Book.class))
                .verify();
    }

}
