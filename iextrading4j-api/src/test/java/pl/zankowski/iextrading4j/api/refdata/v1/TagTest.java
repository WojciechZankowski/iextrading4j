package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class TagTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String name = fixture.create(String.class);

        final Tag tag = new Tag(name);

        assertThat(tag.getName()).isEqualTo(name);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Tag.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Tag.class))
                .verify();
    }

}
