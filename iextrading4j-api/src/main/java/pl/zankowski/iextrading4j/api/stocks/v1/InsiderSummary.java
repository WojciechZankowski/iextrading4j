package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"fullName", "netTransacted", "reportedTitle",
        "totalBought", "totalSold"})
public class InsiderSummary implements Serializable {

    private static final long serialVersionUID = 8669068160445448149L;

    private final String fullName;
    private final BigDecimal netTransacted;
    private final String reportedTitle;
    private final BigDecimal totalBought;
    private final BigDecimal totalSold;

    @JsonCreator
    public InsiderSummary(
            @JsonProperty("fullName") final String fullName,
            @JsonProperty("netTransacted") final BigDecimal netTransacted,
            @JsonProperty("reportedTitle") final String reportedTitle,
            @JsonProperty("totalBought") final BigDecimal totalBought,
            @JsonProperty("totalSold") final BigDecimal totalSold) {
        this.fullName = fullName;
        this.netTransacted = netTransacted;
        this.reportedTitle = reportedTitle;
        this.totalBought = totalBought;
        this.totalSold = totalSold;
    }

    public String getFullName() {
        return fullName;
    }

    public BigDecimal getNetTransacted() {
        return netTransacted;
    }

    public String getReportedTitle() {
        return reportedTitle;
    }

    public BigDecimal getTotalBought() {
        return totalBought;
    }

    public BigDecimal getTotalSold() {
        return totalSold;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InsiderSummary that = (InsiderSummary) o;
        return Objects.equal(fullName, that.fullName) &&
                Objects.equal(netTransacted, that.netTransacted) &&
                Objects.equal(reportedTitle, that.reportedTitle) &&
                Objects.equal(totalBought, that.totalBought) &&
                Objects.equal(totalSold, that.totalSold);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fullName, netTransacted, reportedTitle, totalBought, totalSold);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("fullName", fullName)
                .add("netTransacted", netTransacted)
                .add("reportedTitle", reportedTitle)
                .add("totalBought", totalBought)
                .add("totalSold", totalSold)
                .toString();
    }
}
