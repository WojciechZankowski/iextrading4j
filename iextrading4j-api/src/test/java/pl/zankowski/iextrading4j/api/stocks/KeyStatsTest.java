package pl.zankowski.iextrading4j.api.stocks;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class KeyStatsTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(KeyStats.class)
                .usingGetClass()
                .verify();
    }

}
