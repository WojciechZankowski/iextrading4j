package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.HALT_NEWS_DISSEMINATION;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.HALT_NEWS_PENDING;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.IPO_ISSUE_DEFERRED;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.IPO_ISSUE_NOT_YET_TRADING;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.IPO_PRE_LAUNCH_PERIOD;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3;
import static pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType.REASON_NOT_AVAILABLE;

class TradingStatusReasonTypeDeserializer extends AbstractEnumDeserializer<TradingStatusReasonType> {

    static final BiMap<String, TradingStatusReasonType> TRADING_STATUS_REASON_TYPE_MAPPER = ImmutableBiMap.<String, TradingStatusReasonType>builder()
            .put("T1", HALT_NEWS_PENDING)
            .put("IPO1", IPO_ISSUE_NOT_YET_TRADING)
            .put("IPOD", IPO_ISSUE_DEFERRED)
            .put("MCB3", MARKET_WIDE_CIRCUIT_BREAKER_LEVEL3)
            .put("NA", REASON_NOT_AVAILABLE)
            .put("T2", HALT_NEWS_DISSEMINATION)
            .put("IPO2", IPO_ISSUE_ORDER_ACCEPTANCE_PERIOD)
            .put("IPO3", IPO_PRE_LAUNCH_PERIOD)
            .put("MCB1", MARKET_WIDE_CIRCUIT_BREAKER_LEVEL1)
            .put("MCB2", MARKET_WIDE_CIRCUIT_BREAKER_LEVEL2)
            .build();

    TradingStatusReasonTypeDeserializer() {
        super(TRADING_STATUS_REASON_TYPE_MAPPER, TradingStatusReasonType.UNKNOWN);
    }
}
