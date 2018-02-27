package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXDividendsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String recordId = fixture.create(String.class);
        final LocalDateTime dailyListTimestamp = fixture.create(LocalDateTime.class);
        final EventType eventType = fixture.create(EventType.class);
        final String symbolInINETSymbology = fixture.create(String.class);
        final String symbolInCQSSymbology = fixture.create(String.class);
        final String symbolInCMSSymbology = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final LocalDate declarationDate = fixture.create(LocalDate.class);
        final String amountDescription = fixture.create(String.class);
        final PaymentFrequency paymentFrequency = fixture.create(PaymentFrequency.class);
        final LocalDate exDate = fixture.create(LocalDate.class);
        final LocalDate recordDate = fixture.create(LocalDate.class);
        final LocalDate paymentDate = fixture.create(LocalDate.class);
        final DividendTypeId dividendTypeId = fixture.create(DividendTypeId.class);
        final BigDecimal stockAdjustmentFactor = fixture.create(BigDecimal.class);
        final BigDecimal stockAmount = fixture.create(BigDecimal.class);
        final BigDecimal cashAmount = fixture.create(BigDecimal.class);
        final BigDecimal postSplitShares = fixture.create(BigDecimal.class);
        final BigDecimal preSplitShares = fixture.create(BigDecimal.class);
        final QualifiedDividendType qualifiedDividend = fixture.create(QualifiedDividendType.class);
        final BigDecimal exercisePriceAmount = fixture.create(BigDecimal.class);
        final LocalDate electionorExpirationDate = fixture.create(LocalDate.class);
        final BigDecimal grossAmount = fixture.create(BigDecimal.class);
        final BigDecimal netAmount = fixture.create(BigDecimal.class);
        final String basisNotes = fixture.create(String.class);
        final String notesForEachEntry = fixture.create(String.class);
        final LocalDateTime recordUpdateTime = fixture.create(LocalDateTime.class);

        final IEXDividends dividends = new IEXDividends(recordId, dailyListTimestamp, eventType, symbolInINETSymbology,
                symbolInCQSSymbology, symbolInCMSSymbology, securityName, companyName, declarationDate,
                amountDescription, paymentFrequency, exDate, recordDate, paymentDate, dividendTypeId,
                stockAdjustmentFactor, stockAmount, cashAmount, postSplitShares, preSplitShares, qualifiedDividend,
                exercisePriceAmount, electionorExpirationDate, grossAmount, netAmount, basisNotes, notesForEachEntry,
                recordUpdateTime);

        assertThat(dividends.getRecordId()).isEqualTo(recordId);
        assertThat(dividends.getDailyListTimestamp()).isEqualTo(dailyListTimestamp);
        assertThat(dividends.getEventType()).isEqualTo(eventType);
        assertThat(dividends.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(dividends.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(dividends.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(dividends.getSecurityName()).isEqualTo(securityName);
        assertThat(dividends.getCompanyName()).isEqualTo(companyName);
        assertThat(dividends.getDeclarationDate()).isEqualTo(declarationDate);
        assertThat(dividends.getAmountDescription()).isEqualTo(amountDescription);
        assertThat(dividends.getPaymentFrequency()).isEqualTo(paymentFrequency);
        assertThat(dividends.getExDate()).isEqualTo(exDate);
        assertThat(dividends.getRecordDate()).isEqualTo(recordDate);
        assertThat(dividends.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(dividends.getDividendTypeId()).isEqualTo(dividendTypeId);
        assertThat(dividends.getStockAdjustmentFactor()).isEqualTo(stockAdjustmentFactor);
        assertThat(dividends.getStockAmount()).isEqualTo(stockAmount);
        assertThat(dividends.getCashAmount()).isEqualTo(cashAmount);
        assertThat(dividends.getPostSplitShares()).isEqualTo(postSplitShares);
        assertThat(dividends.getPreSplitShares()).isEqualTo(preSplitShares);
        assertThat(dividends.getQualifiedDividend()).isEqualTo(qualifiedDividend);
        assertThat(dividends.getExercisePriceAmount()).isEqualTo(exercisePriceAmount);
        assertThat(dividends.getElectionorExpirationDate()).isEqualTo(electionorExpirationDate);
        assertThat(dividends.getGrossAmount()).isEqualTo(grossAmount);
        assertThat(dividends.getNetAmount()).isEqualTo(netAmount);
        assertThat(dividends.getBasisNotes()).isEqualTo(basisNotes);
        assertThat(dividends.getNotesForEachEntry()).isEqualTo(notesForEachEntry);
        assertThat(dividends.getRecordUpdateTime()).isEqualTo(recordUpdateTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXDividends.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IEXDividends.class))
                .verify();
    }

}
