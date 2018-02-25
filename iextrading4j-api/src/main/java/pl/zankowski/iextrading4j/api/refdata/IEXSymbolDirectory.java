package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({"RecordID", "DailyListTimestamp", "SymbolinINETSymbology", "SymbolinCQSSymbology",
        "SymbolinCMSSymbology", "SecurityName", "CompanyName", "TestIssue", "IssueDescription",
        "IssueType", "IssueSubType", "SICCode", "TransferAgent", "FinancialStatus", "RoundLotSize",
        "PreviousOfficialClosingPrice", "AdjustedPreviousOfficialClosingPrice", "WhenIssuedFlag",
        "WhenDistributedFlag", "IPOFlag", "FirstDateListed", "LULDTierIndicator", "CountryofIncorporation",
        "LeveragedETPFlag", "LeveragedETPRatio", "InverseETPFlag", "RecordUpdateTime"})
public class IEXSymbolDirectory extends DailyList {

    private final String symbolInINETSymbology;
    private final String symbolInCQSSymbology;
    private final String symbolInCMSSymbology;
    private final String securityName;
    private final String companyName;
    private final Flag testIssue;
    private final String issueDescription;
    private final IssueType issueType;
    private final IssueSubType issueSubType;
    private final String sicCode;
    private final String transferAgent;
    private final FinancialStatus financialStatus;
    private final BigDecimal roundLotSize;
    private final BigDecimal previousOfficialClosingPrice;
    private final BigDecimal adjustedPreviousOfficialClosingPrice;
    private final Flag whenIssuedFlag;
    private final Flag whenDistributedFlag;
    private final Flag ipoFlag;
    private final LocalDate firstDateListed;
    private final LuldTier luldTierIndicator;
    private final String countryOfIncorporation;
    private final Flag leveragedETPFlag;
    private final BigDecimal leveragedETPRatio;
    private final Flag inverseETPFlag;
    private final LocalDateTime recordUpdateTime;

    @JsonCreator
    public IEXSymbolDirectory(
            @JsonProperty("RecordID") final String recordId,
            @JsonProperty("DailyListTimestamp") final LocalDateTime dailyListTimestamp,
            @JsonProperty("SymbolinINETSymbology") final String symbolInINETSymbology,
            @JsonProperty("SymbolinCQSSymbology") final String symbolInCQSSymbology,
            @JsonProperty("SymbolinCMSSymbology") final String symbolInCMSSymbology,
            @JsonProperty("SecurityName") final String securityName,
            @JsonProperty("CompanyName") final String companyName,
            @JsonProperty("TestIssue") final Flag testIssue,
            @JsonProperty("IssueDescription") final String issueDescription,
            @JsonProperty("IssueType") final IssueType issueType,
            @JsonProperty("IssueSubType") final IssueSubType issueSubType,
            @JsonProperty("SICCode") final String sicCode,
            @JsonProperty("TransferAgent") final String transferAgent,
            @JsonProperty("FinancialStatus") final FinancialStatus financialStatus,
            @JsonProperty("RoundLotSize") final BigDecimal roundLotSize,
            @JsonProperty("PreviousOfficialClosingPrice") final BigDecimal previousOfficialClosingPrice,
            @JsonProperty("AdjustedPreviousOfficialClosingPrice") final BigDecimal adjustedPreviousOfficialClosingPrice,
            @JsonProperty("WhenIssuedFlag") final Flag whenIssuedFlag,
            @JsonProperty("WhenDistributedFlag") final Flag whenDistributedFlag,
            @JsonProperty("IPOFlag") final Flag ipoFlag,
            @JsonProperty("FirstDateListed") final LocalDate firstDateListed,
            @JsonProperty("LULDTierIndicator") final LuldTier luldTierIndicator,
            @JsonProperty("CountryofIncorporation") final String countryOfIncorporation,
            @JsonProperty("LeveragedETPFlag") final Flag leveragedETPFlag,
            @JsonProperty("LeveragedETPRatio") final BigDecimal leveragedETPRatio,
            @JsonProperty("InverseETPFlag") final Flag inverseETPFlag,
            @JsonProperty("RecordUpdateTime") final LocalDateTime recordUpdateTime) {
        super(recordId, dailyListTimestamp);
        this.symbolInINETSymbology = symbolInINETSymbology;
        this.symbolInCQSSymbology = symbolInCQSSymbology;
        this.symbolInCMSSymbology = symbolInCMSSymbology;
        this.securityName = securityName;
        this.companyName = companyName;
        this.testIssue = testIssue;
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.issueSubType = issueSubType;
        this.sicCode = sicCode;
        this.transferAgent = transferAgent;
        this.financialStatus = financialStatus;
        this.roundLotSize = roundLotSize;
        this.previousOfficialClosingPrice = previousOfficialClosingPrice;
        this.adjustedPreviousOfficialClosingPrice = adjustedPreviousOfficialClosingPrice;
        this.whenIssuedFlag = whenIssuedFlag;
        this.whenDistributedFlag = whenDistributedFlag;
        this.ipoFlag = ipoFlag;
        this.firstDateListed = firstDateListed;
        this.luldTierIndicator = luldTierIndicator;
        this.countryOfIncorporation = countryOfIncorporation;
        this.leveragedETPFlag = leveragedETPFlag;
        this.leveragedETPRatio = leveragedETPRatio;
        this.inverseETPFlag = inverseETPFlag;
        this.recordUpdateTime = recordUpdateTime;
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

    public String getSecurityName() {
        return securityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Flag getTestIssue() {
        return testIssue;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IssueSubType getIssueSubType() {
        return issueSubType;
    }

    public String getSicCode() {
        return sicCode;
    }

    public String getTransferAgent() {
        return transferAgent;
    }

    public FinancialStatus getFinancialStatus() {
        return financialStatus;
    }

    public BigDecimal getRoundLotSize() {
        return roundLotSize;
    }

    public BigDecimal getPreviousOfficialClosingPrice() {
        return previousOfficialClosingPrice;
    }

    public BigDecimal getAdjustedPreviousOfficialClosingPrice() {
        return adjustedPreviousOfficialClosingPrice;
    }

    public Flag getWhenIssuedFlag() {
        return whenIssuedFlag;
    }

    public Flag getWhenDistributedFlag() {
        return whenDistributedFlag;
    }

    public Flag getIpoFlag() {
        return ipoFlag;
    }

    public LocalDate getFirstDateListed() {
        return firstDateListed;
    }

    public LuldTier getLuldTierIndicator() {
        return luldTierIndicator;
    }

    public String getCountryOfIncorporation() {
        return countryOfIncorporation;
    }

    public Flag getLeveragedETPFlag() {
        return leveragedETPFlag;
    }

    public BigDecimal getLeveragedETPRatio() {
        return leveragedETPRatio;
    }

    public Flag getInverseETPFlag() {
        return inverseETPFlag;
    }

    public LocalDateTime getRecordUpdateTime() {
        return recordUpdateTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXSymbolDirectory that = (IEXSymbolDirectory) o;
        return Objects.equal(symbolInINETSymbology, that.symbolInINETSymbology) &&
                Objects.equal(symbolInCQSSymbology, that.symbolInCQSSymbology) &&
                Objects.equal(symbolInCMSSymbology, that.symbolInCMSSymbology) &&
                Objects.equal(securityName, that.securityName) &&
                Objects.equal(companyName, that.companyName) &&
                testIssue == that.testIssue &&
                Objects.equal(issueDescription, that.issueDescription) &&
                issueType == that.issueType &&
                issueSubType == that.issueSubType &&
                Objects.equal(sicCode, that.sicCode) &&
                Objects.equal(transferAgent, that.transferAgent) &&
                financialStatus == that.financialStatus &&
                Objects.equal(roundLotSize, that.roundLotSize) &&
                Objects.equal(previousOfficialClosingPrice, that.previousOfficialClosingPrice) &&
                Objects.equal(adjustedPreviousOfficialClosingPrice, that.adjustedPreviousOfficialClosingPrice) &&
                whenIssuedFlag == that.whenIssuedFlag &&
                whenDistributedFlag == that.whenDistributedFlag &&
                ipoFlag == that.ipoFlag &&
                Objects.equal(firstDateListed, that.firstDateListed) &&
                luldTierIndicator == that.luldTierIndicator &&
                Objects.equal(countryOfIncorporation, that.countryOfIncorporation) &&
                leveragedETPFlag == that.leveragedETPFlag &&
                Objects.equal(leveragedETPRatio, that.leveragedETPRatio) &&
                inverseETPFlag == that.inverseETPFlag &&
                Objects.equal(recordUpdateTime, that.recordUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology,
                securityName, companyName, testIssue, issueDescription, issueType, issueSubType, sicCode, transferAgent,
                financialStatus, roundLotSize, previousOfficialClosingPrice, adjustedPreviousOfficialClosingPrice,
                whenIssuedFlag, whenDistributedFlag, ipoFlag, firstDateListed, luldTierIndicator, countryOfIncorporation,
                leveragedETPFlag, leveragedETPRatio, inverseETPFlag, recordUpdateTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbolInINETSymbology", symbolInINETSymbology)
                .add("symbolInCQSSymbology", symbolInCQSSymbology)
                .add("symbolInCMSSymbology", symbolInCMSSymbology)
                .add("securityName", securityName)
                .add("companyName", companyName)
                .add("testIssue", testIssue)
                .add("issueDescription", issueDescription)
                .add("issueType", issueType)
                .add("issueSubType", issueSubType)
                .add("sicCode", sicCode)
                .add("transferAgent", transferAgent)
                .add("financialStatus", financialStatus)
                .add("roundLotSize", roundLotSize)
                .add("previousOfficialClosingPrice", previousOfficialClosingPrice)
                .add("adjustedPreviousOfficialClosingPrice", adjustedPreviousOfficialClosingPrice)
                .add("whenIssuedFlag", whenIssuedFlag)
                .add("whenDistributedFlag", whenDistributedFlag)
                .add("ipoFlag", ipoFlag)
                .add("firstDateListed", firstDateListed)
                .add("luldTierIndicator", luldTierIndicator)
                .add("countryOfIncorporation", countryOfIncorporation)
                .add("leveragedETPFlag", leveragedETPFlag)
                .add("leveragedETPRatio", leveragedETPRatio)
                .add("inverseETPFlag", inverseETPFlag)
                .add("recordUpdateTime", recordUpdateTime)
                .toString();
    }
}
