package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

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
        final String flag = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String frequency = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);

        final Dividends dividends = new Dividends(exDate, paymentDate, recordDate, declaredDate, amount,
                flag, currency, description, frequency, date);

        assertThat(dividends.getExDate()).isEqualTo(exDate);
        assertThat(dividends.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(dividends.getRecordDate()).isEqualTo(recordDate);
        assertThat(dividends.getDeclaredDate()).isEqualTo(declaredDate);
        assertThat(dividends.getAmount()).isEqualTo(amount);
        assertThat(dividends.getFlag()).isEqualTo(flag);
        assertThat(dividends.getCurrency()).isEqualTo(currency);
        assertThat(dividends.getDescription()).isEqualTo(description);
        assertThat(dividends.getFrequency()).isEqualTo(frequency);
        assertThat(dividends.getDate()).isEqualTo(date);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Dividends.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Dividends.class))
                .verify();
    }

}
