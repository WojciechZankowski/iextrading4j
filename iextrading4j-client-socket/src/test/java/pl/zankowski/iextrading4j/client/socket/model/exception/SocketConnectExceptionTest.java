package pl.zankowski.iextrading4j.client.socket.model.exception;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class SocketConnectExceptionTest {

    @Test
    public void shouldCorrectlyCreateSocketConnectException() {
        SocketConnectException socketConnectException = new SocketConnectException();
        assertThat(socketConnectException).isInstanceOfAny(Exception.class);
    }

    @Test
    public void shouldCorrectlyCreateSocketConnectExceptionWithMessage() {
        final String message = "MESSAGE";
        SocketConnectException socketConnectException = new SocketConnectException(message);

        assertThat(socketConnectException.getMessage()).isEqualTo(message);
    }

}
