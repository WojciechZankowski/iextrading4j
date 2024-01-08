package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class EstimateTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal consensusEPS = fixture.create(BigDecimal.class);
        final String announceTime = fixture.create(String.class);
        final BigDecimal numberOfEstimates = fixture.create(BigDecimal.class);
        final String fiscalPeriod = fixture.create(String.class);
        final LocalDate fiscalEndDate = fixture.create(LocalDate.class);
        final LocalDate reportDate = fixture.create(LocalDate.class);
        final String currency = fixture.create(String.class);

        final Estimate estimate = new Estimate(consensusEPS, announceTime, numberOfEstimates,
                fiscalPeriod, fiscalEndDate, reportDate, currency);

        assertThat(estimate.getConsensusEPS()).isEqualTo(consensusEPS);
        assertThat(estimate.getAnnounceTime()).isEqualTo(announceTime);
        assertThat(estimate.getNumberOfEstimates()).isEqualTo(numberOfEstimates);
        assertThat(estimate.getFiscalPeriod()).isEqualTo(fiscalPeriod);
        assertThat(estimate.getFiscalEndDate()).isEqualTo(fiscalEndDate);
        assertThat(estimate.getReportDate()).isEqualTo(reportDate);
        assertThat(estimate.getCurrency()).isEqualTo(currency);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Estimate.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Estimate.class))
                .verify();
    }

}
