package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class LogoTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String url = fixture.create(String.class);

        final Logo logo = new Logo(url);

        assertThat(logo.getUrl()).isEqualTo(url);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Logo.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Logo.class))
                .verify();
    }

}
