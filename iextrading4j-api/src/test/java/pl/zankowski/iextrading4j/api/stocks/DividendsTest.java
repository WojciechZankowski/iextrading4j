package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DividendsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate exDate = fixture.create(LocalDate.class);
        final LocalDate paymentDate = fixture.create(LocalDate.class);
        final LocalDate recordDate = fixture.create(LocalDate.class);
        final LocalDate declaredDate = fixture.create(LocalDate.class);
        final BigDecimal amount = fixture.create(BigDecimal.class);
        final DividendType dividendType = fixture.create(DividendType.class);
        final DividendQualification qualification = fixture.create(DividendQualification.class);

        final Dividends dividends = new Dividends(exDate, paymentDate, recordDate, declaredDate, amount,
                dividendType, qualification);

        assertThat(dividends.getExDate()).isEqualTo(exDate);
        assertThat(dividends.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(dividends.getRecordDate()).isEqualTo(recordDate);
        assertThat(dividends.getDeclaredDate()).isEqualTo(declaredDate);
        assertThat(dividends.getAmount()).isEqualTo(amount);
        assertThat(dividends.getType()).isEqualTo(dividendType);
        assertThat(dividends.getQualified()).isEqualTo(qualification);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Dividends.class)
                .usingGetClass()
                .verify();
    }

}
