package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Ownership implements Serializable {

    private static final long serialVersionUID = -90284369606919937L;

    private final String symbol;
    private final String id;
    private final BigDecimal adjHolding;
    private final BigDecimal adjMv;
    private final String entityProperName;
    protected final Long reportDate;
    private final LocalDate filingDate;
    private final BigDecimal reportedHolding;
    private final Long updated;

    @JsonCreator
    public Ownership(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("adjHolding") final BigDecimal adjHolding,
            @JsonProperty("adjMv") final BigDecimal adjMv,
            @JsonProperty("entityProperName") final String entityProperName,
            @JsonProperty("reportDate") final Long reportDate,
            @JsonProperty("filingDate") final LocalDate filingDate,
            @JsonProperty("reportedHolding") final BigDecimal reportedHolding,
            @JsonProperty("updated") final Long updated) {
        this.symbol = symbol;
        this.id = id;
        this.adjHolding = adjHolding;
        this.adjMv = adjMv;
        this.entityProperName = entityProperName;
        this.reportDate = reportDate;
        this.filingDate = filingDate;
        this.reportedHolding = reportedHolding;
        this.updated = updated;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getId() {
        return id;
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

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public BigDecimal getReportedHolding() {
        return reportedHolding;
    }

    public Long getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ownership ownership = (Ownership) o;
        return Objects.equals(symbol, ownership.symbol) &&
                Objects.equals(id, ownership.id) &&
                Objects.equals(adjHolding, ownership.adjHolding) &&
                Objects.equals(adjMv, ownership.adjMv) &&
                Objects.equals(entityProperName, ownership.entityProperName) &&
                Objects.equals(reportDate, ownership.reportDate) &&
                Objects.equals(filingDate, ownership.filingDate) &&
                Objects.equals(reportedHolding, ownership.reportedHolding) &&
                Objects.equals(updated, ownership.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, id, adjHolding, adjMv, entityProperName, reportDate, filingDate, reportedHolding, updated);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ownership.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("id='" + id + "'")
                .add("adjHolding=" + adjHolding)
                .add("adjMv=" + adjMv)
                .add("entityProperName='" + entityProperName + "'")
                .add("reportDate=" + reportDate)
                .add("filingDate=" + filingDate)
                .add("reportedHolding=" + reportedHolding)
                .add("updated=" + updated)
                .toString();
    }
}
