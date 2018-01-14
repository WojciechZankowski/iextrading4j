package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;

import java.io.IOException;

public class DividendQualificationDeserializer extends JsonDeserializer<DividendQualification> {

    @Override
    public DividendQualification deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return DividendQualification.UNKNOWN;
        }

        if ("P".equals(value)) {
            return DividendQualification.PARTIALLY_QUALIFIED_INCOME;
        } else if ("Q".equals(value)) {
            return DividendQualification.QUALIFIED_INCOME;
        } else if ("N".equals(value)) {
            return DividendQualification.UNQUALIFIED_INCOME;
        }

        return DividendQualification.UNKNOWN;
    }
}
