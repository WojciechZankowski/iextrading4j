package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class SectorTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String name = fixture.create(String.class);

        final Sector sector = new Sector(name);

        assertThat(sector.getName()).isEqualTo(name);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Sector.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Sector.class))
                .verify();
    }

}
