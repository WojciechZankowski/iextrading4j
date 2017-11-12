package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import java.io.IOException;

public class SystemEventTypeDeserializer extends JsonDeserializer<SystemEventType> {

    @Override
    public SystemEventType deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return SystemEventType.UNKNOWN;
        }

        switch (value) {
            case "O":
                return SystemEventType.MESSAGES_START;
            case "S":
                return SystemEventType.SYSTEM_HOURS_START;
            case "R":
                return SystemEventType.REGULAR_MARKET_HOURS_START;
            case "M":
                return SystemEventType.REGULAR_MARKET_HOURS_END;
            case "E":
                return SystemEventType.SYSTEM_HOURS_END;
            case "C":
                return SystemEventType.MESSAGES_END;
            default:
                return SystemEventType.UNKNOWN;
        }
    }

}
