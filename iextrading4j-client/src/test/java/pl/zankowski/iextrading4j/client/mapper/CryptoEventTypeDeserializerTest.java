package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoEventType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CryptoEventTypeDeserializerTest {

    private CryptoEventTypeDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new CryptoEventTypeDeserializer();
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

        final CryptoEventType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("block_trade");

        final CryptoEventType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(CryptoEventType.BLOCK_TRADE);
    }

}
