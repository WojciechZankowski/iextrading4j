package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EstimateTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal consensusEPS = fixture.create(BigDecimal.class);
        final String announceTime = fixture.create(String.class);
        final BigDecimal numberOfEstimates = fixture.create(BigDecimal.class);
        final String fiscalPeriod = fixture.create(String.class);
        final LocalDate fiscalEndDate = fixture.create(LocalDate.class);
        final LocalDate reportDate = fixture.create(LocalDate.class);

        final Estimate estimate = new Estimate(consensusEPS, announceTime, numberOfEstimates,
                fiscalPeriod, fiscalEndDate, reportDate);

        assertThat(estimate.getConsensusEPS()).isEqualTo(consensusEPS);
        assertThat(estimate.getAnnounceTime()).isEqualTo(announceTime);
        assertThat(estimate.getNumberOfEstimates()).isEqualTo(numberOfEstimates);
        assertThat(estimate.getFiscalPeriod()).isEqualTo(fiscalPeriod);
        assertThat(estimate.getFiscalEndDate()).isEqualTo(fiscalEndDate);
        assertThat(estimate.getReportDate()).isEqualTo(reportDate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Estimate.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Estimate.class))
                .verify();
    }

}
