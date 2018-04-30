package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChartTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String minute = fixture.create(String.class);
        final BigDecimal marketAverage = fixture.create(BigDecimal.class);
        final BigDecimal marketNotional = fixture.create(BigDecimal.class);
        final BigDecimal marketNumberOfTrades = fixture.create(BigDecimal.class);
        final BigDecimal marketHigh = fixture.create(BigDecimal.class);
        final BigDecimal marketLow = fixture.create(BigDecimal.class);
        final BigDecimal marketVolume = fixture.create(BigDecimal.class);
        final BigDecimal marketChangeOverTime = fixture.create(BigDecimal.class);
        final BigDecimal marketOpen = fixture.create(BigDecimal.class);
        final BigDecimal marketClose = fixture.create(BigDecimal.class);
        final BigDecimal average = fixture.create(BigDecimal.class);
        final BigDecimal notional = fixture.create(BigDecimal.class);
        final BigDecimal numberOfTrades = fixture.create(BigDecimal.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final String date = fixture.create(String.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final BigDecimal unadjustedVolume = fixture.create(BigDecimal.class);
        final BigDecimal change = fixture.create(BigDecimal.class);
        final BigDecimal changePercent = fixture.create(BigDecimal.class);
        final BigDecimal vwap = fixture.create(BigDecimal.class);
        final String label = fixture.create(String.class);
        final BigDecimal changeOverTime = fixture.create(BigDecimal.class);
        final List<BigDecimal> simplifyFactor = Lists.newArrayList(
                fixture.collections().createCollection(BigDecimal.class));

        final Chart chart = new Chart(minute, marketAverage, marketNotional, marketNumberOfTrades, marketHigh,
                marketLow, marketVolume, marketChangeOverTime, marketOpen, marketClose, average, notional,
                numberOfTrades, simplifyFactor, high, low, volume, label, changeOverTime, date, open, close,
                unadjustedVolume, change, changePercent, vwap);

        assertThat(chart.getMinute()).isEqualTo(minute);
        assertThat(chart.getMarketAverage()).isEqualByComparingTo(marketAverage);
        assertThat(chart.getMarketNotional()).isEqualByComparingTo(marketNotional);
        assertThat(chart.getMarketNumberOfTrades()).isEqualByComparingTo(marketNumberOfTrades);
        assertThat(chart.getMarketHigh()).isEqualByComparingTo(marketHigh);
        assertThat(chart.getMarketLow()).isEqualByComparingTo(marketLow);
        assertThat(chart.getMarketVolume()).isEqualByComparingTo(marketVolume);
        assertThat(chart.getMarketChangeOverTime()).isEqualByComparingTo(marketChangeOverTime);
        assertThat(chart.getMarketOpen()).isEqualByComparingTo(marketOpen);
        assertThat(chart.getMarketClose()).isEqualByComparingTo(marketClose);
        assertThat(chart.getAverage()).isEqualTo(average);
        assertThat(chart.getNotional()).isEqualTo(notional);
        assertThat(chart.getNumberOfTrades()).isEqualTo(numberOfTrades);
        assertThat(chart.getHigh()).isEqualTo(high);
        assertThat(chart.getLow()).isEqualTo(low);
        assertThat(chart.getVolume()).isEqualTo(volume);
        assertThat(chart.getDate()).isEqualTo(date);
        assertThat(chart.getOpen()).isEqualTo(open);
        assertThat(chart.getClose()).isEqualTo(close);
        assertThat(chart.getUnadjustedVolume()).isEqualTo(unadjustedVolume);
        assertThat(chart.getChange()).isEqualTo(change);
        assertThat(chart.getChangePercent()).isEqualTo(changePercent);
        assertThat(chart.getVwap()).isEqualTo(vwap);
        assertThat(chart.getLabel()).isEqualTo(label);
        assertThat(chart.getChangeOverTime()).isEqualTo(changeOverTime);
        assertThat(chart.getSimplifyFactor()).isEqualTo(simplifyFactor);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Chart.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Chart.class))
                .verify();
    }

}
