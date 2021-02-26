package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class InsiderRosterTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String entityName = fixture.create(String.class);
        final BigDecimal position = fixture.create(BigDecimal.class);
        final Long reportDate = fixture.create(Long.class);

        final InsiderRoster insiderRoster = new InsiderRoster(entityName, position, reportDate);

        assertThat(insiderRoster.getEntityName()).isEqualTo(entityName);
        assertThat(insiderRoster.getPosition()).isEqualTo(position);
        assertThat(insiderRoster.getReportDate()).isEqualTo(reportDate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(InsiderRoster.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(InsiderRoster.class))
                .verify();
    }

}
