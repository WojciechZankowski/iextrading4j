package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import java.io.IOException;

public class TradingStatusReasonTypeSerializer extends JsonSerializer<TradingStatusReasonType> {

    @Override
    public void serialize(final TradingStatusReasonType value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == TradingStatusReasonType.UNKNOWN) {
            gen.writeNull();
            return;
        }

        switch (value) {
            case HALT_NEWS_PENDING:
                gen.writeString("T1");
                break;
            case IPO_ISSUE_NOT_YET_TRADING:
                gen.writeString("IPO1");
                break;
            case IPO_ISSUE_DEFERRED:
                gen.writeString("IPOD");
                break;
            case MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3:
                gen.writeString("MCB3");
                break;
            case REASON_NOT_AVAILABLE:
                gen.writeString("NA");
                break;
            case HALT_NEWS_DISSEMINATION:
                gen.writeString("T2");
                break;
            case IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD:
                gen.writeString("IPO2");
                break;
            case IPO_PRE_LAUNCH_PERIOD:
                gen.writeString("IPO3");
                break;
            case MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1:
                gen.writeString("MCB1");
                break;
            case MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2:
                gen.writeString("MCB2");
                break;
            default:
                gen.writeNull();
                break;
        }
    }
}
