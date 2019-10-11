package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"effectiveDate", "fullName", "reportedTitle", "tranPrice", "tranShares",
        "tranValue", "directIndirect", "tranCode"})
public class InsiderTransaction implements Serializable {

    private static final long serialVersionUID = -5403038990862585492L;

    private final Long effectiveDate;
    private final String fullName;
    private final String reportedTitle;
    private final BigDecimal tranPrice;
    private final BigDecimal tranShares;
    private final BigDecimal tranValue;
    private final DirectIndirect directIndirect;
    private final char tranCode;

    @JsonCreator
    public InsiderTransaction(
            @JsonProperty("effectiveDate") final Long effectiveDate,
            @JsonProperty("fullName") final String fullName,
            @JsonProperty("reportedTitle") final String reportedTitle,
            @JsonProperty("tranPrice") final BigDecimal tranPrice,
            @JsonProperty("tranShares") final BigDecimal tranShares,
            @JsonProperty("tranValue") final BigDecimal tranValue,
            @JsonProperty("directIndirect") final DirectIndirect directIndirect,
            @JsonProperty("tranCode") final char tranCode) {
        this.effectiveDate = effectiveDate;
        this.fullName = fullName;
        this.reportedTitle = reportedTitle;
        this.tranPrice = tranPrice;
        this.tranShares = tranShares;
        this.tranValue = tranValue;
        this.directIndirect = directIndirect;
        this.tranCode = tranCode;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getReportedTitle() {
        return reportedTitle;
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

    public DirectIndirect getDirectIndirect() {
        return directIndirect;
    }

    public char getTranCode() {
        return tranCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InsiderTransaction that = (InsiderTransaction) o;
        return tranCode == that.tranCode &&
                Objects.equal(effectiveDate, that.effectiveDate) &&
                Objects.equal(fullName, that.fullName) &&
                Objects.equal(reportedTitle, that.reportedTitle) &&
                Objects.equal(tranPrice, that.tranPrice) &&
                Objects.equal(tranShares, that.tranShares) &&
                Objects.equal(tranValue, that.tranValue) &&
                directIndirect == that.directIndirect;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(effectiveDate, fullName, reportedTitle, tranPrice,
                tranShares, tranValue, directIndirect, tranCode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("effectiveDate", effectiveDate)
                .add("fullName", fullName)
                .add("reportedTitle", reportedTitle)
                .add("tranPrice", tranPrice)
                .add("tranShares", tranShares)
                .add("tranValue", tranValue)
                .add("directIndirect", directIndirect)
                .add("tranCode", tranCode)
                .toString();
    }
}
