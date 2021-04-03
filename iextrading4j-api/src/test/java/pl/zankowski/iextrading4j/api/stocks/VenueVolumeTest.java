package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class VenueVolumeTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final String venue = fixture.create(String.class);
        final String venueName = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final BigDecimal marketPercent = fixture.create(BigDecimal.class);
        final BigDecimal avgMarketPercent = fixture.create(BigDecimal.class);

        final VenueVolume venueVolume = new VenueVolume(volume, venue, venueName, date,
                marketPercent, avgMarketPercent);

        assertThat(venueVolume.getVolume()).isEqualTo(volume);
        assertThat(venueVolume.getVenue()).isEqualTo(venue);
        assertThat(venueVolume.getVenueName()).isEqualTo(venueName);
        assertThat(venueVolume.getDate()).isEqualTo(date);
        assertThat(venueVolume.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(venueVolume.getAvgMarketPercent()).isEqualTo(avgMarketPercent);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(VenueVolume.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(VenueVolume.class))
                .verify();
    }

}
