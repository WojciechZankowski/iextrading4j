package pl.zankowski.iextrading4j.api.forex;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final String fromCurrency = fixture.create(String.class);
        final String toCurrency = fixture.create(String.class);
        final BigDecimal rate = fixture.create(BigDecimal.class);

        final ExchangeRate exchangeRate = new ExchangeRate(date, fromCurrency, toCurrency, rate);

        assertThat(exchangeRate.getDate()).isEqualTo(date);
        assertThat(exchangeRate.getFromCurrency()).isEqualTo(fromCurrency);
        assertThat(exchangeRate.getToCurrency()).isEqualTo(toCurrency);
        assertThat(exchangeRate.getRate()).isEqualTo(rate);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(ExchangeRate.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(ExchangeRate.class))
                .verify();
    }

}
