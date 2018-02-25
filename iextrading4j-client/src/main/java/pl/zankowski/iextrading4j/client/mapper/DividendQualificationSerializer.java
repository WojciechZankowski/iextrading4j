package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.stocks.DividendQualification;

import static pl.zankowski.iextrading4j.client.mapper.DividendQualificationDeserializer.DIVIDEND_QUALIFICATION_MAPPER;

class DividendQualificationSerializer extends AbstractEnumSerializer<DividendQualification> {

    DividendQualificationSerializer() {
        super(DIVIDEND_QUALIFICATION_MAPPER.inverse(), DividendQualification.UNKNOWN);
    }
}
