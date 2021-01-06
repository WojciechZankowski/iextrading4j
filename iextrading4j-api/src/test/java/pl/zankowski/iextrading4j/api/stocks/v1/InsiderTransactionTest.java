package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class InsiderTransactionTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String key = fixture.create(String.class);
        final String subkey = fixture.create(String.class);
        final Long updated = fixture.create(Long.class);
        final BigDecimal conversionOrExercisePrice = fixture.create(BigDecimal.class);
        final DirectIndirect directIndirect = fixture.create(DirectIndirect.class);
        final Long effectiveDate = fixture.create(Long.class);
        final LocalDate filingDate = fixture.create(LocalDate.class);
        final String fullName = fixture.create(String.class);
        final boolean is10b51 = fixture.create(Boolean.class);
        final BigDecimal postShares = fixture.create(BigDecimal.class);
        final String reportedTitle = fixture.create(String.class);
        final String transactionCode = fixture.create(String.class);
        final LocalDate transactionDate = fixture.create(LocalDate.class);
        final BigDecimal transactionPrice = fixture.create(BigDecimal.class);
        final BigDecimal transactionShares = fixture.create(BigDecimal.class);
        final BigDecimal transactionValue = fixture.create(BigDecimal.class);
        final BigDecimal tranPrice = fixture.create(BigDecimal.class);
        final BigDecimal tranShares = fixture.create(BigDecimal.class);
        final BigDecimal tranValue = fixture.create(BigDecimal.class);

        final InsiderTransaction insiderTransaction = new InsiderTransaction(symbol, id, key, subkey, updated,
                conversionOrExercisePrice, directIndirect, effectiveDate, filingDate, fullName, is10b51, postShares,
                reportedTitle, transactionCode, transactionDate, transactionPrice, transactionShares,
                transactionValue, tranPrice, tranShares, tranValue);

        assertThat(insiderTransaction.getSymbol()).isEqualTo(symbol);
        assertThat(insiderTransaction.getKey()).isEqualTo(key);
        assertThat(insiderTransaction.getSubkey()).isEqualTo(subkey);
        assertThat(insiderTransaction.getId()).isEqualTo(id);
        assertThat(insiderTransaction.getUpdated()).isEqualTo(updated);
        assertThat(insiderTransaction.getEffectiveDate()).isEqualTo(effectiveDate);
        assertThat(insiderTransaction.getFullName()).isEqualTo(fullName);
        assertThat(insiderTransaction.getReportedTitle()).isEqualTo(reportedTitle);
        assertThat(insiderTransaction.getTranPrice()).isEqualTo(tranPrice);
        assertThat(insiderTransaction.getTranShares()).isEqualTo(tranShares);
        assertThat(insiderTransaction.getTranValue()).isEqualTo(tranValue);
        assertThat(insiderTransaction.getDirectIndirect()).isEqualTo(directIndirect);
        assertThat(insiderTransaction.getTransactionCode()).isEqualTo(transactionCode);
        assertThat(insiderTransaction.getTransactionPrice()).isEqualTo(transactionPrice);
        assertThat(insiderTransaction.getTransactionShares()).isEqualTo(transactionShares);
        assertThat(insiderTransaction.getTransactionValue()).isEqualTo(transactionValue);
        assertThat(insiderTransaction.isIs10b51()).isEqualTo(is10b51);
        assertThat(insiderTransaction.getPostShares()).isEqualTo(postShares);
        assertThat(insiderTransaction.getFilingDate()).isEqualTo(filingDate);
        assertThat(insiderTransaction.getConversionOrExercisePrice()).isEqualTo(conversionOrExercisePrice);
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
