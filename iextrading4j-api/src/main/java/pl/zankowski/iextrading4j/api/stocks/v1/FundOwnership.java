package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class FundOwnership implements Serializable {

    private final BigDecimal adjHolding;
    private final BigDecimal adjMv;
    private final String entityProperName;
    private final Long reportDate;
    private final BigDecimal reportedHolding;
    private final BigDecimal reportedMv;

    @JsonCreator
    public FundOwnership(
            @JsonProperty("adjHolding") final BigDecimal adjHolding,
            @JsonProperty("adjMv") final BigDecimal adjMv,
            @JsonProperty("entityProperName") final String entityProperName,
            @JsonProperty("reportDate") final Long reportDate,
            @JsonProperty("reportedHolding") final BigDecimal reportedHolding,
            @JsonProperty("reportedMv") final BigDecimal reportedMv) {
        this.adjHolding = adjHolding;
        this.adjMv = adjMv;
        this.entityProperName = entityProperName;
        this.reportDate = reportDate;
        this.reportedHolding = reportedHolding;
        this.reportedMv = reportedMv;
    }

    public BigDecimal getAdjHolding() {
        return adjHolding;
    }

    public BigDecimal getAdjMv() {
        return adjMv;
    }

    public String getEntityProperName() {
        return entityProperName;
    }

    public Long getReportDate() {
        return reportDate;
    }

    public BigDecimal getReportedHolding() {
        return reportedHolding;
    }

    public BigDecimal getReportedMv() {
        return reportedMv;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FundOwnership)) return false;
        final FundOwnership that = (FundOwnership) o;
        return Objects.equal(adjHolding, that.adjHolding) &&
                Objects.equal(adjMv, that.adjMv) &&
                Objects.equal(entityProperName, that.entityProperName) &&
                Objects.equal(reportDate, that.reportDate) &&
                Objects.equal(reportedHolding, that.reportedHolding) &&
                Objects.equal(reportedMv, that.reportedMv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(adjHolding, adjMv, entityProperName, reportDate, reportedHolding, reportedMv);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("adjHolding", adjHolding)
                .add("adjMv", adjMv)
                .add("entityProperName", entityProperName)
                .add("reportDate", reportDate)
                .add("reportedHolding", reportedHolding)
                .add("reportedMv", reportedMv)
                .toString();
    }

}
