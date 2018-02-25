package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;

import static pl.zankowski.iextrading4j.client.mapper.TradingStatusReasonTypeDeserializer.TRADING_STATUS_REASON_TYPE_MAPPER;

class TradingStatusReasonTypeSerializer extends AbstractEnumSerializer<TradingStatusReasonType> {

    TradingStatusReasonTypeSerializer() {
        super(TRADING_STATUS_REASON_TYPE_MAPPER.inverse(), TradingStatusReasonType.UNKNOWN);
    }
}
