package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QualifiedDividendTypeDeserializerTest {

    private QualifiedDividendTypeDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new QualifiedDividendTypeDeserializer();
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

        final QualifiedDividendType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(QualifiedDividendType.UNKNOWN);
    }

    @Test
    void shouldCreateNotAvailableBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("");

        final QualifiedDividendType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(QualifiedDividendType.NOT_AVAILABLE);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("U");

        final QualifiedDividendType result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(QualifiedDividendType.NO_AFFIRMATION);
    }
}
