package pl.zankowski.iextrading4j.api.datapoint;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class DataPointTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String key = fixture.create(String.class);
        final BigDecimal weight = fixture.create(BigDecimal.class);
        final String description = fixture.create(String.class);
        final OffsetDateTime lastUpdated = fixture.create(OffsetDateTime.class);

        final DataPoint dataPoint = new DataPoint(key, weight, description, lastUpdated);

        assertThat(dataPoint.getKey()).isEqualTo(key);
        assertThat(dataPoint.getWeight()).isEqualTo(weight);
        assertThat(dataPoint.getDescription()).isEqualTo(description);
        assertThat(dataPoint.getLastUpdated()).isEqualTo(lastUpdated);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(DataPoint.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DataPoint.class))
                .verify();
    }

}
