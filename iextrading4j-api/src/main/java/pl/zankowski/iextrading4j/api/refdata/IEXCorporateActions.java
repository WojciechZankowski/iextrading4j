package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({"RecordID", "DailyListTimestamp", "EffectiveDate", "IssueEvent",
        "CurrentSymbolinINETSymbology", "CurrentSymbolinCQSSymbology", "CurrentSymbolinCMSSymbology",
        "NewSymbolinINETSymbology", "NewSymbolinCQSSymbology", "NewSymbolinCMSSymbology",
        "CurrentSecurityName", "NewSecurityName", "CurrentListingCenter", "NewListingCenter",
        "DelistingReason", "CurrentRoundLotSize", "NewRoundLotSize", "CurrentLULDTierIndicator",
        "NewLULDTierIndicator", "ExpirationDate", "SeparationDate", "SettlementDate", "MaturityDate",
        "RedemptionDate", "CurrentFinancialStatus", "NewFinancialStatus", "WhenIssuedFlag", "WhenDistributedFlag",
        "IPOFlag", "NotesforEachEntry", "RecordUpdateTime"})
public class IEXCorporateActions extends DailyList {

    private final LocalDate effectiveDate;
    private final IssueEvent issueEvent;
    private final String currentSymbolInINETSymbology;
    private final String currentSymbolInCQSSymbology;
    private final String currentSymbolInCMSSymbology;
    private final String newSymbolInINETSymbology;
    private final String newSymbolInCQSSymbology;
    private final String newSymbolInCMSSymbology;
    private final String currentSecurityName;
    private final String newSecurityName;
    private final String currentCompanyName;
    private final String newCompanyName;
    private final ListingCenter currentListingCenter;
    private final ListingCenter newListingCenter;
    private final DelistingReason delistingReason;
    private final BigDecimal currentRoundLotSize;
    private final BigDecimal newRoundLotSize;
    private final LuldTier currentLULDTierIndicator;
    private final LuldTier newLULDTierIndicator;
    private final LocalDate expirationDate;
    private final LocalDate separationDate;
    private final LocalDate settlementDate;
    private final LocalDate maturityDate;
    private final LocalDate redemptionDate;
    private final FinancialStatus currentFinancialStatus;
    private final FinancialStatus newFinancialStatus;
    private final Flag whenIssuedFlag;
    private final Flag whenDistributedFlag;
    private final Flag ipoFlag;
    private final String notesForEachEntry;
    private final LocalDateTime recordUpdateTime;

    @JsonCreator
    public IEXCorporateActions(
            @JsonProperty("RecordID") final String recordId,
            @JsonProperty("DailyListTimestamp") final LocalDateTime dailyListTimestamp,
            @JsonProperty("EffectiveDate") final LocalDate effectiveDate,
            @JsonProperty("IssueEvent") final IssueEvent issueEvent,
            @JsonProperty("CurrentSymbolinINETSymbology") final String currentSymbolInINETSymbology,
            @JsonProperty("CurrentSymbolinCQSSymbology") final String currentSymbolInCQSSymbology,
            @JsonProperty("CurrentSymbolinCMSSymbology") final String currentSymbolInCMSSymbology,
            @JsonProperty("NewSymbolinINETSymbology") final String newSymbolInINETSymbology,
            @JsonProperty("NewSymbolinCQSSymbology") final String newSymbolInCQSSymbology,
            @JsonProperty("NewSymbolinCMSSymbology") final String newSymbolInCMSSymbology,
            @JsonProperty("CurrentSecurityName") final String currentSecurityName,
            @JsonProperty("NewSecurityName") final String newSecurityName,
            @JsonProperty("CurrentCompanyName") final String currentCompanyName,
            @JsonProperty("NewCompanyName") final String newCompanyName,
            @JsonProperty("CurrentListingCenter") final ListingCenter currentListingCenter,
            @JsonProperty("NewListingCenter") final ListingCenter newListingCenter,
            @JsonProperty("DelistingReason") final DelistingReason delistingReason,
            @JsonProperty("CurrentRoundLotSize") final BigDecimal currentRoundLotSize,
            @JsonProperty("NewRoundLotSize") final BigDecimal newRoundLotSize,
            @JsonProperty("CurrentLULDTierIndicator") final LuldTier currentLULDTierIndicator,
            @JsonProperty("NewLULDTierIndicator") final LuldTier newLULDTierIndicator,
            @JsonProperty("ExpirationDate") final LocalDate expirationDate,
            @JsonProperty("SeparationDate") final LocalDate separationDate,
            @JsonProperty("SettlementDate") final LocalDate settlementDate,
            @JsonProperty("MaturityDate") final LocalDate maturityDate,
            @JsonProperty("RedemptionDate") final LocalDate redemptionDate,
            @JsonProperty("CurrentFinancialStatus") final FinancialStatus currentFinancialStatus,
            @JsonProperty("NewFinancialStatus") final FinancialStatus newFinancialStatus,
            @JsonProperty("WhenIssuedFlag") final Flag whenIssuedFlag,
            @JsonProperty("WhenDistributedFlag") final Flag whenDistributedFlag,
            @JsonProperty("IPOFlag") final Flag ipoFlag,
            @JsonProperty("NotesforEachEntry") final String notesForEachEntry,
            @JsonProperty("RecordUpdateTime") final LocalDateTime recordUpdateTime) {
        super(recordId, dailyListTimestamp);
        this.effectiveDate = effectiveDate;
        this.issueEvent = issueEvent;
        this.currentSymbolInINETSymbology = currentSymbolInINETSymbology;
        this.currentSymbolInCQSSymbology = currentSymbolInCQSSymbology;
        this.currentSymbolInCMSSymbology = currentSymbolInCMSSymbology;
        this.newSymbolInINETSymbology = newSymbolInINETSymbology;
        this.newSymbolInCQSSymbology = newSymbolInCQSSymbology;
        this.newSymbolInCMSSymbology = newSymbolInCMSSymbology;
        this.currentSecurityName = currentSecurityName;
        this.newSecurityName = newSecurityName;
        this.currentCompanyName = currentCompanyName;
        this.newCompanyName = newCompanyName;
        this.currentListingCenter = currentListingCenter;
        this.newListingCenter = newListingCenter;
        this.delistingReason = delistingReason;
        this.currentRoundLotSize = currentRoundLotSize;
        this.newRoundLotSize = newRoundLotSize;
        this.currentLULDTierIndicator = currentLULDTierIndicator;
        this.newLULDTierIndicator = newLULDTierIndicator;
        this.expirationDate = expirationDate;
        this.separationDate = separationDate;
        this.settlementDate = settlementDate;
        this.maturityDate = maturityDate;
        this.redemptionDate = redemptionDate;
        this.currentFinancialStatus = currentFinancialStatus;
        this.newFinancialStatus = newFinancialStatus;
        this.whenIssuedFlag = whenIssuedFlag;
        this.whenDistributedFlag = whenDistributedFlag;
        this.ipoFlag = ipoFlag;
        this.notesForEachEntry = notesForEachEntry;
        this.recordUpdateTime = recordUpdateTime;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public IssueEvent getIssueEvent() {
        return issueEvent;
    }

    public String getCurrentSymbolInINETSymbology() {
        return currentSymbolInINETSymbology;
    }

    public String getCurrentSymbolInCQSSymbology() {
        return currentSymbolInCQSSymbology;
    }

    public String getCurrentSymbolInCMSSymbology() {
        return currentSymbolInCMSSymbology;
    }

    public String getNewSymbolInINETSymbology() {
        return newSymbolInINETSymbology;
    }

    public String getNewSymbolInCQSSymbology() {
        return newSymbolInCQSSymbology;
    }

    public String getNewSymbolInCMSSymbology() {
        return newSymbolInCMSSymbology;
    }

    public String getCurrentSecurityName() {
        return currentSecurityName;
    }

    public String getNewSecurityName() {
        return newSecurityName;
    }

    public String getCurrentCompanyName() {
        return currentCompanyName;
    }

    public String getNewCompanyName() {
        return newCompanyName;
    }

    public ListingCenter getCurrentListingCenter() {
        return currentListingCenter;
    }

    public ListingCenter getNewListingCenter() {
        return newListingCenter;
    }

    public DelistingReason getDelistingReason() {
        return delistingReason;
    }

    public BigDecimal getCurrentRoundLotSize() {
        return currentRoundLotSize;
    }

    public BigDecimal getNewRoundLotSize() {
        return newRoundLotSize;
    }

    public LuldTier getCurrentLULDTierIndicator() {
        return currentLULDTierIndicator;
    }

    public LuldTier getNewLULDTierIndicator() {
        return newLULDTierIndicator;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getSeparationDate() {
        return separationDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public LocalDate getRedemptionDate() {
        return redemptionDate;
    }

    public FinancialStatus getCurrentFinancialStatus() {
        return currentFinancialStatus;
    }

    public FinancialStatus getNewFinancialStatus() {
        return newFinancialStatus;
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

    public String getNotesForEachEntry() {
        return notesForEachEntry;
    }

    public LocalDateTime getRecordUpdateTime() {
        return recordUpdateTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXCorporateActions that = (IEXCorporateActions) o;
        return Objects.equal(effectiveDate, that.effectiveDate) &&
                issueEvent == that.issueEvent &&
                Objects.equal(currentSymbolInINETSymbology, that.currentSymbolInINETSymbology) &&
                Objects.equal(currentSymbolInCQSSymbology, that.currentSymbolInCQSSymbology) &&
                Objects.equal(currentSymbolInCMSSymbology, that.currentSymbolInCMSSymbology) &&
                Objects.equal(newSymbolInINETSymbology, that.newSymbolInINETSymbology) &&
                Objects.equal(newSymbolInCQSSymbology, that.newSymbolInCQSSymbology) &&
                Objects.equal(newSymbolInCMSSymbology, that.newSymbolInCMSSymbology) &&
                Objects.equal(currentSecurityName, that.currentSecurityName) &&
                Objects.equal(newSecurityName, that.newSecurityName) &&
                Objects.equal(currentCompanyName, that.currentCompanyName) &&
                Objects.equal(newCompanyName, that.newCompanyName) &&
                currentListingCenter == that.currentListingCenter &&
                newListingCenter == that.newListingCenter &&
                delistingReason == that.delistingReason &&
                Objects.equal(currentRoundLotSize, that.currentRoundLotSize) &&
                Objects.equal(newRoundLotSize, that.newRoundLotSize) &&
                currentLULDTierIndicator == that.currentLULDTierIndicator &&
                newLULDTierIndicator == that.newLULDTierIndicator &&
                Objects.equal(expirationDate, that.expirationDate) &&
                Objects.equal(separationDate, that.separationDate) &&
                Objects.equal(settlementDate, that.settlementDate) &&
                Objects.equal(maturityDate, that.maturityDate) &&
                Objects.equal(redemptionDate, that.redemptionDate) &&
                currentFinancialStatus == that.currentFinancialStatus &&
                newFinancialStatus == that.newFinancialStatus &&
                whenIssuedFlag == that.whenIssuedFlag &&
                whenDistributedFlag == that.whenDistributedFlag &&
                ipoFlag == that.ipoFlag &&
                Objects.equal(notesForEachEntry, that.notesForEachEntry) &&
                Objects.equal(recordUpdateTime, that.recordUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), effectiveDate, issueEvent, currentSymbolInINETSymbology,
                currentSymbolInCQSSymbology, currentSymbolInCMSSymbology, newSymbolInINETSymbology,
                newSymbolInCQSSymbology, newSymbolInCMSSymbology, currentSecurityName, newSecurityName,
                currentCompanyName, newCompanyName, currentListingCenter, newListingCenter, delistingReason,
                currentRoundLotSize, newRoundLotSize, currentLULDTierIndicator, newLULDTierIndicator,
                expirationDate, separationDate, settlementDate, maturityDate, redemptionDate,
                currentFinancialStatus, newFinancialStatus, whenIssuedFlag, whenDistributedFlag,
                ipoFlag, notesForEachEntry, recordUpdateTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectiveDate", effectiveDate)
                .add("issueEvent", issueEvent)
                .add("currentSymbolInINETSymbology", currentSymbolInINETSymbology)
                .add("currentSymbolInCQSSymbology", currentSymbolInCQSSymbology)
                .add("currentSymbolInCMSSymbology", currentSymbolInCMSSymbology)
                .add("newSymbolInINETSymbology", newSymbolInINETSymbology)
                .add("newSymbolInCQSSymbology", newSymbolInCQSSymbology)
                .add("newSymbolInCMSSymbology", newSymbolInCMSSymbology)
                .add("currentSecurityName", currentSecurityName)
                .add("newSecurityName", newSecurityName)
                .add("currentCompanyName", currentCompanyName)
                .add("newCompanyName", newCompanyName)
                .add("currentListingCenter", currentListingCenter)
                .add("newListingCenter", newListingCenter)
                .add("delistingReason", delistingReason)
                .add("currentRoundLotSize", currentRoundLotSize)
                .add("newRoundLotSize", newRoundLotSize)
                .add("currentLULDTierIndicator", currentLULDTierIndicator)
                .add("newLULDTierIndicator", newLULDTierIndicator)
                .add("expirationDate", expirationDate)
                .add("separationDate", separationDate)
                .add("settlementDate", settlementDate)
                .add("maturityDate", maturityDate)
                .add("redemptionDate", redemptionDate)
                .add("currentFinancialStatus", currentFinancialStatus)
                .add("newFinancialStatus", newFinancialStatus)
                .add("whenIssuedFlag", whenIssuedFlag)
                .add("whenDistributedFlag", whenDistributedFlag)
                .add("ipoFlag", ipoFlag)
                .add("notesForEachEntry", notesForEachEntry)
                .add("recordUpdateTime", recordUpdateTime)
                .toString();
    }
}
