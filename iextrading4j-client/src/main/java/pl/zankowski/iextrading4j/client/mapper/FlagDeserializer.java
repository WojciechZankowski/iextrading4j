package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.Flag;

import static pl.zankowski.iextrading4j.api.refdata.Flag.NO;
import static pl.zankowski.iextrading4j.api.refdata.Flag.YES;

class FlagDeserializer extends AbstractEnumDeserializer<Flag> {

    static final BiMap<String, Flag> FLAG_MAPPER = ImmutableBiMap.<String, Flag>builder()
            .put("Y", YES)
            .put("N", NO)
            .build();

    FlagDeserializer() {
        super(FLAG_MAPPER, Flag.UNKNOWN);
    }
}
