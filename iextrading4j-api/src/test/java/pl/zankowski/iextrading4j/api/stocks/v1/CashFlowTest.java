package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CashFlowTest {

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
        final String currency = fixture.create(String.class);
        final BigDecimal netIncome = fixture.create(BigDecimal.class);
        final BigDecimal depreciation = fixture.create(BigDecimal.class);
        final BigDecimal changesInReceivables = fixture.create(BigDecimal.class);
        final BigDecimal changesInInventories = fixture.create(BigDecimal.class);
        final BigDecimal cashChange = fixture.create(BigDecimal.class);
        final BigDecimal cashFlow = fixture.create(BigDecimal.class);
        final BigDecimal capitalExpenditures = fixture.create(BigDecimal.class);
        final BigDecimal investments = fixture.create(BigDecimal.class);
        final BigDecimal investingActivityOther = fixture.create(BigDecimal.class);
        final BigDecimal totalInvestingCashFlows = fixture.create(BigDecimal.class);
        final BigDecimal dividendsPaid = fixture.create(BigDecimal.class);
        final BigDecimal netBorrowings = fixture.create(BigDecimal.class);
        final BigDecimal otherFinancingCashFlows = fixture.create(BigDecimal.class);
        final BigDecimal cashFlowFinancing = fixture.create(BigDecimal.class);
        final BigDecimal exchangeRateEffect = fixture.create(BigDecimal.class);
        final String filingType = fixture.create(String.class);
        final BigDecimal fiscalQuarter = fixture.create(BigDecimal.class);
        final BigDecimal fiscalYear = fixture.create(BigDecimal.class);

        final CashFlow result = new CashFlow(symbol, id, key, subkey, updated, reportDate, fiscalDate, currency,
                netIncome, depreciation, changesInReceivables, changesInInventories, cashChange, cashFlow,
                capitalExpenditures, investments, investingActivityOther, totalInvestingCashFlows,
                dividendsPaid, netBorrowings, otherFinancingCashFlows, cashFlowFinancing, exchangeRateEffect,
                filingType, fiscalQuarter, fiscalYear);

        assertThat(result.getReportDate()).isEqualTo(reportDate);
        assertThat(result.getFiscalDate()).isEqualTo(fiscalDate);
        assertThat(result.getCurrency()).isEqualTo(currency);
        assertThat(result.getNetIncome()).isEqualTo(netIncome);
        assertThat(result.getDepreciation()).isEqualTo(depreciation);
        assertThat(result.getChangesInReceivables()).isEqualTo(changesInReceivables);
        assertThat(result.getChangesInInventories()).isEqualTo(changesInInventories);
        assertThat(result.getCashChange()).isEqualTo(cashChange);
        assertThat(result.getCashFlow()).isEqualTo(cashFlow);
        assertThat(result.getCapitalExpenditures()).isEqualTo(capitalExpenditures);
        assertThat(result.getInvestments()).isEqualTo(investments);
        assertThat(result.getInvestingActivityOther()).isEqualTo(investingActivityOther);
        assertThat(result.getTotalInvestingCashFlows()).isEqualTo(totalInvestingCashFlows);
        assertThat(result.getDividendsPaid()).isEqualTo(dividendsPaid);
        assertThat(result.getNetBorrowings()).isEqualTo(netBorrowings);
        assertThat(result.getOtherFinancingCashFlows()).isEqualTo(otherFinancingCashFlows);
        assertThat(result.getCashFlowFinancing()).isEqualTo(cashFlowFinancing);
        assertThat(result.getExchangeRateEffect()).isEqualTo(exchangeRateEffect);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CashFlow.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CashFlow.class))
                .verify();
    }

}
