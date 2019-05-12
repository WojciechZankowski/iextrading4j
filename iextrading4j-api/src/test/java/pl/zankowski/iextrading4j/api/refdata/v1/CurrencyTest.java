package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String code = fixture.create(String.class);
        final String name = fixture.create(String.class);

        final Currency currency = new Currency(code, name);

        assertThat(currency.getCode()).isEqualTo(code);
        assertThat(currency.getName()).isEqualTo(name);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Currency.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Currency.class))
                .verify();
    }

}
