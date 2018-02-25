package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentFrequencyDeserializerTest {

    private PaymentFrequencyDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new PaymentFrequencyDeserializer();
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

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.UNKNOWN);
    }

    @Test
    public void shouldCreateNotAvailableBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("");

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.NOT_AVAILABLE);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("Q");

        final PaymentFrequency result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(PaymentFrequency.QUARTERLY);
    }
}
