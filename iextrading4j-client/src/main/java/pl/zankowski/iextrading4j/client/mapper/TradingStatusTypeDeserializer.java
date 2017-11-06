package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;

import java.io.IOException;

public class TradingStatusTypeDeserializer extends JsonDeserializer<TradingStatusType> {

    @Override
    public TradingStatusType deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return TradingStatusType.UNKNOWN;
        }

        if ("H".equals(value)) {
            return TradingStatusType.TRADING_HALTED;
        } else if ("O".equals(value)) {
            return TradingStatusType.TRADING_HALT_RELEASED_INTO_ORDER_ACCEPTANCE_PERIOD;
        } else if ("P".equals(value)) {
            return TradingStatusType.TRADING_PAUSED_AND_ORDER_ACCEPTANCE_PERIOD_ON_IEX;
        } else if ("T".equals(value)) {
            return TradingStatusType.TRADING_ON_IEX;
        }

        return TradingStatusType.UNKNOWN;
    }

}
