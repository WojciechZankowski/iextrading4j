package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String url = fixture.create(String.class);

        final Logo logo = new Logo(url);

        assertThat(logo.getUrl()).isEqualTo(url);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Logo.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Logo.class))
                .verify();
    }

}
