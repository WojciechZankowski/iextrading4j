package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class UsExchangeTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String name = fixture.create(String.class);
        final String longName = fixture.create(String.class);
        final String mic = fixture.create(String.class);
        final String tapeId = fixture.create(String.class);
        final String oatsId = fixture.create(String.class);
        final String refId = fixture.create(String.class);
        final String type = fixture.create(String.class);

        final UsExchange usExchange = new UsExchange(name, longName, mic, tapeId, oatsId, refId, type);

        assertThat(usExchange.getName()).isEqualTo(name);
        assertThat(usExchange.getLongName()).isEqualTo(longName);
        assertThat(usExchange.getMic()).isEqualTo(mic);
        assertThat(usExchange.getTapeId()).isEqualTo(tapeId);
        assertThat(usExchange.getOatsId()).isEqualTo(oatsId);
        assertThat(usExchange.getRefId()).containsSequence(refId);
        assertThat(usExchange.getType()).isEqualTo(type);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(UsExchange.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(UsExchange.class))
                .verify();
    }

}
