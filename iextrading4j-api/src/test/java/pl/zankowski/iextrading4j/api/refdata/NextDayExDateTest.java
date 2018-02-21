package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class NextDayExDateTest {

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
        final String dividendTypeId = fixture.create(String.class);
        final String amountDescription = fixture.create(String.class);
        final String paymentFrequency = fixture.create(String.class);
        final BigDecimal stockAdjustmentFactor = fixture.create(BigDecimal.class);
        final BigDecimal stockAmount = fixture.create(BigDecimal.class);
        final BigDecimal cashAmount = fixture.create(BigDecimal.class);
        final BigDecimal postSplitShares = fixture.create(BigDecimal.class);
        final BigDecimal preSplitShares = fixture.create(BigDecimal.class);
        final String qualifiedDividend = fixture.create(String.class);
        final BigDecimal exercisePriceAmount = fixture.create(BigDecimal.class);
        final BigDecimal electionorExpirationDate = fixture.create(BigDecimal.class);
        final BigDecimal grossAmount = fixture.create(BigDecimal.class);
        final BigDecimal netAmount = fixture.create(BigDecimal.class);
        final String basisNotes = fixture.create(String.class);
        final String notesForEachEntry = fixture.create(String.class);
        final LocalDateTime recordUpdateTime = fixture.create(LocalDateTime.class);

        final NextDayExDate nextDayExDate = new NextDayExDate(recordId, dailyListTimestamp, exDate,
                symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology, securityName, companyName,
                dividendTypeId, amountDescription, paymentFrequency, stockAdjustmentFactor, stockAmount,
                cashAmount, postSplitShares, preSplitShares, qualifiedDividend, exercisePriceAmount,
                electionorExpirationDate, grossAmount, netAmount, basisNotes, notesForEachEntry, recordUpdateTime);

        assertThat(nextDayExDate.getRecordId()).isEqualTo(recordId);
        assertThat(nextDayExDate.getDailyListTimestamp()).isEqualTo(dailyListTimestamp);
        assertThat(nextDayExDate.getExDate()).isEqualTo(exDate);
        assertThat(nextDayExDate.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(nextDayExDate.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(nextDayExDate.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(nextDayExDate.getSecurityName()).isEqualTo(securityName);
        assertThat(nextDayExDate.getCompanyName()).isEqualTo(companyName);
        assertThat(nextDayExDate.getDividendTypeId()).isEqualTo(dividendTypeId);
        assertThat(nextDayExDate.getAmountDescription()).isEqualTo(amountDescription);
        assertThat(nextDayExDate.getPaymentFrequency()).isEqualTo(paymentFrequency);
        assertThat(nextDayExDate.getStockAdjustmentFactor()).isEqualTo(stockAdjustmentFactor);
        assertThat(nextDayExDate.getStockAmount()).isEqualTo(stockAmount);
        assertThat(nextDayExDate.getCashAmount()).isEqualTo(cashAmount);
        assertThat(nextDayExDate.getPostSplitShares()).isEqualTo(postSplitShares);
        assertThat(nextDayExDate.getPreSplitShares()).isEqualTo(preSplitShares);
        assertThat(nextDayExDate.getQualifiedDividend()).isEqualTo(qualifiedDividend);
        assertThat(nextDayExDate.getExercisePriceAmount()).isEqualTo(exercisePriceAmount);
        assertThat(nextDayExDate.getElectionorExpirationDate()).isEqualTo(electionorExpirationDate);
        assertThat(nextDayExDate.getGrossAmount()).isEqualTo(grossAmount);
        assertThat(nextDayExDate.getNetAmount()).isEqualTo(netAmount);
        assertThat(nextDayExDate.getBasisNotes()).isEqualTo(basisNotes);
        assertThat(nextDayExDate.getNotesForEachEntry()).isEqualTo(notesForEachEntry);
        assertThat(nextDayExDate.getRecordUpdateTime()).isEqualTo(recordUpdateTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(NextDayExDate.class)
                .usingGetClass()
                .verify();
    }

}
