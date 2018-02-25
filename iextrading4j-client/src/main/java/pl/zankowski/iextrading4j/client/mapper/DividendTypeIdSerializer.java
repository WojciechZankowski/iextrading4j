package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.DividendTypeId;

import static pl.zankowski.iextrading4j.client.mapper.DividendTypeIdDeserializer.DIVIDEND_TYPE_ID_MAPPER;

class DividendTypeIdSerializer extends AbstractEnumSerializer<DividendTypeId> {

    DividendTypeIdSerializer() {
        super(DIVIDEND_TYPE_ID_MAPPER.inverse(), DividendTypeId.UNKNOWN);
    }
}
