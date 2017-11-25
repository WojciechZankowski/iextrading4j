package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DividendQualificationDeserializerTest {

    private DividendQualificationDeserializer dividendQualificationDeserializer;

    @Before
    public void setUp() {
        dividendQualificationDeserializer = new DividendQualificationDeserializer();
    }

    @After
    public void tearDown() {
        dividendQualificationDeserializer = null;
    }

    @Test
    public void shouldReturnUnknownTypeIfValueIsNull() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn(null);

        final DividendQualification result = dividendQualificationDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendQualification.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("N");

        final DividendQualification result = dividendQualificationDeserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(DividendQualification.UNQUALIFIED_INCOME);
    }
}
