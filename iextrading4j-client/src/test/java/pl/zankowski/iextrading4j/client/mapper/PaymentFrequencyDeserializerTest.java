package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentFrequencyDeserializerTest {

    private PaymentFrequencyDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new PaymentFrequencyDeserializer();
    }

    @AfterEach
    public void tearDown() {
        deserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.UNKNOWN);
    }

    @Test
    void shouldCreateNotAvailableBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("");

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.NOT_AVAILABLE);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("Q");

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.QUARTERLY);
    }
}
