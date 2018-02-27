package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class IntradayStatTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal value = fixture.create(BigDecimal.class);
        final Long lastUpdated = fixture.create(Long.class);

        final IntradayStat intradayStat = new IntradayStat(value, lastUpdated);

        assertThat(intradayStat.getValue()).isEqualTo(value);
        assertThat(intradayStat.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IntradayStat.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IntradayStat.class))
                .verify();
    }

}
