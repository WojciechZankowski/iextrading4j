package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InsiderSummaryTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String fullName = fixture.create(String.class);
        final BigDecimal netTransacted = fixture.create(BigDecimal.class);
        final String reportedTitle = fixture.create(String.class);
        final BigDecimal totalBought = fixture.create(BigDecimal.class);
        final BigDecimal totalSold = fixture.create(BigDecimal.class);

        final InsiderSummary insiderSummary = new InsiderSummary(fullName, netTransacted,
                reportedTitle, totalBought, totalSold);

        assertThat(insiderSummary.getFullName()).isEqualTo(fullName);
        assertThat(insiderSummary.getNetTransacted()).isEqualTo(netTransacted);
        assertThat(insiderSummary.getReportedTitle()).isEqualTo(reportedTitle);
        assertThat(insiderSummary.getTotalBought()).isEqualTo(totalBought);
        assertThat(insiderSummary.getTotalSold()).isEqualTo(totalSold);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(InsiderSummary.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(InsiderSummary.class))
                .verify();
    }

}
