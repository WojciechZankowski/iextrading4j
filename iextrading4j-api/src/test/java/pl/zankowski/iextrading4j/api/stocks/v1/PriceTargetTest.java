package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTargetTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final LocalDate updatedDate = fixture.create(LocalDate.class);
        final BigDecimal priceTargetAverage = fixture.create(BigDecimal.class);
        final BigDecimal priceTargetHigh = fixture.create(BigDecimal.class);
        final BigDecimal priceTargetLow = fixture.create(BigDecimal.class);
        final BigDecimal numberOfAnalysts = fixture.create(BigDecimal.class);
        final String currency = fixture.create(String.class);

        final PriceTarget priceTarget = new PriceTarget(symbol, updatedDate, priceTargetAverage,
                priceTargetHigh, priceTargetLow, numberOfAnalysts, currency);

        assertThat(priceTarget.getSymbol()).isEqualTo(symbol);
        assertThat(priceTarget.getUpdatedDate()).isEqualTo(updatedDate);
        assertThat(priceTarget.getPriceTargetAverage()).isEqualTo(priceTargetAverage);
        assertThat(priceTarget.getPriceTargetHigh()).isEqualTo(priceTargetHigh);
        assertThat(priceTarget.getPriceTargetLow()).isEqualTo(priceTargetLow);
        assertThat(priceTarget.getNumberOfAnalysts()).isEqualTo(numberOfAnalysts);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(PriceTarget.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(PriceTarget.class))
                .verify();
    }

}
