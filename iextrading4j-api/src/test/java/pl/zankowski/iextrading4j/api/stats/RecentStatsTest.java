package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal routedVolume = fixture.create(BigDecimal.class);
        final BigDecimal marketShare = fixture.create(BigDecimal.class);
        final Boolean isHalfday = fixture.create(Boolean.class);
        final BigDecimal litVolume = fixture.create(BigDecimal.class);

        final RecentStats recentStats = new RecentStats(date, volume, routedVolume,
                marketShare, isHalfday, litVolume);

        assertThat(recentStats.getDate()).isEqualTo(date);
        assertThat(recentStats.getVolume()).isEqualTo(volume);
        assertThat(recentStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(recentStats.getMarketShare()).isEqualTo(marketShare);
        assertThat(recentStats.isHalfday()).isEqualTo(isHalfday);
        assertThat(recentStats.getLitVolume()).isEqualTo(litVolume);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RecentStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(RecentStats.class))
                .verify();
    }

}
