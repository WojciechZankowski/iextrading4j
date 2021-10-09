package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BookEntryTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);

        final BookEntry bookEntry = new BookEntry(price, size, timestamp);

        assertThat(bookEntry.getPrice()).isEqualTo(price);
        assertThat(bookEntry.getSize()).isEqualTo(size);
        assertThat(bookEntry.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(BookEntry.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BookEntry.class))
                .verify();
    }

}
