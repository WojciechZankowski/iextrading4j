package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

class HackyBigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {

    HackyBigDecimalDeserializer() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(final JsonParser parser, final DeserializationContext ctx) throws IOException {
        final String val = parser.getValueAsString();

        // #HACK Sometimes instead of a null they return N/A in number field
        // #HACK In Daily List they return empty String if number is N/A
        // #HACK In Key Stats they return NaN for revenuePerEmployee
        if (val == null || "N/A".equalsIgnoreCase(val) || "NaN".equalsIgnoreCase(val) || val.isEmpty()) {
            return null;
        }

        try {
            return parser.getDecimalValue();
        } catch (IOException e) {
            // #HACK In Daily List they return numbers as a String
            return new BigDecimal(val);
        }
    }

}
