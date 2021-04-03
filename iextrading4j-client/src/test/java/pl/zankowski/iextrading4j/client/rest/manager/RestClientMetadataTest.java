package pl.zankowski.iextrading4j.client.rest.manager;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.client.IEXCloudToken;

import static org.assertj.core.api.Assertions.assertThat;

public class RestClientMetadataTest {

    @Test
    void testUrl() {
        final String url = "https://api.iextrading.com/1.0";
        final RestClientMetadata restClientMetadata = new RestClientMetadata(url, new IEXCloudToken("token", "t"));

        assertThat(restClientMetadata.getUrl()).isEqualTo(url);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(RestClientMetadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new RestClientMetadata("url", new IEXCloudToken("token", "T")))
                .verify();
    }

}
