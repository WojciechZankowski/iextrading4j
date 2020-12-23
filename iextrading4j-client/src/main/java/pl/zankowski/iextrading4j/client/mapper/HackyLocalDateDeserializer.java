package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class HackyLocalDateDeserializer extends LocalDateDeserializer {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    HackyLocalDateDeserializer() {
        super(DEFAULT_FORMATTER);
    }

    HackyLocalDateDeserializer(DateTimeFormatter dtf) {
        super(dtf);
    }

    @Override
    protected LocalDateDeserializer withDateFormat(DateTimeFormatter dtf) {
        return new HackyLocalDateDeserializer(dtf);
    }

    @Override
    public LocalDate deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final String val = parser.getValueAsString();

        // #HACK In Daily List they return "0" if data is not available
        if (val == null || val.equals("0") || val.equals("0000-00-00")) {
            return null;
        }

        if (val.length() > 10) {
            LocalDateTime dateTime =
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(val)), ZoneId.systemDefault());
            return dateTime.toLocalDate();
        }

        return super.deserialize(parser, context);
    }
}
