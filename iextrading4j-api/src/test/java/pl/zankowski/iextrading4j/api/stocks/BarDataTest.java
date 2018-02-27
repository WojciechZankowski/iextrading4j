package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BarDataTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal unadjustedVolume = fixture.create(BigDecimal.class);
        final BigDecimal change = fixture.create(BigDecimal.class);
        final BigDecimal changePercent = fixture.create(BigDecimal.class);
        final BigDecimal vwap = fixture.create(BigDecimal.class);

        final BarData barData = new BarData(symbol, date, open, high, low, close,
                volume, unadjustedVolume, change, changePercent, vwap);

        assertThat(barData.getSymbol()).isEqualTo(symbol);
        assertThat(barData.getDate()).isEqualTo(date);
        assertThat(barData.getOpen()).isEqualTo(open);
        assertThat(barData.getHigh()).isEqualTo(high);
        assertThat(barData.getLow()).isEqualTo(low);
        assertThat(barData.getClose()).isEqualTo(close);
        assertThat(barData.getVolume()).isEqualTo(volume);
        assertThat(barData.getUnadjustedVolume()).isEqualTo(unadjustedVolume);
        assertThat(barData.getChange()).isEqualTo(change);
        assertThat(barData.getChangePercent()).isEqualTo(changePercent);
        assertThat(barData.getVwap()).isEqualTo(vwap);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(BarData.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BarData.class))
                .verify();
    }

}
