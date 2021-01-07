package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FundOwnership extends Ownership {

    private static final long serialVersionUID = 3647818589558036777L;

    private final BigDecimal reportedMv;

    @JsonCreator
    public FundOwnership(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("adjHolding") final BigDecimal adjHolding,
            @JsonProperty("adjMv") final BigDecimal adjMv,
            @JsonProperty("entityProperName") final String entityProperName,
            @JsonProperty("report_date") final Long reportDate,
            @JsonProperty("filingDate") final LocalDate filingDate,
            @JsonProperty("reportedHolding") final BigDecimal reportedHolding,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("reportedMv") final BigDecimal reportedMv) {
        super(symbol, id, adjHolding, adjMv, entityProperName, reportDate, filingDate, reportedHolding, updated);
        this.reportedMv = reportedMv;
    }

    // TODO workaround, reported to IEX
    @JsonProperty("report_date")
    @Override
    public Long getReportDate() {
        return reportDate;
    }

    public BigDecimal getReportedMv() {
        return reportedMv;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FundOwnership)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final FundOwnership that = (FundOwnership) o;
        return Objects.equal(reportedMv, that.reportedMv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), reportedMv);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ownership", super.toString())
                .add("reportedMv", reportedMv)
                .toString();
    }

}
