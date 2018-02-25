package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;

import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.MESSAGES_END;
import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.MESSAGES_START;
import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.REGULAR_MARKET_HOURS_END;
import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.REGULAR_MARKET_HOURS_START;
import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.SYSTEM_HOURS_END;
import static pl.zankowski.iextrading4j.api.marketdata.SystemEventType.SYSTEM_HOURS_START;

class SystemEventTypeDeserializer extends AbstractEnumDeserializer<SystemEventType> {

    static final BiMap<String, SystemEventType> SYSTEM_EVENT_TYPE_MAPPER = ImmutableBiMap.<String, SystemEventType>builder()
            .put("O", MESSAGES_START)
            .put("S", SYSTEM_HOURS_START)
            .put("R", REGULAR_MARKET_HOURS_START)
            .put("M", REGULAR_MARKET_HOURS_END)
            .put("E", SYSTEM_HOURS_END)
            .put("C", MESSAGES_END)
            .build();

    SystemEventTypeDeserializer() {
        super(SYSTEM_EVENT_TYPE_MAPPER, SystemEventType.UNKNOWN);
    }

}
