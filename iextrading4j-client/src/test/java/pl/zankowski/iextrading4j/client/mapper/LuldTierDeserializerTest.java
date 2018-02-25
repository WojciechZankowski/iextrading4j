package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.LuldTier;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LuldTierDeserializerTest {

    private LuldTierDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new LuldTierDeserializer();
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

        final LuldTier result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(LuldTier.UNKNOWN);
    }

    @Test
    public void shouldCreateNotAvailableBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("");

        final LuldTier result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(LuldTier.NOT_AVAILABLE);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("2");

        final LuldTier result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(LuldTier.TIER_2_NMS_STOCKS);
    }
}
