package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoBookEntryTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);

        final CryptoBookEntry bookEvent = new CryptoBookEntry(price, size, timestamp);

        assertThat(bookEvent.getPrice()).isEqualTo(price);
        assertThat(bookEvent.getSize()).isEqualTo(size);
        assertThat(bookEvent.getTimestamp()).isEqualTo(timestamp);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoBookEntry.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoBookEntry.class))
                .verify();
    }

}
