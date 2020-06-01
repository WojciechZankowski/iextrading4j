package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class CashFlow extends Report {

    private static final Long serialVersionUID = 3659383763381838960L;

    private final BigDecimal netIncome;
    private final BigDecimal depreciation;
    private final BigDecimal changesInReceivables;
    private final BigDecimal changesInInventories;
    private final BigDecimal cashChange;
    private final BigDecimal cashFlow;
    private final BigDecimal capitalExpenditures;
    private final BigDecimal investments;
    private final BigDecimal investingActivityOther;
    private final BigDecimal totalInvestingCashFlows;
    private final BigDecimal dividendsPaid;
    private final BigDecimal netBorrowings;
    private final BigDecimal otherFinancingCashFlows;
    private final BigDecimal cashFlowFinancing;
    private final BigDecimal exchangeRateEffect;

    @JsonCreator
    public CashFlow(
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("fiscalDate") final LocalDate fiscalDate,
            @JsonProperty("currency") final String currency,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("depreciation") final BigDecimal depreciation,
            @JsonProperty("changesInReceivables") final BigDecimal changesInReceivables,
            @JsonProperty("changesInInventories") final BigDecimal changesInInventories,
            @JsonProperty("cashChange") final BigDecimal cashChange,
            @JsonProperty("cashFlow") final BigDecimal cashFlow,
            @JsonProperty("capitalExpenditures") final BigDecimal capitalExpenditures,
            @JsonProperty("investments") final BigDecimal investments,
            @JsonProperty("investingActivityOther") final BigDecimal investingActivityOther,
            @JsonProperty("totalInvestingCashFlows") final BigDecimal totalInvestingCashFlows,
            @JsonProperty("dividendsPaid") final BigDecimal dividendsPaid,
            @JsonProperty("netBorrowings") final BigDecimal netBorrowings,
            @JsonProperty("otherFinancingCashFlows") final BigDecimal otherFinancingCashFlows,
            @JsonProperty("cashFlowFinancing") final BigDecimal cashFlowFinancing,
            @JsonProperty("exchangeRateEffect") final BigDecimal exchangeRateEffect) {
        super(reportDate, fiscalDate, currency);
        this.netIncome = netIncome;
        this.depreciation = depreciation;
        this.changesInReceivables = changesInReceivables;
        this.changesInInventories = changesInInventories;
        this.cashChange = cashChange;
        this.cashFlow = cashFlow;
        this.capitalExpenditures = capitalExpenditures;
        this.investments = investments;
        this.investingActivityOther = investingActivityOther;
        this.totalInvestingCashFlows = totalInvestingCashFlows;
        this.dividendsPaid = dividendsPaid;
        this.netBorrowings = netBorrowings;
        this.otherFinancingCashFlows = otherFinancingCashFlows;
        this.cashFlowFinancing = cashFlowFinancing;
        this.exchangeRateEffect = exchangeRateEffect;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getDepreciation() {
        return depreciation;
    }

    public BigDecimal getChangesInReceivables() {
        return changesInReceivables;
    }

    public BigDecimal getChangesInInventories() {
        return changesInInventories;
    }

    public BigDecimal getCashChange() {
        return cashChange;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    public BigDecimal getCapitalExpenditures() {
        return capitalExpenditures;
    }

    public BigDecimal getInvestments() {
        return investments;
    }

    public BigDecimal getInvestingActivityOther() {
        return investingActivityOther;
    }

    public BigDecimal getTotalInvestingCashFlows() {
        return totalInvestingCashFlows;
    }

    public BigDecimal getDividendsPaid() {
        return dividendsPaid;
    }

    public BigDecimal getNetBorrowings() {
        return netBorrowings;
    }

    public BigDecimal getOtherFinancingCashFlows() {
        return otherFinancingCashFlows;
    }

    public BigDecimal getCashFlowFinancing() {
        return cashFlowFinancing;
    }

    public BigDecimal getExchangeRateEffect() {
        return exchangeRateEffect;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CashFlow cashFlow1 = (CashFlow) o;
        return Objects.equals(netIncome, cashFlow1.netIncome) &&
                Objects.equals(depreciation, cashFlow1.depreciation) &&
                Objects.equals(changesInReceivables, cashFlow1.changesInReceivables) &&
                Objects.equals(changesInInventories, cashFlow1.changesInInventories) &&
                Objects.equals(cashChange, cashFlow1.cashChange) &&
                Objects.equals(cashFlow, cashFlow1.cashFlow) &&
                Objects.equals(capitalExpenditures, cashFlow1.capitalExpenditures) &&
                Objects.equals(investments, cashFlow1.investments) &&
                Objects.equals(investingActivityOther, cashFlow1.investingActivityOther) &&
                Objects.equals(totalInvestingCashFlows, cashFlow1.totalInvestingCashFlows) &&
                Objects.equals(dividendsPaid, cashFlow1.dividendsPaid) &&
                Objects.equals(netBorrowings, cashFlow1.netBorrowings) &&
                Objects.equals(otherFinancingCashFlows, cashFlow1.otherFinancingCashFlows) &&
                Objects.equals(cashFlowFinancing, cashFlow1.cashFlowFinancing) &&
                Objects.equals(exchangeRateEffect, cashFlow1.exchangeRateEffect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), netIncome, depreciation, changesInReceivables, changesInInventories,
                cashChange, cashFlow, capitalExpenditures, investments, investingActivityOther, totalInvestingCashFlows,
                dividendsPaid, netBorrowings, otherFinancingCashFlows, cashFlowFinancing, exchangeRateEffect);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("netIncome", netIncome)
                .add("depreciation", depreciation)
                .add("changesInReceivables", changesInReceivables)
                .add("changesInInventories", changesInInventories)
                .add("cashChange", cashChange)
                .add("cashFlow", cashFlow)
                .add("capitalExpenditures", capitalExpenditures)
                .add("investments", investments)
                .add("investingActivityOther", investingActivityOther)
                .add("totalInvestingCashFlows", totalInvestingCashFlows)
                .add("dividendsPaid", dividendsPaid)
                .add("netBorrowings", netBorrowings)
                .add("otherFinancingCashFlows", otherFinancingCashFlows)
                .add("cashFlowFinancing", cashFlowFinancing)
                .add("exchangeRateEffect", exchangeRateEffect)
                .toString();
    }

}
