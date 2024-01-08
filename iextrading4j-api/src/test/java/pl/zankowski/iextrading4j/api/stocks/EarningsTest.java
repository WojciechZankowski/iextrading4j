package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EarningsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final List<Earning> earningList = Lists.newArrayList(fixture.collections()
                .createCollection(Earning.class));

        final Earnings earnings = new Earnings(symbol, earningList);

        assertThat(earnings.getSymbol()).isEqualTo(symbol);
        assertThat(earnings.getEarnings()).isEqualTo(earningList);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Earnings.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Earnings.class))
                .verify();
    }

}
