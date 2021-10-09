package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TradingStatusReasonTypeDeserializerTest {

    private TradingStatusReasonTypeDeserializer tradingStatusReasonTypeDeserializer;

    @BeforeEach
    public void setUp() {
        tradingStatusReasonTypeDeserializer = new TradingStatusReasonTypeDeserializer();
    }

    @AfterEach
    public void tearDown() {
        tradingStatusReasonTypeDeserializer = null;
    }

    @Test
    void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final TradingStatusReasonType result = tradingStatusReasonTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusReasonType.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("T1");

        final TradingStatusReasonType result = tradingStatusReasonTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusReasonType.HALT_NEWS_PENDING);
    }

}
