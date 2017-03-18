package pl.zankowski.iextrading4j.client.socket.model.exception;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class UnsubscribeExceptionTest {

    @Test
    public void shouldCorrectlyCreateUnsubscribeException() {
        UnsubscribeException unsubscribeException = new UnsubscribeException();
        assertThat(unsubscribeException).isInstanceOf(Exception.class);
    }

    @Test
    public void shouldCorrectlyCreateUnsubscribeExceptionWithMessage() {
        final String message = "MESSAGE";
        UnsubscribeException unsubscribeException = new UnsubscribeException(message);

        assertThat(unsubscribeException.getMessage()).isEqualTo(message);
    }

}
