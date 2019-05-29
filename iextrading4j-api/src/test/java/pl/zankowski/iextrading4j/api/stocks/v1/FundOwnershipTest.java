package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class FundOwnershipTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal adjHolding = fixture.create(BigDecimal.class);
        final BigDecimal adjMv = fixture.create(BigDecimal.class);
        final String entityProperName = fixture.create(String.class);
        final Long reportDate = fixture.create(Long.class);
        final BigDecimal reportedHolding = fixture.create(BigDecimal.class);
        final BigDecimal reportedMv = fixture.create(BigDecimal.class);

        final FundOwnership fundOwnership = new FundOwnership(adjHolding, adjMv,
                entityProperName, reportDate, reportedHolding, reportedMv);

        assertThat(fundOwnership.getAdjHolding()).isEqualTo(adjHolding);
        assertThat(fundOwnership.getAdjMv()).isEqualTo(adjMv);
        assertThat(fundOwnership.getEntityProperName()).isEqualTo(entityProperName);
        assertThat(fundOwnership.getReportDate()).isEqualTo(reportDate);
        assertThat(fundOwnership.getReportedHolding()).isEqualTo(reportedHolding);
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
