package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeSeriesTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String key = fixture.create(String.class);
        final String subkey = fixture.create(String.class);
        final Long updated = fixture.create(Long.class);
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
        final BigDecimal uOpen = fixture.create(BigDecimal.class);
        final BigDecimal uHigh = fixture.create(BigDecimal.class);
        final BigDecimal uLow = fixture.create(BigDecimal.class);
        final BigDecimal uClose = fixture.create(BigDecimal.class);
        final BigDecimal uVolume = fixture.create(BigDecimal.class);
        final BigDecimal fOpen = fixture.create(BigDecimal.class);
        final BigDecimal fHigh = fixture.create(BigDecimal.class);
        final BigDecimal fLow = fixture.create(BigDecimal.class);
        final BigDecimal fClose = fixture.create(BigDecimal.class);
        final BigDecimal fVolume = fixture.create(BigDecimal.class);

        final TimeSeries timeSeries = new TimeSeries(symbol, id, key, subkey, updated, date, open, high, low, close,
                volume, uOpen, uHigh, uLow, uClose, uVolume, fOpen, fHigh, fLow, fClose, fVolume, unadjustedVolume,
                change, changePercent, vwap, label, changeOverTime);

        assertThat(timeSeries.getSymbol()).isEqualTo(symbol);
        assertThat(timeSeries.getKey()).isEqualTo(key);
        assertThat(timeSeries.getSubkey()).isEqualTo(subkey);
        assertThat(timeSeries.getId()).isEqualTo(id);
        assertThat(timeSeries.getUpdated()).isEqualTo(updated);
        assertThat(timeSeries.getHigh()).isEqualTo(high);
        assertThat(timeSeries.getLow()).isEqualTo(low);
        assertThat(timeSeries.getVolume()).isEqualTo(volume);
        assertThat(timeSeries.getDate()).isEqualTo(date);
        assertThat(timeSeries.getOpen()).isEqualTo(open);
        assertThat(timeSeries.getClose()).isEqualTo(close);
        assertThat(timeSeries.getuOpen()).isEqualTo(uOpen);
        assertThat(timeSeries.getuClose()).isEqualTo(uClose);
        assertThat(timeSeries.getuHigh()).isEqualTo(uHigh);
        assertThat(timeSeries.getuLow()).isEqualTo(uLow);
        assertThat(timeSeries.getuVolume()).isEqualTo(uVolume);
        assertThat(timeSeries.getUnadjustedVolume()).isEqualTo(unadjustedVolume);
        assertThat(timeSeries.getChange()).isEqualTo(change);
        assertThat(timeSeries.getChangePercent()).isEqualTo(changePercent);
        assertThat(timeSeries.getVwap()).isEqualTo(vwap);
        assertThat(timeSeries.getLabel()).isEqualTo(label);
        assertThat(timeSeries.getChangeOverTime()).isEqualTo(changeOverTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(TimeSeries.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TimeSeries.class))
                .verify();
    }
}
