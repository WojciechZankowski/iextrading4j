package pl.zankowski.iextrading4j.api.market;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketVolumeTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String mic = fixture.create(String.class);
        final String tapeId = fixture.create(String.class);
        final String venueName = fixture.create(String.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal tapeA = fixture.create(BigDecimal.class);
        final BigDecimal tapeB = fixture.create(BigDecimal.class);
        final BigDecimal tapeC = fixture.create(BigDecimal.class);
        final BigDecimal marketPercent = fixture.create(BigDecimal.class);
        final Long lastUpdated = fixture.create(Long.class);

        final MarketVolume marketVolume = new MarketVolume(mic, tapeId, venueName, volume, tapeA, tapeB,
                tapeC, marketPercent, lastUpdated);

        assertThat(marketVolume.getMic()).isEqualTo(mic);
        assertThat(marketVolume.getTapeId()).isEqualTo(tapeId);
        assertThat(marketVolume.getVenueName()).isEqualTo(venueName);
        assertThat(marketVolume.getVolume()).isEqualTo(volume);
        assertThat(marketVolume.getTapeA()).isEqualTo(tapeA);
        assertThat(marketVolume.getTapeB()).isEqualTo(tapeB);
        assertThat(marketVolume.getTapeC()).isEqualTo(tapeC);
        assertThat(marketVolume.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(marketVolume.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(MarketVolume.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(MarketVolume.class))
                .verify();
    }

}
