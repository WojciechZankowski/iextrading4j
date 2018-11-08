package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TodayEarningsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<TodayEarning> bto = Lists.newArrayList(fixture.collections().createCollection(TodayEarning.class));
        final List<TodayEarning> amc = Lists.newArrayList(fixture.collections().createCollection(TodayEarning.class));

        final TodayEarnings earning = new TodayEarnings(bto, amc);

        assertThat(earning.getBto()).isEqualTo(bto);
        assertThat(earning.getAmc()).isEqualTo(amc);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(TodayEarnings.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TodayEarnings.class))
                .verify();
    }
}
