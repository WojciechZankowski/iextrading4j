package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RelevantTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Boolean peers = fixture.create(Boolean.class);
        final List<String> symbols = Lists.newArrayList(fixture.collections()
                .createCollection(String.class));

        final Relevant relevant = new Relevant(peers, symbols);

        assertThat(relevant.isPeers()).isEqualTo(peers);
        assertThat(relevant.getSymbols()).isEqualTo(symbols);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Relevant.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Relevant.class))
                .verify();
    }

}
