package pl.zankowski.iextrading4j.client.socket.manager;

import io.socket.client.IO;
import io.socket.client.Socket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SocketWrapper.class, IO.class})
@PowerMockIgnore({"javax.net.ssl.*"})
public class SocketWrapperTest {

    private SocketWrapper socketWrapper;
    private Socket socketMock;

    @Before
    public void setUp() {
        socketWrapper = new SocketWrapper();
        PowerMockito.mockStatic(IO.class);
        socketMock = mock(Socket.class);
    }

    @Test
    public void shouldSuccessfullyCreateSocket() throws URISyntaxException {
        final String uri = "uri";
        when(IO.socket(eq(uri), any(IO.Options.class))).thenReturn(socketMock);

        final Socket socket = socketWrapper.socket(uri, false);

        assertThat(socket).isEqualTo(socketMock);
    }

}
