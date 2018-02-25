package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.LuldTier;

import static pl.zankowski.iextrading4j.client.mapper.LuldTierDeserializer.LULD_TIER_MAPPER;

class LuldTierSerializer extends AbstractEnumSerializer<LuldTier> {

    LuldTierSerializer() {
        super(LULD_TIER_MAPPER.inverse(), LuldTier.UNKNOWN);
    }

}
