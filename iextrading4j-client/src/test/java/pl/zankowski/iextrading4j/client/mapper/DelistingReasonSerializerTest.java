package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.DelistingReason;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DelistingReasonSerializerTest {

    private DelistingReasonSerializer serializer;

    @Before
    public void setUp() {
        serializer = new DelistingReasonSerializer();
    }

    @After
    public void tearDown() {
        serializer = null;
    }

    @Test
    public void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final DelistingReason input = null;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final DelistingReason input = DelistingReason.UNKNOWN;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final DelistingReason input = DelistingReason.CALLED_FOR_REDEMPTION;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString(eq("CR"));
    }
}
