package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import java.io.IOException;

public class SymbolTypeSerializer extends JsonSerializer<SymbolType> {

    @Override
    public void serialize(final SymbolType value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == SymbolType.UNKNOWN) {
            gen.writeNull();
            return;
        }

        if (value == SymbolType.NOT_AVAILABLE) {
            gen.writeString("N/A");
        } else {
            gen.writeString(value.name().toLowerCase());
        }
    }
}
