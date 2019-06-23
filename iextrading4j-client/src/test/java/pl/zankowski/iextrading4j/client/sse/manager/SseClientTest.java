package pl.zankowski.iextrading4j.client.sse.manager;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import javax.ws.rs.client.Client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class SseClientTest {

    @Test
    public void testConstructor() {
        final Client clientMock = mock(Client.class);
        final SseClientMetadata sseClientMetadata = mock(SseClientMetadata.class);

        final SseClient restClient = new SseClient(clientMock, sseClientMetadata);

        assertThat(restClient.getClient()).isEqualTo(clientMock);
        assertThat(restClient.getSseClientMetadata()).isEqualTo(sseClientMetadata);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(SseClient.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(new SseClient(null, null))
                .verify();
    }

}
