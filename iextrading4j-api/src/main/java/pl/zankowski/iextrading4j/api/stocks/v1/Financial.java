package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Financial extends Report {

    private static final long serialVersionUID = -732345058122234058L;

    private final BigDecimal EBITDA;
    private final BigDecimal accountsPayable;
    private final BigDecimal capitalSurplus;
    private final BigDecimal cashChange;
    private final BigDecimal cashFlow;
    private final BigDecimal cashFlowFinancing;
    private final BigDecimal changesInInventories;
    private final BigDecimal changesInReceivables;
    private final BigDecimal commonStock;
    private final BigDecimal costOfRevenue;
    private final BigDecimal currentAssets;
    private final BigDecimal currentCash;
    private final BigDecimal currentDebt;
    private final BigDecimal currentLongTermDebt;
    private final BigDecimal depreciation;
    private final BigDecimal dividendsPaid;
    private final BigDecimal ebit;
    private final BigDecimal exchangeRateEffect;
    private final BigDecimal goodwill;
    private final BigDecimal grossProfit;
    private final BigDecimal incomeTax;
    private final BigDecimal intangibleAssets;
    private final BigDecimal interestIncome;
    private final BigDecimal inventory;
    private final BigDecimal investingActivityOther;
    private final BigDecimal investments;
    private final BigDecimal longTermDebt;
    private final BigDecimal longTermInvestments;
    private final BigDecimal minorityInterest;
    private final BigDecimal netBorrowings;
    private final BigDecimal netIncome;
    private final BigDecimal netIncomeBasic;
    private final BigDecimal netTangibleAssets;
    private final BigDecimal operatingExpense;
    private final BigDecimal operatingIncome;
    private final BigDecimal operatingRevenue;
    private final BigDecimal otherAssets;
    private final BigDecimal otherCurrentAssets;
    private final BigDecimal otherCurrentLiabilities;
    private final BigDecimal otherIncomeExpenseNet;
    private final BigDecimal otherLiabilities;
    private final BigDecimal pretaxIncome;
    private final BigDecimal propertyPlantEquipment;
    private final BigDecimal receivables;
    private final BigDecimal researchAndDevelopment;
    private final BigDecimal retainedEarnings;
    private final BigDecimal revenue;
    private final BigDecimal sellingGeneralAndAdmin;
    private final BigDecimal shareholderEquity;
    private final BigDecimal shortTermDebt;
    private final BigDecimal shortTermInvestments;
    private final BigDecimal totalAssets;
    private final BigDecimal totalCash;
    private final BigDecimal totalDebt;
    private final BigDecimal totalInvestingCashFlows;
    private final BigDecimal totalLiabilities;
    private final BigDecimal totalRevenue;
    private final BigDecimal treasuryStock;

    public Financial(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("filingType") final String filingType,
            @JsonProperty("fiscalDate") final LocalDate fiscalDate,
            @JsonProperty("fiscalQuarter") final BigDecimal fiscalQuarter,
            @JsonProperty("fiscalYear") final BigDecimal fiscalYear,
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("currency") final String currency,
            @JsonProperty("EBITDA") final BigDecimal EBITDA,
            @JsonProperty("accountsPayable") final BigDecimal accountsPayable,
            @JsonProperty("capitalSurplus") final BigDecimal capitalSurplus,
            @JsonProperty("cashChange") final BigDecimal cashChange,
            @JsonProperty("cashFlow") final BigDecimal cashFlow,
            @JsonProperty("cashFlowFinancing") final BigDecimal cashFlowFinancing,
            @JsonProperty("changesInInventories") final BigDecimal changesInInventories,
            @JsonProperty("changesInReceivables") final BigDecimal changesInReceivables,
            @JsonProperty("commonStock") final BigDecimal commonStock,
            @JsonProperty("costOfRevenue") final BigDecimal costOfRevenue,
            @JsonProperty("currentAssets") final BigDecimal currentAssets,
            @JsonProperty("currentCash") final BigDecimal currentCash,
            @JsonProperty("currentDebt") final BigDecimal currentDebt,
            @JsonProperty("currentLongTermDebt") final BigDecimal currentLongTermDebt,
            @JsonProperty("depreciation") final BigDecimal depreciation,
            @JsonProperty("dividendsPaid") final BigDecimal dividendsPaid,
            @JsonProperty("ebit") final BigDecimal ebit,
            @JsonProperty("exchangeRateEffect") final BigDecimal exchangeRateEffect,
            @JsonProperty("goodwill") final BigDecimal goodwill,
            @JsonProperty("grossProfit") final BigDecimal grossProfit,
            @JsonProperty("incomeTax") final BigDecimal incomeTax,
            @JsonProperty("intangibleAssets") final BigDecimal intangibleAssets,
            @JsonProperty("interestIncome") final BigDecimal interestIncome,
            @JsonProperty("inventory") final BigDecimal inventory,
            @JsonProperty("investingActivityOther") final BigDecimal investingActivityOther,
            @JsonProperty("investments") final BigDecimal investments,
            @JsonProperty("longTermDebt") final BigDecimal longTermDebt,
            @JsonProperty("longTermInvestments") final BigDecimal longTermInvestments,
            @JsonProperty("minorityInterest") final BigDecimal minorityInterest,
            @JsonProperty("netBorrowings") final BigDecimal netBorrowings,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("netIncomeBasic") final BigDecimal netIncomeBasic,
            @JsonProperty("netTangibleAssets") final BigDecimal netTangibleAssets,
            @JsonProperty("operatingExpense") final BigDecimal operatingExpense,
            @JsonProperty("operatingIncome") final BigDecimal operatingIncome,
            @JsonProperty("operatingRevenue") final BigDecimal operatingRevenue,
            @JsonProperty("otherAssets") final BigDecimal otherAssets,
            @JsonProperty("otherCurrentAssets") final BigDecimal otherCurrentAssets,
            @JsonProperty("otherCurrentLiabilities") final BigDecimal otherCurrentLiabilities,
            @JsonProperty("otherIncomeExpenseNet") final BigDecimal otherIncomeExpenseNet,
            @JsonProperty("otherLiabilities") final BigDecimal otherLiabilities,
            @JsonProperty("pretaxIncome") final BigDecimal pretaxIncome,
            @JsonProperty("propertyPlantEquipment") final BigDecimal propertyPlantEquipment,
            @JsonProperty("receivables") final BigDecimal receivables,
            @JsonProperty("researchAndDevelopment") final BigDecimal researchAndDevelopment,
            @JsonProperty("retainedEarnings") final BigDecimal retainedEarnings,
            @JsonProperty("revenue") final BigDecimal revenue,
            @JsonProperty("sellingGeneralAndAdmin") final BigDecimal sellingGeneralAndAdmin,
            @JsonProperty("shareholderEquity") final BigDecimal shareholderEquity,
            @JsonProperty("shortTermDebt") final BigDecimal shortTermDebt,
            @JsonProperty("shortTermInvestments") final BigDecimal shortTermInvestments,
            @JsonProperty("totalAssets") final BigDecimal totalAssets,
            @JsonProperty("totalCash") final BigDecimal totalCash,
            @JsonProperty("totalDebt") final BigDecimal totalDebt,
            @JsonProperty("totalInvestingCashFlows") final BigDecimal totalInvestingCashFlows,
            @JsonProperty("totalLiabilities") final BigDecimal totalLiabilities,
            @JsonProperty("totalRevenue") final BigDecimal totalRevenue,
            @JsonProperty("treasuryStock") final BigDecimal treasuryStock) {
        super(symbol, id, key, subkey, updated, reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear, currency);
        this.EBITDA = EBITDA;
        this.accountsPayable = accountsPayable;
        this.capitalSurplus = capitalSurplus;
        this.cashChange = cashChange;
        this.cashFlow = cashFlow;
        this.cashFlowFinancing = cashFlowFinancing;
        this.changesInInventories = changesInInventories;
        this.changesInReceivables = changesInReceivables;
        this.commonStock = commonStock;
        this.costOfRevenue = costOfRevenue;
        this.currentAssets = currentAssets;
        this.currentCash = currentCash;
        this.currentDebt = currentDebt;
        this.currentLongTermDebt = currentLongTermDebt;
        this.depreciation = depreciation;
        this.dividendsPaid = dividendsPaid;
        this.ebit = ebit;
        this.exchangeRateEffect = exchangeRateEffect;
        this.goodwill = goodwill;
        this.grossProfit = grossProfit;
        this.incomeTax = incomeTax;
        this.intangibleAssets = intangibleAssets;
        this.interestIncome = interestIncome;
        this.inventory = inventory;
        this.investingActivityOther = investingActivityOther;
        this.investments = investments;
        this.longTermDebt = longTermDebt;
        this.longTermInvestments = longTermInvestments;
        this.minorityInterest = minorityInterest;
        this.netBorrowings = netBorrowings;
        this.netIncome = netIncome;
        this.netIncomeBasic = netIncomeBasic;
        this.netTangibleAssets = netTangibleAssets;
        this.operatingExpense = operatingExpense;
        this.operatingIncome = operatingIncome;
        this.operatingRevenue = operatingRevenue;
        this.otherAssets = otherAssets;
        this.otherCurrentAssets = otherCurrentAssets;
        this.otherCurrentLiabilities = otherCurrentLiabilities;
        this.otherIncomeExpenseNet = otherIncomeExpenseNet;
        this.otherLiabilities = otherLiabilities;
        this.pretaxIncome = pretaxIncome;
        this.propertyPlantEquipment = propertyPlantEquipment;
        this.receivables = receivables;
        this.researchAndDevelopment = researchAndDevelopment;
        this.retainedEarnings = retainedEarnings;
        this.revenue = revenue;
        this.sellingGeneralAndAdmin = sellingGeneralAndAdmin;
        this.shareholderEquity = shareholderEquity;
        this.shortTermDebt = shortTermDebt;
        this.shortTermInvestments = shortTermInvestments;
        this.totalAssets = totalAssets;
        this.totalCash = totalCash;
        this.totalDebt = totalDebt;
        this.totalInvestingCashFlows = totalInvestingCashFlows;
        this.totalLiabilities = totalLiabilities;
        this.totalRevenue = totalRevenue;
        this.treasuryStock = treasuryStock;
    }

    public BigDecimal getEBITDA() {
        return EBITDA;
    }

    public BigDecimal getAccountsPayable() {
        return accountsPayable;
    }

    public BigDecimal getCapitalSurplus() {
        return capitalSurplus;
    }

    public BigDecimal getCashChange() {
        return cashChange;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    public BigDecimal getCashFlowFinancing() {
        return cashFlowFinancing;
    }

    public BigDecimal getChangesInInventories() {
        return changesInInventories;
    }

    public BigDecimal getChangesInReceivables() {
        return changesInReceivables;
    }

    public BigDecimal getCommonStock() {
        return commonStock;
    }

    public BigDecimal getCostOfRevenue() {
        return costOfRevenue;
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public BigDecimal getCurrentCash() {
        return currentCash;
    }

    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    public BigDecimal getCurrentLongTermDebt() {
        return currentLongTermDebt;
    }

    public BigDecimal getDepreciation() {
        return depreciation;
    }

    public BigDecimal getDividendsPaid() {
        return dividendsPaid;
    }

    public BigDecimal getEbit() {
        return ebit;
    }

    public BigDecimal getExchangeRateEffect() {
        return exchangeRateEffect;
    }

    public BigDecimal getGoodwill() {
        return goodwill;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getIntangibleAssets() {
        return intangibleAssets;
    }

    public BigDecimal getInterestIncome() {
        return interestIncome;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public BigDecimal getInvestingActivityOther() {
        return investingActivityOther;
    }

    public BigDecimal getInvestments() {
        return investments;
    }

    public BigDecimal getLongTermDebt() {
        return longTermDebt;
    }

    public BigDecimal getLongTermInvestments() {
        return longTermInvestments;
    }

    public BigDecimal getMinorityInterest() {
        return minorityInterest;
    }

    public BigDecimal getNetBorrowings() {
        return netBorrowings;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getNetIncomeBasic() {
        return netIncomeBasic;
    }

    public BigDecimal getNetTangibleAssets() {
        return netTangibleAssets;
    }

    public BigDecimal getOperatingExpense() {
        return operatingExpense;
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public BigDecimal getOperatingRevenue() {
        return operatingRevenue;
    }

    public BigDecimal getOtherAssets() {
        return otherAssets;
    }

    public BigDecimal getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    public BigDecimal getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    }

    public BigDecimal getOtherIncomeExpenseNet() {
        return otherIncomeExpenseNet;
    }

    public BigDecimal getOtherLiabilities() {
        return otherLiabilities;
    }

    public BigDecimal getPretaxIncome() {
        return pretaxIncome;
    }

    public BigDecimal getPropertyPlantEquipment() {
        return propertyPlantEquipment;
    }

    public BigDecimal getReceivables() {
        return receivables;
    }

    public BigDecimal getResearchAndDevelopment() {
        return researchAndDevelopment;
    }

    public BigDecimal getRetainedEarnings() {
        return retainedEarnings;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getSellingGeneralAndAdmin() {
        return sellingGeneralAndAdmin;
    }

    public BigDecimal getShareholderEquity() {
        return shareholderEquity;
    }

    public BigDecimal getShortTermDebt() {
        return shortTermDebt;
    }

    public BigDecimal getShortTermInvestments() {
        return shortTermInvestments;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public BigDecimal getTotalInvestingCashFlows() {
        return totalInvestingCashFlows;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public BigDecimal getTreasuryStock() {
        return treasuryStock;
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
        final Financial financial = (Financial) o;
        return Objects.equals(EBITDA, financial.EBITDA) &&
                Objects.equals(accountsPayable, financial.accountsPayable) &&
                Objects.equals(shortTermDebt, financial.shortTermDebt) &&
                Objects.equals(shortTermInvestments, financial.shortTermInvestments) &&
                Objects.equals(capitalSurplus, financial.capitalSurplus) && Objects.equals(cashChange, financial.cashChange) && Objects.equals(cashFlow, financial.cashFlow) && Objects.equals(cashFlowFinancing, financial.cashFlowFinancing) && Objects.equals(changesInInventories, financial.changesInInventories) && Objects.equals(changesInReceivables, financial.changesInReceivables) && Objects.equals(commonStock, financial.commonStock) && Objects.equals(costOfRevenue, financial.costOfRevenue) && Objects.equals(currentAssets, financial.currentAssets) && Objects.equals(currentCash, financial.currentCash) && Objects.equals(currentDebt, financial.currentDebt) && Objects.equals(currentLongTermDebt, financial.currentLongTermDebt) && Objects.equals(depreciation, financial.depreciation) && Objects.equals(dividendsPaid, financial.dividendsPaid) && Objects.equals(ebit, financial.ebit) && Objects.equals(exchangeRateEffect, financial.exchangeRateEffect) && Objects.equals(goodwill, financial.goodwill) && Objects.equals(grossProfit, financial.grossProfit) && Objects.equals(incomeTax, financial.incomeTax) && Objects.equals(intangibleAssets, financial.intangibleAssets) && Objects.equals(interestIncome, financial.interestIncome) && Objects.equals(inventory, financial.inventory) && Objects.equals(investingActivityOther, financial.investingActivityOther) && Objects.equals(investments, financial.investments) && Objects.equals(longTermDebt, financial.longTermDebt) && Objects.equals(longTermInvestments, financial.longTermInvestments) && Objects.equals(minorityInterest, financial.minorityInterest) && Objects.equals(netBorrowings, financial.netBorrowings) && Objects.equals(netIncome, financial.netIncome) && Objects.equals(netIncomeBasic, financial.netIncomeBasic) && Objects.equals(netTangibleAssets, financial.netTangibleAssets) && Objects.equals(operatingExpense, financial.operatingExpense) && Objects.equals(operatingIncome, financial.operatingIncome) && Objects.equals(operatingRevenue, financial.operatingRevenue) && Objects.equals(otherAssets, financial.otherAssets) && Objects.equals(otherCurrentAssets, financial.otherCurrentAssets) && Objects.equals(otherCurrentLiabilities, financial.otherCurrentLiabilities) && Objects.equals(otherIncomeExpenseNet, financial.otherIncomeExpenseNet) && Objects.equals(otherLiabilities, financial.otherLiabilities) && Objects.equals(pretaxIncome, financial.pretaxIncome) && Objects.equals(propertyPlantEquipment, financial.propertyPlantEquipment) && Objects.equals(receivables, financial.receivables) && Objects.equals(researchAndDevelopment, financial.researchAndDevelopment) && Objects.equals(retainedEarnings, financial.retainedEarnings) && Objects.equals(revenue, financial.revenue) && Objects.equals(sellingGeneralAndAdmin, financial.sellingGeneralAndAdmin) && Objects.equals(shareholderEquity, financial.shareholderEquity) && Objects.equals(totalAssets, financial.totalAssets) && Objects.equals(totalCash, financial.totalCash) && Objects.equals(totalDebt, financial.totalDebt) && Objects.equals(totalInvestingCashFlows, financial.totalInvestingCashFlows) && Objects.equals(totalLiabilities, financial.totalLiabilities) && Objects.equals(totalRevenue, financial.totalRevenue) && Objects.equals(treasuryStock, financial.treasuryStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), EBITDA, accountsPayable, capitalSurplus, cashChange,
                cashFlow, cashFlowFinancing, changesInInventories, changesInReceivables, commonStock,
                costOfRevenue, currentAssets, currentCash, currentDebt, currentLongTermDebt, depreciation,
                dividendsPaid, ebit, exchangeRateEffect, goodwill, grossProfit, incomeTax, intangibleAssets,
                interestIncome, inventory, investingActivityOther, investments, longTermDebt,
                longTermInvestments, minorityInterest, netBorrowings, netIncome, netIncomeBasic,
                netTangibleAssets, operatingExpense, operatingIncome, operatingRevenue, otherAssets,
                otherCurrentAssets, otherCurrentLiabilities, otherIncomeExpenseNet, otherLiabilities,
                pretaxIncome, propertyPlantEquipment, receivables, researchAndDevelopment, retainedEarnings,
                revenue, sellingGeneralAndAdmin, shareholderEquity, shortTermDebt, shortTermInvestments, totalAssets,
                totalCash, totalDebt, totalInvestingCashFlows, totalLiabilities, totalRevenue, treasuryStock);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Financial.class.getSimpleName() + "[", "]")
                .add("EBITDA=" + EBITDA)
                .add("accountsPayable=" + accountsPayable)
                .add("capitalSurplus=" + capitalSurplus)
                .add("cashChange=" + cashChange)
                .add("cashFlow=" + cashFlow)
                .add("cashFlowFinancing=" + cashFlowFinancing)
                .add("changesInInventories=" + changesInInventories)
                .add("changesInReceivables=" + changesInReceivables)
                .add("commonStock=" + commonStock)
                .add("costOfRevenue=" + costOfRevenue)
                .add("currentAssets=" + currentAssets)
                .add("currentCash=" + currentCash)
                .add("currentDebt=" + currentDebt)
                .add("currentLongTermDebt=" + currentLongTermDebt)
                .add("depreciation=" + depreciation)
                .add("dividendsPaid=" + dividendsPaid)
                .add("ebit=" + ebit)
                .add("exchangeRateEffect=" + exchangeRateEffect)
                .add("goodwill=" + goodwill)
                .add("grossProfit=" + grossProfit)
                .add("incomeTax=" + incomeTax)
                .add("intangibleAssets=" + intangibleAssets)
                .add("interestIncome=" + interestIncome)
                .add("inventory=" + inventory)
                .add("investingActivityOther=" + investingActivityOther)
                .add("investments=" + investments)
                .add("longTermDebt=" + longTermDebt)
                .add("longTermInvestments=" + longTermInvestments)
                .add("minorityInterest=" + minorityInterest)
                .add("netBorrowings=" + netBorrowings)
                .add("netIncome=" + netIncome)
                .add("netIncomeBasic=" + netIncomeBasic)
                .add("netTangibleAssets=" + netTangibleAssets)
                .add("operatingExpense=" + operatingExpense)
                .add("operatingIncome=" + operatingIncome)
                .add("operatingRevenue=" + operatingRevenue)
                .add("otherAssets=" + otherAssets)
                .add("otherCurrentAssets=" + otherCurrentAssets)
                .add("otherCurrentLiabilities=" + otherCurrentLiabilities)
                .add("otherIncomeExpenseNet=" + otherIncomeExpenseNet)
                .add("otherLiabilities=" + otherLiabilities)
                .add("pretaxIncome=" + pretaxIncome)
                .add("propertyPlantEquipment=" + propertyPlantEquipment)
                .add("receivables=" + receivables)
                .add("researchAndDevelopment=" + researchAndDevelopment)
                .add("retainedEarnings=" + retainedEarnings)
                .add("revenue=" + revenue)
                .add("sellingGeneralAndAdmin=" + sellingGeneralAndAdmin)
                .add("shareholderEquity=" + shareholderEquity)
                .add("shortTermDebt=" + shortTermDebt)
                .add("shortTermInvestments=" + shortTermInvestments)
                .add("totalAssets=" + totalAssets)
                .add("totalCash=" + totalCash)
                .add("totalDebt=" + totalDebt)
                .add("totalInvestingCashFlows=" + totalInvestingCashFlows)
                .add("totalLiabilities=" + totalLiabilities)
                .add("totalRevenue=" + totalRevenue)
                .add("treasuryStock=" + treasuryStock)
                .toString();
    }

}
