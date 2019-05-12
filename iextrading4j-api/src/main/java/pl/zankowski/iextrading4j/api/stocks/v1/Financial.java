package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Financial implements Serializable {

    private static final long serialVersionUID = -2466964917607304006L;

    private final LocalDate reportDate;
    private final BigDecimal grossProfit;
    private final BigDecimal costOfRevenue;
    private final BigDecimal operatingRevenue;
    private final BigDecimal totalRevenue;
    private final BigDecimal operatingIncome;
    private final BigDecimal netIncome;
    private final BigDecimal researchAndDevelopment;
    private final BigDecimal operatingExpense;
    private final BigDecimal currentAssets;
    private final BigDecimal totalAssets;
    private final BigDecimal totalLiabilities;
    private final BigDecimal currentCash;
    private final BigDecimal currentDebt;
    private final BigDecimal shortTermDebt;
    private final BigDecimal longTermDebt;
    private final BigDecimal totalCash;
    private final BigDecimal totalDebt;
    private final BigDecimal shareholderEquity;
    private final BigDecimal cashChange;
    private final BigDecimal cashFlow;

    @JsonCreator
    public Financial(
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("grossProfit") final BigDecimal grossProfit,
            @JsonProperty("costOfRevenue") final BigDecimal costOfRevenue,
            @JsonProperty("operatingRevenue") final BigDecimal operatingRevenue,
            @JsonProperty("totalRevenue") final BigDecimal totalRevenue,
            @JsonProperty("operatingIncome") final BigDecimal operatingIncome,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("researchAndDevelopment") final BigDecimal researchAndDevelopment,
            @JsonProperty("operatingExpense") final BigDecimal operatingExpense,
            @JsonProperty("currentAssets") final BigDecimal currentAssets,
            @JsonProperty("totalAssets") final BigDecimal totalAssets,
            @JsonProperty("totalLiabilities") final BigDecimal totalLiabilities,
            @JsonProperty("currentCash") final BigDecimal currentCash,
            @JsonProperty("currentDebt") final BigDecimal currentDebt,
            @JsonProperty("shortTermDebt") final BigDecimal shortTermDebt,
            @JsonProperty("longTermDebt") final BigDecimal longTermDebt,
            @JsonProperty("totalCash") final BigDecimal totalCash,
            @JsonProperty("totalDebt") final BigDecimal totalDebt,
            @JsonProperty("shareholderEquity") final BigDecimal shareholderEquity,
            @JsonProperty("cashChange") final BigDecimal cashChange,
            @JsonProperty("cashFlow") final BigDecimal cashFlow) {
        this.reportDate = reportDate;
        this.grossProfit = grossProfit;
        this.costOfRevenue = costOfRevenue;
        this.operatingRevenue = operatingRevenue;
        this.totalRevenue = totalRevenue;
        this.operatingIncome = operatingIncome;
        this.netIncome = netIncome;
        this.researchAndDevelopment = researchAndDevelopment;
        this.operatingExpense = operatingExpense;
        this.currentAssets = currentAssets;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.currentCash = currentCash;
        this.currentDebt = currentDebt;
        this.shortTermDebt = shortTermDebt;
        this.longTermDebt = longTermDebt;
        this.totalCash = totalCash;
        this.totalDebt = totalDebt;
        this.shareholderEquity = shareholderEquity;
        this.cashChange = cashChange;
        this.cashFlow = cashFlow;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public BigDecimal getCostOfRevenue() {
        return costOfRevenue;
    }

    public BigDecimal getOperatingRevenue() {
        return operatingRevenue;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getResearchAndDevelopment() {
        return researchAndDevelopment;
    }

    public BigDecimal getOperatingExpense() {
        return operatingExpense;
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public BigDecimal getCurrentCash() {
        return currentCash;
    }

    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    public BigDecimal getShortTermDebt() {
        return shortTermDebt;
    }

    public BigDecimal getLongTermDebt() {
        return longTermDebt;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public BigDecimal getShareholderEquity() {
        return shareholderEquity;
    }

    public BigDecimal getCashChange() {
        return cashChange;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Financial financial = (Financial) o;
        return Objects.equal(reportDate, financial.reportDate) &&
                Objects.equal(grossProfit, financial.grossProfit) &&
                Objects.equal(costOfRevenue, financial.costOfRevenue) &&
                Objects.equal(operatingRevenue, financial.operatingRevenue) &&
                Objects.equal(totalRevenue, financial.totalRevenue) &&
                Objects.equal(operatingIncome, financial.operatingIncome) &&
                Objects.equal(netIncome, financial.netIncome) &&
                Objects.equal(researchAndDevelopment, financial.researchAndDevelopment) &&
                Objects.equal(operatingExpense, financial.operatingExpense) &&
                Objects.equal(currentAssets, financial.currentAssets) &&
                Objects.equal(totalAssets, financial.totalAssets) &&
                Objects.equal(totalLiabilities, financial.totalLiabilities) &&
                Objects.equal(currentCash, financial.currentCash) &&
                Objects.equal(currentDebt, financial.currentDebt) &&
                Objects.equal(shortTermDebt, financial.shortTermDebt) &&
                Objects.equal(longTermDebt, financial.longTermDebt) &&
                Objects.equal(totalCash, financial.totalCash) &&
                Objects.equal(totalDebt, financial.totalDebt) &&
                Objects.equal(shareholderEquity, financial.shareholderEquity) &&
                Objects.equal(cashChange, financial.cashChange) &&
                Objects.equal(cashFlow, financial.cashFlow);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reportDate, grossProfit, costOfRevenue, operatingRevenue,
                totalRevenue, operatingIncome, netIncome, researchAndDevelopment, operatingExpense,
                currentAssets, totalAssets, totalLiabilities, currentCash, currentDebt, shortTermDebt,
                longTermDebt, totalCash, totalDebt, shareholderEquity, cashChange, cashFlow);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("reportDate", reportDate)
                .add("grossProfit", grossProfit)
                .add("costOfRevenue", costOfRevenue)
                .add("operatingRevenue", operatingRevenue)
                .add("totalRevenue", totalRevenue)
                .add("operatingIncome", operatingIncome)
                .add("netIncome", netIncome)
                .add("researchAndDevelopment", researchAndDevelopment)
                .add("operatingExpense", operatingExpense)
                .add("currentAssets", currentAssets)
                .add("totalAssets", totalAssets)
                .add("totalLiabilities", totalLiabilities)
                .add("currentCash", currentCash)
                .add("currentDebt", currentDebt)
                .add("shortTermDebt", shortTermDebt)
                .add("longTermDebt", longTermDebt)
                .add("totalCash", totalCash)
                .add("totalDebt", totalDebt)
                .add("shareholderEquity", shareholderEquity)
                .add("cashChange", cashChange)
                .add("cashFlow", cashFlow)
                .toString();
    }

}
