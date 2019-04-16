package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import static pl.zankowski.iextrading4j.api.refdata.SymbolType.*;

class SymbolTypeDeserializer extends AbstractEnumDeserializer<SymbolType> {

    static final BiMap<String, SymbolType> SYMBOL_TYPE_MAPPER = ImmutableBiMap.<String, SymbolType>builder()
            .put("ad", ADR)
            .put("re", REIT)
            .put("ce", CLOSED_END_FUND)
            .put("si", SECONDARY_ISSUE)
            .put("lp", LIMITED_PARTNERSHIP)
            .put("cs", COMMON_STOCK)
            .put("et", ETF)
            .put("ps", PREFERRED_STOCK)
            .put("bo", BO)
            .put("su", SU)
            .put("wt", WARRANT)
            .put("oef", OPEN_ENDED_FUND)
            .put("cef", CLOSED_ENDED_FUND)
            .put("N/A", NOT_AVAILABLE)
            .build();

    SymbolTypeDeserializer() {
        super(SYMBOL_TYPE_MAPPER, SymbolType.UNKNOWN);
    }

}
