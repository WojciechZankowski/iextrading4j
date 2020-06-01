package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceSheetTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate reportDate = fixture.create(LocalDate.class);
        final LocalDate fiscalDate = fixture.create(LocalDate.class);
        final String currency = fixture.create(String.class);
        final BigDecimal currentCash = fixture.create(BigDecimal.class);
        final BigDecimal shortTermInvestments = fixture.create(BigDecimal.class);
        final BigDecimal receivables = fixture.create(BigDecimal.class);
        final BigDecimal inventory = fixture.create(BigDecimal.class);
        final BigDecimal otherCurrentAssets = fixture.create(BigDecimal.class);
        final BigDecimal currentAssets = fixture.create(BigDecimal.class);
        final BigDecimal longTermInvestments = fixture.create(BigDecimal.class);
        final BigDecimal propertyPlantEquipment = fixture.create(BigDecimal.class);
        final BigDecimal goodwill = fixture.create(BigDecimal.class);
        final BigDecimal intangibleAssets = fixture.create(BigDecimal.class);
        final BigDecimal otherAssets = fixture.create(BigDecimal.class);
        final BigDecimal totalAssets = fixture.create(BigDecimal.class);
        final BigDecimal accountsPayable = fixture.create(BigDecimal.class);
        final BigDecimal currentLongTermDebt = fixture.create(BigDecimal.class);
        final BigDecimal otherCurrentLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal totalCurrentLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal longTermDebt = fixture.create(BigDecimal.class);
        final BigDecimal otherLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal minorityInterest = fixture.create(BigDecimal.class);
        final BigDecimal totalLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal commonStock = fixture.create(BigDecimal.class);
        final BigDecimal retainedEarnings = fixture.create(BigDecimal.class);
        final BigDecimal treasuryStock = fixture.create(BigDecimal.class);
        final BigDecimal capitalSurplus = fixture.create(BigDecimal.class);
        final BigDecimal shareholderEquity = fixture.create(BigDecimal.class);
        final BigDecimal netTangibleAssets = fixture.create(BigDecimal.class);

        final BalanceSheet balanceSheet = new BalanceSheet(reportDate, fiscalDate, currency, currentCash,
                shortTermInvestments, receivables, inventory, otherCurrentAssets, currentAssets, longTermInvestments,
                propertyPlantEquipment, goodwill, intangibleAssets, otherAssets, totalAssets,
                accountsPayable, currentLongTermDebt, otherCurrentLiabilities, totalCurrentLiabilities,
                longTermDebt, otherLiabilities, minorityInterest, totalLiabilities, commonStock,
                retainedEarnings, treasuryStock, capitalSurplus, shareholderEquity, netTangibleAssets);

        assertThat(balanceSheet.getReportDate()).isEqualTo(reportDate);
        assertThat(balanceSheet.getFiscalDate()).isEqualTo(fiscalDate);
        assertThat(balanceSheet.getCurrency()).isEqualTo(currency);
        assertThat(balanceSheet.getCurrentCash()).isEqualTo(currentCash);
        assertThat(balanceSheet.getShortTermInvestments()).isEqualTo(shortTermInvestments);
        assertThat(balanceSheet.getReceivables()).isEqualTo(receivables);
        assertThat(balanceSheet.getInventory()).isEqualTo(inventory);
        assertThat(balanceSheet.getOtherCurrentAssets()).isEqualTo(otherCurrentAssets);
        assertThat(balanceSheet.getCurrentAssets()).isEqualTo(currentAssets);
        assertThat(balanceSheet.getLongTermInvestments()).isEqualTo(longTermInvestments);
        assertThat(balanceSheet.getPropertyPlantEquipment()).isEqualTo(propertyPlantEquipment);
        assertThat(balanceSheet.getGoodwill()).isEqualTo(goodwill);
        assertThat(balanceSheet.getIntangibleAssets()).isEqualTo(intangibleAssets);
        assertThat(balanceSheet.getOtherAssets()).isEqualTo(otherAssets);
        assertThat(balanceSheet.getTotalAssets()).isEqualTo(totalAssets);
        assertThat(balanceSheet.getAccountsPayable()).isEqualTo(accountsPayable);
        assertThat(balanceSheet.getCurrentLongTermDebt()).isEqualTo(currentLongTermDebt);
        assertThat(balanceSheet.getOtherCurrentLiabilities()).isEqualTo(otherCurrentLiabilities);
        assertThat(balanceSheet.getTotalCurrentLiabilities()).isEqualTo(totalCurrentLiabilities);
        assertThat(balanceSheet.getLongTermDebt()).isEqualTo(longTermDebt);
        assertThat(balanceSheet.getOtherLiabilities()).isEqualTo(otherLiabilities);
        assertThat(balanceSheet.getMinorityInterest()).isEqualTo(minorityInterest);
        assertThat(balanceSheet.getTotalLiabilities()).isEqualTo(totalLiabilities);
        assertThat(balanceSheet.getCommonStock()).isEqualTo(commonStock);
        assertThat(balanceSheet.getRetainedEarnings()).isEqualTo(retainedEarnings);
        assertThat(balanceSheet.getTreasuryStock()).isEqualTo(treasuryStock);
        assertThat(balanceSheet.getCapitalSurplus()).isEqualTo(capitalSurplus);
        assertThat(balanceSheet.getShareholderEquity()).isEqualTo(shareholderEquity);
        assertThat(balanceSheet.getNetTangibleAssets()).isEqualTo(netTangibleAssets);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(BalanceSheet.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BalanceSheet.class))
                .verify();
    }

}
