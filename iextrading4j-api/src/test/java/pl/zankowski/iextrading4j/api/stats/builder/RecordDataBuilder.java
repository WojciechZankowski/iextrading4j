package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.Record;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class RecordDataBuilder {

    private double recordValue = 324d;
    private LocalDate recordDate = LocalDate.now();
    private double previousDayValue = 321d;
    private double avg30Value = 320d;

    public static Record defaultRecord() {
        return aRecord().build();
    }

    public static RecordDataBuilder aRecord() {
        return new RecordDataBuilder();
    }

    public RecordDataBuilder withRecordValue(double recordValue) {
        this.recordValue = recordValue;
        return this;
    }

    public RecordDataBuilder withRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
        return this;
    }

    public RecordDataBuilder withPreviousDayValue(double previousDayValue) {
        this.previousDayValue = previousDayValue;
        return this;
    }

    public RecordDataBuilder withAvg30Value(double avg30Value) {
        this.avg30Value = avg30Value;
        return this;
    }

    public Record build() {
        return new Record(recordValue, recordDate, previousDayValue, avg30Value);
    }

}