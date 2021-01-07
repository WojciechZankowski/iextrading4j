package pl.zankowski.iextrading4j.api.stocks.v1;

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
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String key = fixture.create(String.class);
        final String subkey = fixture.create(String.class);
        final Long updated = fixture.create(Long.class);
        final LocalDate reportDate = fixture.create(LocalDate.class);
        final LocalDate fiscalDate = fixture.create(LocalDate.class);
        final String filingType = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final BigDecimal fiscalQuarter = fixture.create(BigDecimal.class);
        final BigDecimal fiscalYear = fixture.create(BigDecimal.class);
        final BigDecimal EBITDA = fixture.create(BigDecimal.class);
        final BigDecimal accountsPayable = fixture.create(BigDecimal.class);
        final BigDecimal capitalSurplus = fixture.create(BigDecimal.class);
        final BigDecimal cashChange = fixture.create(BigDecimal.class);
        final BigDecimal cashFlow = fixture.create(BigDecimal.class);
        final BigDecimal cashFlowFinancing = fixture.create(BigDecimal.class);
        final BigDecimal changesInInventories = fixture.create(BigDecimal.class);
        final BigDecimal changesInReceivables = fixture.create(BigDecimal.class);
        final BigDecimal commonStock = fixture.create(BigDecimal.class);
        final BigDecimal costOfRevenue = fixture.create(BigDecimal.class);
        final BigDecimal currentAssets = fixture.create(BigDecimal.class);
        final BigDecimal currentCash = fixture.create(BigDecimal.class);
        final BigDecimal currentDebt = fixture.create(BigDecimal.class);
        final BigDecimal currentLongTermDebt = fixture.create(BigDecimal.class);
        final BigDecimal depreciation = fixture.create(BigDecimal.class);
        final BigDecimal dividendsPaid = fixture.create(BigDecimal.class);
        final BigDecimal ebit = fixture.create(BigDecimal.class);
        final BigDecimal exchangeRateEffect = fixture.create(BigDecimal.class);
        final BigDecimal goodwill = fixture.create(BigDecimal.class);
        final BigDecimal grossProfit = fixture.create(BigDecimal.class);
        final BigDecimal incomeTax = fixture.create(BigDecimal.class);
        final BigDecimal intangibleAssets = fixture.create(BigDecimal.class);
        final BigDecimal interestIncome = fixture.create(BigDecimal.class);
        final BigDecimal inventory = fixture.create(BigDecimal.class);
        final BigDecimal investingActivityOther = fixture.create(BigDecimal.class);
        final BigDecimal investments = fixture.create(BigDecimal.class);
        final BigDecimal longTermDebt = fixture.create(BigDecimal.class);
        final BigDecimal longTermInvestments = fixture.create(BigDecimal.class);
        final BigDecimal minorityInterest = fixture.create(BigDecimal.class);
        final BigDecimal netBorrowings = fixture.create(BigDecimal.class);
        final BigDecimal netIncome = fixture.create(BigDecimal.class);
        final BigDecimal netIncomeBasic = fixture.create(BigDecimal.class);
        final BigDecimal netTangibleAssets = fixture.create(BigDecimal.class);
        final BigDecimal operatingExpense = fixture.create(BigDecimal.class);
        final BigDecimal operatingIncome = fixture.create(BigDecimal.class);
        final BigDecimal operatingRevenue = fixture.create(BigDecimal.class);
        final BigDecimal otherAssets = fixture.create(BigDecimal.class);
        final BigDecimal otherCurrentAssets = fixture.create(BigDecimal.class);
        final BigDecimal otherCurrentLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal otherIncomeExpenseNet = fixture.create(BigDecimal.class);
        final BigDecimal otherLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal pretaxIncome = fixture.create(BigDecimal.class);
        final BigDecimal propertyPlantEquipment = fixture.create(BigDecimal.class);
        final BigDecimal receivables = fixture.create(BigDecimal.class);
        final BigDecimal researchAndDevelopment = fixture.create(BigDecimal.class);
        final BigDecimal retainedEarnings = fixture.create(BigDecimal.class);
        final BigDecimal revenue = fixture.create(BigDecimal.class);
        final BigDecimal sellingGeneralAndAdmin = fixture.create(BigDecimal.class);
        final BigDecimal shareholderEquity = fixture.create(BigDecimal.class);
        final BigDecimal shortTermDebt = fixture.create(BigDecimal.class);
        final BigDecimal shortTermInvestments = fixture.create(BigDecimal.class);
        final BigDecimal totalAssets = fixture.create(BigDecimal.class);
        final BigDecimal totalCash = fixture.create(BigDecimal.class);
        final BigDecimal totalDebt = fixture.create(BigDecimal.class);
        final BigDecimal totalInvestingCashFlows = fixture.create(BigDecimal.class);
        final BigDecimal totalLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal totalRevenue = fixture.create(BigDecimal.class);
        final BigDecimal treasuryStock = fixture.create(BigDecimal.class);

        final Financial financial = new Financial(symbol, id, key, subkey, updated, filingType, fiscalDate,
                fiscalQuarter, fiscalYear, reportDate, currency, EBITDA, accountsPayable, capitalSurplus, cashChange,
                cashFlow, cashFlowFinancing, changesInInventories, changesInReceivables, commonStock, costOfRevenue,
                currentAssets, currentCash, currentDebt, currentLongTermDebt, depreciation, dividendsPaid, ebit,
                exchangeRateEffect, goodwill, grossProfit, incomeTax, intangibleAssets, interestIncome, inventory,
                investingActivityOther, investments, longTermDebt, longTermInvestments, minorityInterest,
                netBorrowings, netIncome, netIncomeBasic, netTangibleAssets, operatingExpense, operatingIncome,
                operatingRevenue, otherAssets, otherCurrentAssets, otherCurrentLiabilities, otherIncomeExpenseNet,
                otherLiabilities, pretaxIncome, propertyPlantEquipment, receivables, researchAndDevelopment,
                retainedEarnings, revenue, sellingGeneralAndAdmin, shareholderEquity, shortTermDebt,
                shortTermInvestments, totalAssets, totalCash, totalDebt, totalInvestingCashFlows, totalLiabilities,
                totalRevenue, treasuryStock);

        assertThat(financial.getReportDate()).isEqualTo(reportDate);
        assertThat(financial.getFilingType()).isEqualTo(filingType);
        assertThat(financial.getFiscalYear()).isEqualTo(fiscalYear);
        assertThat(financial.getFiscalQuarter()).isEqualTo(fiscalQuarter);
        assertThat(financial.getFiscalDate()).isEqualTo(fiscalDate);
        assertThat(financial.getCurrency()).isEqualTo(currency);
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
        assertThat(financial.getShortTermDebt()).isEqualTo(shortTermDebt);
        assertThat(financial.getLongTermDebt()).isEqualTo(longTermDebt);
        assertThat(financial.getTotalCash()).isEqualTo(totalCash);
        assertThat(financial.getTotalDebt()).isEqualTo(totalDebt);
        assertThat(financial.getShareholderEquity()).isEqualTo(shareholderEquity);
        assertThat(financial.getCashChange()).isEqualTo(cashChange);
        assertThat(financial.getCashFlow()).isEqualTo(cashFlow);
        assertThat(financial.getEBITDA()).isEqualTo(EBITDA);
        assertThat(financial.getAccountsPayable()).isEqualTo(accountsPayable);
        assertThat(financial.getCapitalSurplus()).isEqualTo(capitalSurplus);
        assertThat(financial.getCashFlowFinancing()).isEqualTo(cashFlowFinancing);
        assertThat(financial.getChangesInInventories()).isEqualTo(changesInInventories);
        assertThat(financial.getChangesInReceivables()).isEqualTo(changesInReceivables);
        assertThat(financial.getCommonStock()).isEqualTo(commonStock);
        assertThat(financial.getCurrentLongTermDebt()).isEqualTo(currentLongTermDebt);
        assertThat(financial.getDepreciation()).isEqualTo(depreciation);
        assertThat(financial.getDividendsPaid()).isEqualTo(dividendsPaid);
        assertThat(financial.getEbit()).isEqualTo(ebit);
        assertThat(financial.getExchangeRateEffect()).isEqualTo(exchangeRateEffect);
        assertThat(financial.getGoodwill()).isEqualTo(goodwill);
        assertThat(financial.getIncomeTax()).isEqualTo(incomeTax);
        assertThat(financial.getIntangibleAssets()).isEqualTo(intangibleAssets);
        assertThat(financial.getInterestIncome()).isEqualTo(interestIncome);
        assertThat(financial.getInventory()).isEqualTo(inventory);
        assertThat(financial.getInvestingActivityOther()).isEqualTo(investingActivityOther);
        assertThat(financial.getInvestments()).isEqualTo(investments);
        assertThat(financial.getLongTermInvestments()).isEqualTo(longTermInvestments);
        assertThat(financial.getMinorityInterest()).isEqualTo(minorityInterest);
        assertThat(financial.getNetBorrowings()).isEqualTo(netBorrowings);
        assertThat(financial.getNetIncomeBasic()).isEqualTo(netIncomeBasic);
        assertThat(financial.getNetTangibleAssets()).isEqualTo(netTangibleAssets);
        assertThat(financial.getOtherAssets()).isEqualTo(otherAssets);
        assertThat(financial.getOtherCurrentAssets()).isEqualTo(otherCurrentAssets);
        assertThat(financial.getOtherCurrentLiabilities()).isEqualTo(otherCurrentLiabilities);
        assertThat(financial.getOtherIncomeExpenseNet()).isEqualTo(otherIncomeExpenseNet);
        assertThat(financial.getOtherLiabilities()).isEqualTo(otherLiabilities);
        assertThat(financial.getPretaxIncome()).isEqualTo(pretaxIncome);
        assertThat(financial.getPropertyPlantEquipment()).isEqualTo(propertyPlantEquipment);
        assertThat(financial.getReceivables()).isEqualTo(receivables);
        assertThat(financial.getRetainedEarnings()).isEqualTo(retainedEarnings);
        assertThat(financial.getRevenue()).isEqualTo(revenue);
        assertThat(financial.getSellingGeneralAndAdmin()).isEqualTo(sellingGeneralAndAdmin);
        assertThat(financial.getShortTermInvestments()).isEqualTo(shortTermInvestments);
        assertThat(financial.getTotalInvestingCashFlows()).isEqualTo(totalInvestingCashFlows);
        assertThat(financial.getTreasuryStock()).isEqualTo(treasuryStock);
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
