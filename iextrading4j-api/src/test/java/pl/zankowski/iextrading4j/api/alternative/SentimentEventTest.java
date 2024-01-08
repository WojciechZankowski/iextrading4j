package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SentimentEventTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal score = fixture.create(BigDecimal.class);
        final BigDecimal sequence = fixture.create(BigDecimal.class);
        final BigDecimal date = fixture.create(BigDecimal.class);

        final SentimentEvent sentimentEvent = new SentimentEvent(symbol, score, sequence, date);

        assertThat(sentimentEvent.getSymbol()).isEqualTo(symbol);
        assertThat(sentimentEvent.getScore()).isEqualTo(score);
        assertThat(sentimentEvent.getSequence()).isEqualTo(sequence);
        assertThat(sentimentEvent.getDate()).isEqualTo(date);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SentimentEvent.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SentimentEvent.class))
                .verify();
    }

}
