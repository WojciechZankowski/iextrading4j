package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ThresholdSecuritiesTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final LocalDate tradeDate = fixture.create(LocalDate.class);
        final String symbolInINETSymbology = fixture.create(String.class);
        final String symbolInCQSSymbology = fixture.create(String.class);
        final String symbolInCMSSymbology = fixture.create(String.class);
        final String cusip = fixture.create(String.class);
        final String securityName = fixture.create(String.class);

        final ThresholdSecurities thresholdSecurities = new ThresholdSecurities(tradeDate, symbolInINETSymbology,
                symbolInCQSSymbology, symbolInCMSSymbology, cusip, securityName);

        assertThat(thresholdSecurities.getTradeDate()).isEqualTo(tradeDate);
        assertThat(thresholdSecurities.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(thresholdSecurities.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(thresholdSecurities.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(thresholdSecurities.getCusip()).isEqualTo(cusip);
        assertThat(thresholdSecurities.getSecurityName()).isEqualTo(securityName);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(ThresholdSecurities.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(ThresholdSecurities.class))
                .verify();
    }

}
