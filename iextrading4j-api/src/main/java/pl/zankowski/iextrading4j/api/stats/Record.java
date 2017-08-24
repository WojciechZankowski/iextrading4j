package pl.zankowski.iextrading4j.api.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.api.util.DoubleUtil;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class Record {

    private final double recordValue;
    private final LocalDate recordDate;
    private final double previousDayValue;
    private final double avg30Value;

    @JsonCreator
    public Record(@JsonProperty("recordValue") double recordValue,
                  @JsonProperty("recordDate") LocalDate recordDate,
                  @JsonProperty("previousDayValue") double previousDayValue,
                  @JsonProperty("avg30Value") double avg30Value) {
        this.recordValue = recordValue;
        this.recordDate = recordDate;
        this.previousDayValue = previousDayValue;
        this.avg30Value = avg30Value;
    }

    public double getRecordValue() {
        return recordValue;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public double getPreviousDayValue() {
        return previousDayValue;
    }

    public double getAvg30Value() {
        return avg30Value;
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
                "recordValue=" + DoubleUtil.printDouble(recordValue) +
                ", recordDate=" + recordDate +
                ", previousDayValue=" + DoubleUtil.printDouble(previousDayValue) +
                ", avg30Value=" + DoubleUtil.printDouble(avg30Value) +
                '}';
    }

}
