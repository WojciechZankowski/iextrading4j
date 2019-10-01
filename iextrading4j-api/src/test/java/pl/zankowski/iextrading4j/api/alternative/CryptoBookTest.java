package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoBookTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<CryptoBookEvent> asks = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEvent.class));
        final List<CryptoBookEvent> bids = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEvent.class));

        final CryptoBook book = new CryptoBook(asks, bids);

        assertThat(book.getAsks()).isEqualTo(asks);
        assertThat(book.getBids()).isEqualTo(bids);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoBook.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoBook.class))
                .verify();
    }

}
