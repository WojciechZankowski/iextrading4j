package pl.zankowski.iextrading4j.api.stats;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class HistoricalStatsTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HistoricalStats.class)
                .usingGetClass()
                .verify();
    }

}
