package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import static pl.zankowski.iextrading4j.client.mapper.SystemEventTypeDeserializer.SYSTEM_EVENT_TYPE_MAPPER;

class SystemEventTypeSerializer extends AbstractEnumSerializer<SystemEventType> {

    SystemEventTypeSerializer() {
        super(SYSTEM_EVENT_TYPE_MAPPER.inverse(), SystemEventType.UNKNOWN);
    }
}
