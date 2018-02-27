package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SsrStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Boolean isSSR = fixture.create(Boolean.class);
        final String detail = fixture.create(String.class);
        final Long timestamp = fixture.create(Long.class);

        final SsrStatus ssrStatus = new SsrStatus(isSSR, detail, timestamp);

        assertThat(ssrStatus.isSSR()).isEqualTo(isSSR);
        assertThat(ssrStatus.getDetail()).isEqualTo(detail);
        assertThat(ssrStatus.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SsrStatus.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SsrStatus.class))
                .verify();
    }

}
