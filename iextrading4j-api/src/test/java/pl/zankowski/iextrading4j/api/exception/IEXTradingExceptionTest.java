package pl.zankowski.iextrading4j.api.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.exception.IEXTradingException.DEFAULT_PREFIX;

class IEXTradingExceptionTest {

    @Test
    void shouldSuccessfullyCreateExceptionWithStatus() {
        final String message = "test";
        final int statusCode = 500;

        final IEXTradingException exception = new IEXTradingException(message, statusCode);

        assertThat(exception.getStatus()).isEqualTo(statusCode);
        assertThat(exception.getMessage()).containsSequence(DEFAULT_PREFIX, message);
    }

    @Test
    void shouldSuccessfullyCreateException() {
        final String message = "test";

        final IEXTradingException exception = new IEXTradingException(message);

        assertThat(exception.getMessage()).containsSequence(DEFAULT_PREFIX, message);
    }

}
