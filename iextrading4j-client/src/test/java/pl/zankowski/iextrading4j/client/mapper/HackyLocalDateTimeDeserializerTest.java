package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HackyLocalDateTimeDeserializerTest {

    private HackyLocalDateTimeDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new HackyLocalDateTimeDeserializer();
    }

    @AfterEach
    public void tearDown() {
        deserializer = null;
    }

    @Test
    void shouldReturnNullIfValueIsNA() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("0");

        final LocalDateTime result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    void shouldReturnNullIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final LocalDateTime result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isNull();
    }

    @Test
    void shouldCreateLocalDateTimeBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);
        final String dateTime = "2015-05-05T19:19:19";

        when(parserMock.getText()).thenReturn(dateTime);
        when(parserMock.getValueAsString()).thenReturn(dateTime);
        when(parserMock.hasTokenId(JsonTokenId.ID_STRING)).thenReturn(true);

        final LocalDateTime result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(LocalDateTime.of(2015, 5, 5, 19, 19, 19));
    }

}
