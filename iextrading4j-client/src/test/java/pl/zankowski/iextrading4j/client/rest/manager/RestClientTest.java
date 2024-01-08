package pl.zankowski.iextrading4j.client.rest.manager;

import javax.ws.rs.client.Client;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class RestClientTest {

    @Test
    void testConstructor() {
        final Client clientMock = mock(Client.class);
        final RestClientMetadata restClientMetadataMock = mock(RestClientMetadata.class);

        final RestClient restClient = new RestClient(clientMock, restClientMetadataMock);

        assertThat(restClient.getClient()).isEqualTo(clientMock);
        assertThat(restClient.getRestClientMetadata()).isEqualTo(restClientMetadataMock);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(RestClient.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new RestClient(null, null))
                .verify();
    }

}
