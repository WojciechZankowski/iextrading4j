package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestManagerTest {

    private RestClient restClientMock;
    private RestManager restManager;

    @Before
    public void setUp() {
        restClientMock = mock(RestClient.class);
        restManager = new RestManager(restClientMock);
    }

    @Test
    public void shouldSuccessfullyExecuteGetRequest() {
        final RestClientMetadata metadataMock = mock(RestClientMetadata.class);
        final RestRequest restRequestMock = mock(RestRequest.class);
        final Client clientMock = mock(Client.class);
        final WebTarget webTargetMock = mock(WebTarget.class);
        final Invocation.Builder builderMock = mock(Invocation.Builder.class);
        final Response responseMock = mock(Response.class);
        final Response.StatusType statusTypeMock = mock(Response.StatusType.class);
        final String reasonPhrase = "reason";

        when(statusTypeMock.getReasonPhrase()).thenReturn(reasonPhrase);
        when(responseMock.getStatusInfo()).thenReturn(statusTypeMock);
        when(builderMock.get()).thenReturn(responseMock);
        when(webTargetMock.request(anyString())).thenReturn(builderMock);
        when(clientMock.target(anyString())).thenReturn(webTargetMock);
        when(restClientMock.getClient()).thenReturn(clientMock);
        when(restClientMock.getRestClientMetadata()).thenReturn(metadataMock);

        when(restRequestMock.getMethodType()).thenReturn(MethodType.GET);
        when(restRequestMock.getPath()).thenReturn("/test/{test}");
        when(restRequestMock.getPathParams()).thenReturn(ImmutableMap.builder()
                .put("test", "works")
                .build());
        when(restRequestMock.getQueryParams()).thenReturn(ImmutableMap.builder()
                .put("query", "test")
                .build());
        when(metadataMock.getUrl()).thenReturn("http://localhost:8080");

        final RestResponse response = restManager.executeRequest(restRequestMock);

        assertThat(response.getMessage()).isEqualTo(reasonPhrase);

        verify(responseMock).close();
        verify(clientMock).target(eq("http://localhost:8080/test/works?query=test"));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionIfMethodTypeIsNotSupported() {
        final RestClientMetadata metadataMock = mock(RestClientMetadata.class);
        final RestRequest restRequestMock = mock(RestRequest.class);
        final Client clientMock = mock(Client.class);
        final WebTarget webTargetMock = mock(WebTarget.class);
        final Invocation.Builder builderMock = mock(Invocation.Builder.class);

        when(webTargetMock.request(anyString())).thenReturn(builderMock);
        when(clientMock.target(anyString())).thenReturn(webTargetMock);
        when(restClientMock.getClient()).thenReturn(clientMock);
        when(restClientMock.getRestClientMetadata()).thenReturn(metadataMock);

        when(restRequestMock.getMethodType()).thenReturn(MethodType.POST);
        when(restRequestMock.getPath()).thenReturn("/test");
        when(metadataMock.getUrl()).thenReturn("http://localhost:8080");

        restManager.executeRequest(restRequestMock);
    }
}
