package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;

import java.io.IOException;

public class ChartRangeSerializer extends JsonSerializer<ChartRange> {

    @Override
    public void serialize(final ChartRange value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        gen.writeString(value.getCode());
    }
}
