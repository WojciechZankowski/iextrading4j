package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.alternative.CryptoSide;

import static pl.zankowski.iextrading4j.api.alternative.CryptoSide.ASK;
import static pl.zankowski.iextrading4j.api.alternative.CryptoSide.BID;

public class CryptoSideDeserializer extends AbstractEnumDeserializer<CryptoSide> {

    static final BiMap<String, CryptoSide> CRYPTO_SIDE_MAPPER = ImmutableBiMap.<String, CryptoSide>builder()
            .put("bid", BID)
            .put("ask", ASK)
            .build();

    CryptoSideDeserializer() {
        super(CRYPTO_SIDE_MAPPER, null);
    }
}
