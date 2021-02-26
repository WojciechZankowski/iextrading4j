package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BarDataTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal uOpen = fixture.create(BigDecimal.class);
        final BigDecimal uClose = fixture.create(BigDecimal.class);
        final BigDecimal uHigh = fixture.create(BigDecimal.class);
        final BigDecimal uLow = fixture.create(BigDecimal.class);
        final BigDecimal uVolume = fixture.create(BigDecimal.class);
        final BigDecimal change = fixture.create(BigDecimal.class);
        final BigDecimal changePercent = fixture.create(BigDecimal.class);
        final BigDecimal changeOverTime = fixture.create(BigDecimal.class);
        final String symbol = fixture.create(String.class);

        final BarData barData = new BarData(date, open, close, high, low, volume,
                uOpen, uClose, uHigh, uLow, uVolume, change, changePercent,
                changeOverTime, symbol);

        assertThat(barData.getDate()).isEqualTo(date);
        assertThat(barData.getOpen()).isEqualTo(open);
        assertThat(barData.getClose()).isEqualTo(close);
        assertThat(barData.getHigh()).isEqualTo(high);
        assertThat(barData.getLow()).isEqualTo(low);
        assertThat(barData.getVolume()).isEqualTo(volume);
        assertThat(barData.getuOpen()).isEqualTo(uOpen);
        assertThat(barData.getuClose()).isEqualTo(uClose);
        assertThat(barData.getuHigh()).isEqualTo(uHigh);
        assertThat(barData.getuLow()).isEqualTo(uLow);
        assertThat(barData.getuVolume()).isEqualTo(uVolume);
        assertThat(barData.getChange()).isEqualTo(change);
        assertThat(barData.getChangePercent()).isEqualTo(changePercent);
        assertThat(barData.getChangeOverTime()).isEqualTo(changeOverTime);
        assertThat(barData.getSymbol()).isEqualTo(symbol);
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
