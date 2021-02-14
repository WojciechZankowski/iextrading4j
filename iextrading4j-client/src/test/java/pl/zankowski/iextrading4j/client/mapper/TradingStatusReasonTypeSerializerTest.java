package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TradingStatusReasonTypeSerializerTest {

    private TradingStatusReasonTypeSerializer tradingStatusReasonTypeSerializer;

    @BeforeEach
    public void setUp() {
        tradingStatusReasonTypeSerializer = new TradingStatusReasonTypeSerializer();
    }

    @AfterEach
    public void tearDown() {
        tradingStatusReasonTypeSerializer = null;
    }

    @Test
    public void shouldWriteNullIfValueIsNull() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final TradingStatusReasonType input = null;

        tradingStatusReasonTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteNullIfValueIsUnknown() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final TradingStatusReasonType input = TradingStatusReasonType.UNKNOWN;

        tradingStatusReasonTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeNull();
    }

    @Test
    public void shouldWriteStringFromValue() throws IOException {
        final JsonGenerator jsonGeneratorMock = mock(JsonGenerator.class);
        final SerializerProvider serializerProviderMock = mock(SerializerProvider.class);
        final TradingStatusReasonType input = TradingStatusReasonType.HALT_NEWS_DISSEMINATION;

        tradingStatusReasonTypeSerializer.serialize(input, jsonGeneratorMock, serializerProviderMock);

        verify(jsonGeneratorMock).writeString("T2");
    }

}
