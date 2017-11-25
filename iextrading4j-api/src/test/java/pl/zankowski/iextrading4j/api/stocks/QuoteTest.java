package pl.zankowski.iextrading4j.api.stocks;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class QuoteTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Quote.class)
                .usingGetClass()
                .verify();
    }

}
