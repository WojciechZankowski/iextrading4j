package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"actualEPS", "consensusEPS", "estimatedEPS", "announceTime",
        "numberOfEstimates", "EPSSurpriseDollar", "EPSReportDate", "fiscalPeriod",
        "fiscalEndDate", "yearAgo", "yearAgoChangePercent"})
public class Earning implements Serializable {

    private static final long serialVersionUID = -3254561425537119565L;

    private final BigDecimal actualEPS;
    private final BigDecimal consensusEPS;
    private final BigDecimal estimatedEPS;
    private final String announceTime;
    private final BigDecimal numberOfEstimates;
    private final BigDecimal EPSSurpriseDollar;
    private final LocalDate EPSReportDate;
    private final String fiscalPeriod;
    private final LocalDate fiscalEndDate;
    private final BigDecimal yearAgo;
    private final BigDecimal yearAgoChangePercent;

    @JsonCreator
    public Earning(
            @JsonProperty("actualEPS") final BigDecimal actualEPS,
            @JsonProperty("consensusEPS") final BigDecimal consensusEPS,
            @JsonProperty("estimatedEPS") final BigDecimal estimatedEPS,
            @JsonProperty("announceTime") final String announceTime,
            @JsonProperty("numberOfEstimates") final BigDecimal numberOfEstimates,
            @JsonProperty("EPSSurpriseDollar") final BigDecimal EPSSurpriseDollar,
            @JsonProperty("EPSReportDate") final LocalDate EPSReportDate,
            @JsonProperty("fiscalPeriod") final String fiscalPeriod,
            @JsonProperty("fiscalEndDate") final LocalDate fiscalEndDate,
            @JsonProperty("yearAgo") final BigDecimal yearAgo,
            @JsonProperty("yearAgoChangePercent") final BigDecimal yearAgoChangePercent) {
        this.actualEPS = actualEPS;
        this.consensusEPS = consensusEPS;
        this.estimatedEPS = estimatedEPS;
        this.announceTime = announceTime;
        this.numberOfEstimates = numberOfEstimates;
        this.EPSSurpriseDollar = EPSSurpriseDollar;
        this.EPSReportDate = EPSReportDate;
        this.fiscalPeriod = fiscalPeriod;
        this.fiscalEndDate = fiscalEndDate;
        this.yearAgo = yearAgo;
        this.yearAgoChangePercent = yearAgoChangePercent;
    }

    public BigDecimal getActualEPS() {
        return actualEPS;
    }

    public BigDecimal getConsensusEPS() {
        return consensusEPS;
    }

    public BigDecimal getEstimatedEPS() {
        return estimatedEPS;
    }

    public String getAnnounceTime() {
        return announceTime;
    }

    public BigDecimal getNumberOfEstimates() {
        return numberOfEstimates;
    }

    @JsonProperty("EPSSurpriseDollar")
    public BigDecimal getEPSSurpriseDollar() {
        return EPSSurpriseDollar;
    }

    @JsonProperty("EPSReportDate")
    public LocalDate getEPSReportDate() {
        return EPSReportDate;
    }

    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public LocalDate getFiscalEndDate() {
        return fiscalEndDate;
    }

    public BigDecimal getYearAgo() {
        return yearAgo;
    }

    public BigDecimal getYearAgoChangePercent() {
        return yearAgoChangePercent;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Earning earning = (Earning) o;
        return Objects.equal(actualEPS, earning.actualEPS) &&
                Objects.equal(consensusEPS, earning.consensusEPS) &&
                Objects.equal(estimatedEPS, earning.estimatedEPS) &&
                Objects.equal(announceTime, earning.announceTime) &&
                Objects.equal(numberOfEstimates, earning.numberOfEstimates) &&
                Objects.equal(EPSSurpriseDollar, earning.EPSSurpriseDollar) &&
                Objects.equal(EPSReportDate, earning.EPSReportDate) &&
                Objects.equal(fiscalPeriod, earning.fiscalPeriod) &&
                Objects.equal(fiscalEndDate, earning.fiscalEndDate) &&
                Objects.equal(yearAgo, earning.yearAgo) &&
                Objects.equal(yearAgoChangePercent, earning.yearAgoChangePercent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actualEPS, consensusEPS, estimatedEPS, announceTime, numberOfEstimates,
                EPSSurpriseDollar, EPSReportDate, fiscalPeriod, fiscalEndDate, yearAgo, yearAgoChangePercent);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("actualEPS", actualEPS)
                .add("consensusEPS", consensusEPS)
                .add("estimatedEPS", estimatedEPS)
                .add("announceTime", announceTime)
                .add("numberOfEstimates", numberOfEstimates)
                .add("EPSSurpriseDollar", EPSSurpriseDollar)
                .add("EPSReportDate", EPSReportDate)
                .add("fiscalPeriod", fiscalPeriod)
                .add("fiscalEndDate", fiscalEndDate)
                .add("yearAgo", yearAgo)
                .add("yearAgoChangePercent", yearAgoChangePercent)
                .toString();
    }

}
