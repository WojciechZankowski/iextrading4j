package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate exDate = fixture.create(LocalDate.class);
        final LocalDate declaredDate = fixture.create(LocalDate.class);
        final LocalDate recordDate = fixture.create(LocalDate.class);
        final LocalDate paymentDate = fixture.create(LocalDate.class);
        final BigDecimal ratio = fixture.create(BigDecimal.class);
        final BigDecimal toFactor = fixture.create(BigDecimal.class);
        final BigDecimal forFactor = fixture.create(BigDecimal.class);

        final Split split = new Split(exDate, declaredDate, recordDate, paymentDate,
                ratio, toFactor, forFactor);

        assertThat(split.getExDate()).isEqualTo(exDate);
        assertThat(split.getDeclaredDate()).isEqualTo(declaredDate);
        assertThat(split.getRecordDate()).isEqualTo(recordDate);
        assertThat(split.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(split.getRatio()).isEqualTo(ratio);
        assertThat(split.getToFactor()).isEqualTo(toFactor);
        assertThat(split.getForFactor()).isEqualTo(forFactor);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Split.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Split.class))
                .verify();
    }

}
