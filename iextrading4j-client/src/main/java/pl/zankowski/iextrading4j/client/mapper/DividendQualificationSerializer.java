package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;

import java.io.IOException;

public class DividendQualificationSerializer extends JsonSerializer<DividendQualification> {

    @Override
    public void serialize(final DividendQualification value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == DividendQualification.UNKNOWN) {
            gen.writeNull();
            return;
        }

        switch (value) {
            case PARTIALLY_QUALIFIED_INCOME:
                gen.writeString("P");
                break;
            case QUALIFIED_INCOME:
                gen.writeString("Q");
                break;
            case UNQUALIFIED_INCOME:
                gen.writeString("N");
                break;
            default:
                gen.writeNull();
                break;
        }
    }

}
