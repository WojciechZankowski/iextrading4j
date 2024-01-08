package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class PairTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String from = fixture.create(String.class);
        final String to = fixture.create(String.class);

        final Pair pair = new Pair(from, to);

        assertThat(pair.getFrom()).isEqualTo(from);
        assertThat(pair.getTo()).isEqualTo(to);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Pair.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Pair.class))
                .verify();
    }

}
