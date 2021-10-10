package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TodayEarningsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<TodayEarning> bto = Lists.newArrayList(fixture.collections().createCollection(TodayEarning.class));
        final List<TodayEarning> amc = Lists.newArrayList(fixture.collections().createCollection(TodayEarning.class));
        final List<TodayEarning> other = Lists.newArrayList(fixture.collections().createCollection(TodayEarning.class));

        final TodayEarnings earning = new TodayEarnings(bto, amc, other);

        assertThat(earning.getBto()).isEqualTo(bto);
        assertThat(earning.getAmc()).isEqualTo(amc);
        assertThat(earning.getOther()).isEqualTo(other);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(TodayEarnings.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TodayEarnings.class))
                .verify();
    }
}
