package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoEventReason;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CryptoEventReasonDeserializerTest {

    private CryptoEventReasonDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new CryptoEventReasonDeserializer();
    }

    @AfterEach
    public void tearDown() {
        deserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final CryptoEventReason result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("cancel");

        final CryptoEventReason result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(CryptoEventReason.CANCEL);
    }

}
