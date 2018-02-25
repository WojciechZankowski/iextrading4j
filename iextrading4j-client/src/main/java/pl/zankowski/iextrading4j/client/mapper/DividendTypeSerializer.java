package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.stocks.DividendType;

import static pl.zankowski.iextrading4j.client.mapper.DividendTypeDeserializer.DIVIDEND_TYPE_MAPPER;

class DividendTypeSerializer extends AbstractEnumSerializer<DividendType> {

    DividendTypeSerializer() {
        super(DIVIDEND_TYPE_MAPPER.inverse(), DividendType.UNKNOWN);
    }
}
