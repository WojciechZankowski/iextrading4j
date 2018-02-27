package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class EffectiveSpreadTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final String venue = fixture.create(String.class);
        final String venueName = fixture.create(String.class);
        final BigDecimal effectiveSpread = fixture.create(BigDecimal.class);
        final BigDecimal effectiveQuoted = fixture.create(BigDecimal.class);
        final BigDecimal priceImprovement = fixture.create(BigDecimal.class);

        final EffectiveSpread spread = new EffectiveSpread(volume, venue, venueName, effectiveSpread,
                effectiveQuoted, priceImprovement);

        assertThat(spread.getVolume()).isEqualTo(volume);
        assertThat(spread.getVenue()).isEqualTo(venue);
        assertThat(spread.getVenueName()).isEqualTo(venueName);
        assertThat(spread.getEffectiveSpread()).isEqualTo(effectiveSpread);
        assertThat(spread.getEffectiveQuoted()).isEqualTo(effectiveQuoted);
        assertThat(spread.getPriceImprovement()).isEqualTo(priceImprovement);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(EffectiveSpread.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(EffectiveSpread.class))
                .verify();
    }

}
