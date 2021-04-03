package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepMessageTypeTest {

    @Test
    void shouldReturnUnknownTypeForUnknownName() {
        final String name = "test";

        final DeepMessageType messageType = DeepMessageType.getMessageType(name);

        assertThat(messageType).isEqualTo(DeepMessageType.UNKNOWN);
    }

    @Test
    void shouldSuccessfullyConvertToType() {
        final DeepMessageType bookType = DeepMessageType.BOOK;

        final DeepMessageType messageType = DeepMessageType.getMessageType(bookType.getName());

        assertThat(messageType).isEqualTo(bookType);
    }

}
