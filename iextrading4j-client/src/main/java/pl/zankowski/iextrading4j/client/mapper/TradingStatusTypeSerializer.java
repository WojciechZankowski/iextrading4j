package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;

import java.io.IOException;

public class TradingStatusTypeSerializer extends JsonSerializer<TradingStatusType> {

    @Override
    public void serialize(final TradingStatusType value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        if (value == null || value == TradingStatusType.UNKNOWN) {
            gen.writeNull();
            return;
        }

        switch (value) {
            case TRADING_HALTED:
                gen.writeString("H");
                break;
            case TRADING_HALT_RELEASED_INTO_ORDER_ACCEPTANCE_PERIOD:
                gen.writeString("O");
                break;
            case TRADING_PAUSED_AND_ORDER_ACCEPTANCE_PERIOD_ON_IEX:
                gen.writeString("P");
                break;
            case TRADING_ON_IEX:
                gen.writeString("T");
                break;
            default:
                gen.writeNull();
                break;
        }
    }
}
