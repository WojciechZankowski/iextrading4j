package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class FundOwnershipTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {

        final BigDecimal reportedMv = fixture.create(BigDecimal.class);
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final LocalDate filingDate = fixture.create(LocalDate.class);
        final Long updated = fixture.create(Long.class);
        final BigDecimal adjHolding = fixture.create(BigDecimal.class);
        final BigDecimal adjMv = fixture.create(BigDecimal.class);
        final String entityProperName = fixture.create(String.class);
        final Long reportDate = fixture.create(Long.class);
        final BigDecimal reportedHolding = fixture.create(BigDecimal.class);

        final FundOwnership fundOwnership = new FundOwnership(symbol, id, adjHolding, adjMv,
                entityProperName, reportDate, filingDate, reportedHolding, updated, reportedMv);

        assertThat(fundOwnership.getSymbol()).isEqualTo(symbol);
        assertThat(fundOwnership.getId()).isEqualTo(id);
        assertThat(fundOwnership.getAdjHolding()).isEqualTo(adjHolding);
        assertThat(fundOwnership.getAdjMv()).isEqualTo(adjMv);
        assertThat(fundOwnership.getEntityProperName()).isEqualTo(entityProperName);
        assertThat(fundOwnership.getReportDate()).isEqualTo(reportDate);
        assertThat(fundOwnership.getFilingDate()).isEqualTo(filingDate);
        assertThat(fundOwnership.getReportedHolding()).isEqualTo(reportedHolding);
        assertThat(fundOwnership.getUpdated()).isEqualTo(updated);
        assertThat(fundOwnership.getReportedMv()).isEqualTo(reportedMv);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(FundOwnership.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(FundOwnership.class))
                .verify();
    }

}
