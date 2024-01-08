package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class SsrStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Boolean isSSR = fixture.create(Boolean.class);
        final String detail = fixture.create(String.class);
        final Long timestamp = fixture.create(Long.class);

        final SsrStatus ssrStatus = new SsrStatus(isSSR, detail, timestamp);

        assertThat(ssrStatus.isSSR()).isEqualTo(isSSR);
        assertThat(ssrStatus.getDetail()).isEqualTo(detail);
        assertThat(ssrStatus.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SsrStatus.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SsrStatus.class))
                .verify();
    }

}
