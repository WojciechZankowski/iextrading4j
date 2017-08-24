package pl.zankowski.iextrading4j.api.stats;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.stats.builder.RecordDataBuilder.defaultRecord;

/**
 * @author Wojciech Zankowski
 */
public class RecordTest {

    @Test
    public void shouldSuccessfullyCreateRecord() {
        final double recordValue = 324d;
        final LocalDate recordDate = LocalDate.now();
        final double previousDayValue = 321d;
        final double avg30Value = 320d;

        Record record = new Record(recordValue, recordDate, previousDayValue, avg30Value);
        assertRecord(record, recordValue, recordDate, previousDayValue, avg30Value);
    }

    @Test
    public void shouldSuccessfullyEqualTwoRecord() {
        Record record_1 = defaultRecord();
        Record record_2 = defaultRecord();

        assertThat(record_1.equals(record_2)).isTrue();
        assertThat(record_1.hashCode()).isEqualTo(record_2.hashCode());
    }

    private void assertRecord(Record record, double recordValue, LocalDate recordDate, double previousDayValue,
                              double avg30Value) {
        assertThat(record.getRecordValue()).isEqualTo(recordValue);
        assertThat(record.getRecordDate()).isEqualTo(recordDate);
        assertThat(record.getPreviousDayValue()).isEqualTo(previousDayValue);
        assertThat(record.getAvg30Value()).isEqualTo(avg30Value);
    }

}
