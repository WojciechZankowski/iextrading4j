package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String code = fixture.create(String.class);
        final String name = fixture.create(String.class);

        final Currency currency = new Currency(code, name);

        assertThat(currency.getCode()).isEqualTo(code);
        assertThat(currency.getName()).isEqualTo(name);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Currency.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Currency.class))
                .verify();
    }

}
