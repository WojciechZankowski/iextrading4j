package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class InsiderRosterTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String entityName = fixture.create(String.class);
        final BigDecimal position = fixture.create(BigDecimal.class);
        final Long reportDate = fixture.create(Long.class);

        final InsiderRoster insiderRoster = new InsiderRoster(entityName, position, reportDate);

        assertThat(insiderRoster.getEntityName()).isEqualTo(entityName);
        assertThat(insiderRoster.getPosition()).isEqualTo(position);
        assertThat(insiderRoster.getReportDate()).isEqualTo(reportDate);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(InsiderRoster.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(InsiderRoster.class))
                .verify();
    }

}
