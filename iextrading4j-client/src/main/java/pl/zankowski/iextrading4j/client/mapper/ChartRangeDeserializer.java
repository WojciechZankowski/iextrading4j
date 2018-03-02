package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;

import java.io.IOException;

public class ChartRangeDeserializer extends JsonDeserializer<ChartRange> {

    @Override
    public ChartRange deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return null;
        }

        return ChartRange.getValueFromCode(value);
    }

}
