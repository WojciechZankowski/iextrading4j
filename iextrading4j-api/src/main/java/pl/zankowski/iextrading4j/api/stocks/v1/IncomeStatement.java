package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeStatement implements Serializable {

    private static final long serialVersionUID = -1413080264580022740L;

    private final LocalDate reportDate;
    private final BigDecimal totalRevenue;
    private final BigDecimal costOfRevenue;
    private final BigDecimal grossProfit;
    private final BigDecimal researchAndDevelopment;
    private final BigDecimal sellingGeneralAndAdmin;
    private final BigDecimal operatingExpense;
    private final BigDecimal operatingIncome;
    private final BigDecimal otherIncomeExpenseNet;
    private final BigDecimal ebit;
    private final BigDecimal interestIncome;
    private final BigDecimal pretaxIncome;
    private final BigDecimal incomeTax;
    private final BigDecimal minorityInterest;
    private final BigDecimal netIncome;
    private final BigDecimal netIncomeBasic;

    @JsonCreator
    public IncomeStatement(
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("totalRevenue") final BigDecimal totalRevenue,
            @JsonProperty("costOfRevenue") final BigDecimal costOfRevenue,
            @JsonProperty("grossProfit") final BigDecimal grossProfit,
            @JsonProperty("researchAndDevelopment") final BigDecimal researchAndDevelopment,
            @JsonProperty("sellingGeneralAndAdmin") final BigDecimal sellingGeneralAndAdmin,
            @JsonProperty("operatingExpense") final BigDecimal operatingExpense,
            @JsonProperty("operatingIncome") final BigDecimal operatingIncome,
            @JsonProperty("otherIncomeExpenseNet") final BigDecimal otherIncomeExpenseNet,
            @JsonProperty("ebit") final BigDecimal ebit,
            @JsonProperty("interestIncome") final BigDecimal interestIncome,
            @JsonProperty("pretaxIncome") final BigDecimal pretaxIncome,
            @JsonProperty("incomeTax") final BigDecimal incomeTax,
            @JsonProperty("minorityInterest") final BigDecimal minorityInterest,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("netIncomeBasic") final BigDecimal netIncomeBasic) {
        this.reportDate = reportDate;
        this.totalRevenue = totalRevenue;
        this.costOfRevenue = costOfRevenue;
        this.grossProfit = grossProfit;
        this.researchAndDevelopment = researchAndDevelopment;
        this.sellingGeneralAndAdmin = sellingGeneralAndAdmin;
        this.operatingExpense = operatingExpense;
        this.operatingIncome = operatingIncome;
        this.otherIncomeExpenseNet = otherIncomeExpenseNet;
        this.ebit = ebit;
        this.interestIncome = interestIncome;
        this.pretaxIncome = pretaxIncome;
        this.incomeTax = incomeTax;
        this.minorityInterest = minorityInterest;
        this.netIncome = netIncome;
        this.netIncomeBasic = netIncomeBasic;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public BigDecimal getCostOfRevenue() {
        return costOfRevenue;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public BigDecimal getResearchAndDevelopment() {
        return researchAndDevelopment;
    }

    public BigDecimal getSellingGeneralAndAdmin() {
        return sellingGeneralAndAdmin;
    }

    public BigDecimal getOperatingExpense() {
        return operatingExpense;
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public BigDecimal getOtherIncomeExpenseNet() {
        return otherIncomeExpenseNet;
    }

    public BigDecimal getEbit() {
        return ebit;
    }

    public BigDecimal getInterestIncome() {
        return interestIncome;
    }

    public BigDecimal getPretaxIncome() {
        return pretaxIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getMinorityInterest() {
        return minorityInterest;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getNetIncomeBasic() {
        return netIncomeBasic;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof IncomeStatement)) return false;
        final IncomeStatement that = (IncomeStatement) o;
        return Objects.equal(reportDate, that.reportDate) &&
                Objects.equal(totalRevenue, that.totalRevenue) &&
                Objects.equal(costOfRevenue, that.costOfRevenue) &&
                Objects.equal(grossProfit, that.grossProfit) &&
                Objects.equal(researchAndDevelopment, that.researchAndDevelopment) &&
                Objects.equal(sellingGeneralAndAdmin, that.sellingGeneralAndAdmin) &&
                Objects.equal(operatingExpense, that.operatingExpense) &&
                Objects.equal(operatingIncome, that.operatingIncome) &&
                Objects.equal(otherIncomeExpenseNet, that.otherIncomeExpenseNet) &&
                Objects.equal(ebit, that.ebit) &&
                Objects.equal(interestIncome, that.interestIncome) &&
                Objects.equal(pretaxIncome, that.pretaxIncome) &&
                Objects.equal(incomeTax, that.incomeTax) &&
                Objects.equal(minorityInterest, that.minorityInterest) &&
                Objects.equal(netIncome, that.netIncome) &&
                Objects.equal(netIncomeBasic, that.netIncomeBasic);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reportDate, totalRevenue, costOfRevenue, grossProfit,
                researchAndDevelopment, sellingGeneralAndAdmin, operatingExpense,
                operatingIncome, otherIncomeExpenseNet, ebit, interestIncome, pretaxIncome,
                incomeTax, minorityInterest, netIncome, netIncomeBasic);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("reportDate", reportDate)
                .add("totalRevenue", totalRevenue)
                .add("costOfRevenue", costOfRevenue)
                .add("grossProfit", grossProfit)
                .add("researchAndDevelopment", researchAndDevelopment)
                .add("sellingGeneralAndAdmin", sellingGeneralAndAdmin)
                .add("operatingExpense", operatingExpense)
                .add("operatingIncome", operatingIncome)
                .add("otherIncomeExpenseNet", otherIncomeExpenseNet)
                .add("ebit", ebit)
                .add("interestIncome", interestIncome)
                .add("pretaxIncome", pretaxIncome)
                .add("incomeTax", incomeTax)
                .add("minorityInterest", minorityInterest)
                .add("netIncome", netIncome)
                .add("netIncomeBasic", netIncomeBasic)
                .toString();
    }
}
