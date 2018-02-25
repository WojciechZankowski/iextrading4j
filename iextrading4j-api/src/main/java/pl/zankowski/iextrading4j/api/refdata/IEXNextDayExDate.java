package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({"RecordID", "DailyListTimestamp", "ExDate", "SymbolinINETSymbology",
        "SymbolinCQSSymbology", "SymbolinCMSSymbology", "SecurityName", "CompanyName",
        "DividendTypeID", "AmountDescription", "PaymentFrequency", "StockAdjustmentFactor",
        "StockAmount", "CashAmount", "PostSplitShares", "PreSplitShares", "QualifiedDividend",
        "ExercisePriceAmount", "ElectionorExpirationDate", "GrossAmount", "NetAmount",
        "BasisNotes", "NotesforEachEntry", "RecordUpdateTime"})
public class IEXNextDayExDate extends DailyList {

    private final LocalDate exDate;
    private final String symbolInINETSymbology;
    private final String symbolInCQSSymbology;
    private final String symbolInCMSSymbology;
    private final String securityName;
    private final String companyName;
    private final DividendTypeId dividendTypeId;
    private final String amountDescription;
    private final PaymentFrequency paymentFrequency;
    private final BigDecimal stockAdjustmentFactor;
    private final BigDecimal stockAmount;
    private final BigDecimal cashAmount;
    private final BigDecimal postSplitShares;
    private final BigDecimal preSplitShares;
    private final QualifiedDividendType qualifiedDividend;
    private final BigDecimal exercisePriceAmount;
    private final BigDecimal electionorExpirationDate;
    private final BigDecimal grossAmount;
    private final BigDecimal netAmount;
    private final String basisNotes;
    private final String notesForEachEntry;
    private final LocalDateTime recordUpdateTime;

    @JsonCreator
    public IEXNextDayExDate(
            @JsonProperty("RecordID") final String recordId,
            @JsonProperty("DailyListTimestamp") final LocalDateTime dailyListTimestamp,
            @JsonProperty("ExDate") final LocalDate exDate,
            @JsonProperty("SymbolinINETSymbology") final String symbolInINETSymbology,
            @JsonProperty("SymbolinCQSSymbology") final String symbolInCQSSymbology,
            @JsonProperty("SymbolinCMSSymbology") final String symbolInCMSSymbology,
            @JsonProperty("SecurityName") final String securityName,
            @JsonProperty("CompanyName") final String companyName,
            @JsonProperty("DividendTypeID") final DividendTypeId dividendTypeId,
            @JsonProperty("AmountDescription") final String amountDescription,
            @JsonProperty("PaymentFrequency") final PaymentFrequency paymentFrequency,
            @JsonProperty("StockAdjustmentFactor") final BigDecimal stockAdjustmentFactor,
            @JsonProperty("StockAmount") final BigDecimal stockAmount,
            @JsonProperty("CashAmount") final BigDecimal cashAmount,
            @JsonProperty("PostSplitShares") final BigDecimal postSplitShares,
            @JsonProperty("PreSplitShares") final BigDecimal preSplitShares,
            @JsonProperty("QualifiedDividend") final QualifiedDividendType qualifiedDividend,
            @JsonProperty("ExercisePriceAmount") final BigDecimal exercisePriceAmount,
            @JsonProperty("ElectionorExpirationDate") final BigDecimal electionorExpirationDate,
            @JsonProperty("GrossAmount") final BigDecimal grossAmount,
            @JsonProperty("NetAmount") final BigDecimal netAmount,
            @JsonProperty("BasisNotes") final String basisNotes,
            @JsonProperty("NotesforEachEntry") final String notesForEachEntry,
            @JsonProperty("RecordUpdateTime") final LocalDateTime recordUpdateTime) {
        super(recordId, dailyListTimestamp);
        this.exDate = exDate;
        this.symbolInINETSymbology = symbolInINETSymbology;
        this.symbolInCQSSymbology = symbolInCQSSymbology;
        this.symbolInCMSSymbology = symbolInCMSSymbology;
        this.securityName = securityName;
        this.companyName = companyName;
        this.dividendTypeId = dividendTypeId;
        this.amountDescription = amountDescription;
        this.paymentFrequency = paymentFrequency;
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

    public LocalDate getExDate() {
        return exDate;
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

    public DividendTypeId getDividendTypeId() {
        return dividendTypeId;
    }

    public String getAmountDescription() {
        return amountDescription;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
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

    public BigDecimal getElectionorExpirationDate() {
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
        final IEXNextDayExDate that = (IEXNextDayExDate) o;
        return Objects.equal(exDate, that.exDate) &&
                Objects.equal(symbolInINETSymbology, that.symbolInINETSymbology) &&
                Objects.equal(symbolInCQSSymbology, that.symbolInCQSSymbology) &&
                Objects.equal(symbolInCMSSymbology, that.symbolInCMSSymbology) &&
                Objects.equal(securityName, that.securityName) &&
                Objects.equal(companyName, that.companyName) &&
                dividendTypeId == that.dividendTypeId &&
                Objects.equal(amountDescription, that.amountDescription) &&
                Objects.equal(paymentFrequency, that.paymentFrequency) &&
                Objects.equal(stockAdjustmentFactor, that.stockAdjustmentFactor) &&
                Objects.equal(stockAmount, that.stockAmount) &&
                Objects.equal(cashAmount, that.cashAmount) &&
                Objects.equal(postSplitShares, that.postSplitShares) &&
                Objects.equal(preSplitShares, that.preSplitShares) &&
                Objects.equal(qualifiedDividend, that.qualifiedDividend) &&
                Objects.equal(exercisePriceAmount, that.exercisePriceAmount) &&
                Objects.equal(electionorExpirationDate, that.electionorExpirationDate) &&
                Objects.equal(grossAmount, that.grossAmount) &&
                Objects.equal(netAmount, that.netAmount) &&
                Objects.equal(basisNotes, that.basisNotes) &&
                Objects.equal(notesForEachEntry, that.notesForEachEntry) &&
                Objects.equal(recordUpdateTime, that.recordUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), exDate, symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology, securityName, companyName, dividendTypeId, amountDescription, paymentFrequency, stockAdjustmentFactor, stockAmount, cashAmount, postSplitShares, preSplitShares, qualifiedDividend, exercisePriceAmount, electionorExpirationDate, grossAmount, netAmount, basisNotes, notesForEachEntry, recordUpdateTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exDate", exDate)
                .add("symbolInINETSymbology", symbolInINETSymbology)
                .add("symbolInCQSSymbology", symbolInCQSSymbology)
                .add("symbolInCMSSymbology", symbolInCMSSymbology)
                .add("securityName", securityName)
                .add("companyName", companyName)
                .add("dividendTypeId", dividendTypeId)
                .add("amountDescription", amountDescription)
                .add("paymentFrequency", paymentFrequency)
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
