package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class Ownership implements Serializable {

    private static final long serialVersionUID = -90284369606919937L;

    private final BigDecimal adjHolding;
    private final BigDecimal adjMv;
    private final String entityProperName;
    private final Long reportDate;
    private final BigDecimal reportedHolding;

    @JsonCreator
    public Ownership(
            @JsonProperty("adjHolding") final BigDecimal adjHolding,
            @JsonProperty("adjMv") final BigDecimal adjMv,
            @JsonProperty("entityProperName") final String entityProperName,
            @JsonProperty("reportDate") final Long reportDate,
            @JsonProperty("reportedHolding") final BigDecimal reportedHolding) {
        this.adjHolding = adjHolding;
        this.adjMv = adjMv;
        this.entityProperName = entityProperName;
        this.reportDate = reportDate;
        this.reportedHolding = reportedHolding;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ownership ownership = (Ownership) o;
        return Objects.equal(adjHolding, ownership.adjHolding) &&
                Objects.equal(adjMv, ownership.adjMv) &&
                Objects.equal(entityProperName, ownership.entityProperName) &&
                Objects.equal(reportDate, ownership.reportDate) &&
                Objects.equal(reportedHolding, ownership.reportedHolding);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(adjHolding, adjMv, entityProperName, reportDate, reportedHolding);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("adjHolding", adjHolding)
                .add("adjMv", adjMv)
                .add("entityProperName", entityProperName)
                .add("reportDate", reportDate)
                .add("reportedHolding", reportedHolding)
                .toString();
    }

}
