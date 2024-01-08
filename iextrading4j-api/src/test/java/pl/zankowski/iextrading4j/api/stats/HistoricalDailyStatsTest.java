package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HistoricalDailyStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal routedVolume = fixture.create(BigDecimal.class);
        final BigDecimal marketShare = fixture.create(BigDecimal.class);
        final Boolean isHalfday = fixture.create(Boolean.class);
        final BigDecimal litVolume = fixture.create(BigDecimal.class);

        final HistoricalDailyStats historicalDailyStats = new HistoricalDailyStats(date, volume,
                routedVolume, marketShare, isHalfday, litVolume);

        assertThat(historicalDailyStats.getDate()).isEqualTo(date);
        assertThat(historicalDailyStats.getVolume()).isEqualTo(volume);
        assertThat(historicalDailyStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(historicalDailyStats.getMarketShare()).isEqualTo(marketShare);
        assertThat(historicalDailyStats.isHalfday()).isEqualTo(isHalfday);
        assertThat(historicalDailyStats.getLitVolume()).isEqualTo(litVolume);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(HistoricalDailyStats.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HistoricalDailyStats.class))
                .verify();
    }

}
