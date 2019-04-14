package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"consensusEPS", "numberOfEstimates", "fiscalPeriod",
        "fiscalEndDate", "reportDate"})
public class Estimate implements Serializable {

    private final BigDecimal consensusEPS;
    private final BigDecimal numberOfEstimates;
    private final String fiscalPeriod;
    private final LocalDate fiscalEndDate;
    private final LocalDate reportDate;

    @JsonCreator
    public Estimate(
            @JsonProperty("consensusEPS") final BigDecimal consensusEPS,
            @JsonProperty("numberOfEstimates") final BigDecimal numberOfEstimates,
            @JsonProperty("fiscalPeriod") final String fiscalPeriod,
            @JsonProperty("fiscalEndDate") final LocalDate fiscalEndDate,
            @JsonProperty("reportDate") final LocalDate reportDate) {
        this.consensusEPS = consensusEPS;
        this.numberOfEstimates = numberOfEstimates;
        this.fiscalPeriod = fiscalPeriod;
        this.fiscalEndDate = fiscalEndDate;
        this.reportDate = reportDate;
    }

    public BigDecimal getConsensusEPS() {
        return consensusEPS;
    }

    public BigDecimal getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public LocalDate getFiscalEndDate() {
        return fiscalEndDate;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Estimate)) return false;
        final Estimate estimate = (Estimate) o;
        return Objects.equal(consensusEPS, estimate.consensusEPS) &&
                Objects.equal(numberOfEstimates, estimate.numberOfEstimates) &&
                Objects.equal(fiscalPeriod, estimate.fiscalPeriod) &&
                Objects.equal(fiscalEndDate, estimate.fiscalEndDate) &&
                Objects.equal(reportDate, estimate.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(consensusEPS, numberOfEstimates, fiscalPeriod, fiscalEndDate, reportDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("consensusEPS", consensusEPS)
                .add("numberOfEstimates", numberOfEstimates)
                .add("fiscalPeriod", fiscalPeriod)
                .add("fiscalEndDate", fiscalEndDate)
                .add("reportDate", reportDate)
                .toString();
    }

}
