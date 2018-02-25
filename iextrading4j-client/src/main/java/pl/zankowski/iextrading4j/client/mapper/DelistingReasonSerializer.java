package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.DelistingReason;

import static pl.zankowski.iextrading4j.client.mapper.DelistingReasonDeserializer.DELISTING_REASON_MAPPER;

class DelistingReasonSerializer extends AbstractEnumSerializer<DelistingReason> {

    DelistingReasonSerializer() {
        super(DELISTING_REASON_MAPPER.inverse(), DelistingReason.UNKNOWN);
    }
}
