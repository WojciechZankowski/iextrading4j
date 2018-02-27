package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class OpHaltStatusTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Boolean isHalted = fixture.create(Boolean.class);
        final Long timestamp = fixture.create(Long.class);

        final OpHaltStatus opHaltStatus = new OpHaltStatus(isHalted, timestamp);

        assertThat(opHaltStatus.isHalted()).isEqualTo(isHalted);
        assertThat(opHaltStatus.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(OpHaltStatus.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(OpHaltStatus.class))
                .verify();
    }

}
