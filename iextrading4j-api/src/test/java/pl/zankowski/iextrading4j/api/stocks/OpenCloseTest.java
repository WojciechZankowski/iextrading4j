package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenCloseTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Point open = fixture.create(Point.class);
        final Point close = fixture.create(Point.class);

        final OpenClose openClose = new OpenClose(open, close);

        assertThat(openClose.getOpen()).isEqualTo(open);
        assertThat(openClose.getClose()).isEqualTo(close);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(OpenClose.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(OpenClose.class))
                .verify();
    }

}
