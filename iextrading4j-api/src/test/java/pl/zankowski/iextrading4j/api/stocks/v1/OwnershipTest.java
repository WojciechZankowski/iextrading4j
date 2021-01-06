package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class OwnershipTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final LocalDate filingDate = fixture.create(LocalDate.class);
        final Long updated = fixture.create(Long.class);
        final BigDecimal adjHolding = fixture.create(BigDecimal.class);
        final BigDecimal adjMv = fixture.create(BigDecimal.class);
        final String entityProperName = fixture.create(String.class);
        final Long reportDate = fixture.create(Long.class);
        final BigDecimal reportedHolding = fixture.create(BigDecimal.class);

        final Ownership ownership = new Ownership(symbol, id, adjHolding, adjMv,
                entityProperName, reportDate, filingDate, reportedHolding, updated);

        assertThat(ownership.getSymbol()).isEqualTo(symbol);
        assertThat(ownership.getId()).isEqualTo(id);
        assertThat(ownership.getAdjHolding()).isEqualTo(adjHolding);
        assertThat(ownership.getAdjMv()).isEqualTo(adjMv);
        assertThat(ownership.getEntityProperName()).isEqualTo(entityProperName);
        assertThat(ownership.getReportDate()).isEqualTo(reportDate);
        assertThat(ownership.getFilingDate()).isEqualTo(filingDate);
        assertThat(ownership.getReportedHolding()).isEqualTo(reportedHolding);
        assertThat(ownership.getUpdated()).isEqualTo(updated);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Ownership.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Ownership.class))
                .verify();
    }

}
