package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.IntradayStatDataBuilder.defaultIntradayStat;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStatTest {

    @Test
    public void shouldSuccessfullyCreateEmptyIntradayStat() {
        IntradayStat intradayStat = new IntradayStat();

        assertThat(intradayStat.getValue()).isEqualTo(0d);
        assertThat(intradayStat.getLastUpdated()).isEqualTo(0L);
    }

    @Test
    public void shouldSuccessfullyCreateIntradayStat() {
        final double value = 1234d;
        final long lastUpdated = 1489438707493L;

        IntradayStat intradayStat = new IntradayStat(value, lastUpdated);
        assertIntradayStat(intradayStat, value, lastUpdated);
    }

    @Test
    public void shouldSuccessfullySetDataIntoEmptyIntradayStat() {
        final double value = 1234d;
        final long lastUpdated = 1489438707493L;

        IntradayStat intradayStat = new IntradayStat();
        intradayStat.setValue(value);
        intradayStat.setLastUpdated(lastUpdated);

        assertIntradayStat(intradayStat, value, lastUpdated);
    }

    @Test
    public void shouldSuccessfullyEqualTwoIntradayStat() {
        IntradayStat intradayStat_1 = defaultIntradayStat();
        IntradayStat intradayStat_2 = defaultIntradayStat();

        assertThat(intradayStat_1.equals(intradayStat_2)).isTrue();
        assertThat(intradayStat_1.hashCode()).isEqualTo(intradayStat_2.hashCode());
    }

    private void assertIntradayStat(IntradayStat intradayStat, double value, long lastUpdated) {
        assertThat(intradayStat.getValue()).isEqualTo(value);
        assertThat(intradayStat.getLastUpdated()).isEqualTo(lastUpdated);
    }

}
