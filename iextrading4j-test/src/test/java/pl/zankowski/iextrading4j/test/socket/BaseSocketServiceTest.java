package pl.zankowski.iextrading4j.test.socket;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.manager.SocketWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IEXTradingClient.class})
@PowerMockIgnore({"javax.net.ssl.*"})
public abstract class BaseSocketServiceTest {

    protected Socket socket;
    protected IEXTradingClient iexTradingClient;

    @Before
    public void setUp() throws Exception {
        socket = mock(Socket.class, RETURNS_DEEP_STUBS);
        when(socket.connect()).thenReturn(socket);
        when(socket.emit(any(), any())).thenReturn(socket);

        final SocketWrapper socketWrapper = mock(SocketWrapper.class);
        when(socketWrapper.socket(any())).thenReturn(socket);

        whenNew(SocketWrapper.class).withAnyArguments().thenReturn(socketWrapper);

        iexTradingClient = IEXTradingClient.create();
    }

    @After
    public void tearDown() {
        iexTradingClient = null;
    }

    protected SocketServiceConfigurer stubFor(final Socket socket) {
        return new SocketServiceConfigurer(socket);
    }

    protected static class SocketServiceConfigurer {

        private static final String PATH_PREFIX = "__files/socket";

        private final Socket socket;

        SocketServiceConfigurer(final Socket socket) {
            this.socket = socket;
        }

        public SocketServiceConfigurer withResponseFile(final String responsePath) {
            try {
                final InputStream resource = BaseSocketServiceTest.class.getClassLoader().getResourceAsStream(
                        PATH_PREFIX + responsePath);
                final String response = CharStreams.toString(new InputStreamReader(resource, Charsets.UTF_8));

                doAnswer(responseAnswer(response)).when(socket).on(any(), any());
            } catch (final IOException e) {
                throw new IllegalStateException(e);
            }
            return this;
        }

        private Answer<Void> responseAnswer(final String response) {
            return (invocation) -> {
                final Object[] args = invocation.getArguments();
                final Emitter.Listener listener = (Emitter.Listener) args[1];

                listener.call(response);
                return null;
            };
        }

    }

}
