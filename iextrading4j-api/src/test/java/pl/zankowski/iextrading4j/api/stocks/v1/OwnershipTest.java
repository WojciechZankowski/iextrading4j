package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class OwnershipTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final LocalDate filingDate = fixture.create(LocalDate.class);
        final Long updated = fixture.create(Long.class);
        final Long date = fixture.create(Long.class);
        final BigDecimal adjHolding = fixture.create(BigDecimal.class);
        final BigDecimal adjMv = fixture.create(BigDecimal.class);
        final String entityProperName = fixture.create(String.class);
        final Long reportDate = fixture.create(Long.class);
        final BigDecimal reportedHolding = fixture.create(BigDecimal.class);

        final Ownership ownership = new Ownership(symbol, id, adjHolding, adjMv,
                entityProperName, reportDate, filingDate, reportedHolding, updated, date);

        assertThat(ownership.getSymbol()).isEqualTo(symbol);
        assertThat(ownership.getId()).isEqualTo(id);
        assertThat(ownership.getAdjHolding()).isEqualTo(adjHolding);
        assertThat(ownership.getAdjMv()).isEqualTo(adjMv);
        assertThat(ownership.getEntityProperName()).isEqualTo(entityProperName);
        assertThat(ownership.getReportDate()).isEqualTo(reportDate);
        assertThat(ownership.getFilingDate()).isEqualTo(filingDate);
        assertThat(ownership.getReportedHolding()).isEqualTo(reportedHolding);
        assertThat(ownership.getUpdated()).isEqualTo(updated);
        assertThat(ownership.getDate()).isEqualTo(date);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Ownership.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Ownership.class))
                .verify();
    }

}
