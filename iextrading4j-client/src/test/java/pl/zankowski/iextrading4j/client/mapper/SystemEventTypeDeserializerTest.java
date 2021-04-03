package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SystemEventTypeDeserializerTest {

    private SystemEventTypeDeserializer systemEventTypeDeserializer;

    @BeforeEach
    public void setUp() {
        systemEventTypeDeserializer = new SystemEventTypeDeserializer();
    }

    @AfterEach
    public void tearDown() {
        systemEventTypeDeserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final SystemEventType result = systemEventTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SystemEventType.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("M");

        final SystemEventType result = systemEventTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SystemEventType.REGULAR_MARKET_HOURS_END);
    }
}
