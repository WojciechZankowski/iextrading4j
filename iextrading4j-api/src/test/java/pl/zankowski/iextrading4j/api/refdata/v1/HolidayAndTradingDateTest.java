package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HolidayAndTradingDateTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final LocalDate date = fixture.create(LocalDate.class);
        final LocalDate settlementDate = fixture.create(LocalDate.class);

        final HolidayAndTradingDate holidayAndTradingDate = new HolidayAndTradingDate(date, settlementDate);

        assertThat(holidayAndTradingDate.getDate()).isEqualTo(date);
        assertThat(holidayAndTradingDate.getSettlementDate()).isEqualTo(settlementDate);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(HolidayAndTradingDate.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HolidayAndTradingDate.class))
                .verify();
    }

}
