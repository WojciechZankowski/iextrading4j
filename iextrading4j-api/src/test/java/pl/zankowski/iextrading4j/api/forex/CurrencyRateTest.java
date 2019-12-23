package pl.zankowski.iextrading4j.api.forex;

import com.flextrade.jfixture.JFixture;
import com.sun.org.apache.xpath.internal.operations.Bool;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyRateTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal rate = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);
        final Boolean isDerived = fixture.create(Boolean.class);

        final CurrencyRate currencyConversion = new CurrencyRate(symbol, rate,
                timestamp, isDerived);

        assertThat(currencyConversion.getSymbol()).isEqualTo(symbol);
        assertThat(currencyConversion.getRate()).isEqualTo(rate);
        assertThat(currencyConversion.getTimestamp()).isEqualTo(timestamp);
        assertThat(currencyConversion.isDerived()).isEqualTo(isDerived);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CurrencyRate.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CurrencyRate.class))
                .verify();
    }
}
