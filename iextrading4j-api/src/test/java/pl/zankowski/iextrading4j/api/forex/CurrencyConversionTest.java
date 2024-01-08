package pl.zankowski.iextrading4j.api.forex;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyConversionTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal rate = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);
        final BigDecimal amount = fixture.create(BigDecimal.class);
        final Boolean isDerived = fixture.create(Boolean.class);

        final CurrencyConversion currencyConversion = new CurrencyConversion(symbol, rate,
                timestamp, amount, isDerived);

        assertThat(currencyConversion.getSymbol()).isEqualTo(symbol);
        assertThat(currencyConversion.getRate()).isEqualTo(rate);
        assertThat(currencyConversion.getTimestamp()).isEqualTo(timestamp);
        assertThat(currencyConversion.getAmount()).isEqualTo(amount);
        assertThat(currencyConversion.isDerived()).isEqualTo(isDerived);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CurrencyConversion.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY);
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CurrencyConversion.class))
                .verify();
    }

}
