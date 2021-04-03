package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.DividendType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DividendTypeDeserializerTest {

    private DividendTypeDeserializer dividendTypeDeserializer;

    @BeforeEach
    public void setUp() {
        dividendTypeDeserializer = new DividendTypeDeserializer();
    }

    @AfterEach
    public void tearDown() {
        dividendTypeDeserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final DividendType result = dividendTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendType.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("Long term capital gain");

        final DividendType result = dividendTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendType.LONG_TERM_CAPITAL_GAIN);
    }
}
