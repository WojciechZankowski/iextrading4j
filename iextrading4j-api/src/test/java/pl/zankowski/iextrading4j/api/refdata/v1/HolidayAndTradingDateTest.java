package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class HolidayAndTradingDateTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final LocalDate settlementDate = fixture.create(LocalDate.class);

        final HolidayAndTradingDate holidayAndTradingDate = new HolidayAndTradingDate(date, settlementDate);

        assertThat(holidayAndTradingDate.getDate()).isEqualTo(date);
        assertThat(holidayAndTradingDate.getSettlementDate()).isEqualTo(settlementDate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HolidayAndTradingDate.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HolidayAndTradingDate.class))
                .verify();
    }

}
