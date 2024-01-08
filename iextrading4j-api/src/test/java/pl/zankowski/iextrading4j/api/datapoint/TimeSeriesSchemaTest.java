package pl.zankowski.iextrading4j.api.datapoint;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TimeSeriesSchemaTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String type = fixture.create(String.class);
        final Map<String, FieldMetadata> properties = fixture.collections().createMap(String.class, FieldMetadata.class);
        final List<String> required = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final boolean additionalProperties = fixture.create(boolean.class);

        final TimeSeriesSchema schema = new TimeSeriesSchema(type, properties, required, additionalProperties);

        assertThat(schema.getType()).isEqualTo(type);
        assertThat(schema.getProperties()).isEqualTo(properties);
        assertThat(schema.getRequired()).isEqualTo(required);
        assertThat(schema.isAdditionalProperties()).isEqualTo(additionalProperties);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(TimeSeriesSchema.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TimeSeriesSchema.class))
                .verify();
    }

}
