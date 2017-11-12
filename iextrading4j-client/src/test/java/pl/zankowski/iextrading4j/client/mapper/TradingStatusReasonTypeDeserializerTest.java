package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TradingStatusReasonTypeDeserializerTest {

    private TradingStatusReasonTypeDeserializer tradingStatusReasonTypeDeserializer;

    @Before
    public void setUp() {
        tradingStatusReasonTypeDeserializer = new TradingStatusReasonTypeDeserializer();
    }

    @After
    public void tearDown() {
        tradingStatusReasonTypeDeserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final TradingStatusReasonType result = tradingStatusReasonTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusReasonType.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("T1");

        final TradingStatusReasonType result = tradingStatusReasonTypeDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(TradingStatusReasonType.HALT_NEWS_PENDING);
    }

}
