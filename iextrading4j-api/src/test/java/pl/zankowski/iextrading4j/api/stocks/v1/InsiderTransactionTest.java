package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InsiderTransactionTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Long effectiveDate = fixture.create(Long.class);
        final String fullName = fixture.create(String.class);
        final String reportedTitle = fixture.create(String.class);
        final BigDecimal tranPrice = fixture.create(BigDecimal.class);
        final BigDecimal tranShares = fixture.create(BigDecimal.class);
        final BigDecimal tranValue = fixture.create(BigDecimal.class);

        final InsiderTransaction insiderTransaction = new InsiderTransaction(effectiveDate, fullName,
                reportedTitle, tranPrice, tranShares, tranValue);

        assertThat(insiderTransaction.getEffectiveDate()).isEqualTo(effectiveDate);
        assertThat(insiderTransaction.getFullName()).isEqualTo(fullName);
        assertThat(insiderTransaction.getReportedTitle()).isEqualTo(reportedTitle);
        assertThat(insiderTransaction.getTranPrice()).isEqualTo(tranPrice);
        assertThat(insiderTransaction.getTranShares()).isEqualTo(tranShares);
        assertThat(insiderTransaction.getTranValue()).isEqualTo(tranValue);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(InsiderTransaction.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(InsiderTransaction.class))
                .verify();
    }

}
