package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordsStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Record volume = fixture.create(Record.class);
        final Record symbolsTraded = fixture.create(Record.class);
        final Record routedVolume = fixture.create(Record.class);
        final Record notional = fixture.create(Record.class);

        final RecordsStats recordsStats = new RecordsStats(volume, symbolsTraded,
                routedVolume, notional);

        assertThat(recordsStats.getVolume()).isEqualTo(volume);
        assertThat(recordsStats.getSymbolsTraded()).isEqualTo(symbolsTraded);
        assertThat(recordsStats.getRoutedVolume()).isEqualTo(routedVolume);
        assertThat(recordsStats.getNotional()).isEqualTo(notional);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RecordsStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(RecordsStats.class))
                .verify();
    }

}
