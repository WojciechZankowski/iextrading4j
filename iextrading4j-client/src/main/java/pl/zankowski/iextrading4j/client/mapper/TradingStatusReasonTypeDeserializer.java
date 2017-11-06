package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import java.io.IOException;

public class TradingStatusReasonTypeDeserializer extends JsonDeserializer<TradingStatusReasonType> {

    @Override
    public TradingStatusReasonType deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final String value = parser.getValueAsString();
        if (value == null) {
            return TradingStatusReasonType.UNKNOWN;
        }

        if ("T1".equals(value)) {
            return TradingStatusReasonType.HALT_NEWS_PENDING;
        } else if ("IPO1".equals(value)) {
            return TradingStatusReasonType.IPO_ISSUE_NOT_YET_TRADING;
        } else if ("IPOD".equals(value)) {
            return TradingStatusReasonType.IPO_ISSUE_DEFERRED;
        } else if ("MCB3".equals(value)) {
            return TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3;
        } else if ("NA".equals(value)) {
            return TradingStatusReasonType.REASON_NOT_AVAILABLE;
        } else if ("T2".equals(value)) {
            return TradingStatusReasonType.HALT_NEWS_DISSEMINATION;
        } else if ("IPO2".equals(value)) {
            return TradingStatusReasonType.IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD;
        } else if ("IPO3".equals(value)) {
            return TradingStatusReasonType.IPO_PRE_LAUNCH_PERIOD;
        } else if ("MCB1".equals(value)) {
            return TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1;
        } else if ("MCB2".equals(value)) {
            return TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2;
        }

        return TradingStatusReasonType.UNKNOWN;
    }
}
