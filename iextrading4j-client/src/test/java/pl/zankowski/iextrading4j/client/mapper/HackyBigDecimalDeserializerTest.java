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

public class HackyBigDecimalDeserializerTest {

    private HackyBigDecimalDeserializer hackyBigDecimalDeserializer;

    @Before
    public void setUp() {
        hackyBigDecimalDeserializer = new HackyBigDecimalDeserializer();
    }

    @After
    public void tearDown() {
        hackyBigDecimalDeserializer = null;
    }

    @Test
    public void shouldReturnNullIfValueIsNA() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("N/A");

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnNullIfValueIsNaN() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("NaN");

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnNullIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnNullIfValueIsEmpty() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("");

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    public void shouldCreateBigDecimalBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);
        final BigDecimal value = BigDecimal.valueOf(3);

        when(parserMock.getValueAsString()).thenReturn(value.toString());
        when(parserMock.getDecimalValue()).thenReturn(value);

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(value);
    }

}
