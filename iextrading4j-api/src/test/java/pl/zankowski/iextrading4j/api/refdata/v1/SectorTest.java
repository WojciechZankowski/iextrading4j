package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class SectorTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String name = fixture.create(String.class);

        final Sector sector = new Sector(name);

        assertThat(sector.getName()).isEqualTo(name);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Sector.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Sector.class))
                .verify();
    }

}
