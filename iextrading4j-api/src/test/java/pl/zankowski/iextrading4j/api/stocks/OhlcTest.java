package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class OhlcTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Point open = fixture.create(Point.class);
        final Point close = fixture.create(Point.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final BigDecimal low = fixture.create(BigDecimal.class);

        final Ohlc ohlc = new Ohlc(open, close, high, low);

        assertThat(ohlc.getOpen()).isEqualTo(open);
        assertThat(ohlc.getClose()).isEqualTo(close);
        assertThat(ohlc.getHigh()).isEqualTo(high);
        assertThat(ohlc.getLow()).isEqualTo(low);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Ohlc.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Ohlc.class))
                .verify();
    }

}
