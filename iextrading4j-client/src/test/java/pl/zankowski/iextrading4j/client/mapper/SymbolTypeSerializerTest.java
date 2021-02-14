package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SymbolTypeSerializerTest {

    private SymbolTypeSerializer serializer;

    @BeforeEach
    public void setUp() {
        serializer = new SymbolTypeSerializer();
    }

    @AfterEach
    public void tearDown() {
        serializer = null;
    }

    @Test
    public void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SymbolType input = null;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SymbolType input = SymbolType.UNKNOWN;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteStringFromNotAvailable() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SymbolType input = SymbolType.NOT_AVAILABLE;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("N/A");
    }

    @Test
    public void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final SymbolType input = SymbolType.COMMON_STOCK;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("cs");
    }

}
