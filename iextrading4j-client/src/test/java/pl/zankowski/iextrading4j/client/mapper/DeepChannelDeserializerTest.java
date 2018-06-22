package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.DelistingReason;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeepChannelDeserializerTest {

    private DeepChannelDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new DeepChannelDeserializer();
    }

    @After
    public void tearDown() {
        deserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final DeepChannel result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DeepChannel.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("ophaltstatus");

        final DeepChannel result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DeepChannel.OP_HALT_STATUS);
    }

}
