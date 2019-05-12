package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceSheetsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final List<BalanceSheet> balanceSheet = Lists.newArrayList(fixture.collections().createCollection(BalanceSheet.class));

        final BalanceSheets balanceSheets = new BalanceSheets(symbol, balanceSheet);

        assertThat(balanceSheets.getSymbol()).isEqualTo(symbol);
        assertThat(balanceSheets.getBalanceSheet()).isEqualTo(balanceSheet);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(BalanceSheets.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BalanceSheets.class))
                .verify();
    }

}
