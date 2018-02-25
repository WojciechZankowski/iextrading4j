package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;

import static pl.zankowski.iextrading4j.client.mapper.TradingStatusTypeDeserializer.TRADING_STATUS_TYPE_MAPPER;

class TradingStatusTypeSerializer extends AbstractEnumSerializer<TradingStatusType> {

    TradingStatusTypeSerializer() {
        super(TRADING_STATUS_TYPE_MAPPER.inverse(), TradingStatusType.UNKNOWN);
    }
}
