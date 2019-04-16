package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

public class CashFlow implements Serializable {

    private final LocalDate reportDate;
    private final Long netIncome;
    private final Long depreciation;
    private final Long changesInReceivables;
    private final Long changesInInventories;
    private final Long cashChange;
    private final Long cashFlow;
    private final Long capitalExpenditures;
    private final Long investments;
    private final Long investingActivityOther;
    private final Long totalInvestingCashFlows;
    private final Long dividendsPaid;
    private final Long netBorrowings;
    private final Long otherFinancingCashFlows;
    private final Long cashFlowFinancing;
    private final Long exchangeRateEffect;

    @JsonCreator
    public CashFlow(
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("netIncome") final Long netIncome,
            @JsonProperty("depreciation") final Long depreciation,
            @JsonProperty("changesInReceivables") final Long changesInReceivables,
            @JsonProperty("changesInInventories") final Long changesInInventories,
            @JsonProperty("cashChange") final Long cashChange,
            @JsonProperty("cashFlow") final Long cashFlow,
            @JsonProperty("capitalExpenditures") final Long capitalExpenditures,
            @JsonProperty("investments") final Long investments,
            @JsonProperty("investingActivityOther") final Long investingActivityOther,
            @JsonProperty("totalInvestingCashFlows") final Long totalInvestingCashFlows,
            @JsonProperty("dividendsPaid") final Long dividendsPaid,
            @JsonProperty("netBorrowings") final Long netBorrowings,
            @JsonProperty("otherFinancingCashFlows") final Long otherFinancingCashFlows,
            @JsonProperty("cashFlowFinancing") final Long cashFlowFinancing,
            @JsonProperty("exchangeRateEffect") final Long exchangeRateEffect) {
        this.reportDate = reportDate;
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

    public LocalDate getReportDate() {
        return reportDate;
    }

    public Long getNetIncome() {
        return netIncome;
    }

    public Long getDepreciation() {
        return depreciation;
    }

    public Long getChangesInReceivables() {
        return changesInReceivables;
    }

    public Long getChangesInInventories() {
        return changesInInventories;
    }

    public Long getCashChange() {
        return cashChange;
    }

    public Long getCashFlow() {
        return cashFlow;
    }

    public Long getCapitalExpenditures() {
        return capitalExpenditures;
    }

    public Long getInvestments() {
        return investments;
    }

    public Long getInvestingActivityOther() {
        return investingActivityOther;
    }

    public Long getTotalInvestingCashFlows() {
        return totalInvestingCashFlows;
    }

    public Long getDividendsPaid() {
        return dividendsPaid;
    }

    public Long getNetBorrowings() {
        return netBorrowings;
    }

    public Long getOtherFinancingCashFlows() {
        return otherFinancingCashFlows;
    }

    public Long getCashFlowFinancing() {
        return cashFlowFinancing;
    }

    public Long getExchangeRateEffect() {
        return exchangeRateEffect;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CashFlow)) return false;
        final CashFlow cashFlow1 = (CashFlow) o;
        return Objects.equal(reportDate, cashFlow1.reportDate) &&
                Objects.equal(netIncome, cashFlow1.netIncome) &&
                Objects.equal(depreciation, cashFlow1.depreciation) &&
                Objects.equal(changesInReceivables, cashFlow1.changesInReceivables) &&
                Objects.equal(changesInInventories, cashFlow1.changesInInventories) &&
                Objects.equal(cashChange, cashFlow1.cashChange) &&
                Objects.equal(cashFlow, cashFlow1.cashFlow) &&
                Objects.equal(capitalExpenditures, cashFlow1.capitalExpenditures) &&
                Objects.equal(investments, cashFlow1.investments) &&
                Objects.equal(investingActivityOther, cashFlow1.investingActivityOther) &&
                Objects.equal(totalInvestingCashFlows, cashFlow1.totalInvestingCashFlows) &&
                Objects.equal(dividendsPaid, cashFlow1.dividendsPaid) &&
                Objects.equal(netBorrowings, cashFlow1.netBorrowings) &&
                Objects.equal(otherFinancingCashFlows, cashFlow1.otherFinancingCashFlows) &&
                Objects.equal(cashFlowFinancing, cashFlow1.cashFlowFinancing) &&
                Objects.equal(exchangeRateEffect, cashFlow1.exchangeRateEffect);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reportDate, netIncome, depreciation, changesInReceivables,
                changesInInventories, cashChange, cashFlow, capitalExpenditures, investments,
                investingActivityOther, totalInvestingCashFlows, dividendsPaid, netBorrowings,
                otherFinancingCashFlows, cashFlowFinancing, exchangeRateEffect);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("reportDate", reportDate)
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
