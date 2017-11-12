package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import java.io.IOException;

public class SystemEventTypeSerializer extends JsonSerializer<SystemEventType> {

    @Override
    public void serialize(final SystemEventType value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == SystemEventType.UNKNOWN) {
            gen.writeNull();
            return;
        }

        switch (value) {
            case MESSAGES_START:
                gen.writeString("O");
                return;
            case SYSTEM_HOURS_START:
                gen.writeString("S");
                return;
            case REGULAR_MARKET_HOURS_START:
                gen.writeString("R");
                return;
            case REGULAR_MARKET_HOURS_END:
                gen.writeString("M");
                return;
            case SYSTEM_HOURS_END:
                gen.writeString("E");
                return;
            case MESSAGES_END:
                gen.writeString("C");
                return;
            default:
                gen.writeNull();
        }
    }
}
