package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FinancialsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final List<Financial> financialList = Lists.newArrayList(fixture.collections()
                .createCollection(Financial.class));

        final Financials financials = new Financials(symbol, financialList);

        assertThat(financials.getSymbol()).isEqualTo(symbol);
        assertThat(financials.getFinancials()).isEqualTo(financialList);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Financials.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Financials.class))
                .verify();
    }

}
