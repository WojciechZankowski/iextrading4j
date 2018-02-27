package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final List<Earning> earningList = Lists.newArrayList(fixture.collections()
                .createCollection(Earning.class));

        final Earnings earnings = new Earnings(symbol, earningList);

        assertThat(earnings.getSymbol()).isEqualTo(symbol);
        assertThat(earnings.getEarnings()).isEqualTo(earningList);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Earnings.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Earnings.class))
                .verify();
    }

}
