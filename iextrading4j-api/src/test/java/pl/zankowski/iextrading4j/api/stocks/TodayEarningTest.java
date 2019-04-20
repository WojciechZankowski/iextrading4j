package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TodayEarningTest {

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
        final String symbol = fixture.create(String.class);
        final Quote quote = fixture.create(Quote.class);
        final String headline = fixture.create(String.class);
        final LocalDate reportDate = fixture.create(LocalDate.class);

        final TodayEarning earning = new TodayEarning(actualEPS, consensusEPS, estimatedEPS, announceTime,
                numberOfEstimates, EPSSurpriseDollar, EPSReportDate, fiscalPeriod, fiscalEndDate,
                yearAgo, yearAgoChangePercent, symbol, quote, headline, reportDate);

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
        assertThat(earning.getSymbol()).isEqualTo(symbol);
        assertThat(earning.getQuote()).isEqualTo(quote);
        assertThat(earning.getHeadline()).isEqualTo(headline);
        assertThat(earning.getReportDate()).isEqualTo(reportDate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(TodayEarning.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TodayEarning.class))
                .verify();
    }

}
