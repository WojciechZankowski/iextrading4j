package pl.zankowski.iextrading4j.api.datapoint;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DataPointTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
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
    public void equalsContract() {
        EqualsVerifier.forClass(DataPoint.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DataPoint.class))
                .verify();
    }

}
