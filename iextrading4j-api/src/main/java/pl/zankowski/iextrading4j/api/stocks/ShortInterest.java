package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.refdata.Flag;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"SettlementDate", "SymbolinINETSymbology", "SymbolinCQSSymbology", "SymbolinCMSSymbology",
        "CUSIP", "SecurityName", "CompanyName", "CurrentShortInterest", "PreviousShortInterest", "PercentChange",
        "AverageDailyVolume", "DaystoCover", "StockAdjustmentFlag", "NewIssueFlag", "RevisionFlag"})
public class ShortInterest implements Serializable {

    private final LocalDate settlementDate;
    private final String symbolInINETSymbology;
    private final String symbolInCQSSymbology;
    private final String symbolInCMSSymbology;
    private final String cusip;
    private final String securityName;
    private final String companyName;
    private final BigDecimal currentShortInterest;
    private final BigDecimal previousShortInterest;
    private final BigDecimal percentChange;
    private final BigDecimal averageDailyVolume;
    private final BigDecimal daystoCover;
    private final Flag stockAdjustmentFlag;
    private final Flag newIssueFlag;
    private final Flag revisionFlag;

    @JsonCreator
    public ShortInterest(
            @JsonProperty("SettlementDate") @JsonFormat(pattern = "yyyyMMdd") final LocalDate settlementDate,
            @JsonProperty("SymbolinINETSymbology") final String symbolInINETSymbology,
            @JsonProperty("SymbolinCQSSymbology") final String symbolInCQSSymbology,
            @JsonProperty("SymbolinCMSSymbology") final String symbolInCMSSymbology,
            @JsonProperty("CUSIP") final String cusip,
            @JsonProperty("SecurityName") final String securityName,
            @JsonProperty("CompanyName") final String companyName,
            @JsonProperty("CurrentShortInterest") final BigDecimal currentShortInterest,
            @JsonProperty("PreviousShortInterest") final BigDecimal previousShortInterest,
            @JsonProperty("PercentChange") final BigDecimal percentChange,
            @JsonProperty("AverageDailyVolume") final BigDecimal averageDailyVolume,
            @JsonProperty("DaystoCover") final BigDecimal daystoCover,
            @JsonProperty("StockAdjustmentFlag") final Flag stockAdjustmentFlag,
            @JsonProperty("NewIssueFlag") final Flag newIssueFlag,
            @JsonProperty("RevisionFlag") final Flag revisionFlag) {
        this.settlementDate = settlementDate;
        this.symbolInINETSymbology = symbolInINETSymbology;
        this.symbolInCQSSymbology = symbolInCQSSymbology;
        this.symbolInCMSSymbology = symbolInCMSSymbology;
        this.cusip = cusip;
        this.securityName = securityName;
        this.companyName = companyName;
        this.currentShortInterest = currentShortInterest;
        this.previousShortInterest = previousShortInterest;
        this.percentChange = percentChange;
        this.averageDailyVolume = averageDailyVolume;
        this.daystoCover = daystoCover;
        this.stockAdjustmentFlag = stockAdjustmentFlag;
        this.newIssueFlag = newIssueFlag;
        this.revisionFlag = revisionFlag;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public String getSymbolInINETSymbology() {
        return symbolInINETSymbology;
    }

    public String getSymbolInCQSSymbology() {
        return symbolInCQSSymbology;
    }

    public String getSymbolInCMSSymbology() {
        return symbolInCMSSymbology;
    }

    public String getCusip() {
        return cusip;
    }

    public String getSecurityName() {
        return securityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getCurrentShortInterest() {
        return currentShortInterest;
    }

    public BigDecimal getPreviousShortInterest() {
        return previousShortInterest;
    }

    public BigDecimal getPercentChange() {
        return percentChange;
    }

    public BigDecimal getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public BigDecimal getDaystoCover() {
        return daystoCover;
    }

    public Flag getStockAdjustmentFlag() {
        return stockAdjustmentFlag;
    }

    public Flag getNewIssueFlag() {
        return newIssueFlag;
    }

    public Flag getRevisionFlag() {
        return revisionFlag;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ShortInterest that = (ShortInterest) o;
        return Objects.equal(settlementDate, that.settlementDate) &&
                Objects.equal(symbolInINETSymbology, that.symbolInINETSymbology) &&
                Objects.equal(symbolInCQSSymbology, that.symbolInCQSSymbology) &&
                Objects.equal(symbolInCMSSymbology, that.symbolInCMSSymbology) &&
                Objects.equal(cusip, that.cusip) &&
                Objects.equal(securityName, that.securityName) &&
                Objects.equal(companyName, that.companyName) &&
                Objects.equal(currentShortInterest, that.currentShortInterest) &&
                Objects.equal(previousShortInterest, that.previousShortInterest) &&
                Objects.equal(percentChange, that.percentChange) &&
                Objects.equal(averageDailyVolume, that.averageDailyVolume) &&
                Objects.equal(daystoCover, that.daystoCover) &&
                stockAdjustmentFlag == that.stockAdjustmentFlag &&
                newIssueFlag == that.newIssueFlag &&
                revisionFlag == that.revisionFlag;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(settlementDate, symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology,
                cusip, securityName, companyName, currentShortInterest, previousShortInterest, percentChange,
                averageDailyVolume, daystoCover, stockAdjustmentFlag, newIssueFlag, revisionFlag);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("settlementDate", settlementDate)
                .add("symbolInINETSymbology", symbolInINETSymbology)
                .add("symbolInCQSSymbology", symbolInCQSSymbology)
                .add("symbolInCMSSymbology", symbolInCMSSymbology)
                .add("cusip", cusip)
                .add("securityName", securityName)
                .add("companyName", companyName)
                .add("currentShortInterest", currentShortInterest)
                .add("previousShortInterest", previousShortInterest)
                .add("percentChange", percentChange)
                .add("averageDailyVolume", averageDailyVolume)
                .add("daystoCover", daystoCover)
                .add("stockAdjustmentFlag", stockAdjustmentFlag)
                .add("newIssueFlag", newIssueFlag)
                .add("revisionFlag", revisionFlag)
                .toString();
    }
}
