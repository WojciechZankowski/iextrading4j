package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.alternative.CryptoSide;

import static pl.zankowski.iextrading4j.client.mapper.CryptoSideDeserializer.CRYPTO_SIDE_MAPPER;

public class CryptoSideSerializer extends AbstractEnumSerializer<CryptoSide> {

    CryptoSideSerializer() {
        super(CRYPTO_SIDE_MAPPER.inverse(), null);
    }
}
