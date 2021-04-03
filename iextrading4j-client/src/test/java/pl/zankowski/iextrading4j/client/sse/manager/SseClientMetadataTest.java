package pl.zankowski.iextrading4j.client.sse.manager;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.client.IEXCloudToken;

import static org.assertj.core.api.Assertions.assertThat;

public class SseClientMetadataTest {

    @Test
    void testUrl() {
        final String url = "https://api.iextrading.com/1.0";
        final SseClientMetadata sseClientMetadata = new SseClientMetadata(url, new IEXCloudToken("token", "t"));

        assertThat(sseClientMetadata.getUrl()).isEqualTo(url);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SseClientMetadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new SseClientMetadata("url", new IEXCloudToken("token", "T")))
                .verify();
    }

}
