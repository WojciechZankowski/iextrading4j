package pl.zankowski.iextrading4j.client.socket.model.exception;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class SubscribeExceptionTest {

    @Test
    public void shouldCorrectlyCreateSubscribeException() {
        SubscribeException subscribeException = new SubscribeException();
        assertThat(subscribeException).isInstanceOf(SubscribeException.class);
    }

    @Test
    public void shouldCorrectlyCreateSubscribeExceptionWithMessage() {
        final String message = "MESSAGE";
        SubscribeException subscribeException = new SubscribeException(message);

        assertThat(subscribeException.getMessage()).isEqualTo(message);
    }

}
