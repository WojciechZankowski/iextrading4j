package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoDetailedBookTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<CryptoBookEvent> asks = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEvent.class));
        final List<CryptoBookEvent> bids = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEvent.class));
        final String symbol = fixture.create(String.class);

        final CryptoDetailedBook book = new CryptoDetailedBook(asks, bids, symbol);

        assertThat(book.getAsks()).isEqualTo(asks);
        assertThat(book.getBids()).isEqualTo(bids);
        assertThat(book.getSymbol()).isEqualTo(symbol);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoDetailedBook.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoDetailedBook.class))
                .verify();
    }

}
