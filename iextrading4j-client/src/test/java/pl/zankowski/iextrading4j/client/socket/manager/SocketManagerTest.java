package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SocketManagerTest {

    private SocketManager socketManager;
    private SocketWrapper socketWrapper;
    private Socket socket;

    @Before
    public void setUp() throws URISyntaxException {
        this.socket = mock(Socket.class);

        this.socketWrapper = mock(SocketWrapper.class);
        when(socketWrapper.socket(any())).thenReturn(socket);

        this.socketManager = new SocketManager(socketWrapper);
    }

    @Test
    public void shouldConnectAndSubscribeAndProcessResponse() {
        final String path = "/test";
        final List<String> params = Arrays.asList("Test", "Test2");
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, path, params);
        final Consumer<String> consumer = spy(Consumer.class);

        final String response = "response";
        final ArgumentCaptor<Emitter.Listener> listenerCaptor = ArgumentCaptor.forClass(Emitter.Listener.class);

        when(socket.connect()).thenReturn(socket);
        when(socket.emit(any(), any())).thenReturn(socket);
        when(socket.on(any(), any())).thenReturn(socket);

        socketManager.subscribe(request, consumer);

        verify(socket).connect();
        verify(socket).emit("subscribe", "[\"Test\",\"Test2\"]");
        verify(socket).on(eq("message"), listenerCaptor.capture());

        listenerCaptor.getValue().call("\""+response+"\"");

        verify(consumer).accept(eq(response));
    }

    @Test
    public void shouldNotOverwriteSubscription() {
        final String path = "/test";
        final List<String> params = Arrays.asList("Test", "Test2");
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, path, params);
        final Consumer<String> consumer = spy(Consumer.class);
        final Consumer<String> anotherConsumer = spy(Consumer.class);

        final String response = "response";
        final ArgumentCaptor<Emitter.Listener> listenerCaptor = ArgumentCaptor.forClass(Emitter.Listener.class);

        when(socket.connect()).thenReturn(socket);
        when(socket.emit(any(), any())).thenReturn(socket);
        when(socket.on(any(), any())).thenReturn(socket);

        socketManager.subscribe(request, consumer);
        socketManager.subscribe(request, anotherConsumer);

        verify(socket).on(eq("message"), listenerCaptor.capture());

        listenerCaptor.getValue().call("\""+response+"\"");

        verify(consumer).accept(eq(response));
    }

    @Test
    public void verifyCreatedSocketPath() throws URISyntaxException {
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, "/test",
                Arrays.asList("Test", "Test2"));
        final Consumer<String> consumer = spy(Consumer.class);

        when(socket.connect()).thenReturn(socket);
        when(socket.emit(any(), any())).thenReturn(socket);
        when(socket.on(any(), any())).thenReturn(socket);

        socketManager.subscribe(request, consumer);

        verify(socketWrapper).socket(eq("https://ws-api.iextrading.com/1.0/test"));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionIfFailsOnConnection() throws URISyntaxException {
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, "/test",
                Arrays.asList("Test", "Test2"));
        final Consumer<String> consumer = mock(Consumer.class);

        when(socketWrapper.socket(any())).thenThrow(URISyntaxException.class);

        socketManager.subscribe(request, consumer);
    }

    @Test
    public void shouldNotThrowExceptionWhenThereIsNoSubscription() {
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, "/test",
                Arrays.asList("Test", "Test2"));

        socketManager.unsubscribe(request);
    }

    @Test
    public void shouldDisconnectFromSocketAfterUnsubscription() {
        final SocketRequest<String> request = new SocketRequest<>(new TypeReference<String>() {}, "/test",
                Arrays.asList("Test", "Test2"));
        final Consumer<String> consumer = spy(Consumer.class);

        when(socket.connect()).thenReturn(socket);
        when(socket.emit(any(), any())).thenReturn(socket);
        when(socket.on(any(), any())).thenReturn(socket);

        socketManager.subscribe(request, consumer);
        socketManager.unsubscribe(request);

        verify(socket).disconnect();
    }

}
