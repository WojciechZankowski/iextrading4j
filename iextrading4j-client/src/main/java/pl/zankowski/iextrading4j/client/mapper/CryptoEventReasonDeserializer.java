package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.alternative.CryptoEventReason;

import static pl.zankowski.iextrading4j.api.alternative.CryptoEventReason.CANCEL;
import static pl.zankowski.iextrading4j.api.alternative.CryptoEventReason.INITIAL;
import static pl.zankowski.iextrading4j.api.alternative.CryptoEventReason.PLACE;
import static pl.zankowski.iextrading4j.api.alternative.CryptoEventReason.TRADE;

public class CryptoEventReasonDeserializer extends AbstractEnumDeserializer<CryptoEventReason> {

    static final BiMap<String, CryptoEventReason> CRYPTO_EVENT_REASON_MAPPER = ImmutableBiMap.<String, CryptoEventReason>builder()
            .put("place", PLACE)
            .put("trade", TRADE)
            .put("cancel", CANCEL)
            .put("initial", INITIAL)
            .build();

    CryptoEventReasonDeserializer() {
        super(CRYPTO_EVENT_REASON_MAPPER, null);
    }
}
