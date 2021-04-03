package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.FinancialStatus;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FinancialStatusDeserializerTest {

    private FinancialStatusDeserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = new FinancialStatusDeserializer();
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

        final FinancialStatus result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(FinancialStatus.UNKNOWN);
    }

    @Test
    void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("7");

        final FinancialStatus result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(FinancialStatus.BANKRUPT_AND_BELOW_CONTINUING_LISTING_STANDARDS_AND_LATE_FILING);
    }
}
