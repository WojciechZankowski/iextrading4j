package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;

import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusType.TRADING_HALTED;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusType.TRADING_HALT_RELEASED_INTO_ORDER_ACCEPTANCE_PERIOD;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusType.TRADING_ON_IEX;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusType.TRADING_PAUSED_AND_ORDER_ACCEPTANCE_PERIOD_ON_IEX;

class TradingStatusTypeDeserializer extends AbstractEnumDeserializer<TradingStatusType> {

    static final BiMap<String, TradingStatusType> TRADING_STATUS_TYPE_MAPPER = ImmutableBiMap.<String, TradingStatusType>builder()
            .put("H", TRADING_HALTED)
            .put("O", TRADING_HALT_RELEASED_INTO_ORDER_ACCEPTANCE_PERIOD)
            .put("P", TRADING_PAUSED_AND_ORDER_ACCEPTANCE_PERIOD_ON_IEX)
            .put("T", TRADING_ON_IEX)
            .build();

    TradingStatusTypeDeserializer() {
        super(TRADING_STATUS_TYPE_MAPPER, TradingStatusType.UNKNOWN);
    }


}
