package pl.zankowski.iextrading4j.api.forex;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HistoricalCurrencyRateTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal rate = fixture.create(BigDecimal.class);
        final Long timestamp = fixture.create(Long.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final Boolean isDerived = fixture.create(Boolean.class);

        final HistoricalCurrencyRate historicalCurrencyRate = new HistoricalCurrencyRate(symbol, rate,
                timestamp, date, isDerived);

        assertThat(historicalCurrencyRate.getSymbol()).isEqualTo(symbol);
        assertThat(historicalCurrencyRate.getRate()).isEqualTo(rate);
        assertThat(historicalCurrencyRate.getTimestamp()).isEqualTo(timestamp);
        assertThat(historicalCurrencyRate.getDate()).isEqualTo(date);
        assertThat(historicalCurrencyRate.isDerived()).isEqualTo(isDerived);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(HistoricalCurrencyRate.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HistoricalCurrencyRate.class))
                .verify();
    }

}
