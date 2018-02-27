package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal recordValue = fixture.create(BigDecimal.class);
        final LocalDate recordDate = fixture.create(LocalDate.class);
        final BigDecimal previousDayValue = fixture.create(BigDecimal.class);
        final BigDecimal avg30Value = fixture.create(BigDecimal.class);

        final Record record = new Record(recordValue, recordDate, previousDayValue,
                avg30Value);

        assertThat(record.getRecordValue()).isEqualTo(recordValue);
        assertThat(record.getRecordDate()).isEqualTo(recordDate);
        assertThat(record.getPreviousDayValue()).isEqualTo(previousDayValue);
        assertThat(record.getAvg30Value()).isEqualTo(avg30Value);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Record.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Record.class))
                .verify();
    }

}
