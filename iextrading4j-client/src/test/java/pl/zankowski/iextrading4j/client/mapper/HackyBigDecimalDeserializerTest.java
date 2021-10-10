package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HackyBigDecimalDeserializerTest {

    private HackyBigDecimalDeserializer hackyBigDecimalDeserializer;

    @BeforeEach
    public void setUp() {
        hackyBigDecimalDeserializer = new HackyBigDecimalDeserializer();
    }

    @AfterEach
    public void tearDown() {
        hackyBigDecimalDeserializer = null;
    }

    @ValueSource(strings = {"N/A", "NaN", ""})
    @NullSource
    @ParameterizedTest
    void shouldReturnNullForUnknownValues(final String value) throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(value);

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    void shouldCreateBigDecimalBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);
        final BigDecimal value = BigDecimal.valueOf(3);

        when(parserMock.getValueAsString()).thenReturn(value.toString());
        when(parserMock.getDecimalValue()).thenReturn(value);

        final BigDecimal result = hackyBigDecimalDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(value);
    }

}
