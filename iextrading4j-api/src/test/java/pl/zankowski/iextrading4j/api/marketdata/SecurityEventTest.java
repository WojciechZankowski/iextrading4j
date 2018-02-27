package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final SecurityEventType securityEventType = fixture.create(SecurityEventType.class);
        final Long timestamp = fixture.create(Long.class);

        final SecurityEvent securityEvent = new SecurityEvent(securityEventType, timestamp);

        assertThat(securityEvent.getSecurityEvent()).isEqualTo(securityEventType);
        assertThat(securityEvent.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SecurityEvent.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SecurityEvent.class))
                .verify();
    }

}
