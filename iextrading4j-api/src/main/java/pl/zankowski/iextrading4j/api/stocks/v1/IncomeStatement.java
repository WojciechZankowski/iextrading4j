package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class IncomeStatement extends Report {

    private static final long serialVersionUID = -1413080264580022740L;

    private final BigDecimal totalRevenue;
    private final BigDecimal costOfRevenue;
    private final BigDecimal ebit;
    private final BigDecimal grossProfit;
    private final BigDecimal incomeTax;
    private final BigDecimal interestIncome;
    private final BigDecimal minorityInterest;
    private final BigDecimal netIncome;
    private final BigDecimal netIncomeBasic;
    private final BigDecimal operatingExpense;
    private final BigDecimal operatingIncome;
    private final BigDecimal otherIncomeExpenseNet;
    private final BigDecimal pretaxIncome;
    private final BigDecimal researchAndDevelopment;
    private final BigDecimal sellingGeneralAndAdmin;

    @JsonCreator
    public IncomeStatement(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("date") final Long date,
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("fiscalDate") final LocalDate fiscalDate,
            @JsonProperty("currency") final String currency,
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
            @JsonProperty("netIncomeBasic") final BigDecimal netIncomeBasic,
            @JsonProperty("filingType") final String filingType,
            @JsonProperty("fiscalQuarter") final BigDecimal fiscalQuarter,
            @JsonProperty("fiscalYear") final BigDecimal fiscalYear) {
        super(symbol, id, key, subkey, updated, reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear,
                currency, date);
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final IncomeStatement that = (IncomeStatement) o;
        return Objects.equals(totalRevenue, that.totalRevenue) &&
                Objects.equals(costOfRevenue, that.costOfRevenue) &&
                Objects.equals(grossProfit, that.grossProfit) &&
                Objects.equals(researchAndDevelopment, that.researchAndDevelopment) &&
                Objects.equals(sellingGeneralAndAdmin, that.sellingGeneralAndAdmin) &&
                Objects.equals(operatingExpense, that.operatingExpense) &&
                Objects.equals(operatingIncome, that.operatingIncome) &&
                Objects.equals(otherIncomeExpenseNet, that.otherIncomeExpenseNet) &&
                Objects.equals(ebit, that.ebit) &&
                Objects.equals(interestIncome, that.interestIncome) &&
                Objects.equals(pretaxIncome, that.pretaxIncome) &&
                Objects.equals(incomeTax, that.incomeTax) &&
                Objects.equals(minorityInterest, that.minorityInterest) &&
                Objects.equals(netIncome, that.netIncome) &&
                Objects.equals(netIncomeBasic, that.netIncomeBasic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalRevenue, costOfRevenue, grossProfit, researchAndDevelopment,
                sellingGeneralAndAdmin, operatingExpense, operatingIncome, otherIncomeExpenseNet, ebit,
                interestIncome, pretaxIncome, incomeTax, minorityInterest, netIncome, netIncomeBasic);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
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
