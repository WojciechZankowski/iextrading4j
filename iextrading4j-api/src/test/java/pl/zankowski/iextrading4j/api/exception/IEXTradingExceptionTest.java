package pl.zankowski.iextrading4j.api.exception;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.exception.IEXTradingException.DEFAULT_PREFIX;

public class IEXTradingExceptionTest {

    @Test
    public void shouldSuccessfullyCreateExceptionWithStatus() {
        final String message = "test";
        final int statusCode = 500;

        final IEXTradingException exception = new IEXTradingException(message, statusCode);

        assertThat(exception.getStatus()).isEqualTo(statusCode);
        assertThat(exception.getMessage()).containsSequence(DEFAULT_PREFIX, message);
    }

    @Test
    public void shouldSuccessfullyCreateException() {
        final String message = "test";

        final IEXTradingException exception = new IEXTradingException(message);

        assertThat(exception.getMessage()).containsSequence(DEFAULT_PREFIX, message);
    }

}
