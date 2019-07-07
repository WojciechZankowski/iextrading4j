package pl.zankowski.iextrading4j.api.system;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String status = fixture.create(String.class);
        final String version = fixture.create(String.class);
        final Long time = fixture.create(Long.class);

        final SystemStatus systemStatus = new SystemStatus(status, version, time);

        assertThat(systemStatus.getStatus()).isEqualTo(status);
        assertThat(systemStatus.getVersion()).isEqualTo(version);
        assertThat(systemStatus.getTime()).isEqualTo(time);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SystemStatus.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SystemStatus.class))
                .verify();
    }

}
