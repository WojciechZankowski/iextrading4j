package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXNextDayExDateTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String recordId = fixture.create(String.class);
        final LocalDateTime dailyListTimestamp = fixture.create(LocalDateTime.class);
        final LocalDate exDate = fixture.create(LocalDate.class);
        final String symbolInINETSymbology = fixture.create(String.class);
        final String symbolInCQSSymbology = fixture.create(String.class);
        final String symbolInCMSSymbology = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final DividendTypeId dividendTypeId = fixture.create(DividendTypeId.class);
        final String amountDescription = fixture.create(String.class);
        final PaymentFrequency paymentFrequency = fixture.create(PaymentFrequency.class);
        final BigDecimal stockAdjustmentFactor = fixture.create(BigDecimal.class);
        final BigDecimal stockAmount = fixture.create(BigDecimal.class);
        final BigDecimal cashAmount = fixture.create(BigDecimal.class);
        final BigDecimal postSplitShares = fixture.create(BigDecimal.class);
        final BigDecimal preSplitShares = fixture.create(BigDecimal.class);
        final QualifiedDividendType qualifiedDividend = fixture.create(QualifiedDividendType.class);
        final BigDecimal exercisePriceAmount = fixture.create(BigDecimal.class);
        final BigDecimal electionorExpirationDate = fixture.create(BigDecimal.class);
        final BigDecimal grossAmount = fixture.create(BigDecimal.class);
        final BigDecimal netAmount = fixture.create(BigDecimal.class);
        final String basisNotes = fixture.create(String.class);
        final String notesForEachEntry = fixture.create(String.class);
        final LocalDateTime recordUpdateTime = fixture.create(LocalDateTime.class);

        final IEXNextDayExDate IEXNextDayExDate = new IEXNextDayExDate(recordId, dailyListTimestamp, exDate,
                symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology, securityName, companyName,
                dividendTypeId, amountDescription, paymentFrequency, stockAdjustmentFactor, stockAmount,
                cashAmount, postSplitShares, preSplitShares, qualifiedDividend, exercisePriceAmount,
                electionorExpirationDate, grossAmount, netAmount, basisNotes, notesForEachEntry, recordUpdateTime);

        assertThat(IEXNextDayExDate.getRecordId()).isEqualTo(recordId);
        assertThat(IEXNextDayExDate.getDailyListTimestamp()).isEqualTo(dailyListTimestamp);
        assertThat(IEXNextDayExDate.getExDate()).isEqualTo(exDate);
        assertThat(IEXNextDayExDate.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(IEXNextDayExDate.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(IEXNextDayExDate.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(IEXNextDayExDate.getSecurityName()).isEqualTo(securityName);
        assertThat(IEXNextDayExDate.getCompanyName()).isEqualTo(companyName);
        assertThat(IEXNextDayExDate.getDividendTypeId()).isEqualTo(dividendTypeId);
        assertThat(IEXNextDayExDate.getAmountDescription()).isEqualTo(amountDescription);
        assertThat(IEXNextDayExDate.getPaymentFrequency()).isEqualTo(paymentFrequency);
        assertThat(IEXNextDayExDate.getStockAdjustmentFactor()).isEqualTo(stockAdjustmentFactor);
        assertThat(IEXNextDayExDate.getStockAmount()).isEqualTo(stockAmount);
        assertThat(IEXNextDayExDate.getCashAmount()).isEqualTo(cashAmount);
        assertThat(IEXNextDayExDate.getPostSplitShares()).isEqualTo(postSplitShares);
        assertThat(IEXNextDayExDate.getPreSplitShares()).isEqualTo(preSplitShares);
        assertThat(IEXNextDayExDate.getQualifiedDividend()).isEqualTo(qualifiedDividend);
        assertThat(IEXNextDayExDate.getExercisePriceAmount()).isEqualTo(exercisePriceAmount);
        assertThat(IEXNextDayExDate.getElectionorExpirationDate()).isEqualTo(electionorExpirationDate);
        assertThat(IEXNextDayExDate.getGrossAmount()).isEqualTo(grossAmount);
        assertThat(IEXNextDayExDate.getNetAmount()).isEqualTo(netAmount);
        assertThat(IEXNextDayExDate.getBasisNotes()).isEqualTo(basisNotes);
        assertThat(IEXNextDayExDate.getNotesForEachEntry()).isEqualTo(notesForEachEntry);
        assertThat(IEXNextDayExDate.getRecordUpdateTime()).isEqualTo(recordUpdateTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXNextDayExDate.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IEXNextDayExDate.class))
                .verify();
    }

}
