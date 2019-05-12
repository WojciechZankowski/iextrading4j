package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BalanceSheet implements Serializable {

    private static final long serialVersionUID = 903088600080035429L;

    private final LocalDate reportDate;
    private final BigDecimal currentCash;
    private final BigDecimal shortTermInvestments;
    private final BigDecimal receivables;
    private final BigDecimal inventory;
    private final BigDecimal otherCurrentAssets;
    private final BigDecimal currentAssets;
    private final BigDecimal longTermInvestments;
    private final BigDecimal propertyPlantEquipment;
    private final BigDecimal goodwill;
    private final BigDecimal intangibleAssets;
    private final BigDecimal otherAssets;
    private final BigDecimal totalAssets;
    private final BigDecimal accountsPayable;
    private final BigDecimal currentLongTermDebt;
    private final BigDecimal otherCurrentLiabilities;
    private final BigDecimal totalCurrentLiabilities;
    private final BigDecimal longTermDebt;
    private final BigDecimal otherLiabilities;
    private final BigDecimal minorityInterest;
    private final BigDecimal totalLiabilities;
    private final BigDecimal commonStock;
    private final BigDecimal retainedEarnings;
    private final BigDecimal treasuryStock;
    private final BigDecimal capitalSurplus;
    private final BigDecimal shareholderEquity;
    private final BigDecimal netTangibleAssets;

    @JsonCreator
    public BalanceSheet(
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("currentCash") final BigDecimal currentCash,
            @JsonProperty("shortTermInvestments") final BigDecimal shortTermInvestments,
            @JsonProperty("receivables") final BigDecimal receivables,
            @JsonProperty("inventory") final BigDecimal inventory,
            @JsonProperty("otherCurrentAssets") final BigDecimal otherCurrentAssets,
            @JsonProperty("currentAssets") final BigDecimal currentAssets,
            @JsonProperty("longTermInvestments") final BigDecimal longTermInvestments,
            @JsonProperty("propertyPlantEquipment") final BigDecimal propertyPlantEquipment,
            @JsonProperty("goodwill") final BigDecimal goodwill,
            @JsonProperty("intangibleAssets") final BigDecimal intangibleAssets,
            @JsonProperty("otherAssets") final BigDecimal otherAssets,
            @JsonProperty("totalAssets") final BigDecimal totalAssets,
            @JsonProperty("accountsPayable") final BigDecimal accountsPayable,
            @JsonProperty("currentLongTermDebt") final BigDecimal currentLongTermDebt,
            @JsonProperty("otherCurrentLiabilities") final BigDecimal otherCurrentLiabilities,
            @JsonProperty("totalCurrentLiabilities") final BigDecimal totalCurrentLiabilities,
            @JsonProperty("longTermDebt") final BigDecimal longTermDebt,
            @JsonProperty("otherLiabilities") final BigDecimal otherLiabilities,
            @JsonProperty("minorityInterest") final BigDecimal minorityInterest,
            @JsonProperty("totalLiabilities") final BigDecimal totalLiabilities,
            @JsonProperty("commonStock") final BigDecimal commonStock,
            @JsonProperty("retainedEarnings") final BigDecimal retainedEarnings,
            @JsonProperty("treasuryStock") final BigDecimal treasuryStock,
            @JsonProperty("capitalSurplus") final BigDecimal capitalSurplus,
            @JsonProperty("shareholderEquity") final BigDecimal shareholderEquity,
            @JsonProperty("netTangibleAssets") final BigDecimal netTangibleAssets) {
        this.reportDate = reportDate;
        this.currentCash = currentCash;
        this.shortTermInvestments = shortTermInvestments;
        this.receivables = receivables;
        this.inventory = inventory;
        this.otherCurrentAssets = otherCurrentAssets;
        this.currentAssets = currentAssets;
        this.longTermInvestments = longTermInvestments;
        this.propertyPlantEquipment = propertyPlantEquipment;
        this.goodwill = goodwill;
        this.intangibleAssets = intangibleAssets;
        this.otherAssets = otherAssets;
        this.totalAssets = totalAssets;
        this.accountsPayable = accountsPayable;
        this.currentLongTermDebt = currentLongTermDebt;
        this.otherCurrentLiabilities = otherCurrentLiabilities;
        this.totalCurrentLiabilities = totalCurrentLiabilities;
        this.longTermDebt = longTermDebt;
        this.otherLiabilities = otherLiabilities;
        this.minorityInterest = minorityInterest;
        this.totalLiabilities = totalLiabilities;
        this.commonStock = commonStock;
        this.retainedEarnings = retainedEarnings;
        this.treasuryStock = treasuryStock;
        this.capitalSurplus = capitalSurplus;
        this.shareholderEquity = shareholderEquity;
        this.netTangibleAssets = netTangibleAssets;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public BigDecimal getCurrentCash() {
        return currentCash;
    }

    public BigDecimal getShortTermInvestments() {
        return shortTermInvestments;
    }

    public BigDecimal getReceivables() {
        return receivables;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public BigDecimal getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public BigDecimal getLongTermInvestments() {
        return longTermInvestments;
    }

    public BigDecimal getPropertyPlantEquipment() {
        return propertyPlantEquipment;
    }

    public BigDecimal getGoodwill() {
        return goodwill;
    }

    public BigDecimal getIntangibleAssets() {
        return intangibleAssets;
    }

    public BigDecimal getOtherAssets() {
        return otherAssets;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public BigDecimal getAccountsPayable() {
        return accountsPayable;
    }

    public BigDecimal getCurrentLongTermDebt() {
        return currentLongTermDebt;
    }

    public BigDecimal getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    }

    public BigDecimal getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    }

    public BigDecimal getLongTermDebt() {
        return longTermDebt;
    }

    public BigDecimal getOtherLiabilities() {
        return otherLiabilities;
    }

    public BigDecimal getMinorityInterest() {
        return minorityInterest;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public BigDecimal getCommonStock() {
        return commonStock;
    }

    public BigDecimal getRetainedEarnings() {
        return retainedEarnings;
    }

    public BigDecimal getTreasuryStock() {
        return treasuryStock;
    }

    public BigDecimal getCapitalSurplus() {
        return capitalSurplus;
    }

    public BigDecimal getShareholderEquity() {
        return shareholderEquity;
    }

    public BigDecimal getNetTangibleAssets() {
        return netTangibleAssets;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BalanceSheet that = (BalanceSheet) o;
        return Objects.equal(reportDate, that.reportDate) &&
                Objects.equal(currentCash, that.currentCash) &&
                Objects.equal(shortTermInvestments, that.shortTermInvestments) &&
                Objects.equal(receivables, that.receivables) &&
                Objects.equal(inventory, that.inventory) &&
                Objects.equal(otherCurrentAssets, that.otherCurrentAssets) &&
                Objects.equal(currentAssets, that.currentAssets) &&
                Objects.equal(longTermInvestments, that.longTermInvestments) &&
                Objects.equal(propertyPlantEquipment, that.propertyPlantEquipment) &&
                Objects.equal(goodwill, that.goodwill) &&
                Objects.equal(intangibleAssets, that.intangibleAssets) &&
                Objects.equal(otherAssets, that.otherAssets) &&
                Objects.equal(totalAssets, that.totalAssets) &&
                Objects.equal(accountsPayable, that.accountsPayable) &&
                Objects.equal(currentLongTermDebt, that.currentLongTermDebt) &&
                Objects.equal(otherCurrentLiabilities, that.otherCurrentLiabilities) &&
                Objects.equal(totalCurrentLiabilities, that.totalCurrentLiabilities) &&
                Objects.equal(longTermDebt, that.longTermDebt) &&
                Objects.equal(otherLiabilities, that.otherLiabilities) &&
                Objects.equal(minorityInterest, that.minorityInterest) &&
                Objects.equal(totalLiabilities, that.totalLiabilities) &&
                Objects.equal(commonStock, that.commonStock) &&
                Objects.equal(retainedEarnings, that.retainedEarnings) &&
                Objects.equal(treasuryStock, that.treasuryStock) &&
                Objects.equal(capitalSurplus, that.capitalSurplus) &&
                Objects.equal(shareholderEquity, that.shareholderEquity) &&
                Objects.equal(netTangibleAssets, that.netTangibleAssets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reportDate, currentCash, shortTermInvestments, receivables,
                inventory, otherCurrentAssets, currentAssets, longTermInvestments,
                propertyPlantEquipment, goodwill, intangibleAssets, otherAssets,
                totalAssets, accountsPayable, currentLongTermDebt, otherCurrentLiabilities,
                totalCurrentLiabilities, longTermDebt, otherLiabilities, minorityInterest,
                totalLiabilities, commonStock, retainedEarnings, treasuryStock, capitalSurplus,
                shareholderEquity, netTangibleAssets);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("reportDate", reportDate)
                .add("currentCash", currentCash)
                .add("shortTermInvestments", shortTermInvestments)
                .add("receivables", receivables)
                .add("inventory", inventory)
                .add("otherCurrentAssets", otherCurrentAssets)
                .add("currentAssets", currentAssets)
                .add("longTermInvestments", longTermInvestments)
                .add("propertyPlantEquipment", propertyPlantEquipment)
                .add("goodwill", goodwill)
                .add("intangibleAssets", intangibleAssets)
                .add("otherAssets", otherAssets)
                .add("totalAssets", totalAssets)
                .add("accountsPayable", accountsPayable)
                .add("currentLongTermDebt", currentLongTermDebt)
                .add("otherCurrentLiabilities", otherCurrentLiabilities)
                .add("totalCurrentLiabilities", totalCurrentLiabilities)
                .add("longTermDebt", longTermDebt)
                .add("otherLiabilities", otherLiabilities)
                .add("minorityInterest", minorityInterest)
                .add("totalLiabilities", totalLiabilities)
                .add("commonStock", commonStock)
                .add("retainedEarnings", retainedEarnings)
                .add("treasuryStock", treasuryStock)
                .add("capitalSurplus", capitalSurplus)
                .add("shareholderEquity", shareholderEquity)
                .add("netTangibleAssets", netTangibleAssets)
                .toString();
    }

}
