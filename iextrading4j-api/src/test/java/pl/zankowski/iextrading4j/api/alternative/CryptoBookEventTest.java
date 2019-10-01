package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoBookEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<CryptoBookEntry> asks = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEntry.class));
        final List<CryptoBookEntry> bids = Lists.newArrayList(fixture.collections()
                .createCollection(CryptoBookEntry.class));
        final String symbol = fixture.create(String.class);

        final CryptoBookEvent book = new CryptoBookEvent(asks, bids, symbol);

        assertThat(book.getAsk()).isEqualTo(asks);
        assertThat(book.getBid()).isEqualTo(bids);
        assertThat(book.getSymbol()).isEqualTo(symbol);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoBookEvent.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoBookEvent.class))
                .verify();
    }

}
