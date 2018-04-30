package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal actualEPS = fixture.create(BigDecimal.class);
        final BigDecimal consensusEPS = fixture.create(BigDecimal.class);
        final BigDecimal estimatedEPS = fixture.create(BigDecimal.class);
        final String announceTime = fixture.create(String.class);
        final BigDecimal numberOfEstimates = fixture.create(BigDecimal.class);
        final BigDecimal EPSSurpriseDollar = fixture.create(BigDecimal.class);
        final LocalDate EPSReportDate = fixture.create(LocalDate.class);
        final String fiscalPeriod = fixture.create(String.class);
        final LocalDate fiscalEndDate = fixture.create(LocalDate.class);
        final BigDecimal yearAgo = fixture.create(BigDecimal.class);
        final BigDecimal yearAgoChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal estimatedChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal symbolId = fixture.create(BigDecimal.class);

        final Earning earning = new Earning(actualEPS, consensusEPS, estimatedEPS, announceTime,
                numberOfEstimates, EPSSurpriseDollar, EPSReportDate, fiscalPeriod, fiscalEndDate,
                yearAgo, yearAgoChangePercent, estimatedChangePercent, symbolId);

        assertThat(earning.getActualEPS()).isEqualTo(actualEPS);
        assertThat(earning.getConsensusEPS()).isEqualTo(consensusEPS);
        assertThat(earning.getEstimatedEPS()).isEqualTo(estimatedEPS);
        assertThat(earning.getAnnounceTime()).isEqualTo(announceTime);
        assertThat(earning.getNumberOfEstimates()).isEqualTo(numberOfEstimates);
        assertThat(earning.getEPSSurpriseDollar()).isEqualTo(EPSSurpriseDollar);
        assertThat(earning.getEPSReportDate()).isEqualTo(EPSReportDate);
        assertThat(earning.getFiscalPeriod()).isEqualTo(fiscalPeriod);
        assertThat(earning.getFiscalEndDate()).isEqualTo(fiscalEndDate);
        assertThat(earning.getYearAgo()).isEqualByComparingTo(yearAgo);
        assertThat(earning.getYearAgoChangePercent()).isEqualByComparingTo(yearAgoChangePercent);
        assertThat(earning.getEstimatedChangePercent()).isEqualByComparingTo(estimatedChangePercent);
        assertThat(earning.getSymbolId()).isEqualByComparingTo(symbolId);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Earning.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Earning.class))
                .verify();
    }

}
