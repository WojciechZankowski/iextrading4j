package pl.zankowski.iextrading4j.client.rest.manager;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import javax.ws.rs.client.Client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RestClientTest {

    @Test
    public void testConstructor() {
        final Client clientMock = mock(Client.class);
        final RestClientMetadata restClientMetadataMock = mock(RestClientMetadata.class);

        final RestClient restClient = new RestClient(clientMock, restClientMetadataMock);

        assertThat(restClient.getClient()).isEqualTo(clientMock);
        assertThat(restClient.getRestClientMetadata()).isEqualTo(restClientMetadataMock);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RestClient.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(new RestClient(null, null))
                .verify();
    }

}
