package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.IOException;

public class SymbolTypeDeserializer extends JsonDeserializer<SymbolType> {

    @Override
    public SymbolType deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException {
        final String value = parser.getValueAsString();
        if (value == null || value.isEmpty()) {
            return SymbolType.UNKNOWN;
        }

        switch (value) {
            case "N/A":
                return SymbolType.NOT_AVAILABLE;
            default:
                return SymbolType.valueOf(value.toUpperCase());
        }
    }
}
