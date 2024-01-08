package pl.zankowski.iextrading4j.api.system;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SystemStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String status = fixture.create(String.class);
        final String version = fixture.create(String.class);
        final Long time = fixture.create(Long.class);
        final BigDecimal currentMonthAPICalls = fixture.create(BigDecimal.class);

        final SystemStatus systemStatus = new SystemStatus(status, version, time, currentMonthAPICalls);

        assertThat(systemStatus.getStatus()).isEqualTo(status);
        assertThat(systemStatus.getVersion()).isEqualTo(version);
        assertThat(systemStatus.getTime()).isEqualTo(time);
        assertThat(systemStatus.getCurrentMonthAPICalls()).isEqualTo(systemStatus.getCurrentMonthAPICalls());
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SystemStatus.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SystemStatus.class))
                .verify();
    }

}
