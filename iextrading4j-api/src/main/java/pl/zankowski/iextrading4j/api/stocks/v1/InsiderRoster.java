package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class InsiderRoster implements Serializable {

    private static final long serialVersionUID = 1274323028982169499L;

    private final String entityName;
    private final BigDecimal position;
    private final Long reportDate;

    @JsonCreator
    public InsiderRoster(
            @JsonProperty("entityName") final String entityName,
            @JsonProperty("position") final BigDecimal position,
            @JsonProperty("reportDate") final Long reportDate) {
        this.entityName = entityName;
        this.position = position;
        this.reportDate = reportDate;
    }

    public String getEntityName() {
        return entityName;
    }

    public BigDecimal getPosition() {
        return position;
    }

    public Long getReportDate() {
        return reportDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InsiderRoster that = (InsiderRoster) o;
        return Objects.equal(entityName, that.entityName) &&
                Objects.equal(position, that.position) &&
                Objects.equal(reportDate, that.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entityName, position, reportDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityName", entityName)
                .add("position", position)
                .add("reportDate", reportDate)
                .toString();
    }

}
