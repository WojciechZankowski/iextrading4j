package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.BiMap;

import java.io.IOException;

public abstract class AbstractEnumSerializer<T> extends JsonSerializer<T> {

    private final BiMap<T, String> MAPPER;
    private final T UNKNOWN;

    AbstractEnumSerializer(final BiMap<T, String> MAPPER, final T UNKNOWN) {
        this.MAPPER = MAPPER;
        this.UNKNOWN = UNKNOWN;
    }

    @Override
    public void serialize(final T value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == UNKNOWN) {
            gen.writeNull();
            return;
        }

        final String input = MAPPER.get(value);
        if (input == null) {
            gen.writeNull();
            return;
        }
        gen.writeString(input);
    }

}
