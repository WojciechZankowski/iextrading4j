package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CashFlowsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<CashFlow> cashFlow = Lists.newArrayList(fixture.collections().createCollection(CashFlow.class));
        final String symbol = fixture.create(String.class);

        final CashFlows cashFlows = new CashFlows(symbol, cashFlow);

        assertThat(cashFlows.getCashFlow()).isEqualTo(cashFlow);
        assertThat(cashFlows.getSymbol()).isEqualTo(symbol);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CashFlows.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CashFlows.class))
                .verify();
    }

}
