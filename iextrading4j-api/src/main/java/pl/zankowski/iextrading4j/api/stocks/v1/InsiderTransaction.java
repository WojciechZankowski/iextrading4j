package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class InsiderTransaction extends BaseData {

    private static final long serialVersionUID = -5403038990862585492L;

    private final BigDecimal conversionOrExercisePrice;
    private final DirectIndirect directIndirect;
    private final Long effectiveDate;
    private final LocalDate filingDate;
    private final String fullName;
    private final boolean is10b51;
    private final BigDecimal postShares;
    private final String reportedTitle;
    private final String transactionCode;
    private final LocalDate transactionDate;
    private final BigDecimal transactionPrice;
    private final BigDecimal transactionShares;
    private final BigDecimal transactionValue;
    private final BigDecimal tranPrice;
    private final BigDecimal tranShares;
    private final BigDecimal tranValue;

    public InsiderTransaction(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("conversionOrExercisePrice") final BigDecimal conversionOrExercisePrice,
            @JsonProperty("directIndirect") final DirectIndirect directIndirect,
            @JsonProperty("effectiveDate") final Long effectiveDate,
            @JsonProperty("filingDate") final LocalDate filingDate,
            @JsonProperty("fullName") final String fullName,
            @JsonProperty("is10b51") final boolean is10b51,
            @JsonProperty("postShares") final BigDecimal postShares,
            @JsonProperty("reportedTitle") final String reportedTitle,
            @JsonProperty("transactionCode") final String transactionCode,
            @JsonProperty("transactionDate") final LocalDate transactionDate,
            @JsonProperty("transactionPrice") final BigDecimal transactionPrice,
            @JsonProperty("transactionShares") final BigDecimal transactionShares,
            @JsonProperty("transactionValue") final BigDecimal transactionValue,
            @JsonProperty("tranPrice") final BigDecimal tranPrice,
            @JsonProperty("tranShares") final BigDecimal tranShares,
            @JsonProperty("tranValue") final BigDecimal tranValue) {
        super(symbol, id, key, subkey, updated);
        this.conversionOrExercisePrice = conversionOrExercisePrice;
        this.directIndirect = directIndirect;
        this.effectiveDate = effectiveDate;
        this.filingDate = filingDate;
        this.fullName = fullName;
        this.is10b51 = is10b51;
        this.postShares = postShares;
        this.reportedTitle = reportedTitle;
        this.transactionCode = transactionCode;
        this.transactionDate = transactionDate;
        this.transactionPrice = transactionPrice;
        this.transactionShares = transactionShares;
        this.transactionValue = transactionValue;
        this.tranPrice = tranPrice;
        this.tranShares = tranShares;
        this.tranValue = tranValue;
    }

    public BigDecimal getConversionOrExercisePrice() {
        return conversionOrExercisePrice;
    }

    public DirectIndirect getDirectIndirect() {
        return directIndirect;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isIs10b51() {
        return is10b51;
    }

    public BigDecimal getPostShares() {
        return postShares;
    }

    public String getReportedTitle() {
        return reportedTitle;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public BigDecimal getTransactionPrice() {
        return transactionPrice;
    }

    public BigDecimal getTransactionShares() {
        return transactionShares;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public BigDecimal getTranPrice() {
        return tranPrice;
    }

    public BigDecimal getTranShares() {
        return tranShares;
    }

    public BigDecimal getTranValue() {
        return tranValue;
    }

    @Deprecated
    public char getTranCode() {
        return transactionCode == null ? ' ' : transactionCode.charAt(0);
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
        final InsiderTransaction that = (InsiderTransaction) o;
        return is10b51 == that.is10b51 &&
                Objects.equals(conversionOrExercisePrice, that.conversionOrExercisePrice) &&
                Objects.equals(directIndirect, that.directIndirect) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                directIndirect == that.directIndirect &&
                Objects.equals(filingDate, that.filingDate) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(postShares, that.postShares) &&
                Objects.equals(reportedTitle, that.reportedTitle) &&
                Objects.equals(transactionCode, that.transactionCode) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionPrice, that.transactionPrice) &&
                Objects.equals(transactionShares, that.transactionShares) &&
                Objects.equals(transactionValue, that.transactionValue) &&
                Objects.equals(tranPrice, that.tranPrice) &&
                Objects.equals(tranShares, that.tranShares) &&
                Objects.equals(tranValue, that.tranValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), conversionOrExercisePrice, directIndirect, effectiveDate, directIndirect,
                filingDate, fullName, is10b51, postShares, reportedTitle, transactionCode, transactionDate,
                transactionPrice, transactionShares, transactionValue, tranPrice, tranShares, tranValue);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InsiderTransaction.class.getSimpleName() + "[", "]")
                .add("conversionOrExercisePrice=" + conversionOrExercisePrice)
                .add("directIndirect=" + directIndirect)
                .add("effectiveDate=" + effectiveDate)
                .add("filingDate=" + filingDate)
                .add("fullName='" + fullName + "'")
                .add("is10b51=" + is10b51)
                .add("postShares=" + postShares)
                .add("reportedTitle='" + reportedTitle + "'")
                .add("transactionCode='" + transactionCode + "'")
                .add("transactionDate=" + transactionDate)
                .add("transactionPrice=" + transactionPrice)
                .add("transactionShares=" + transactionShares)
                .add("transactionValue=" + transactionValue)
                .add("tranPrice=" + tranPrice)
                .add("tranShares=" + tranShares)
                .add("tranValue=" + tranValue)
                .toString();
    }
}
