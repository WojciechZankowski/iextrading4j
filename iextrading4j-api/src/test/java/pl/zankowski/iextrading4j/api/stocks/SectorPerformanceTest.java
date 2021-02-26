package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SectorPerformanceTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String type = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final BigDecimal performance = fixture.create(BigDecimal.class);
        final Long lastUpdated = fixture.create(Long.class);

        final SectorPerformance sectorPerformance = new SectorPerformance(type, name,
                performance, lastUpdated);

        assertThat(sectorPerformance.getType()).isEqualTo(type);
        assertThat(sectorPerformance.getName()).isEqualTo(name);
        assertThat(sectorPerformance.getPerformance()).isEqualTo(performance);
        assertThat(sectorPerformance.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SectorPerformance.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SectorPerformance.class))
                .verify();
    }

}
