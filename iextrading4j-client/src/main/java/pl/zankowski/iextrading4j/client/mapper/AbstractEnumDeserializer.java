package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.collect.BiMap;

import java.io.IOException;

public abstract class AbstractEnumDeserializer<T> extends JsonDeserializer<T> {

    private final BiMap<String, T> MAPPER;
    private final T UNKNOWN;

    AbstractEnumDeserializer(final BiMap<String, T> MAPPER, T UNKNOWN) {
        this.MAPPER = MAPPER;
        this.UNKNOWN = UNKNOWN;
    }

    @Override
    public T deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return UNKNOWN;
        }

        final T enumInstance = MAPPER.get(value);
        if (enumInstance == null) {
            return UNKNOWN;
        }
        return enumInstance;
    }
}
