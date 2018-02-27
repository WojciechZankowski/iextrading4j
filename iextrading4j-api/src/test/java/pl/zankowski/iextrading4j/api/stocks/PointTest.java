package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final Long time = fixture.create(Long.class);

        final Point point = new Point(price, time);

        assertThat(point.getPrice()).isEqualTo(price);
        assertThat(point.getTime()).isEqualTo(time);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Point.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Point.class))
                .verify();
    }

}
