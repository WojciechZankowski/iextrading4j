package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.stocks.DividendType;

import java.io.IOException;

public class DividendTypeSerializer extends JsonSerializer<DividendType> {

    @Override
    public void serialize(final DividendType value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == DividendType.UNKNOWN) {
            gen.writeNull();
            return;
        }

        switch (value) {
            case DIVIDEND_INCOME:
                gen.writeString("Dividend income");
                break;
            case INTEREST_INCOME:
                gen.writeString("Interest income");
                break;
            case STOCK_DIVIDEND:
                gen.writeString("Stock dividend");
                break;
            case SHORT_TERM_CAPITAL_GAIN:
                gen.writeString("Short term capital gain");
                break;
            case MEDIUM_TERM_CAPITAL_GAIN:
                gen.writeString("Medium term capital gain");
                break;
            case LONG_TERM_CAPITAL_GAIN:
                gen.writeString("Long term capital gain");
                break;
            case UNSPECIFIED_TERM_CAPITAL_GAIN:
                gen.writeString("Unspecified term capital gain");
                break;
            default:
                gen.writeNull();
                break;
        }
    }

}
