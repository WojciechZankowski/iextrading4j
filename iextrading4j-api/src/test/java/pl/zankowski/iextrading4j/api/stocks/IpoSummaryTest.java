package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class IpoSummaryTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String company = fixture.create(String.class);
        final String symbol = fixture.create(String.class);
        final String price = fixture.create(String.class);
        final String shares = fixture.create(String.class);
        final String amount = fixture.create(String.class);
        final String floatValue = fixture.create(String.class);
        final String percent = fixture.create(String.class);
        final String market = fixture.create(String.class);
        final String expected = fixture.create(String.class);

        final IpoSummary ipoSummary = new IpoSummary(company, symbol, price, shares, amount, floatValue,
                percent, market, expected);

        assertThat(ipoSummary.getCompany()).isEqualTo(company);
        assertThat(ipoSummary.getSymbol()).isEqualTo(symbol);
        assertThat(ipoSummary.getPrice()).isEqualTo(price);
        assertThat(ipoSummary.getShares()).isEqualTo(shares);
        assertThat(ipoSummary.getAmount()).isEqualTo(amount);
        assertThat(ipoSummary.getFloat()).isEqualTo(floatValue);
        assertThat(ipoSummary.getPercent()).isEqualTo(percent);
        assertThat(ipoSummary.getMarket()).isEqualTo(market);
        assertThat(ipoSummary.getExpected()).isEqualTo(expected);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IpoSummary.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IpoSummary.class))
                .verify();
    }

}
