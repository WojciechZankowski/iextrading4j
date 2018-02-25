package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.ListingCenter;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListingCenterDeserializerTest {

    private ListingCenterDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new ListingCenterDeserializer();
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

        final ListingCenter result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(ListingCenter.UNKNOWN);
    }

    @Test
    public void shouldCreateEnumBasedOnValue() throws IOException {
        final JsonParser parserMock = mock(JsonParser.class);
        final DeserializationContext contextMock = mock(DeserializationContext.class);

        when(parserMock.getValueAsString()).thenReturn("M");

        final ListingCenter result = deserializer.deserialize(parserMock, contextMock);

        assertThat(result).isEqualTo(ListingCenter.CHICAGO_STOCK_EXCHANGE);
    }
}
