package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class SectorPerformanceTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String type = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final BigDecimal performance = fixture.create(BigDecimal.class);
        final Long lastUpdated = fixture.create(Long.class);

        final SectorPerformance sectorPerformance = new SectorPerformance(symbol, type, name,
                performance, lastUpdated);

        assertThat(sectorPerformance.getSymbol()).isEqualTo(symbol);
        assertThat(sectorPerformance.getType()).isEqualTo(type);
        assertThat(sectorPerformance.getName()).isEqualTo(name);
        assertThat(sectorPerformance.getPerformance()).isEqualTo(performance);
        assertThat(sectorPerformance.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SectorPerformance.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(SectorPerformance.class))
                .verify();
    }

}
