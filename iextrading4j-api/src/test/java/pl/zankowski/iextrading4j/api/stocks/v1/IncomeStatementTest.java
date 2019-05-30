package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class IncomeStatementTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate reportDate = fixture.create(LocalDate.class);
        final BigDecimal totalRevenue = fixture.create(BigDecimal.class);
        final BigDecimal costOfRevenue = fixture.create(BigDecimal.class);
        final BigDecimal grossProfit = fixture.create(BigDecimal.class);
        final BigDecimal researchAndDevelopment = fixture.create(BigDecimal.class);
        final BigDecimal sellingGeneralAndAdmin = fixture.create(BigDecimal.class);
        final BigDecimal operatingExpense = fixture.create(BigDecimal.class);
        final BigDecimal operatingIncome = fixture.create(BigDecimal.class);
        final BigDecimal otherIncomeExpenseNet = fixture.create(BigDecimal.class);
        final BigDecimal ebit = fixture.create(BigDecimal.class);
        final BigDecimal interestIncome = fixture.create(BigDecimal.class);
        final BigDecimal pretaxIncome = fixture.create(BigDecimal.class);
        final BigDecimal incomeTax = fixture.create(BigDecimal.class);
        final BigDecimal minorityInterest = fixture.create(BigDecimal.class);
        final BigDecimal netIncome = fixture.create(BigDecimal.class);
        final BigDecimal netIncomeBasic = fixture.create(BigDecimal.class);

        final IncomeStatement incomeStatement = new IncomeStatement(reportDate, totalRevenue,
                costOfRevenue, grossProfit, researchAndDevelopment, sellingGeneralAndAdmin,
                operatingExpense, operatingIncome, otherIncomeExpenseNet, ebit, interestIncome,
                pretaxIncome, incomeTax, minorityInterest, netIncome, netIncomeBasic);

        assertThat(incomeStatement.getReportDate()).isEqualTo(reportDate);
        assertThat(incomeStatement.getTotalRevenue()).isEqualTo(totalRevenue);
        assertThat(incomeStatement.getCostOfRevenue()).isEqualTo(costOfRevenue);
        assertThat(incomeStatement.getGrossProfit()).isEqualTo(grossProfit);
        assertThat(incomeStatement.getResearchAndDevelopment()).isEqualTo(researchAndDevelopment);
        assertThat(incomeStatement.getSellingGeneralAndAdmin()).isEqualTo(sellingGeneralAndAdmin);
        assertThat(incomeStatement.getOperatingExpense()).isEqualTo(operatingExpense);
        assertThat(incomeStatement.getOperatingIncome()).isEqualTo(operatingIncome);
        assertThat(incomeStatement.getOtherIncomeExpenseNet()).isEqualTo(otherIncomeExpenseNet);
        assertThat(incomeStatement.getEbit()).isEqualTo(ebit);
        assertThat(incomeStatement.getInterestIncome()).isEqualTo(interestIncome);
        assertThat(incomeStatement.getPretaxIncome()).isEqualTo(pretaxIncome);
        assertThat(incomeStatement.getIncomeTax()).isEqualTo(incomeTax);
        assertThat(incomeStatement.getMinorityInterest()).isEqualTo(minorityInterest);
        assertThat(incomeStatement.getNetIncome()).isEqualTo(netIncome);
        assertThat(incomeStatement.getNetIncomeBasic()).isEqualTo(netIncomeBasic);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IncomeStatement.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IncomeStatement.class))
                .verify();
    }

}
