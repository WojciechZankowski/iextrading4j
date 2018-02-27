package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class FinancialTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate reportDate = fixture.create(LocalDate.class);
        final BigDecimal grossProfit = fixture.create(BigDecimal.class);
        final BigDecimal costOfRevenue = fixture.create(BigDecimal.class);
        final BigDecimal operatingRevenue = fixture.create(BigDecimal.class);
        final BigDecimal totalRevenue = fixture.create(BigDecimal.class);
        final BigDecimal operatingIncome = fixture.create(BigDecimal.class);
        final BigDecimal netIncome = fixture.create(BigDecimal.class);
        final BigDecimal researchAndDevelopment = fixture.create(BigDecimal.class);
        final BigDecimal operatingExpense = fixture.create(BigDecimal.class);
        final BigDecimal currentAssets = fixture.create(BigDecimal.class);
        final BigDecimal totalAssets = fixture.create(BigDecimal.class);
        final BigDecimal totalLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal currentCash = fixture.create(BigDecimal.class);
        final BigDecimal currentDebt = fixture.create(BigDecimal.class);
        final BigDecimal totalCash = fixture.create(BigDecimal.class);
        final BigDecimal totalDebt = fixture.create(BigDecimal.class);
        final BigDecimal shareholderEquity = fixture.create(BigDecimal.class);
        final BigDecimal cashChange = fixture.create(BigDecimal.class);
        final BigDecimal cashFlow = fixture.create(BigDecimal.class);
        final String operatingGainsLosses = fixture.create(String.class);

        final Financial financial = new Financial(reportDate, grossProfit, costOfRevenue, operatingRevenue,
                totalRevenue, operatingIncome, netIncome, researchAndDevelopment, operatingExpense,
                currentAssets, totalAssets, totalLiabilities, currentCash, currentDebt, totalCash,
                totalDebt, shareholderEquity, cashChange, cashFlow, operatingGainsLosses);

        assertThat(financial.getReportDate()).isEqualTo(reportDate);
        assertThat(financial.getGrossProfit()).isEqualTo(grossProfit);
        assertThat(financial.getCostOfRevenue()).isEqualTo(costOfRevenue);
        assertThat(financial.getOperatingRevenue()).isEqualTo(operatingRevenue);
        assertThat(financial.getTotalRevenue()).isEqualTo(totalRevenue);
        assertThat(financial.getOperatingIncome()).isEqualTo(operatingIncome);
        assertThat(financial.getNetIncome()).isEqualTo(netIncome);
        assertThat(financial.getResearchAndDevelopment()).isEqualTo(researchAndDevelopment);
        assertThat(financial.getOperatingExpense()).isEqualTo(operatingExpense);
        assertThat(financial.getCurrentAssets()).isEqualTo(currentAssets);
        assertThat(financial.getTotalAssets()).isEqualTo(totalAssets);
        assertThat(financial.getTotalLiabilities()).isEqualTo(totalLiabilities);
        assertThat(financial.getCurrentCash()).isEqualTo(currentCash);
        assertThat(financial.getCurrentDebt()).isEqualTo(currentDebt);
        assertThat(financial.getTotalCash()).isEqualTo(totalCash);
        assertThat(financial.getTotalDebt()).isEqualTo(totalDebt);
        assertThat(financial.getShareholderEquity()).isEqualTo(shareholderEquity);
        assertThat(financial.getCashChange()).isEqualTo(cashChange);
        assertThat(financial.getCashFlow()).isEqualTo(cashFlow);
        assertThat(financial.getOperatingGainsLosses()).isEqualTo(operatingGainsLosses);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Financial.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Financial.class))
                .verify();
    }

}
