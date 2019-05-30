package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class IntradayTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String date = fixture.create(String.class);
        final String minute = fixture.create(String.class);
        final String label = fixture.create(String.class);
        final BigDecimal marketOpen = fixture.create(BigDecimal.class);
        final BigDecimal marketClose = fixture.create(BigDecimal.class);
        final BigDecimal marketHigh = fixture.create(BigDecimal.class);
        final BigDecimal marketLow = fixture.create(BigDecimal.class);
        final BigDecimal marketAverage = fixture.create(BigDecimal.class);
        final BigDecimal marketVolume = fixture.create(BigDecimal.class);
        final BigDecimal marketNotional = fixture.create(BigDecimal.class);
        final BigDecimal marketNumberOfTrades = fixture.create(BigDecimal.class);
        final BigDecimal marketChangeOverTime = fixture.create(BigDecimal.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final BigDecimal average = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal notional = fixture.create(BigDecimal.class);
        final BigDecimal numberOfTrades = fixture.create(BigDecimal.class);
        final BigDecimal changeOverTime = fixture.create(BigDecimal.class);

        final Intraday intraday = new Intraday(date, minute, label, marketOpen, marketClose,
                marketHigh, marketLow, marketAverage, marketVolume, marketNotional,
                marketNumberOfTrades, marketChangeOverTime, high, low, open, close, average,
                volume, notional, numberOfTrades, changeOverTime);

        assertThat(intraday.getDate()).isEqualTo(date);
        assertThat(intraday.getMinute()).isEqualTo(minute);
        assertThat(intraday.getLabel()).isEqualTo(label);
        assertThat(intraday.getMarketOpen()).isEqualTo(marketOpen);
        assertThat(intraday.getMarketClose()).isEqualTo(marketClose);
        assertThat(intraday.getMarketHigh()).isEqualTo(marketHigh);
        assertThat(intraday.getMarketLow()).isEqualTo(marketLow);
        assertThat(intraday.getMarketAverage()).isEqualTo(marketAverage);
        assertThat(intraday.getMarketVolume()).isEqualTo(marketVolume);
        assertThat(intraday.getMarketNotional()).isEqualTo(marketNotional);
        assertThat(intraday.getMarketNumberOfTrades()).isEqualTo(marketNumberOfTrades);
        assertThat(intraday.getMarketChangeOverTime()).isEqualTo(marketChangeOverTime);
        assertThat(intraday.getHigh()).isEqualTo(high);
        assertThat(intraday.getLow()).isEqualTo(low);
        assertThat(intraday.getOpen()).isEqualTo(open);
        assertThat(intraday.getClose()).isEqualTo(close);
        assertThat(intraday.getAverage()).isEqualTo(average);
        assertThat(intraday.getVolume()).isEqualTo(volume);
        assertThat(intraday.getNotional()).isEqualTo(notional);
        assertThat(intraday.getNumberOfTrades()).isEqualTo(numberOfTrades);
        assertThat(intraday.getChangeOverTime()).isEqualTo(changeOverTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Intraday.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Intraday.class))
                .verify();
    }

}
