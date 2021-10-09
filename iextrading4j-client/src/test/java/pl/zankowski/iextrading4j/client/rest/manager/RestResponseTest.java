package pl.zankowski.iextrading4j.client.rest.manager;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class RestResponseTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String message = fixture.create(String.class);
        final String responseObject = fixture.create(String.class);

        final RestResponse<String> response = new RestResponse<>(responseObject, message);

        assertThat(response.getResponse()).isEqualTo(responseObject);
        assertThat(response.getMessage()).isEqualTo(message);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(RestResponse.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new RestResponse<>(null, null))
                .verify();
    }

}
