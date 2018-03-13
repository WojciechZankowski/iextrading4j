package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HackyLocalDateTimeDeserializer extends LocalDateTimeDeserializer {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    HackyLocalDateTimeDeserializer() {
        super(DEFAULT_FORMATTER);
    }

    HackyLocalDateTimeDeserializer(DateTimeFormatter dtf) {
        super(dtf);
    }

    @Override
    protected JsonDeserializer<LocalDateTime> withDateFormat(DateTimeFormatter dtf) {
        return new HackyLocalDateTimeDeserializer(dtf);
    }

    @Override
    public LocalDateTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final String val = parser.getValueAsString();

        // #HACK In Daily List they return "0" if data is not available
        if (val == null || val.equals("0")) {
            return null;
        }

        return super.deserialize(parser, context);
    }
}
