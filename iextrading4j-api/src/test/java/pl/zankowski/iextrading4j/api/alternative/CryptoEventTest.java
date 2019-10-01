package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final CryptoEventType eventType = fixture.create(CryptoEventType.class);
        final Long timestamp = fixture.create(Long.class);
        final CryptoEventReason reason = fixture.create(CryptoEventReason.class);
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final CryptoSide side = fixture.create(CryptoSide.class);

        final CryptoEvent event = new CryptoEvent(symbol, eventType, timestamp,
                reason, price, size, side);

        assertThat(event.getSymbol()).isEqualTo(symbol);
        assertThat(event.getEventType()).isEqualTo(eventType);
        assertThat(event.getTimestamp()).isEqualTo(timestamp);
        assertThat(event.getReason()).isEqualTo(reason);
        assertThat(event.getPrice()).isEqualTo(price);
        assertThat(event.getSize()).isEqualTo(size);
        assertThat(event.getSide()).isEqualTo(side);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoEvent.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoEvent.class))
                .verify();
    }

}
