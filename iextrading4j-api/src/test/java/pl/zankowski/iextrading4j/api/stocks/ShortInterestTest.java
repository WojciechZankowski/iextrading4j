package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.Flag;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortInterestTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDate settlementDate = fixture.create(LocalDate.class);
        final String symbolInINETSymbology = fixture.create(String.class);
        final String symbolInCQSSymbology = fixture.create(String.class);
        final String symbolInCMSSymbology = fixture.create(String.class);
        final String cusip = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final BigDecimal currentShortInterest = fixture.create(BigDecimal.class);
        final BigDecimal previousShortInterest = fixture.create(BigDecimal.class);
        final BigDecimal percentChange = fixture.create(BigDecimal.class);
        final BigDecimal averageDailyVolume = fixture.create(BigDecimal.class);
        final BigDecimal daystoCover = fixture.create(BigDecimal.class);
        final Flag stockAdjustmentFlag = fixture.create(Flag.class);
        final Flag newIssueFlag = fixture.create(Flag.class);
        final Flag revisionFlag = fixture.create(Flag.class);

        final ShortInterest shortInterest = new ShortInterest(settlementDate, symbolInINETSymbology,
                symbolInCQSSymbology, symbolInCMSSymbology, cusip, securityName, companyName, currentShortInterest,
                previousShortInterest, percentChange, averageDailyVolume, daystoCover, stockAdjustmentFlag,
                newIssueFlag, revisionFlag);

        assertThat(shortInterest.getSettlementDate()).isEqualTo(settlementDate);
        assertThat(shortInterest.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(shortInterest.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(shortInterest.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(shortInterest.getCusip()).isEqualTo(cusip);
        assertThat(shortInterest.getSecurityName()).isEqualTo(securityName);
        assertThat(shortInterest.getCompanyName()).isEqualTo(companyName);
        assertThat(shortInterest.getCurrentShortInterest()).isEqualTo(currentShortInterest);
        assertThat(shortInterest.getPreviousShortInterest()).isEqualTo(previousShortInterest);
        assertThat(shortInterest.getPercentChange()).isEqualTo(percentChange);
        assertThat(shortInterest.getAverageDailyVolume()).isEqualTo(averageDailyVolume);
        assertThat(shortInterest.getDaystoCover()).isEqualTo(daystoCover);
        assertThat(shortInterest.getStockAdjustmentFlag()).isEqualTo(stockAdjustmentFlag);
        assertThat(shortInterest.getNewIssueFlag()).isEqualTo(newIssueFlag);
        assertThat(shortInterest.getRevisionFlag()).isEqualTo(revisionFlag);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ShortInterest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(ShortInterest.class))
                .verify();
    }

}
