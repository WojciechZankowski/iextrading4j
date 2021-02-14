package pl.zankowski.iextrading4j.client.rest.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenericRestEndpointTest {

    private GenericRestEndpoint genericRestEndpoint;
    private RestManager restManagerMock;

    @BeforeEach
    public void setUp() {
        restManagerMock = mock(RestManager.class);
        genericRestEndpoint = new GenericRestEndpoint(restManagerMock);
    }

    @Test
    public void shouldSuccessfullyExecuteRequest() {
        // Arrange
        final Object testObject = new Object();

        final RestResponse<Object> response = mock(RestResponse.class);
        when(response.getResponse()).thenReturn(testObject);

        final RestRequest<Object> restRequest = mock(RestRequest.class);
        when(restManagerMock.executeRequest(restRequest)).thenReturn(response);

        // Act
        final Object result = genericRestEndpoint.executeRequest(restRequest);

        // Assert
        assertThat(result).isEqualTo(testObject);
    }
}
