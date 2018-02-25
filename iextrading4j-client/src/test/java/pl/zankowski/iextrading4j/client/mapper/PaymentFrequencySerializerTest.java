package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentFrequencySerializerTest {

    private PaymentFrequencySerializer serializer;

    @Before
    public void setUp() {
        serializer = new PaymentFrequencySerializer();
    }

    @After
    public void tearDown() {
        serializer = null;
    }

    @Test
    public void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final PaymentFrequency input = null;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final PaymentFrequency input = PaymentFrequency.UNKNOWN;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteStringFromNotAvailable() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final PaymentFrequency input = PaymentFrequency.NOT_AVAILABLE;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString(eq(""));
    }

    @Test
    public void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final PaymentFrequency input = PaymentFrequency.MONTHLY;

        serializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString(eq("M"));
    }
}
