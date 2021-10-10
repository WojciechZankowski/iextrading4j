package pl.zankowski.iextrading4j.api.datapoint;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class FieldMetadataTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String type = fixture.create(String.class);

        final FieldMetadata fieldMetadata = new FieldMetadata(type);

        assertThat(fieldMetadata.getType()).isEqualTo(type);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(FieldMetadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(FieldMetadata.class))
                .verify();
    }

}
