package pl.zankowski.iextrading.api.stats;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class Record {

    private BigDecimal recordValue;
    private LocalDate recordDate;
    private BigDecimal previousDayValue;
    private BigDecimal avg30Value;

    public Record() {
    }

    public Record(BigDecimal recordValue, LocalDate recordDate, BigDecimal previousDayValue, BigDecimal avg30Value) {
        this.recordValue = recordValue;
        this.recordDate = recordDate;
        this.previousDayValue = previousDayValue;
        this.avg30Value = avg30Value;
    }

    public BigDecimal getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(BigDecimal recordValue) {
        this.recordValue = recordValue;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public BigDecimal getPreviousDayValue() {
        return previousDayValue;
    }

    public void setPreviousDayValue(BigDecimal previousDayValue) {
        this.previousDayValue = previousDayValue;
    }

    public BigDecimal getAvg30Value() {
        return avg30Value;
    }

    public void setAvg30Value(BigDecimal avg30Value) {
        this.avg30Value = avg30Value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (recordValue != null ? !recordValue.equals(record.recordValue) : record.recordValue != null) return false;
        if (recordDate != null ? !recordDate.equals(record.recordDate) : record.recordDate != null) return false;
        if (previousDayValue != null ? !previousDayValue.equals(record.previousDayValue) : record.previousDayValue != null)
            return false;
        return avg30Value != null ? avg30Value.equals(record.avg30Value) : record.avg30Value == null;
    }

    @Override
    public int hashCode() {
        int result = recordValue != null ? recordValue.hashCode() : 0;
        result = 31 * result + (recordDate != null ? recordDate.hashCode() : 0);
        result = 31 * result + (previousDayValue != null ? previousDayValue.hashCode() : 0);
        result = 31 * result + (avg30Value != null ? avg30Value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordValue=" + recordValue +
                ", recordDate=" + recordDate +
                ", previousDayValue=" + previousDayValue +
                ", avg30Value=" + avg30Value +
                '}';
    }

}
