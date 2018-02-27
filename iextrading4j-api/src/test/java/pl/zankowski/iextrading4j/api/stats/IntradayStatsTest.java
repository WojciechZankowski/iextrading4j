package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class IntradayStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final IntradayStat volume = fixture.create(IntradayStat.class);
        final IntradayStat symbolsTraded = fixture.create(IntradayStat.class);
        final IntradayStat routedVolume = fixture.create(IntradayStat.class);
        final IntradayStat notional = fixture.create(IntradayStat.class);
        final IntradayStat marketShare = fixture.create(IntradayStat.class);

        final IntradayStats intradayStats = new IntradayStats(volume, symbolsTraded,
                routedVolume, notional, marketShare);

        assertThat(intradayStats.getVolume()).isEqualTo(volume);
        assertThat(intradayStats.getSymbolsTraded()).isEqualTo(symbolsTraded);
        assertThat(intradayStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(intradayStats.getNotional()).isEqualTo(notional);
        assertThat(intradayStats.getMarketShare()).isEqualTo(marketShare);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IntradayStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IntradayStats.class))
                .verify();
    }

}
