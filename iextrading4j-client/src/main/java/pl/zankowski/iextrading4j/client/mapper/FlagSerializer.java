package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.Flag;

import static pl.zankowski.iextrading4j.client.mapper.FlagDeserializer.FLAG_MAPPER;

class FlagSerializer extends AbstractEnumSerializer<Flag> {

    FlagSerializer() {
        super(FLAG_MAPPER.inverse(), Flag.UNKNOWN);
    }
}
