package pl.zankowski.iextrading4j.client.rest.manager;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class RestClientMetadataTest {

    @Test
    public void testUrl() {
        final RestClientMetadata restClientMetadata = new RestClientMetadata();

        assertThat(restClientMetadata.getUrl()).isEqualTo("https://api.iextrading.com/1.0");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RestClientMetadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(new RestClientMetadata())
                .verify();
    }

}
