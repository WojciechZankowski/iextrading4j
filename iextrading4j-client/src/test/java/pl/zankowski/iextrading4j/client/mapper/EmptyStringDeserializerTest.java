package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmptyStringDeserializerTest {

    private EmptyStringDeserializer emptyStringDeserializer;

    @Before
    public void setUp() {
        emptyStringDeserializer = new EmptyStringDeserializer();
    }

    @After
    public void tearDown() {
        emptyStringDeserializer = null;
    }

    @Test
    public void shouldReturnNullIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("N/A");

        final BigDecimal result = emptyStringDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);
        final BigDecimal value = BigDecimal.valueOf(3);

        when(parserMock.getValueAsString()).thenReturn(value.toString());
        when(parserMock.getDecimalValue()).thenReturn(value);

        final BigDecimal result = emptyStringDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(value);
    }

}
