package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DelayedQuoteTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal delayedPrice = fixture.create(BigDecimal.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal delayedSize = fixture.create(BigDecimal.class);
        final Long delayedPriceTime = fixture.create(Long.class);
        final BigDecimal totalVolume = fixture.create(BigDecimal.class);
        final Long processedTime = fixture.create(Long.class);

        final DelayedQuote delayedQuote = new DelayedQuote(symbol, delayedPrice,
                high, low, delayedSize, delayedPriceTime, totalVolume, processedTime);

        assertThat(delayedQuote.getSymbol()).isEqualTo(symbol);
        assertThat(delayedQuote.getDelayedPrice()).isEqualTo(delayedPrice);
        assertThat(delayedQuote.getHigh()).isEqualTo(high);
        assertThat(delayedQuote.getLow()).isEqualTo(low);
        assertThat(delayedQuote.getDelayedSize()).isEqualTo(delayedSize);
        assertThat(delayedQuote.getDelayedPriceTime()).isEqualTo(delayedPriceTime);
        assertThat(delayedQuote.getTotalVolume()).isEqualTo(totalVolume);
        assertThat(delayedQuote.getProcessedTime()).isEqualTo(processedTime);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(DelayedQuote.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DelayedQuote.class))
                .verify();
    }

}
