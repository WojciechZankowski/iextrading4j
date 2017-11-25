package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SystemEventTypeDeserializerTest {

    private SystemEventTypeDeserializer systemEventTypeDeserializer;

    @Before
    public void setUp() {
        systemEventTypeDeserializer = new SystemEventTypeDeserializer();
    }

    @After
    public void tearDown() {
        systemEventTypeDeserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final SystemEventType result = systemEventTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SystemEventType.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("M");

        final SystemEventType result = systemEventTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(SystemEventType.REGULAR_MARKET_HOURS_END);
    }
}
