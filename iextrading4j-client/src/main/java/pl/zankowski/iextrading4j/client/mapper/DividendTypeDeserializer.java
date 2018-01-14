package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.stocks.DividendType;

import java.io.IOException;

public class DividendTypeDeserializer extends JsonDeserializer<DividendType> {

    @Override
    public DividendType deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return DividendType.UNKNOWN;
        }

        if ("Dividend income".equals(value)) {
            return DividendType.DIVIDEND_INCOME;
        } else if ("Interest income".equals(value)) {
            return DividendType.INTEREST_INCOME;
        } else if ("Stock dividend".equals(value)) {
            return DividendType.STOCK_DIVIDEND;
        } else if ("Short term capital gain".equals(value)) {
            return DividendType.SHORT_TERM_CAPITAL_GAIN;
        } else if ("Medium term capital gain".equals(value)) {
            return DividendType.MEDIUM_TERM_CAPITAL_GAIN;
        } else if ("Long term capital gain".equals(value)) {
            return DividendType.LONG_TERM_CAPITAL_GAIN;
        } else if ("Unspecified term capital gain".equals(value)) {
            return DividendType.UNSPECIFIED_TERM_CAPITAL_GAIN;
        }

        return DividendType.UNKNOWN;
    }

}
