package pl.zankowski.iextrading.client.endpoint;

import org.junit.Before;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Wojciech Zankowski
 */
public class EndpointTestBase {

    protected Client clientMock;
    protected WebTarget webTargetMock;
    protected Invocation.Builder builderMock;

    @Before
    public void setUp() {
        clientMock = mock(Client.class);
        webTargetMock = mock(WebTarget.class);
        builderMock = mock(Invocation.Builder.class);

        connectMockWithEachOther();
    }

    private void connectMockWithEachOther() {
        when(clientMock.target(any(UriBuilder.class))).thenReturn(webTargetMock);
        when(webTargetMock.request(eq(MediaType.APPLICATION_JSON))).thenReturn(builderMock);
        when(webTargetMock.path(any())).thenReturn(webTargetMock);
        when(webTargetMock.queryParam(any(), any())).thenReturn(webTargetMock);
    }

    protected void verifyCorrectPaths(String... paths) {
        final ArgumentCaptor<String> pathArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(webTargetMock, times(paths.length)).path(pathArgumentCaptor.capture());

        List<String> calledPaths = pathArgumentCaptor.getAllValues();
        assertThat(calledPaths).hasSize(paths.length);
        for (int i = 0; i < calledPaths.size(); i++) {
            assertThat(calledPaths.get(i)).isEqualTo(paths[i]);
        }
    }

}
