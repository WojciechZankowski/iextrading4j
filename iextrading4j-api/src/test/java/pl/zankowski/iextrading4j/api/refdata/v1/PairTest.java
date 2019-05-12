package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String from = fixture.create(String.class);
        final String to = fixture.create(String.class);

        final Pair pair = new Pair(from, to);

        assertThat(pair.getFrom()).isEqualTo(from);
        assertThat(pair.getTo()).isEqualTo(to);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Pair.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Pair.class))
                .verify();
    }

}
