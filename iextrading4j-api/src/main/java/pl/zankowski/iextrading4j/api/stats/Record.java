package pl.zankowski.iextrading4j.api.stats;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class Record {

    private double recordValue;
    private LocalDate recordDate;
    private double previousDayValue;
    private double avg30Value;

    public Record() {
    }

    public Record(double recordValue, LocalDate recordDate, double previousDayValue, double avg30Value) {
        this.recordValue = recordValue;
        this.recordDate = recordDate;
        this.previousDayValue = previousDayValue;
        this.avg30Value = avg30Value;
    }

    public double getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(double recordValue) {
        this.recordValue = recordValue;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public double getPreviousDayValue() {
        return previousDayValue;
    }

    public void setPreviousDayValue(double previousDayValue) {
        this.previousDayValue = previousDayValue;
    }

    public double getAvg30Value() {
        return avg30Value;
    }

    public void setAvg30Value(double avg30Value) {
        this.avg30Value = avg30Value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (Double.compare(record.recordValue, recordValue) != 0) return false;
        if (Double.compare(record.previousDayValue, previousDayValue) != 0) return false;
        if (Double.compare(record.avg30Value, avg30Value) != 0) return false;
        return recordDate != null ? recordDate.equals(record.recordDate) : record.recordDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(recordValue);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (recordDate != null ? recordDate.hashCode() : 0);
        temp = Double.doubleToLongBits(previousDayValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(avg30Value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
