package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"recordValue", "recordDate", "previousDayValue", "avg30Value"})
public class Record implements Serializable {

    private final BigDecimal recordValue;
    private final LocalDate recordDate;
    private final BigDecimal previousDayValue;
    private final BigDecimal avg30Value;

    @JsonCreator
    public Record(
            @JsonProperty("recordValue") final BigDecimal recordValue,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("previousDayValue") final BigDecimal previousDayValue,
            @JsonProperty("avg30Value") final BigDecimal avg30Value) {
        this.recordValue = recordValue;
        this.recordDate = recordDate;
        this.previousDayValue = previousDayValue;
        this.avg30Value = avg30Value;
    }

    public BigDecimal getRecordValue() {
        return recordValue;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public BigDecimal getPreviousDayValue() {
        return previousDayValue;
    }

    public BigDecimal getAvg30Value() {
        return avg30Value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equal(recordValue, record.recordValue) &&
                Objects.equal(recordDate, record.recordDate) &&
                Objects.equal(previousDayValue, record.previousDayValue) &&
                Objects.equal(avg30Value, record.avg30Value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(recordValue, recordDate, previousDayValue, avg30Value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("recordValue", recordValue)
                .add("recordDate", recordDate)
                .add("previousDayValue", previousDayValue)
                .add("avg30Value", avg30Value)
                .toString();
    }
}
