package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RelevantTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Boolean peers = fixture.create(Boolean.class);
        final List<String> symbols = Lists.newArrayList(fixture.collections()
                .createCollection(String.class));

        final Relevant relevant = new Relevant(peers, symbols);

        assertThat(relevant.isPeers()).isEqualTo(peers);
        assertThat(relevant.getSymbols()).isEqualTo(symbols);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Relevant.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Relevant.class))
                .verify();
    }

}
