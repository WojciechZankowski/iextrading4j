package pl.zankowski.iextrading4j.api.datapoint;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeSeriesMetadataTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String id = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final TimeSeriesSchema schema = fixture.create(TimeSeriesSchema.class);
        final String weightKey = fixture.create(String.class);
        final BigDecimal weight = fixture.create(BigDecimal.class);
        final LocalDateTime created = fixture.create(LocalDateTime.class);
        final LocalDateTime lastUpdated = fixture.create(LocalDateTime.class);

        final TimeSeriesMetadata metadata = new TimeSeriesMetadata(id, description, schema, weightKey,
                weight, created, lastUpdated);

        assertThat(metadata.getId()).isEqualTo(id);
        assertThat(metadata.getDescription()).isEqualTo(description);
        assertThat(metadata.getSchema()).isEqualTo(schema);
        assertThat(metadata.getWeightKey()).isEqualTo(weightKey);
        assertThat(metadata.getWeight()).isEqualTo(weight);
        assertThat(metadata.getCreated()).isEqualTo(created);
        assertThat(metadata.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(TimeSeriesMetadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TimeSeriesMetadata.class))
                .verify();
    }

}
