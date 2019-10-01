package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.alternative.CryptoEventType;

import static pl.zankowski.iextrading4j.client.mapper.CryptoEventTypeDeserializer.CRYPTO_EVENT_TYPE_MAPPER;

public class CryptoEventTypeSerializer extends AbstractEnumSerializer<CryptoEventType> {

    CryptoEventTypeSerializer() {
        super(CRYPTO_EVENT_TYPE_MAPPER.inverse(), null);
    }
}
