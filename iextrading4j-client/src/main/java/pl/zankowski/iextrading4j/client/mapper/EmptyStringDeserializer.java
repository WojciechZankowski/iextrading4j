package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class EmptyStringDeserializer extends StdScalarDeserializer<BigDecimal> {

    public EmptyStringDeserializer() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(final JsonParser parser, final DeserializationContext ctx) throws IOException {
        final String val = parser.getValueAsString();

        if ("N/A".equalsIgnoreCase(val)) {
            return null;
        }

        return parser.getDecimalValue();
    }

}
