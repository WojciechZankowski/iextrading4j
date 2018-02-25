package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({"RecordID", "DailyListTimestamp", "EventType", "SymbolinINETSymbology",
        "SymbolinCQSSymbology", "SymbolinCMSSymbology", "SecurityName", "CompanyName",
        "DeclarationDate", "AmountDescription", "PaymentFrequency", "ExDate", "RecordDate",
        "PaymentDate", "DividendTypeID", "StockAdjustmentFactor", "StockAmount", "CashAmount",
        "PostSplitShares", "PreSplitShares", "QualifiedDividend", "ExercisePriceAmount",
        "ElectionorExpirationDate", "GrossAmount", "NetAmount", "BasisNotes", "NotesforEachEntry",
        "RecordUpdateTime"})
public class IEXDividends extends DailyList {

    private final EventType eventType;
    private final String symbolInINETSymbology;
    private final String symbolInCQSSymbology;
    private final String symbolInCMSSymbology;
    private final String securityName;
    private final String companyName;
    private final LocalDate declarationDate;
    private final String amountDescription;
    private final PaymentFrequency paymentFrequency;
    private final LocalDate exDate;
    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final DividendTypeId dividendTypeId;
    private final BigDecimal stockAdjustmentFactor;
    private final BigDecimal stockAmount;
    private final BigDecimal cashAmount;
    private final BigDecimal postSplitShares;
    private final BigDecimal preSplitShares;
    private final QualifiedDividendType qualifiedDividend;
    private final BigDecimal exercisePriceAmount;
    private final LocalDate electionorExpirationDate;
    private final BigDecimal grossAmount;
    private final BigDecimal netAmount;
    private final String basisNotes;
    private final String notesForEachEntry;
    private final LocalDateTime recordUpdateTime;

    @JsonCreator
    public IEXDividends(
            @JsonProperty("RecordID") final String recordId,
            @JsonProperty("DailyListTimestamp") final LocalDateTime dailyListTimestamp,
            @JsonProperty("EventType") final EventType eventType,
            @JsonProperty("SymbolinINETSymbology") final String symbolInINETSymbology,
            @JsonProperty("SymbolinCQSSymbology") final String symbolInCQSSymbology,
            @JsonProperty("SymbolinCMSSymbology") final String symbolInCMSSymbology,
            @JsonProperty("SecurityName") final String securityName,
            @JsonProperty("CompanyName") final String companyName,
            @JsonProperty("DeclarationDate") final LocalDate declarationDate,
            @JsonProperty("AmountDescription") final String amountDescription,
            @JsonProperty("PaymentFrequency") final PaymentFrequency paymentFrequency,
            @JsonProperty("ExDate") final LocalDate exDate,
            @JsonProperty("RecordDate") final LocalDate recordDate,
            @JsonProperty("PaymentDate") final LocalDate paymentDate,
            @JsonProperty("DividendTypeID") final DividendTypeId dividendTypeId,
            @JsonProperty("StockAdjustmentFactor") final BigDecimal stockAdjustmentFactor,
            @JsonProperty("StockAmount") final BigDecimal stockAmount,
            @JsonProperty("CashAmount") final BigDecimal cashAmount,
            @JsonProperty("PostSplitShares") final BigDecimal postSplitShares,
            @JsonProperty("PreSplitShares") final BigDecimal preSplitShares,
            @JsonProperty("QualifiedDividend") final QualifiedDividendType qualifiedDividend,
            @JsonProperty("ExercisePriceAmount") final BigDecimal exercisePriceAmount,
            @JsonProperty("ElectionorExpirationDate") final LocalDate electionorExpirationDate,
            @JsonProperty("GrossAmount") final BigDecimal grossAmount,
            @JsonProperty("NetAmount") final BigDecimal netAmount,
            @JsonProperty("BasisNotes") final String basisNotes,
            @JsonProperty("NotesforEachEntry") final String notesForEachEntry,
            @JsonProperty("RecordUpdateTime") final LocalDateTime recordUpdateTime) {
        super(recordId, dailyListTimestamp);
        this.eventType = eventType;
        this.symbolInINETSymbology = symbolInINETSymbology;
        this.symbolInCQSSymbology = symbolInCQSSymbology;
        this.symbolInCMSSymbology = symbolInCMSSymbology;
        this.securityName = securityName;
        this.companyName = companyName;
        this.declarationDate = declarationDate;
        this.amountDescription = amountDescription;
        this.paymentFrequency = paymentFrequency;
        this.exDate = exDate;
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.dividendTypeId = dividendTypeId;
        this.stockAdjustmentFactor = stockAdjustmentFactor;
        this.stockAmount = stockAmount;
        this.cashAmount = cashAmount;
        this.postSplitShares = postSplitShares;
        this.preSplitShares = preSplitShares;
        this.qualifiedDividend = qualifiedDividend;
        this.exercisePriceAmount = exercisePriceAmount;
        this.electionorExpirationDate = electionorExpirationDate;
        this.grossAmount = grossAmount;
        this.netAmount = netAmount;
        this.basisNotes = basisNotes;
        this.notesForEachEntry = notesForEachEntry;
        this.recordUpdateTime = recordUpdateTime;
    }

    public EventType getEventType() {
        return eventType;
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

    public LocalDate getDeclarationDate() {
        return declarationDate;
    }

    public String getAmountDescription() {
        return amountDescription;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public DividendTypeId getDividendTypeId() {
        return dividendTypeId;
    }

    public BigDecimal getStockAdjustmentFactor() {
        return stockAdjustmentFactor;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public BigDecimal getPostSplitShares() {
        return postSplitShares;
    }

    public BigDecimal getPreSplitShares() {
        return preSplitShares;
    }

    public QualifiedDividendType getQualifiedDividend() {
        return qualifiedDividend;
    }

    public BigDecimal getExercisePriceAmount() {
        return exercisePriceAmount;
    }

    public LocalDate getElectionorExpirationDate() {
        return electionorExpirationDate;
    }

    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public String getBasisNotes() {
        return basisNotes;
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
        final IEXDividends IEXDividends = (IEXDividends) o;
        return eventType == IEXDividends.eventType &&
                Objects.equal(symbolInINETSymbology, IEXDividends.symbolInINETSymbology) &&
                Objects.equal(symbolInCQSSymbology, IEXDividends.symbolInCQSSymbology) &&
                Objects.equal(symbolInCMSSymbology, IEXDividends.symbolInCMSSymbology) &&
                Objects.equal(securityName, IEXDividends.securityName) &&
                Objects.equal(companyName, IEXDividends.companyName) &&
                Objects.equal(declarationDate, IEXDividends.declarationDate) &&
                Objects.equal(amountDescription, IEXDividends.amountDescription) &&
                paymentFrequency == IEXDividends.paymentFrequency &&
                Objects.equal(exDate, IEXDividends.exDate) &&
                Objects.equal(recordDate, IEXDividends.recordDate) &&
                Objects.equal(paymentDate, IEXDividends.paymentDate) &&
                dividendTypeId == IEXDividends.dividendTypeId &&
                Objects.equal(stockAdjustmentFactor, IEXDividends.stockAdjustmentFactor) &&
                Objects.equal(stockAmount, IEXDividends.stockAmount) &&
                Objects.equal(cashAmount, IEXDividends.cashAmount) &&
                Objects.equal(postSplitShares, IEXDividends.postSplitShares) &&
                Objects.equal(preSplitShares, IEXDividends.preSplitShares) &&
                qualifiedDividend == IEXDividends.qualifiedDividend &&
                Objects.equal(exercisePriceAmount, IEXDividends.exercisePriceAmount) &&
                Objects.equal(electionorExpirationDate, IEXDividends.electionorExpirationDate) &&
                Objects.equal(grossAmount, IEXDividends.grossAmount) &&
                Objects.equal(netAmount, IEXDividends.netAmount) &&
                Objects.equal(basisNotes, IEXDividends.basisNotes) &&
                Objects.equal(notesForEachEntry, IEXDividends.notesForEachEntry) &&
                Objects.equal(recordUpdateTime, IEXDividends.recordUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), eventType, symbolInINETSymbology, symbolInCQSSymbology,
                symbolInCMSSymbology, securityName, companyName, declarationDate, amountDescription,
                paymentFrequency, exDate, recordDate, paymentDate, dividendTypeId, stockAdjustmentFactor,
                stockAmount, cashAmount, postSplitShares, preSplitShares, qualifiedDividend, exercisePriceAmount,
                electionorExpirationDate, grossAmount, netAmount, basisNotes, notesForEachEntry, recordUpdateTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("eventType", eventType)
                .add("symbolInINETSymbology", symbolInINETSymbology)
                .add("symbolInCQSSymbology", symbolInCQSSymbology)
                .add("symbolInCMSSymbology", symbolInCMSSymbology)
                .add("securityName", securityName)
                .add("companyName", companyName)
                .add("declarationDate", declarationDate)
                .add("amountDescription", amountDescription)
                .add("paymentFrequency", paymentFrequency)
                .add("exDate", exDate)
                .add("recordDate", recordDate)
                .add("paymentDate", paymentDate)
                .add("dividendTypeId", dividendTypeId)
                .add("stockAdjustmentFactor", stockAdjustmentFactor)
                .add("stockAmount", stockAmount)
                .add("cashAmount", cashAmount)
                .add("postSplitShares", postSplitShares)
                .add("preSplitShares", preSplitShares)
                .add("qualifiedDividend", qualifiedDividend)
                .add("exercisePriceAmount", exercisePriceAmount)
                .add("electionorExpirationDate", electionorExpirationDate)
                .add("grossAmount", grossAmount)
                .add("netAmount", netAmount)
                .add("basisNotes", basisNotes)
                .add("notesForEachEntry", notesForEachEntry)
                .add("recordUpdateTime", recordUpdateTime)
                .toString();
    }
}
